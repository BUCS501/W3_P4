package com.example.w3_p4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class card_game extends AppCompatActivity {

    private TextView opr1;
    private TextView opr2;
    private TextView oper;
    private Button Gen;
    private Button Submit;
    private EditText input;
    private int[] num1 = new int[]{-1,0,0,0,0,0,0,0,0,0};
    private int[] num2 = new int[10];
    private int[] op = new int[10];
    private Integer score = 0;
    private Integer counter = 0;
    private int[] answer = new int[10];
    private int[] ans = new int[10];

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_card_game);

        opr1 = (TextView) findViewById(R.id.opr1);
        opr2 = (TextView) findViewById(R.id.opr2);
        Gen = (Button) findViewById(R.id.gen);
        Submit = (Button) findViewById(R.id.submit);
        oper = (TextView) findViewById(R.id.oper);
        input = (EditText) findViewById(R.id.input);

        Gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();

                for (int i = 0; i < 10; i++) {
                    num1[i] = rand.nextInt(99) + 1;
                    num2[i] = rand.nextInt(20) + 1;
                    op[i] = rand.nextInt(2);

                    if (op[i] == 0) {
                        answer[i] = num1[i] + num2[i];
                    } else if (op[i] == 1){
                        answer[i] = num1[i] - num2[i];
                    }
                }

                Gen.setEnabled(false);
                opr1.setText(String.valueOf(num1[counter]));
                opr2.setText(String.valueOf(num2[counter]));
                if (op[counter] == 0) {
                    oper.setText("+");
                }
                else {
                    oper.setText("-");
                }

            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num1[0] == -1){
                    Toast.makeText(getApplicationContext(), "Please start by generating problems", Toast.LENGTH_LONG).show();
                }

                else if (input.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter the answer", Toast.LENGTH_LONG).show();
                }

                else{
                    ans[counter] = Integer.parseInt(input.getText().toString());

                    if (counter == 9) {
                        if (answer[counter] == ans[counter]) score++;
                        Gen.setEnabled(true);

                        Toast.makeText(getApplicationContext(), "Your score is " + score.toString() + ". Let's play again", Toast.LENGTH_LONG).show();
                        reload();
                    }

                    if (answer[counter] == ans[counter]) score++;

                    counter++;

                    if (counter != 10) {
                        opr1.setText(String.valueOf(num1[counter]));
                        opr2.setText(String.valueOf(num2[counter]));
                        if (op[counter] == 0) {
                            oper.setText("+");
                        } else {
                            oper.setText("-");
                        }
                    }
                }
            }
        });
    }
}

