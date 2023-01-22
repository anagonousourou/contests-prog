package bj.anagonou.bingo;

import java.util.Arrays;
import java.util.List;

public class BingoBoard {
    public static class BoardCell{
        boolean marked = false;
        final int value;

        public BoardCell(int value) {
            this.value = value;
        }
    }
    private final BoardCell[][] boardCells = new BoardCell[5][5];
    private final int[] linesMarkedCount = new int[5];
    private final int[] columnsMarkedCount = new int[5];
    private int lastNumber = 0;
    private int turnNumber = 0;
    private int winningTurn = 0;
    private boolean won  = false;
    public BingoBoard(List<Integer> numbers){
        for (int i = 0; i < boardCells.length; i++) {
            for (int j = 0; j < boardCells[i].length; j++) {
                boardCells[i][j] = new BoardCell(numbers.get(5 * i + j));
            }
        }
    }

    public void takeNumber(int number){
        if(this.won){
            return;
        }
        this.turnNumber++;
        for (int i = 0; i < boardCells.length; i++) {
            for (int j = 0; j < boardCells[i].length; j++) {
                if(boardCells[i][j].value == number && !boardCells[i][j].marked) {
                    boardCells[i][j].marked = true;
                    columnsMarkedCount[j]++;
                    linesMarkedCount[i]++;
                    this.lastNumber = number;
                    if(columnsMarkedCount[j] == 5){
                        this.won = true;
                        this.winningTurn = turnNumber;
                    }
                    if(linesMarkedCount[i] == 5){
                        this.won = true;
                        this.winningTurn = turnNumber;
                    }
                }
            }
        }
    }

    public boolean won(){
        return won;
        //return Arrays.stream(this.columnsMarkedCount).anyMatch(value -> value == 5) || Arrays.stream(this.linesMarkedCount).anyMatch(value -> value == 5) ;
    }

    public int getWinningTurn() {
        return winningTurn;
    }

    public int score(){
        return Arrays.stream(this.boardCells).flatMap(Arrays::stream).filter(boardCell -> !boardCell.marked) .mapToInt(boardCell -> boardCell.value).sum()
                * this.lastNumber;

    }
}
