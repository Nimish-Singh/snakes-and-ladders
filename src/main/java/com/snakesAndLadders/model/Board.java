package com.snakesAndLadders.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {
    private int start;
    private int end;
    private Map<Integer, Entity> snakesLaddersMap;

    public Board(int start, int end, List<Snake> snakes, List<Ladder> ladders) {
        this.start = start;
        this.end = end;
        initialiseEntityMap(snakes, ladders);
    }

    private void initialiseEntityMap(List<Snake> snakes, List<Ladder> ladders) {
        Map<Integer, Entity> snakesMap = snakes.stream()
                .collect(Collectors.toMap(Snake::getStart, snake -> snake));
        Map<Integer, Entity> laddersMap = ladders.stream()
                .collect(Collectors.toMap(Ladder::getStart, ladder -> ladder));

        snakesLaddersMap = new HashMap<>();
        snakesLaddersMap.putAll(snakesMap);
        snakesLaddersMap.putAll(laddersMap);
    }

    public int determineFinalPosition(int currentPosition, int roll) {
        int finalPosition = currentPosition + roll;

        if (finalPosition > end)
            return currentPosition;

        while (snakesLaddersMap.get(finalPosition) != null)
            finalPosition = snakesLaddersMap.get(finalPosition).giveFinalPosition();

        return finalPosition;
    }

    public boolean hasPlayerReachedBoardEnd(Player player) {
        return player.getCurrentPosition() == end;
    }
}
