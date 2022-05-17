package com.snakesAndLadders;

import com.snakesAndLadders.io.input.Input;
import com.snakesAndLadders.io.output.Output;
import com.snakesAndLadders.model.Board;
import com.snakesAndLadders.model.Game;
import com.snakesAndLadders.model.Ladder;
import com.snakesAndLadders.model.Player;
import com.snakesAndLadders.model.Snake;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Initialiser {
    public static Game initialiseSampleGame(Input input, Output output) {
        List<Player> playerList = getSamplePlayerList();
        List<Snake> snakeList = getSampleSnakeList();
        List<Ladder> ladderList = getSampleLadderList();
        Board board = new Board(1, 100, snakeList, ladderList);
        return new Game(board, playerList, input, output);
    }

    public static Game initialiseGameFromInput(Input input, Output output) {
        List<Player> playerList = readPlayerList(input);
        List<Snake> snakeList = readSnakeList(input);
        List<Ladder> ladderList = readLadderList(input);
        Board board = new Board(1, 100, snakeList, ladderList);
        return new Game(board, playerList, input, output);
    }

    private static List<Player> readPlayerList(Input input) {
        String numberOfPlayersString = input.read();
        int numberOfPlayers = parseInt(numberOfPlayersString);

        List<Player> playerList = new ArrayList<>();
        for (int index = 0; index < numberOfPlayers; index++) {
            String name = input.read();
            Player player = new Player(name);
            playerList.add(player);
        }

        return playerList;
    }

    private static List<Snake> readSnakeList(Input input) {
        String numberOfSnakesString = input.read();

        int numberOfSnakes = parseInt(numberOfSnakesString);

        List<Snake> snakeList = new ArrayList<>();
        for (int index = 0; index < numberOfSnakes; index++) {
            String[] startAndEnd = input.read().split(" ");
            Snake snake = new Snake(parseInt(startAndEnd[0]), parseInt(startAndEnd[1]));
            snakeList.add(snake);
        }

        return snakeList;
    }

    private static List<Ladder> readLadderList(Input input) {
        String numberOfLaddersString = input.read();

        int numberOfLadders = parseInt(numberOfLaddersString);

        List<Ladder> ladderList = new ArrayList<>();
        for (int index = 0; index < numberOfLadders; index++) {
            String[] startAndEnd = input.read().split(" ");
            Ladder ladder = new Ladder(parseInt(startAndEnd[0]), parseInt(startAndEnd[1]));
            ladderList.add(ladder);
        }

        return ladderList;
    }

    private static List<Player> getSamplePlayerList() {
        Player p1 = new Player("Gauravv");
        Player p2 = new Player("Sandesh");
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        return players;
    }

    private static List<Snake> getSampleSnakeList() {
        Snake s1 = new Snake(62, 5);
        Snake s2 = new Snake(33, 6);
        Snake s3 = new Snake(49, 9);
        Snake s4 = new Snake(88, 6);
        Snake s5 = new Snake(41, 20);

        List<Snake> snakes = new ArrayList<>();
        snakes.add(s1);
        snakes.add(s2);
        snakes.add(s3);
        snakes.add(s4);
        snakes.add(s5);
        return snakes;
    }

    private static List<Ladder> getSampleLadderList() {
        Ladder l1 = new Ladder(2, 37);
        Ladder l2 = new Ladder(27, 46);
        Ladder l3 = new Ladder(10, 32);
        Ladder l4 = new Ladder(51, 68);
        Ladder l5 = new Ladder(61, 79);

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(l1);
        ladders.add(l2);
        ladders.add(l3);
        ladders.add(l4);
        ladders.add(l5);
        return ladders;
    }
}
