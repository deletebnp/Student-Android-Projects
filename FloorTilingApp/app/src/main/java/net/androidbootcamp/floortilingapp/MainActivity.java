package net.androidbootcamp.floortilingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    double lengthEntered;
    double widthEntered;
    double totTile;
    double sqArea;
    double convertRate = 1.5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText length = (EditText) findViewById(R.id.txtLength);
        final EditText width =  (EditText) findViewById(R.id.txtWidth);
        final RadioButton op12x12 = (RadioButton) findViewById(R.id.rad12x12);
        final RadioButton op18x18 =  (RadioButton) findViewById(R.id.rad18x18);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lengthEntered = Double.parseDouble(length.getText().toString());
                widthEntered = Double.parseDouble(width.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if (op12x12.isChecked()){
                    if (lengthEntered >= 0) {
                    sqArea = lengthEntered * widthEntered;
                        result.setText(tenth.format(sqArea) + " Tiles");
                    }   else {
                        Toast.makeText(MainActivity.this,"Pick a higher number", Toast.LENGTH_LONG).show();
                    }
                }
           if (op18x18.isChecked()){
               sqArea = lengthEntered * widthEntered;
               totTile = sqArea / convertRate;
               result.setText(tenth.format(totTile) + " Tiles ");
           }
            }

        });
    }
}
