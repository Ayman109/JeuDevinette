package com.example.jeudevinette.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeudevinette.R;

public class Winner extends AppCompatActivity {
    private TextView winner ;
    private Button replay ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        init();
        replays();
        winner.setText("Bravo "+getIntent().getStringExtra("winner")+" Vous avez Gagner");


    }
    public void init(){
        winner = (TextView) findViewById(R.id.winner);
        replay = (Button) findViewById(R.id.btnReplay);
    }
    public void replays(){
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),home.class);
                startActivity(intent);
            }
        });
    }


}