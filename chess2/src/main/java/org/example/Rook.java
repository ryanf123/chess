package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Rook implements Pieces {
    private final char color;
    ArrayList<Point> moveSet = new ArrayList<>();
    Rook(char color) {
        this.color = color;
    }
    public ArrayList<Point> move(Point location, Pieces[][] board){
        int row = (int) location.getX();
        int col = (int) location.getY();
        moveCol(row,col -1,-1 ,board); // up
        moveCol(row,col +1,+1,board); // down
        moveRow(row +1 , col, +1, board); //right
        moveRow(row -1, col, -1,board); //left
        return moveSet;
    }
    public char color() {
        return color;
    }


    private void moveRow(int row, int col, int diff, Pieces[][] board){

        char pieceColor = board[row-diff][col].color();
        for ( ;row <=7 && row >= 0; row += diff){

            if(board[row][col].color() == 'N'){
                moveSet.add(new Point(row,col));

            } else if (board[row][col].color() == pieceColor) {
                break;
            } else if (board[row][col].color() != pieceColor) {
                moveSet.add(new Point(row,col));
                break;
            }
        }
    }
    private void moveCol(int row, int col, int diff, Pieces[][] board){

        char pieceColor = board[row][col-diff].color();
        for (; col <=7 && col >= 0; col += diff){

            if(board[row][col].color() == 'N'){
                moveSet.add(new Point(row,col));

            } else if (board[row][col].color() == pieceColor) {
                break;
            } else if (board[row][col].color() != pieceColor) {
                moveSet.add(new Point(row,col));
                break;
            }
        }
    }
}
