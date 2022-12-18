package practice.machinecoding.game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameTester {
    public static void main(String[] args) {
        Board board = new Board(4);

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        board.printBoard();
        while(true){

            System.out.println("Input number now:");
            int choice = sc.nextInt();
            if(choice==4)
                BoardMover.move(board,Move.LEFT);
            else if(choice == 6)
                BoardMover.move(board,Move.RIGHT);
            else if(choice == 8)
                BoardMover.move(board,Move.TOP);
            else
                BoardMover.move(board,Move.BOTTOM);

            board.printBoard();
            if(board.isGameOver() != 0)
                break;
        }

        if(board.isGameOver() == 1){
            System.out.println("Congratulations");
        }else if(board.isGameOver() == -1)
            System.out.println("Game over");
    }


}
