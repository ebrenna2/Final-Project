package src;

import javax.swing.*;
import java.util.ArrayList;

public class Game {

    private static boolean lose = false;
    static int gridSize=36;
    static ArrayList<ArrayList<State>> grid=createGrid(gridSize);
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameBoard board = new gameBoard();
        frame.getContentPane().add(board);
        frame.setSize(gridSize*20, gridSize*20);

        frame.pack();
        frame.setVisible(true);

        while (!lose) {
            board.revalidate();
            board.repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ArrayList<ArrayList<State>> createGrid(int gridSize) {
        ArrayList<ArrayList<State>> grid=new ArrayList<>();
        ArrayList<State> wallRow=new ArrayList<>();
        for (int i=0;i<gridSize;i++) {
            wallRow.add(State.WALL);
        }
        ArrayList<State> emptyRow=new ArrayList<>();
        emptyRow.add(State.WALL);
        for (int i=0;i<gridSize;i++) {
            emptyRow.add(State.EMPTY);
        }
        emptyRow.add(State.WALL);
        grid.add(wallRow);
        for (int i=0;i<gridSize;i++) {
            grid.add(emptyRow);
        }
        grid.add(wallRow);
        return grid;
    }
}
