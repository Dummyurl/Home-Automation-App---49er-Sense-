package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstPage extends AppCompatActivity {
    EditText usernamemained, passwordmained;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        usernamemained = (EditText) findViewById(R.id.usernamemained);
        passwordmained = (EditText) findViewById(R.id.passwordmained);

        final Button loginmainbtn = (Button) findViewById(R.id.loginmainbtn);
        final Button registermainbtn = (Button) findViewById(R.id.regsitermainbtn);
        final Button resetmainbtn = (Button) findViewById(R.id.resetmainbtn);
        final Button exitmainbtn = (Button) findViewById(R.id.exitmainbtn);


        registermainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FirstPage.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


        resetmainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FirstPage.this,FirstPage.class);
                startActivity(intent);
            }
        });


        exitmainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FirstPage.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void OnLogin(View view){
        String username = usernamemained.getText().toString();
        String password = passwordmained.getText().toString();
        String type = "Login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

    @Override
    public void onBackPressed() {

    }


}
