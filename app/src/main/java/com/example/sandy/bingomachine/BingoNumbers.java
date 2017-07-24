package com.example.sandy.bingomachine;

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sandy on 19/07/2017.
 */

public class BingoNumbers {
    private ArrayList<Integer> numbers;
    private Scanner fileReader;
    private HashMap<Integer, String> lingo;

    public BingoNumbers() {
        this.numbers = new ArrayList<Integer>();
        this.setUpNumbers();
    }

    public BingoNumbers(InputStream file) {
        this.numbers = new ArrayList<Integer>();
        this.fileReader = new Scanner(file);
        this.lingo = new HashMap<>();
        this.setUpNumbers();
        this.setUpLingo();
    }

    public Integer getNumber() {
        Collections.shuffle(numbers);
        Integer number = numbers.get(0);
        numbers.remove(0);
        return number;
    }

    public String getLingo(Integer number) {
        return lingo.get(number);
    }

    public int count() {
        return this.numbers.size();
    }

    public void resetNumbers() {
        this.numbers.clear();
        this.setUpNumbers();
    }

    private void setUpNumbers() {
        for (int i = 1; i < 91; i++) {
            this.numbers.add(i);
        }
    }

    private void setUpLingo() {
        boolean moreLinesToRead = fileReader.hasNextLine();
        int number = 1;
        while (moreLinesToRead) {
            String lineOfText = fileReader.nextLine();
            Log.d("Bingo Machine", "adding " + number + " : " + lineOfText + " to hashmap");
            this.lingo.put(number, lineOfText);
            moreLinesToRead = fileReader.hasNextLine();
            number++;
        }
    }
}

