package com.example.madlibmobile;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText textAdjective;
    private EditText textPastVerb;
    private EditText textColor;
    private EditText textNoun;
    private EditText textMadLib;
    private Button button;
    public void displayText() {
        String message;
        message="The " + textColor.getText() + " dragon " + textPastVerb.getText()
                + " at the " + textAdjective.getText() + " " + textNoun.getText() +".";
        message += "\n";
        message += "And they lived happily ever after.";
        message += "\n";
        message += "The end.";
        System.out.println(message);
        textMadLib.setText(message);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textAdjective = (EditText) findViewById(R.id.textAdjective);
        textPastVerb = (EditText) findViewById(R.id.textPastVerb);;
        textColor = (EditText) findViewById(R.id.textColor);;
        textNoun = (EditText) findViewById(R.id.textNoun);;
        textMadLib = (EditText) findViewById(R.id.ResultText);;
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayText();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        displayText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}