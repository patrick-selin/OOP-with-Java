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

        System.out.println(game1.word + "  <--- Tämä on se sana");

        System.out.println("The hidden word...");
        System.out.println();

        System.out.println("Guess left: " + game1.guessesLeft());
        //kysy kirjainta
        System.out.println("Guess letters: " + game1.guesses());
        char letterGuess = input.next().charAt(0);
        System.out.println(letterGuess);


        game1.guess(letterGuess);
        System.out.println("Guess letters: " + game1.guesses());



    }
}