package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when the button is clicked
    public void submitOrder(View view)
    {
        display(1);
        displayPrice(1 * 5);
    }

    //display sets the TextView to 1
    private void display(int num)
    {
        TextView howMany = (TextView) findViewById(R.id.how_many);
        howMany.setText("" + num);
    }

    private void displayPrice(int num)
    {
        TextView cost = (TextView) findViewById(R.id.cost);
        cost.setText(NumberFormat.getCurrencyInstance().format(num));
    }
}