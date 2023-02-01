package com.example.jeudevinette.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jeudevinette.R;
import com.example.jeudevinette.controller.HomeController;
import com.example.jeudevinette.model.Players;

public class home extends AppCompatActivity {
    EditText nom1,nom2;
    Button btnJouer ;
    HomeController homeController ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        ecouteJouer();

    }
    private void init(){
        nom1 = (EditText) findViewById(R.id.txtNomPlayer1);
        nom2 = (EditText) findViewById(R.id.txtNomPlayer2);
        btnJouer = (Button) findViewById(R.id.btnJouer);

        homeController = HomeController.getInstance(getApplicationContext());
        if(homeController.getPlayerName1() !=null){
            nom1.setText(homeController.getPlayerName1());
        }
        if(homeController.getPlayerName2() != null){
            nom2.setText(homeController.getPlayerName2());
        }


    }

    private void ecouteJouer(){
        btnJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nom1.getText().toString().equals("") || nom2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Entre les noms du 2 joueurs", Toast.LENGTH_SHORT).show();
                else{

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("player1",nom1.getText().toString());
                    intent.putExtra("player2",nom2.getText().toString());
                    homeController.createPlayers(nom1.getText().toString(),nom2.getText().toString(),getApplicationContext());
                    startActivity(intent);
                }
            }
        });
    }


}