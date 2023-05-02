package dev.m3s.programming2.homework4;

import java.util.ArrayList;
import java.util.List;

public class Hangman {

    private String word;
    private int guesses = 5;
    private List<Character> guessedWords = new ArrayList<>();
    private int correctCount = 0;


    public Hangman(WordList wordList, int guesses) {
        randomWord(wordList);
        this.guesses = guesses;
    }


    public String printState() {
        String temp = "";

        for (int i = 0; i < word.length(); i++) {
            if (guessedWords.contains(word.charAt(i))) {
                temp += word.charAt(i);
            }
            else {
                temp += "-";
            }
        }
        return temp;
    }


    public boolean guess(Character c) {
        c = Character.toLowerCase(c);

        if (word.indexOf(c) != -1 &&
            !guessedWords.contains(c)) {
            correctCount++;
        }

        if (!guessedWords.contains(c)) {
            guessedWords.add(c);
        }

        if (word.indexOf(c) == -1) {
            guesses--;
            return false;
        }
        return true;
    }


    public List<Character> guesses () {
        return guessedWords;
    }


    public int guessesLeft() {
        return this.guesses;
    }


    public String word() {
        return word;
    }


    public boolean theEnd() {
        return word.length() == correctCount || guessesLeft() < 1 ;
    }


   private void randomWord(WordList words) {
        this.word = words.giveWords().get((int)
                   (Math.random() * words.giveWords().size()));
    }
}
