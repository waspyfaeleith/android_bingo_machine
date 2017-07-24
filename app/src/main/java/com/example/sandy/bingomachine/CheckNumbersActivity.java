package com.example.sandy.bingomachine;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;

public class CheckNumbersActivity extends AppCompatActivity {

    private ArrayList<Integer> allNumbers;
    private ArrayList<Integer> calledNumbers;
    private GridView numberGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_numbers);

        numberGrid = (GridView)findViewById(R.id.numberGrid);

        Intent intent = getIntent();

        calledNumbers = (ArrayList<Integer>) intent.getSerializableExtra("called_numbers");
        Collections.sort(calledNumbers);
        Log.d("Bingo Machine", calledNumbers.toString());

        allNumbers = new ArrayList<>();
        for (int i = 1; i < 91; i++) {
            this.allNumbers.add(i);
        }

        NumberGridAdapter numberGridAdapter = new NumberGridAdapter(this, allNumbers, calledNumbers);

        numberGrid.setAdapter(numberGridAdapter);

    }
}
