package com.interview.systemDesign.LLD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToe {

    public void ticTacToe() {
        Playr p1 = new Playr(1, "Gautam", 'X');
        Playr p2 = new Playr(1, "Puja", 'O');

        Playr[] players = new Playr[]{p1,p2};
        GameBord gb = new GameBord(players);
        gb.start();
    }
}

class Playr {
    private int id;
    String playerName;
    char playerSymbol;

    Playr(int id, String playerName, char playerSymbol){
        this.id = id;
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }
}

class GameBord {
    char[][] board = new char[][]{
            {' ','|',' ','|',' '},
            {'-','|','-','|','-'},
            {' ','|',' ','|',' '},
            {'-','|','-','|','-'},
            {' ','|',' ','|',' '}
    };
    Scanner input = new Scanner(System.in);
    Queue<Playr> playrs = new LinkedList<>();
    boolean gameOver = Boolean.FALSE;
    int count=0;

    public GameBord(Playr[] players) {
        playrs.offer(players[0]);
        playrs.offer(players[1]);
    }

    public void start(){
        printBoard(board);
        while(!gameOver) {
            count++;
            if (count==10){
                System.out.println( "Match draw");
                break;
            }
            Playr p = playrs.poll();
            int val = nextMove();
            board[val/10][val%10] = p.playerSymbol;
            if(checkStatus(p)) {
                gameOver=true;
                System.out.println(p.playerName + " has won the game");
            }
            printBoard(board);
            playrs.offer(p);
        }

    }

    private void printBoard (char[][] board){
        for(char[] row : board){
            for(char col: row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private boolean checkStatus(Playr p){
        if(board[0][0]+board[0][2]+board[0][4] == p.playerSymbol+p.playerSymbol+p.playerSymbol) return true;
        if(board[2][0]+board[2][2]+board[2][4] == p.playerSymbol+p.playerSymbol+p.playerSymbol) return true;
        if(board[4][0]+board[4][2]+board[4][4] == p.playerSymbol+p.playerSymbol+p.playerSymbol) return true;
        if(board[0][0]+board[2][0]+board[4][0] == p.playerSymbol+p.playerSymbol+p.playerSymbol) return true;
        if(board[0][2]+board[2][2]+board[4][2] == p.playerSymbol+p.playerSymbol+p.playerSymbol) return true;
        if(board[0][4]+board[2][4]+board[4][4] == p.playerSymbol+p.playerSymbol+p.playerSymbol) return true;
        if(board[0][0]+board[2][2]+board[4][4] == p.playerSymbol+p.playerSymbol+p.playerSymbol) return true;
        if(board[0][4]+board[2][2]+board[4][0] == p.playerSymbol+p.playerSymbol+p.playerSymbol) return true;

        return false;
    }


    private int nextMove(){
        System.out.println("Enter a number from 1-9");
        int position = input.nextInt();
        while(!validPosition(position)){
            System.out.println("Wrong Position, try different position.Enter a number from 1-9");
            position = input.nextInt();
        }
        return getCoordinates(position);
    }

    private boolean validPosition(int pos){
        if(pos<1 || pos>9) return false;
        int val = getCoordinates(pos);
        if(board[val/10][val%10]=='X' || board[val/10][val%10]=='O') return false;
        return true;
    }

    private int getCoordinates(int pos){
        switch(pos){
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 20;
            case 5:
                return 22;
            case 6:
                return 24;
            case 7:
                return 40;
            case 8:
                return 42;
            case 9:
                return 44;
        }
        return -1;
    }
}