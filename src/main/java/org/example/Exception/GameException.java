package org.example.Exception;

/**
 * Exception that is thrown upon the creation of a invalid game.
 * For instance:
 * releaseYear is not an integer,
 * or empty values for the title, description, etc.
 */
public class GameException extends Exception {
    public GameException(String message){
        super(message);
    }
}