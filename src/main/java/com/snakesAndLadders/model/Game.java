package com.snakesAndLadders.model;

import com.snakesAndLadders.io.input.Input;
import com.snakesAndLadders.io.output.Output;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.snakesAndLadders.constant.Constants.PLAYER_MOVED_MESSAGE;
import static com.snakesAndLadders.constant.Constants.PLAYER_WON_MESSAGE;

public class Game {
    private Board board;
    private List<Player> players;
    private Queue<Player> activePlayers;
    private Input input;
    private Output output;

    public Game(Board board, List<Player> players, Input input, Output output) {
        this.board = board;
        this.players = players;
        activePlayers = new LinkedList<>(players);
        this.input = input;
        this.output = output;
    }

    public void play() {
        while (!hasGameFinished()) {
            Player player = activePlayers.poll();

            int roll = Die.roll();
            movePlayer(player, roll);

            if (hasPlayerWon(player)) {
                output.print(String.format(PLAYER_WON_MESSAGE, player.getName()));
                continue;
            }
            activePlayers.offer(player);
        }
    }

    private boolean hasGameFinished() {
        return activePlayers.size() == 1;
    }

    private void movePlayer(Player player, int roll) {
        int currentPosition = player.getCurrentPosition();
        int finalPosition = board.determineFinalPosition(currentPosition, roll);

        player.updatePosition(finalPosition);

        output.print(String.format(PLAYER_MOVED_MESSAGE, player.getName(), roll, currentPosition, finalPosition));
    }

    private boolean hasPlayerWon(Player player) {
        return board.hasPlayerReachedBoardEnd(player);
    }
}
