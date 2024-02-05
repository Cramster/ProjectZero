package org.example;

import org.example.Exception.CLIException;
import org.example.Exception.GameException;
import org.example.View.CLIParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CLIParser cliParser = new CLIParser();

        System.out.println("** Welcome to Project Zero: A Game Service **\nCommence project:");

        while(true) {
            System.out.println("Enter: 'add', 'list', or 'search':");
            String input = sc.nextLine();
            try {
                cliParser.parseCommandReturnOutput(input);
            } catch(CLIException exception){
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            } catch(GameException exception){
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }

        }

    }
}