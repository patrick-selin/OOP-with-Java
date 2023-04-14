package dev.m3s.programming2.homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordList {

    //**********    ATTRIBUTES/PARAMETERS
    ArrayList<String> wordsList = new ArrayList<>();


    //**********    CONSTRUCTORS
    public WordList(File wordListTxtFile) throws FileNotFoundException {
        setWordList(wordListTxtFile);
    }


    //**********    METHODS
    public void setWordList(File wordListTxtFile ) throws FileNotFoundException {
        Scanner textScanner = new Scanner(wordListTxtFile);

        while(textScanner.hasNextLine()) {
            wordsList.add(textScanner.nextLine());
        }
    }


    public ArrayList<String> giveWords() {
        // The method returns words of the wordlist
        return wordsList;
    }

}
