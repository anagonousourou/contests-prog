package bj.anagonou.bingo;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class HelloWorld {

    //https://adventofcode.com/2021/day/4

    /**
     * Read the sequence of "called" numbers from the input
     * @param input the bingo input
     * @return the sequence of numbers
     */
    static List<Integer> getBingoSequence(String input){
       return Arrays.stream(input.lines().findFirst().orElse("")
               .split(","))
               .map(Integer::parseInt).toList();
    }

    /**
     * create Boards from the input
     * @param input
     * @return bingo board
     */
    static List<BingoBoard> getBingoBoard(String input){

        Scanner scanner = new Scanner(input);
        scanner.nextLine(); //ignore the first line
        List<Integer> boardNumbers = new ArrayList<>(25);
        List<BingoBoard> boards = new ArrayList<>(10);
        int i = 0;
        while (scanner.hasNextInt()){
            boardNumbers.add(scanner.nextInt());
            i++;
            if(i == 25){
                boards.add(new BingoBoard(boardNumbers));
                boardNumbers.clear();
                i=0;
            }
        }

        return boards;
    }

    /**
     *
     * @param boards (the state of the board is changed after this method return)
     * @param numbers
     * @return the score of the winning board
     */
    static int simulateGameForFirstWinner(List<BingoBoard> boards, List<Integer> numbers){
        for (Integer number:numbers) {
            for (BingoBoard board:boards){
                board.takeNumber(number);
                if(board.won()){
                    return board.score();
                }
            }
        }
        return 0;
    }

    static int simulateGameForLastWinner(List<BingoBoard> boards, List<Integer> numbers) {
        for (BingoBoard board:boards) {
            for(Integer number:numbers){
                board.takeNumber(number);
                if(board.won()){
                    break;
                }
            }
        }
        return boards.stream().max(Comparator.comparing(BingoBoard::getWinningTurn)).orElse(null).score();
    }
    public static void main(String... args) throws IOException {
        Logger logger=Logger.getLogger(HelloWorld.class.getName());
        logger.info("This is a module-using Hello World!");
        String input =  new String(HelloWorld.class.getResourceAsStream("/input-2021-day4").readAllBytes());
        var sequence = getBingoSequence(input);
        var boards = getBingoBoard(input);
        //System.out.println(simulateGameForFirstWinner(boards,sequence));//41668
        System.out.println(simulateGameForLastWinner(boards, sequence ));
    }
}
