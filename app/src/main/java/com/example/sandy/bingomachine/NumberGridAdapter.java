package com.example.sandy.bingomachine;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sandy on 24/07/2017.
 */

public class NumberGridAdapter extends ArrayAdapter<Integer> {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> calledNumbers;
    private int count;

    public NumberGridAdapter(Context context, ArrayList<Integer> allNumbers, ArrayList<Integer> calledNumbers) {
        super(context, 0, allNumbers);
        this.numbers = new ArrayList<>(allNumbers);
        this.calledNumbers = new ArrayList<>(calledNumbers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_grid_item, parent, false);
        }

        TextView text = (TextView) view.findViewById(R.id.numberItem);
        Integer number = numbers.get(position);
        text.setText(number.toString());
        if (calledNumbers.contains(number)) {
            text.setTextColor(Color.RED);
        }

        return view;
    }
}
