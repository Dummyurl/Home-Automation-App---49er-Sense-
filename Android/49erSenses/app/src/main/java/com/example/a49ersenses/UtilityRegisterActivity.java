package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class UtilityRegisterActivity extends AppCompatActivity {
    EditText utilitycompanynameed, utilityusernameed, utilitypassworded, utilitymobilenumbered,utilityemailided;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilityregister);

        final Button utilityregisterbtn = (Button) findViewById(R.id.utilityregisterbtn);
        final Button utilityhomebtn = (Button) findViewById(R.id.utilityhomebtn);

        utilitycompanynameed = (EditText) findViewById(R.id.utilitycompanynameed);
        utilityusernameed = (EditText) findViewById(R.id.utilityusernameed);
        utilitypassworded = (EditText) findViewById(R.id.utilitypassworded);
        utilitymobilenumbered = (EditText) findViewById(R.id.utilitymobilenumbered);
        utilityemailided = (EditText) findViewById(R.id.utilityemailided);

        utilityhomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UtilityRegisterActivity.this,FirstPage.class);
                startActivity(intent);
            }
        });

    }

    public void OnUtilityRegister(View view) {
        String str_name = utilitycompanynameed.getText().toString();
        String str_username = utilityusernameed.getText().toString();
        String str_password = utilitypassworded.getText().toString();
        String str_mobile_num = utilitymobilenumbered.getText().toString();
        String str_email_id = utilityemailided.getText().toString();
        String str_user = "utility company";
        String type = "Utility Register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_username, str_password, str_mobile_num, str_email_id,str_user);
    }

}
