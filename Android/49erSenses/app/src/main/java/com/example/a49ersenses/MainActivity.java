package com.example.a49ersenses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        final Button userfirstbtn = (Button) findViewById(R.id.userfirstbtn);
        final Button powergeneratorfirstbtn = (Button) findViewById(R.id.powergeneratorfirstbtn);
        final Button utilityfirstbtn = (Button) findViewById(R.id.utilityfirstbtn);
        final Button exitfirstbtn = (Button) findViewById(R.id.exitfirstbtn);


        userfirstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FirstPage.class);
                startActivity(intent);
            }


        });


        powergeneratorfirstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PowerLoginActivity.class);
                startActivity(intent);
            }
        });


        utilityfirstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UtilityLoginActivity.class);
                startActivity(intent);
            }
        });


        exitfirstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
