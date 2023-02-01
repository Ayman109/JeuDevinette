package com.example.jeudevinette.view;
import static com.example.jeudevinette.R.drawable.player_turn_border_form;
import static com.example.jeudevinette.R.drawable.player_turn_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeudevinette.R;
import com.example.jeudevinette.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private TextView txtResultat ,txtplayer1 ,txtplayer2 ;
    private int valeurAChercher;
    private Button comparer;
    private Controller controller;
    private String player1 , player2 , playerOn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        controller = Controller.getInstance();
        ecouteComparer();
    }
    private void ecouteComparer(){
        comparer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valeurSaisie =0 ;
                try{
                     valeurSaisie =Integer.parseInt(txtNombre.getText().toString());
                }catch (Exception e) {}

                if(valeurSaisie == 0 ) Toast.makeText(getApplicationContext(),"Pas de valeur Saisie",Toast.LENGTH_LONG).show();
                else{
                    afficheResult(valeurSaisie);
                    txtNombre.setText("");
                    if(playerOn.equals(player1)){ playerOn=player2;
                        txtplayer2.setBackgroundResource(player_turn_border_form);
                        txtplayer1.setBackgroundResource(player_turn_form);
                    }
                    else {playerOn = player1;
                        txtplayer1.setBackgroundResource(player_turn_border_form);
                        txtplayer2.setBackgroundResource(player_turn_form);
                    }
                }


            }
        });

    }
    public void afficheResult(int valeurSaisie){
        controller.createProfile(valeurSaisie,valeurAChercher);
        if(controller.getResultat(playerOn).equals(playerOn)){
            //intent
            Intent intent = new Intent(getApplicationContext(),Winner.class);
            intent.putExtra("winner",playerOn);
            startActivity(intent);
        }
        else txtResultat.setText(controller.getResultat(playerOn));
    }

    private void init(){
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtResultat = (TextView) findViewById(R.id.txtResultat);
        txtplayer1= (TextView) findViewById(R.id.player1);
        txtplayer2= (TextView) findViewById(R.id.player2);
        valeurAChercher = (int) ((Math.random() * 100) + 1);
        comparer = (Button) findViewById(R.id.btnComparer);
        player1 = getIntent().getStringExtra("player1");
        player2 =getIntent().getStringExtra("player2");
        txtplayer1.setText(player1);
        txtplayer2.setText(player2);
        txtplayer1.setBackgroundResource(player_turn_border_form);
        playerOn = player1;

    }

}