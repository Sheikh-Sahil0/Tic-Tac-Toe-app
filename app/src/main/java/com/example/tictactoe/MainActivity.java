package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar tbPlayerDetail;
    EditText edtPlayerOne,edtPlayerTwo;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization of all views
        init();

        Intent playerDetails = new Intent(MainActivity.this, GameActivity.class);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerOneName = edtPlayerOne.getText().toString();
                String playerTwoName = edtPlayerTwo.getText().toString();

                playerDetails.putExtra("Player One Name",playerOneName);
                playerDetails.putExtra("Player Two Name",playerTwoName);

                startActivity(playerDetails);
            }
        });
    }

    public void init() {
        tbPlayerDetail = findViewById(R.id.playerToolbar);
        edtPlayerOne = findViewById(R.id.edtPlayerOne);
        edtPlayerTwo = findViewById(R.id.edtPlayerTwo);
        btnStart = findViewById(R.id.btnStart);
    }
}