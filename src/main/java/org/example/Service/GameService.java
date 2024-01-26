package org.example.Service;

import org.example.Main;
import org.example.Exception.GameException;
import org.example.Model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    List<Game> games;
    public GameService(){
        games = new ArrayList<>();
    }

    public void addGame(String title, int releaseYear, String description, boolean formatDigital) throws GameException {
    Main.log.info("Attempting to add a game." + title +", " + releaseYear +", " + description +", " + formatDigital);

       if (releaseYear < 1500 || releaseYear >= 2025){
           throw new GameException("Release year must be in XXXX format");
       } else if (title.length()<1) {
           throw new GameException("Please enter a valid title");
       }

       Game g = new Game(title, releaseYear, description, formatDigital);
       games.add(g);
    }

    public List<Game> getAllGame(){
        Main.log.info("Now retrieving all games: "+games);
        return games;
    }
}