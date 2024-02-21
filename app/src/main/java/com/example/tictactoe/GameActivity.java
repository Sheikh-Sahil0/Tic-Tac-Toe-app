package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Toolbar tbGameActivity;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonReset;
    TextView txtResult,txtPlayerOne,txtPlayerTwo,txtCountPlayerOne,txtCountPlayerTwo;
    int flag = 0,countPlayerOne = 0,countPlayerTwo = 0,count = 0,win = 0;
    Animation resultAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Initialization
        init();

        // taking the data from previous activity
        Intent fromAct = getIntent();

        // Storing the data
        String playerOneName = fromAct.getStringExtra("Player One Name");
        String playerTwoName = fromAct.getStringExtra("Player Two Name");

        // Setting this names on textView
        txtPlayerOne.setText(playerOneName);
        txtPlayerTwo.setText(playerTwoName);

        //if reset button clicked
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call this function which will reset all the views
                resetAll();
            }
        });

        // Setting back button on toolbar
        setSupportActionBar(tbGameActivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Setting control on button for back
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void perform (View getButton) {
        Button currButton = (Button) getButton;
        resultAnim = AnimationUtils.loadAnimation(this,R.anim.result_animation);

        // Checking if button is null
        if ( currButton.getText().toString().equals("") && win == 0) {
            count++;

            //Checking whose turn is that
            if ( flag == 0 ) {
                countPlayerOne++;
                currButton.setText("X");
                currButton.setTextColor(getResources().getColor(R.color.txtColorForX));
                txtCountPlayerOne.setText(Integer.toString(countPlayerOne));
                flag = 1;
            } else if ( flag == 1 ) {
                countPlayerTwo++;
                currButton.setText("O");
                currButton.setTextColor(getResources().getColor(R.color.txtColorForO));
                txtCountPlayerTwo.setText(Integer.toString(countPlayerTwo));
                flag = 0;
            }

            // Checking if turns are greater then 4
            if ( count > 4 ) {
                String b1 = button1.getText().toString();
                String b2 = button2.getText().toString();
                String b3 = button3.getText().toString();
                String b4 = button4.getText().toString();
                String b5 = button5.getText().toString();
                String b6 = button6.getText().toString();
                String b7 = button7.getText().toString();
                String b8 = button8.getText().toString();
                String b9 = button9.getText().toString();

                // Checking if row 1 wins
                if ( b1.equals(b2) && b2.equals(b3) && !b1.equals("") ) {
                    //Checking who wins this game
                    if ( b1.equals("X") ){
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerOne.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    } else if ( b1.equals("O") ) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerTwo.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    }
                    win = 1;
                }
                // Checking if row 2 wins
                else if ( b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //Checking who wins this game
                    if ( b4.equals("X") ) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerOne.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    } else if ( b4.equals("O") ) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerTwo.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    }
                    win = 1;
                }
                //Checking if row 3 wins
                else if ( b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //Checking who wins this game
                    if (b7.equals("X")) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerOne.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    } else if (b7.equals("O")) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerTwo.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    }
                    win = 1;
                }
                //Checking if column 1 wins
                else if ( b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //Checking who wins this game
                    if ( b1.equals("X") ){
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerOne.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    } else if ( b1.equals("O") ) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerTwo.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    }
                    win = 1;
                }
                //Checking if column 2 wins
                else if ( b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //Checking who wins this game
                    if ( b2.equals("X") ){
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerOne.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    } else if ( b2.equals("O") ) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerTwo.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    }
                    win = 1;
                }
                //Checking if column 3 wins
                else if ( b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //Checking who wins this game
                    if ( b3.equals("X") ){
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerOne.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    } else if ( b3.equals("O") ) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerTwo.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    }
                    win = 1;
                }
                //Checking if diagonal from left top to right bottom wins
                else if ( b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //Checking who wins this game
                    if ( b1.equals("X") ){
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerOne.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    } else if ( b1.equals("O") ) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerTwo.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    }
                    win = 1;
                }
                //Checking if diagonal from right top to left bottom wins
                else if ( b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    //Checking who wins this game
                    if ( b3.equals("X") ){
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerOne.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    } else if ( b3.equals("O") ) {
                        txtResult.setText(getResources().getString(R.string.win) + txtPlayerTwo.getText().toString());
                        txtResult.setAnimation(resultAnim);
                    }
                    win = 1;
                }
                //Checking if game has drawn
                else if ( count == 9 ) {
                    txtResult.setText("Well Played, the game has been drawn");
                    txtResult.setAnimation(resultAnim);
                    win = 1;
                }
            }

        }
    }

    public void init() {
        tbGameActivity = findViewById(R.id.gameToolbar);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonReset = findViewById(R.id.btnReset);
        txtResult = findViewById(R.id.txtResult);
        txtPlayerOne = findViewById(R.id.txtPlayerOne);
        txtPlayerTwo = findViewById(R.id.txtPlayerTwo);
        txtCountPlayerOne = findViewById(R.id.txtCountPlayerOne);
        txtCountPlayerTwo = findViewById(R.id.txtCountPlayerTwo);
    }
    public void resetAll(){
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        txtResult.setText("");
        txtResult.clearAnimation();
        txtCountPlayerOne.setText("0");
        txtCountPlayerTwo.setText("0");
        flag = 0;
        count = 0;
        win = 0;
        countPlayerOne = 0;
        countPlayerTwo = 0;
    }
}