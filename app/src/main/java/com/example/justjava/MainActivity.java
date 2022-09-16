package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numOfCoffees = 0;
    boolean hasWhippedCream = false;
    boolean hasChocolate = false;
    String name;
    //when the button is clicked
    public void submitOrder(View view)
    {
        display(numOfCoffees);
        displayPrice(numOfCoffees * 5);
    }

    public void getName(View view)
    {
        EditText enterName = (EditText) findViewById(R.id.enterName);
        //enterName.setOnClickListener(findViewById(R.id.enterName));
        name = enterName.getText().toString();
    }

    public void toppings1(View view) {hasWhippedCream = !hasWhippedCream;}
    public void toppings2(View view) {hasChocolate = !hasChocolate;}

    public void add(View view)
    {
        addCoffee(numOfCoffees);
    }

    public void subtract(View view)
    {
        subtractCoffee(numOfCoffees);
    }

    private void addCoffee(int num)
    {
        numOfCoffees++;
        display(numOfCoffees);
    }

    private void subtractCoffee(int num)
    {
        if (numOfCoffees > 0)
        {
            numOfCoffees--;
            display(numOfCoffees);
        }
    }

    private void display(int num)
    {
        TextView howMany = (TextView) findViewById(R.id.how_many);
        howMany.setText("" + num);
    }

    private void displayPrice(int num)
    {
        TextView cost = (TextView) findViewById(R.id.cost);
        String text =   "Name: " + name +
                        "\nTotal: " + NumberFormat.getCurrencyInstance().format(num) +
                        "\nThank you!";
        if (hasChocolate)
        {
            text = "Has chocolate. \n" + text;
        }
        if (hasWhippedCream)
        {
            text = "Has whipped cream. \n" + text;
        }
        cost.setText(text);
    }
}