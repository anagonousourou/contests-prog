package com.spa.codewars;

import java.util.ArrayList;
import java.util.List;

public class SimpleMusicEncoder {


    interface SequenceFinder {
        void flush();
        boolean addToken(int token);

        void resetWithToken(int token);
    }

    List<String> encodingResults = new ArrayList<>();
    static class ConsecutiveSequenceFinder implements SequenceFinder{

        enum ConsecutiveSequenceFinderState{
            CONSECUTIVE_SEQUENCE_FINDER_STATE_ONE,
            CONSECUTIVE_SEQUENCE_FINDER_STATE_TWO,
            CONSECUTIVE_SEQUENCE_FINDER_STATE_THREE
        }
        int lastNumber = 0;
        int c2;
        int firstNumber = 0;
        List<String>  econdingResults;
        ConsecutiveSequenceFinderState currentState = ConsecutiveSequenceFinderState.CONSECUTIVE_SEQUENCE_FINDER_STATE_ONE;
        ConsecutiveSequenceFinder(int initFirstNumber, List<String>  econdingResults){
            this.firstNumber = initFirstNumber;
            this.econdingResults = econdingResults;
        }

        @Override
        public void flush() {
            if(this.currentState == ConsecutiveSequenceFinderState.CONSECUTIVE_SEQUENCE_FINDER_STATE_THREE){
                int counter = Math.abs(lastNumber - firstNumber) + 1;
                this.econdingResults.subList(this.econdingResults.size() - counter, this.econdingResults.size()).clear();
                econdingResults.add("%d-%d".formatted(firstNumber, lastNumber));
            }
        }

        @Override
        public boolean addToken(int input){
            switch (currentState){
                case CONSECUTIVE_SEQUENCE_FINDER_STATE_ONE:
                    if(Math.abs(firstNumber - input)  == 1){// 2,2,2,3
                        this.c2 = input;
                        this.currentState = ConsecutiveSequenceFinderState.CONSECUTIVE_SEQUENCE_FINDER_STATE_TWO;
                    }else{
                        this.firstNumber = input;
                    }
                    break;
                case CONSECUTIVE_SEQUENCE_FINDER_STATE_TWO:
                    if(input - c2 != c2 - firstNumber && Math.abs(input - c2) != 1){
                        this.firstNumber = input;
                        this.currentState = ConsecutiveSequenceFinderState.CONSECUTIVE_SEQUENCE_FINDER_STATE_ONE;

                    }else if(input - c2 != c2 - firstNumber && Math.abs(input - c2) == 1){
                        this.firstNumber = c2;
                        this.c2 = input;

                    }else{
                        this.currentState = ConsecutiveSequenceFinderState.CONSECUTIVE_SEQUENCE_FINDER_STATE_THREE;
                        this.lastNumber = input;
                    }

                    break;
                case CONSECUTIVE_SEQUENCE_FINDER_STATE_THREE:
                        if(input - lastNumber == c2 - firstNumber){
                            this.lastNumber = input;
                        }else{
                            int counter = Math.abs(lastNumber - firstNumber) + 1;
                            this.econdingResults.subList(this.econdingResults.size() - counter, this.econdingResults.size()).clear();
                            econdingResults.add("%d-%d".formatted(firstNumber, lastNumber));
                            this.firstNumber = input;
                            this.currentState = ConsecutiveSequenceFinderState.CONSECUTIVE_SEQUENCE_FINDER_STATE_ONE;
                            return true;
                        }
                    break;
            }
            return false;
        }

        @Override
        public void resetWithToken(int token) {
            this.currentState = ConsecutiveSequenceFinderState.CONSECUTIVE_SEQUENCE_FINDER_STATE_ONE;
            this.firstNumber = token;
        }
    }

    static class IdenticalSequenceFinder implements SequenceFinder{

        int number = 0;
        int counter = 1;
        List<String>  econdingResults;
        IdenticalSequenceFinder(int initFirstNumber, List<String>  econdingResults){
            this.number = initFirstNumber;
            this.econdingResults = econdingResults;
        }

        @Override
        public void flush() {
            if(counter >= 2){
                this.econdingResults.subList(this.econdingResults.size() - counter, this.econdingResults.size()).clear();
                econdingResults.add("%d*%d".formatted(number, counter));
                this.counter = 1;
            }
        }

        @Override
        public boolean addToken(int input){
            if(input ==  number){
                this.counter++;
            }
            else if(counter >= 2){
                this.econdingResults.subList(this.econdingResults.size() - counter, this.econdingResults.size()).clear();
                econdingResults.add("%d*%d".formatted(number, counter));
                this.number = input;
                this.counter = 1;
                return true;
            }
            else{
                this.number = input;
                this.counter = 1;
            }
            return false;
        }

        @Override
        public void resetWithToken(int token) {
            this.number = token;
            this.counter = 1;
        }
    }

    static class IntervalSequenceFinder implements SequenceFinder{

        enum State{
            ONE,
            TWO,
            THREE
        }

        int c1;
        int c2;
        int c3;
        int interval;
        List<String>  econdingResults;
        State currentState = State.ONE;
        IntervalSequenceFinder(int initFirstNumber, List<String>  econdingResults){
            this.c1 = initFirstNumber;
            this.econdingResults = econdingResults;
        }

        @Override
        public boolean addToken(int input){
            switch (currentState){
                case ONE :
                    if(Math.abs(input - c1) > 1){
                        this.currentState = State.TWO;
                        this.c2 = input;
                    }
                    else{
                        this.c1 = input;
                    }
                    break;
                case TWO:
                    if(c2 - c1 == input - c2){
                        this.currentState = State.THREE;
                        this.interval = c2 - c1;
                        c3 = input;
                    }
                    else if(Math.abs(input - c2) > 1){
                        this.c1 = this.c2;
                        this.c2 = input;
                    }
                    else {
                        this.currentState = State.ONE;
                        this.c1 = input;
                    }
                    break;
                case THREE:
                    if(input - c3 == interval){
                        c3 = input;
                    }
                    else{
                        int counter = (Math.abs(c3 - c1) / Math.abs(interval)) +1;
                        this.econdingResults.subList(this.econdingResults.size() - counter, this.econdingResults.size()).clear();
                        econdingResults.add("%d-%d/%d".formatted(c1, c3, Math.abs(interval)));
                        this.currentState = State.ONE;
                        this.c1 = input;
                        return true;
                    }
                    break;
            }
            return false;
        }

        @Override
        public void resetWithToken(int token) {
            this.c1 = token;
            this.currentState = State.ONE;
        }

        @Override
        public void flush(){
            if(this.currentState == State.THREE){
                int counter = (Math.abs(c3 - c1) / Math.abs(interval) ) +1;
                this.econdingResults.subList(this.econdingResults.size() - counter, this.econdingResults.size()).clear();
                this.econdingResults.add("%d-%d/%d".formatted(c1, c3, Math.abs(interval)));
            }
        }
    }

    public String compress(int[] raw) {
        this.encodingResults.add("%d".formatted(raw[0]));
        var consecutiveSequenceFinder = new ConsecutiveSequenceFinder(raw[0], encodingResults);
        var identicalSequenceFinder = new IdenticalSequenceFinder(raw[0], encodingResults);
        var intervalSequenceFinder = new IntervalSequenceFinder(raw[0], encodingResults);
        for (int i = 1; i < raw.length; i++) {
            boolean modifiedList = identicalSequenceFinder.addToken(raw[i]);
            if(modifiedList){
                consecutiveSequenceFinder.resetWithToken(raw[i]);
                intervalSequenceFinder.resetWithToken(raw[i]);
            }
            else{
                modifiedList =  consecutiveSequenceFinder.addToken(raw[i]);
                if(modifiedList){
                    intervalSequenceFinder.resetWithToken(raw[i]);
                }else{
                    intervalSequenceFinder.addToken(raw[i]);
                }
            }

            this.encodingResults.add("%d".formatted(raw[i]));
        }
        identicalSequenceFinder.flush();
        consecutiveSequenceFinder.flush();
        intervalSequenceFinder.flush();
        return String.join("," , this.encodingResults);
    }
}
