package com.snakesAndLadders.io.output;

public interface Output {
    Output CONSOLE = System.out::println;

    void print(String message);
}
