package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PowerRegisterActivity extends AppCompatActivity {
    EditText powercompanynameed, powerusernameed, powerpassworded, powermobilenumbered,poweremailided;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powerregister);

        final Button powerregisterbtn = (Button) findViewById(R.id.powerregisterbtn);
        final Button powerhomebtn = (Button) findViewById(R.id.powerhomebtn);

        powercompanynameed = (EditText) findViewById(R.id.powercompanynameed);
        powerusernameed = (EditText) findViewById(R.id.powerusernameed);
        powerpassworded = (EditText) findViewById(R.id.powerpassworded);
        powermobilenumbered = (EditText) findViewById(R.id.powermobilenumbered);
        poweremailided = (EditText) findViewById(R.id.poweremailided);

        powerhomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PowerRegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void OnPowerRegister(View view) {
        String str_name = powercompanynameed.getText().toString();
        String str_username = powerusernameed.getText().toString();
        String str_password = powerpassworded.getText().toString();
        String str_mobile_num = powermobilenumbered.getText().toString();
        String str_email_id = poweremailided.getText().toString();
        String str_user = "power generator";
        String type = "Power Register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_username, str_password, str_mobile_num, str_email_id,str_user);
    }

}
