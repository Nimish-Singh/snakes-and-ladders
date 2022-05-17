package com.snakesAndLadders;

import com.snakesAndLadders.io.input.Input;
import com.snakesAndLadders.io.output.Output;
import com.snakesAndLadders.model.Game;

import static com.snakesAndLadders.Initialiser.initialiseGameFromInput;
import static com.snakesAndLadders.Initialiser.initialiseSampleGame;

public class Driver {
    public static void main(String[] args) {
//        Game game = initialiseSampleGame(Input.CONSOLE, Output.CONSOLE);
        Game game = initialiseGameFromInput(Input.CONSOLE, Output.CONSOLE);
        game.play();
    }
}
