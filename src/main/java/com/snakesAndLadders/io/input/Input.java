package com.snakesAndLadders.io.input;

import java.util.Scanner;

public interface Input {
    Input CONSOLE = () -> new Scanner(System.in).nextLine();

    String read();
}
