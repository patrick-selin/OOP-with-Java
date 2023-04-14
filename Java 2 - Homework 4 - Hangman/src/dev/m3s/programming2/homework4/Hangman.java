package dev.m3s.programming2.homework4;

import java.util.ArrayList;

public class Hangman {

    //**********    ATTRIBUTES/PARAMETERS
    //***********************************

    String word;
    int GUESSES = 5;
    ArrayList<Character> guessedWords = new ArrayList<>();
    ArrayList<Character> hiddenWord = new ArrayList<>();


    int guesses = GUESSES;



    //**********    CONSTRUCTORS
    //***********************************

    public Hangman(WordList wordList, int guesses) {

        randomWord(wordList);
        this.guesses = guesses;

    }


    //**********    METHODS
    //***********************************


    public boolean guess(Character c) {
        // compare if char entered is same as given parameter
        // also add the char to te guessedWords-list
        // if char löytyy sanasta, return true
        // jos ei, -1 guesses ja return false

//        if (word.indexOf(c))
        guessedWords.add(c);

        return true;
    }


    public void printWordState() {
        for (int i = 0; i <word.length(); i++) {
            if(guessedWords.contains(word.charAt(i))) {
                System.out.println(word.charAt(i));

            }
            else {
                System.out.println("-");
            }

        }
        System.out.println();
    }

    public int guessesLeft() {
        return this.guesses;
    }




    public void randomWord(WordList words) {
        String randomWord = words.giveWords().get((int)(Math.random()
                * words.giveWords().size()));

        this.word = randomWord;

    }

  public ArrayList<Character> guesses () {
        return guessedWords;
    }

}
