package edu.hanu.a1_2001040188;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView hiragana, katakana;
    Button btnHira, btnKata;
    MediaPlayer mediaPlayer;
    ScrollView viewHira, viewKata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHira = findViewById(R.id.btnHira);
        btnHira.setBackgroundColor(Color.parseColor("#207AC1"));
        btnKata = findViewById(R.id.btnKata);
        btnKata.setBackgroundColor(Color.parseColor("#ffffff"));
    }
    public void moveToHira(View view) {
        btnHira =findViewById(R.id.btnHira);
        viewHira = findViewById(R.id.viewHira);
        hiragana = findViewById(R.id.Hira);
        btnKata =findViewById(R.id.btnKata);
        viewKata = findViewById(R.id.viewKata);
        katakana = findViewById(R.id.Kata);
        if (viewHira.getVisibility() == View.GONE) {
            btnKata.setBackgroundColor(Color.parseColor("#ffffff"));
            btnHira.setBackgroundColor(Color.parseColor("#207AC1"));
            viewKata.animate().translationXBy(-1000f).setDuration(700).withEndAction(new Runnable() {
                @Override
                public void run() {
                    viewKata.animate().translationXBy(1000f).setDuration(0);
                    hiragana.setVisibility(View.VISIBLE);
                    viewHira.setVisibility(View.VISIBLE);
                    katakana.setVisibility(View.INVISIBLE);
                    viewKata.setVisibility(View.GONE);
                }
            });
        }
    }
    public void moveToKata(View view) {
        btnKata =findViewById(R.id.btnKata);
        viewKata = findViewById(R.id.viewKata);
        katakana = findViewById(R.id.Kata);
        btnHira =findViewById(R.id.btnHira);
        viewHira = findViewById(R.id.viewHira);
        hiragana = findViewById(R.id.Hira);
        if (viewKata.getVisibility() == View.GONE) {
            btnHira.setBackgroundColor(Color.parseColor("#ffffff"));
            btnKata.setBackgroundColor(Color.parseColor("#207AC1"));
            viewHira.animate().translationXBy(-1000f).setDuration(700).withEndAction(new Runnable() {
                @Override
                public void run() {
                    viewHira.animate().translationXBy(1000f).setDuration(0);
                    katakana.setVisibility(View.VISIBLE);
                    viewKata.setVisibility(View.VISIBLE);
                    hiragana.setVisibility(View.INVISIBLE);
                    viewHira.setVisibility(View.GONE);
                }
            });
        }
    }
    public void sound(View view) {
        ImageButton alphabets = (ImageButton) view;
        if(mediaPlayer != null){
            mediaPlayer.reset();
        }
        mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier((String) alphabets.getTag(), "raw", getPackageName()));
        mediaPlayer.start();

    }
}
