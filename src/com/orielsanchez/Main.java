package com.orielsanchez;

import java.util.*;

public class Main {

    private static final List<Options> VALUES = Collections.unmodifiableList(Arrays.asList(Options.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private static String name;
    private static int playerScore = 0;
    private static int computerScore = 0;

    public static Options randomChoice() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static void playAgain() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nPlay again? Y/N");
        System.out.print("> ");
        String input = scnr.next();
        if (input.equalsIgnoreCase("Y")) {
            playerScore = 0;
            computerScore = 0;
            game();
        } else {
            System.out.println("Goodbye.");
        }

    }

    public static void score(Options choice, Options computerChoice) {
        System.out.println();
        if (choice == computerChoice) {
            System.out.println(name + ": " + playerScore);
            System.out.println("Computer: " + computerScore);
            checkScoreForWinner(playerScore, computerScore);
        } else if (choice == Options.ROCK && computerChoice == Options.PAPER) {
            computerScore++;
            System.out.println(name + ": " + playerScore);
            System.out.println("Computer: " + computerScore);
            checkScoreForWinner(playerScore, computerScore);
        } else if (choice == Options.ROCK && computerChoice == Options.SCISSORS) {
            playerScore++;
            System.out.println(name + ": " + playerScore);
            System.out.println("Computer: " + computerScore);
            checkScoreForWinner(playerScore, computerScore);
        } else if (choice == Options.PAPER && computerChoice == Options.SCISSORS) {
            computerScore++;
            System.out.println(name + ": " + playerScore);
            System.out.println("Computer: " + computerScore);
            checkScoreForWinner(playerScore, computerScore);
        } else if (choice == Options.PAPER && computerChoice == Options.ROCK) {
            playerScore++;
            System.out.println(name + ": " + playerScore);
            System.out.println("Computer: " + computerScore);
            checkScoreForWinner(playerScore, computerScore);
        } else if (choice == Options.SCISSORS && computerChoice == Options.ROCK) {
            computerScore++;
            System.out.println(name + ": " + playerScore);
            System.out.println("Computer: " + computerScore);
            checkScoreForWinner(playerScore, computerScore);
        } else if (choice == Options.SCISSORS && computerChoice == Options.PAPER) {
            playerScore++;
            System.out.println(name + ": " + playerScore);
            System.out.println("Computer: " + computerScore);
            checkScoreForWinner(playerScore, computerScore);
        }
    }

    public static void checkScoreForWinner(int playerScore, int computerScore) {

        if (playerScore == 5) {
            System.out.println("You win!");
            playAgain();
        } else if (computerScore == 5) {
            System.out.println("Computer wins!");
            playAgain();
        } else {
            game();
        }
    }

    public static void game() {
        Scanner scnr = new Scanner(System.in);
        String choice;
        System.out.println("\nRock, paper, scissors. Shoot!");
        System.out.print("> ");
        choice = scnr.next();
        while ((!choice.equalsIgnoreCase(String.valueOf(Options.ROCK)))
                && (!choice.equalsIgnoreCase(String.valueOf(Options.PAPER)))
                && (!choice.equalsIgnoreCase(String.valueOf(Options.SCISSORS)))) {
            choice = scnr.next();
        }


        Options playerChoice = Options.valueOf(choice.toUpperCase());

        Options computerChoice = randomChoice();
        if (playerChoice == Options.ROCK) {
            System.out.println("You chose " + playerChoice + " and the computer chose " + computerChoice);
            score(playerChoice, computerChoice);
        } else if (playerChoice == Options.PAPER) {
            System.out.println("You chose " + playerChoice + " and the computer chose " + computerChoice);
            score(playerChoice, computerChoice);
        } else if (playerChoice == Options.SCISSORS) {
            System.out.println("You chose " + playerChoice + " and the computer chose " + computerChoice);
            score(playerChoice, computerChoice);
        }
        else {
            game();
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Name?");
        System.out.print("> ");
        name = scnr.next();
        System.out.println("\nWelcome " + name + ".");
        System.out.println("First to 5 wins.");
        game();
    }
}
