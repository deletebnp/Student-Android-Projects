package net.androidbootcamp.paintcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double gallonConv = 0.004;
    int totalHeight;
    int totalPerimeter;
    double totalFt;
    double totalGal;
    String groupchoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_main);
        final EditText height = (EditText) findViewById(R.id.txtHeight);
        final EditText perimeter = (EditText) findViewById(R.id.txtPerimeter);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);

        Button cost = (Button) findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.txtResult));

            @Override
            public void onClick(View v) {
                totalHeight = Integer.parseInt(height.getText().toString());
                totalPerimeter = Integer.parseInt(perimeter.getText().toString());
                totalFt = totalHeight * totalPerimeter;
                totalGal = totalFt * gallonConv;
                DecimalFormat df = new DecimalFormat("#.##");
                groupchoice = group.getSelectedItem().toString();
                result.setText( df.format(totalGal) + " Gallons of "+ groupchoice+" paint ");
            }
        });
    }




}
