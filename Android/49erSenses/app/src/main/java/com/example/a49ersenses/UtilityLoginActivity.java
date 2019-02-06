package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UtilityLoginActivity extends AppCompatActivity {

    EditText utilityusernameed, utilitytopassworded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilitylogin);

        utilityusernameed = (EditText) findViewById(R.id.utilityusernameed);
        utilitytopassworded = (EditText) findViewById(R.id.utilitytopassworded);

        final Button utilityloginbtn  = (Button) findViewById(R.id.utilityloginbtn);
        final Button utilitytoregisterbtn = (Button) findViewById(R.id.utilitytoregisterbtn);
        final Button utilityresetbtn = (Button) findViewById(R.id.utilityresetbtn);
        final Button utilitytobackbtn = (Button) findViewById(R.id.utilitytobackbtn);


        utilitytoregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UtilityLoginActivity.this,UtilityRegisterActivity.class);
                startActivity(intent);
            }
        });


        utilityresetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UtilityLoginActivity.this,UtilityLoginActivity.class);
                startActivity(intent);
            }
        });


        utilitytobackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UtilityLoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void OnUtilityLogin(View view){
        String username = utilityusernameed.getText().toString();
        String password = utilitytopassworded.getText().toString();
        String type = "Utility Login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

    @Override
    public void onBackPressed() {

    }


}
