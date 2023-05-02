package dev.m3s.programming2.homework4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordList {

    private List<String> wordsList = new ArrayList<>();


    public WordList(String filename) throws FileNotFoundException {
        setWordList(filename);
    }


    public void setWordList(String filename) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        Scanner textScanner = new Scanner(reader);

        while(textScanner.hasNextLine()) {
            wordsList.add(textScanner.nextLine());
        }
    }


    public List<String> giveWords() {
        return wordsList;
    }
}
