package com.example.sandy.bingomachine;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sandy on 19/07/2017.
 */

public class BingoNumbers {
    private ArrayList<Integer> numbers;

    public BingoNumbers() {
        this.numbers = new ArrayList<Integer>();
        this.setUp();
    }

    public Integer getNumber() {
        Collections.shuffle(numbers);
        Integer number = numbers.get(0);
        numbers.remove(0);
        return number;
    }

    public int count() {
        return this.numbers.size();
    }

    public void resetNumbers() {
        this.numbers.clear();
        this.setUp();
    }

    private void setUp() {
        for (int i = 1; i < 91; i++) {
            this.numbers.add(i);
        }
    }
}
