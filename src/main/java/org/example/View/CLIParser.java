package org.example.View;
import org.example.Exception.CLIException;
import org.example.Exception.GameException;
import org.example.Model.Game;
import org.example.Service.GameService;

import java.util.List;
import java.util.Scanner;

public class CLIParser {
    GameService gameService;
    public CLIParser() {
        gameService = new GameService();
    }

    public void parseCommandReturnOutput(String command) throws CLIException, GameException {
        if (command.equals("add")) {
            interpretAddAction();
        } else if (command.equals("list")) {
            interpretListAction();
        } else if (command.equals("search")) {
            interpretSearchAction();
        } else {
            throw new CLIException("Try a valid command..");
        }
    }

    public void interpretAddAction() throws GameException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter game title");
        String titleInput = sc.nextLine();


        System.out.println("Enter game release year (XXXX format)");
        String releaseYearInputString = sc.nextLine();
        int numReleaseYear = Integer.parseInt(releaseYearInputString);

        System.out.println("Enter game description (optional)");
        String descriptionInput = sc.nextLine();

        System.out.println("Is this a digital game? (yes/no)");
        String formatDigitalInputString = sc.nextLine();
        boolean boolFormatDigital = false;
            if (formatDigitalInputString.equals("yes")){
                boolFormatDigital = true; }
            else if (formatDigitalInputString.equals("no")){
                ; }
            else {
                System.out.println ("Please enter 'yes' or 'no'");
                return;
            }

        gameService.addGame(titleInput, numReleaseYear, descriptionInput, boolFormatDigital);
        System.out.println("Game added!");
    }

    public void interpretListAction() {
        List<Game> games = gameService.getAllGame();
        System.out.println("Here are your games: " + games.toString());
    }

    public void interpretSearchAction() {
        Scanner sc = new Scanner(System.in);
        String titleInput = sc.nextLine();
        Game matchingGame = gameService.getGameByTitle(titleInput);
        if (matchingGame == null) {
            System.out.println("There were no matches found.");
        }
        else {
            System.out.println("Here are your match(es): "+matchingGame.toString());
        }
    }
}

