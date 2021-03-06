package com.example.sandy.bingomachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class BingoNumbersActivity extends AppCompatActivity {
    TextView number;
    TextView lingoText;
    Button getNumber;
    Button newGame;
    BingoNumbers bingoNumbers;
    Integer currentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo_numbers);

        number = (TextView)findViewById(R.id.number);
        lingoText = (TextView)findViewById(R.id.lingo);
        getNumber = (Button)findViewById(R.id.get_number);
        newGame = (Button)findViewById(R.id.new_game);

        InputStream input = getResources().openRawResource(R.raw.lingo);
        bingoNumbers = new BingoNumbers(input);

        String lingo = getResources().getString(R.string.eyes_down);
        lingoText.setText(lingo);
    }

    public void getNumberButtonClick(View Button) {
        Log.d("Bingo Machine", "getting number");
        if (bingoNumbers.count() > 0) {
            Integer num = bingoNumbers.getNumber();
            String lingo = bingoNumbers.getLingo(num);
            Log.d("Bingo Machine", "Got " + num + " : " + lingo);
            number.setText(num.toString());
            this.currentNumber = num;
            lingoText.setText(lingo);
        } else {
            lingoText.setText("All numbers are out!");
            number.setText("");
        }
    }

    public void houseCalledButtonClick(View Button) {
        Intent intent = new Intent(BingoNumbersActivity.this, CheckNumbersActivity.class);
        intent.putExtra("called_numbers", this.bingoNumbers.getCalledNumbers() );
        intent.putExtra("last_called_number", this.currentNumber);
        startActivity(intent);
    }

    public void newGameButtonClicked (View Button) {
        Log.d("Bingo Machine", "new game");
        bingoNumbers.resetNumbers();
        number.setText("");
        String lingo = getResources().getString(R.string.eyes_down);
        lingoText.setText(lingo);
    }
}
