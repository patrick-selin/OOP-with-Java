package dev.m3s.programming2.homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        File wordListTxtFile = new File("C:\\Users\\Patrick\\a_CODE\\PROJECTS\\java\\JAVA-kurssi\\Java 2 - Homework 4 - Hangman\\src\\dev\\m3s\\programming2\\homework4\\words.txt");
        WordList wordList = new WordList(wordListTxtFile);

        Hangman game1 = new Hangman(wordList, 5);

        while (true) {
            System.out.println("The hidden word...");
            System.out.println(game1.printState());
            System.out.println("Guess left: " + game1.guessesLeft());
            System.out.println("Guessed letters: " + game1.guesses());

            //kysy kirjainta
            System.out.print("Guess a letter: ");
            char letterGuess = input.next().charAt(0);
            game1.guess(letterGuess);
            if (game1.guessesLeft() < 1) {
                System.out.println("Sorry, you lost!");
                System.out.println("The hidden word was: " + game1.word());
                break;
            }

            if (game1.theEnd()) {
                System.out.println("Congratulations! You won!!!");
                System.out.println("The hidden word was: " + game1.word());
                break;
            }

            System.out.println();

        }



    }
}