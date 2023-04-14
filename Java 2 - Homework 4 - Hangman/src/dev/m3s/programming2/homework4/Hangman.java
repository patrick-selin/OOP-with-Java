package dev.m3s.programming2.homework4;

import java.util.ArrayList;

public class Hangman {

    //**********    ATTRIBUTES/PARAMETERS
    //***********************************

    String word;
    int guesses = 5;
    ArrayList<Character> guessedWords = new ArrayList<>();
    int correctCount = 0;


    //**********    CONSTRUCTORS
    //***********************************

    public Hangman(WordList wordList, int guesses) {
        randomWord(wordList);
        this.guesses = guesses;
    }

    //**********    METHODS
    //***********************************

    public String printState() {

        String temp = "";

        for (int i = 0; i < word.length(); i++) {

            if (guessedWords.contains(word.charAt(i))) {
                temp += word.charAt(i);
//                correctCount++;
            }
            else {
                temp += "-";
            }
        }
        return temp;
    }


    public boolean guess(Character c) {


        if (word.indexOf(c) != -1 &&
            !guessedWords.contains(c)) {
            correctCount++;
        }



        //tarkista löytyytö jo listalta
        if (!guessedWords.contains(c)) {
            guessedWords.add(c);
        }

        if (word.indexOf(c) == -1) {
            guesses--;
            return false;
        }
        return true;
    }


    public ArrayList<Character> guesses () {
        return guessedWords;
    }


    public int guessesLeft() {
        return this.guesses;
    }


    public String word() {
        return word;
    }


    public boolean theEnd() {
        System.out.println(word.length());
        System.out.println(correctCount);

        if (word.length() == correctCount ) {
            return true;
        }

        return false;
    }


    public void randomWord(WordList words) {
        this.word = words.giveWords().get((int)(Math.random()
                * words.giveWords().size()));

    }


}
