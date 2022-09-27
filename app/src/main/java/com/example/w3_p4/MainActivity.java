package com.example.w3_p4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText userName;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login);
        userName = (EditText) findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = userName.getText().toString();
                String password = pass.getText().toString();

                if (name.equals("ahnbh") && password.equals("ahnbh1129")){

                    Toast.makeText(getApplicationContext(), "Welcome "+ name, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, card_game.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}