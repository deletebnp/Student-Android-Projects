package net.androidbootcamp.celticsongs;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpJig, mpBag;
    int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.btnJig);
        button2 = (Button)findViewById(R.id.btnBagPipes);
        button1.setOnClickListener(bJig);
        button2.setOnClickListener(bBag);
        mpJig = new MediaPlayer();
        mpJig = MediaPlayer.create(this,R.raw.jig);
        mpBag = new MediaPlayer();
        mpBag = MediaPlayer.create(this,R.raw.bagpipes);
        playing = 0;
    }
    Button.OnClickListener bJig = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpJig.start();
                    playing =1;
                    button1.setText("Pause Jig Song");
                    button2.setVisibility(View.INVISIBLE);

                    break;
                case 1:
                    mpJig.pause();
                    playing =0;
                    button1.setText("Play Jig Song");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
    Button.OnClickListener bBag = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpBag.start();
                    playing =1;
                    button2.setText("Pause Drums Song");
                    button1.setVisibility(View.INVISIBLE);

                    break;
                case 1:
                    mpBag.pause();
                    playing =0;
                    button2.setText("Play Drums Song");
                    button1.setVisibility(View.VISIBLE);
                    break;

            }
        }



    };
}
