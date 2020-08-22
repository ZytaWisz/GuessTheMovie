package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    private String hiddenTitle = "";
    private String title = "";
    private int remainingPoints = 10;
    private String wrongLetters = "";
    private int wrongLettersCounter = 0;

    public Game() {
        File file = new File("ListOfMovies.txt");

        try {
            Scanner scanner = new Scanner(file);
            int counterLine = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                counterLine++;

            }
            int choseNumber = (int) (Math.random() * counterLine) + 1;
            Scanner readLine = new Scanner(file);
            int counter = 0;
            while (readLine.hasNextLine()) {
                String line = readLine.nextLine();
                counter++;
                if (counter == choseNumber) {
                    System.out.println("Znalazlem linijke, tytul to " + line);
                    title = line;
                    break;
                }

            }
            hiddenTitle = title.replaceAll("[a-zA-Z]", "_");
            System.out.println(hiddenTitle);

        } catch (FileNotFoundException e) {
            System.out.println("Nie znalazlam pliku");
            System.exit(0);
        }

    }

    public void playGame() {
        boolean hasWon = false;
        while (remainingPoints > 0 && !hasWon) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Guess a letter :");
            String letter = scanner.nextLine();
            if (title.contains(letter)) {
                revealLetters(letter);
                if (hiddenTitle.equals(title)) {
                    hasWon = true;
                }
            } else {
                badGuess(letter);

            }
        }
        if (hasWon) {
            System.out.println(" You WON !!!");
            System.out.println("You have guessed " + hiddenTitle + " correctly.");
        } else {
            System.out.println("You lost!!!");
        }
    }

    private void badGuess(String letter) {
        remainingPoints--;

        if (!wrongLetters.contains(letter)) {
            wrongLetters = wrongLetters + " " + letter;
            wrongLettersCounter++;
        }
        System.out.println("You have guessed (" + wrongLettersCounter + ") wrong letters: " + wrongLetters);

    }

    private void revealLetters(String letter) {
        int index = title.indexOf(letter);
        while (index > -1) {
            StringBuilder sb = new StringBuilder(hiddenTitle);
            sb.setCharAt(index, letter.charAt(0));
            hiddenTitle = sb.toString();
            index = title.indexOf(letter, index + 1);
        }
        System.out.println("You are guessing: " + hiddenTitle);
    }
}
