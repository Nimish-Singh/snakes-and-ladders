package com.snakesAndLadders.model;

public class Player {
    private String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void updatePosition(int position) {
        currentPosition = position;
    }
}
