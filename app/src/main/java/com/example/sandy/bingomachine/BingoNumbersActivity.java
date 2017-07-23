package com.example.sandy.bingomachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BingoNumbersActivity extends AppCompatActivity {
    TextView number;
    Button getNumber;
    Button newGame;
    BingoNumbers bingoNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo_numbers);

        number = (TextView)findViewById(R.id.number);
        getNumber = (Button)findViewById(R.id.get_number);
        newGame = (Button)findViewById(R.id.new_game);

        bingoNumbers = new BingoNumbers();
    }

    public void getNumberButtonClick(View Button) {
        Log.d("Bingo Machine", "getting number");
        if (bingoNumbers.count() > 0) {
            Integer num = bingoNumbers.getNumber();
            number.setText(num.toString());
        } else {
            number.setText("All numbers are out!");
        }
    }

    public void newGameButtonClicked (View Button) {
        Log.d("Bingo Machine", "new game");
        bingoNumbers.resetNumbers();
        number.setText("");
    }
}
