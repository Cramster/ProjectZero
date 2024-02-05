package org.example.Service;

import org.example.Exception.CLIException;
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

       if (title.length()<1){
            throw new GameException("Please enter a valid title");
       } else if (releaseYear < 1800 || releaseYear >= 2025){
            throw new GameException("Release year must be in XXXX format");
       }

       Game g = new Game(title, releaseYear, description, formatDigital);
       games.add(g);
    }

    //List function
    public List<Game> getAllGame(){
        Main.log.info("Now retrieving all games: "+games);
        return games;
    }

    //Search function
    public Game getGameByTitle(String title) {
        for (int i = 0; i < games.size(); i=i+1) {
            Game currentGame = games.get(i);
            if (currentGame.getTitle().contains(title)) {
                return currentGame;
            }
        }
        return null;
    }
}