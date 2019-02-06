package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity {
    EditText firstnameed, lastnameed, usernameregsitered, passwordregistered,mobilenumbered, emailided;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button registerregisterbtn = (Button) findViewById(R.id.registerregisterbtn);
        final Button homeregisterbtn = (Button) findViewById(R.id.homeregsiterbtn);

        firstnameed = (EditText) findViewById(R.id.firstnameed);
        lastnameed = (EditText) findViewById(R.id.lastnameed);
        usernameregsitered = (EditText) findViewById(R.id.usernameregsitered);
        passwordregistered = (EditText) findViewById(R.id.passwordregistered);
        mobilenumbered = (EditText) findViewById(R.id.mobilenumbered);
        emailided = (EditText) findViewById(R.id.emailided);

        homeregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void OnRegister(View view) {
        String str_name = firstnameed.getText().toString();
        String str_surname = lastnameed.getText().toString();
        String str_username = usernameregsitered.getText().toString();
        String str_password = passwordregistered.getText().toString();
        String str_mobile_num = mobilenumbered.getText().toString();
        String str_email_id = emailided.getText().toString();
        String str_user = "customer";
        String type = "Register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_surname, str_username, str_password, str_mobile_num, str_email_id,str_user);

    }

}
