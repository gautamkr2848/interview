package com.interview.systemDesign;

import java.util.*;

public class SnakeAndLadder {

    public void snakeAndLadder() {
        Dice dice = new Dice(1);

        Queue<Player> players = new LinkedList<>();
        players.offer(new Player(1, "Gautam"));
        players.offer(new Player(2, "Puja"));

        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(10, 2);
        snakes.put(99,12);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(5, 25);
        ladders.put(40, 89);

        Map<String,Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put("Alberts",0);
        playersCurrentPosition.put("Pintoss",0);

        GameBoard gb=new GameBoard(dice, players, snakes, ladders, playersCurrentPosition, 100);
        gb.startGame();
    }
}

class Player {
    int id;
    String playerName;

    public Player(int id, String playerName) {
        this.id = id;
        this.playerName = playerName;
    }
}

class Dice {
    private int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int rollDice(){
        return ((int) (Math.random()*(6*numberOfDice - 1*numberOfDice))) + 1;
    }
}

class GameBoard {
    private Dice dice;
    private Queue<Player> playerQueue;
    private Map<Integer, Integer> snakes;
    private  Map<Integer, Integer> ladders;
    private  Map<String,Integer> playersCurrentPosition;
    private int boardSize;

    GameBoard(Dice dice, Queue<Player> nextTurn, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders,Map<String,Integer> playersCurrentPosition,int boardSize) {
        this.dice = dice;
        this.playerQueue = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

    public void startGame(){

        while(!playerQueue.isEmpty()) {
            Player player = playerQueue.poll();

            int currentPosition = playersCurrentPosition.get(player.playerName);
            int diceValue = dice.rollDice();
            int nextCell = currentPosition + diceValue;

            if (nextCell > boardSize)
                playerQueue.offer(player);
            else if (nextCell == boardSize)
                System.out.println(player.playerName + " won the game");
            else {
                if(snakes.containsKey(nextCell)) {
                    nextCell = snakes.get(nextCell);
                    System.out.println(player.playerName + " Bitten by Snake present at: "+ nextCell);
                }

                if(ladders.containsKey(nextCell)) {
                    nextCell = ladders.get(nextCell);
                    System.out.println(player.playerName + " Jumped using ladder present at: "+ nextCell);
                }

                if(nextCell == boardSize)
                    System.out.println(player.playerName + " won the game");
                else {
                    playersCurrentPosition.put(player.playerName, nextCell);
                    System.out.println(player.playerName + " is at position "+ nextCell);
                    playerQueue.offer(player);
                }
            }
        }
    }
}
