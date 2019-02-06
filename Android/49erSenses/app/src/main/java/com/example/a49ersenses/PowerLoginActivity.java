package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PowerLoginActivity extends AppCompatActivity {
    EditText powerusernameed, powertopassworded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powerlogin);

        powerusernameed = (EditText) findViewById(R.id.powerusernameed);
        powertopassworded = (EditText) findViewById(R.id.powertopassworded);

        final Button powerloginbtn  = (Button) findViewById(R.id.powerloginbtn);
        final Button powertoregisterbtn = (Button) findViewById(R.id.powertoregisterbtn);
        final Button powerresetbtn = (Button) findViewById(R.id.powerresetbtn);
        final Button powertobackbtn = (Button) findViewById(R.id.powertobackbtn);


        powertoregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PowerLoginActivity.this,PowerRegisterActivity.class);
                startActivity(intent);
            }
        });


        powerresetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PowerLoginActivity.this,PowerLoginActivity.class);
                startActivity(intent);
            }
        });


        powertobackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PowerLoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void OnPowerLogin(View view){
        String username = powerusernameed.getText().toString();
        String password = powertopassworded.getText().toString();
        String type = "Power Login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

    @Override
    public void onBackPressed() {

    }

}
