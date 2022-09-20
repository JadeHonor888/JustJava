package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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
        TextView cost = (TextView) findViewById(R.id.cost);
        String price = cost.getText().toString();
        String text = "ORDER FOR: " + name + "\n" +
                        "Total: " + price;
        composeEmail(text);
    }

    public void getName(View view)
    {
        EditText enterName = (EditText) findViewById(R.id.enterName);
        name = enterName.getText().toString();
    }

    public void toppings1(View view) {hasWhippedCream = !hasWhippedCream;displayPrice(numOfCoffees * 5);}
    public void toppings2(View view) {hasChocolate = !hasChocolate;displayPrice(numOfCoffees * 5);}

    public void add(View view)
    {
        addCoffee(numOfCoffees);
        displayPrice(numOfCoffees * 5);
    }

    public void subtract(View view)
    {
        subtractCoffee(numOfCoffees);
        displayPrice(numOfCoffees * 5);
    }

    private void addCoffee(int num)
    {
        if(num < 100)
        {
            numOfCoffees++;
            display(numOfCoffees);
        }
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
        String text = "";
        if (hasChocolate)
        {
            text = "Has chocolate. \n" + text;
            num += 2 * numOfCoffees;
        }
        if (hasWhippedCream)
        {
            text = "Has whipped cream. \n" + text;
            num += 1 * numOfCoffees;
        }
        text =  text + "\nTotal: " + NumberFormat.getCurrencyInstance().format(num);
        cost.setText(text);
    }

    public void composeEmail(String text)
    {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Coffee Order");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}