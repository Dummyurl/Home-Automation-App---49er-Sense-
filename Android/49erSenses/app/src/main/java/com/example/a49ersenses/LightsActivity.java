package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LightsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);

        final Button mainfloorlightsbtn = (Button) findViewById(R.id.mainfloorlightsbtn);
        final Button firstfloorlightsbtn = (Button) findViewById(R.id.firstfloorlightsbtn);
        final Button backlightsbtn = (Button) findViewById(R.id.backlightsbtn);


        mainfloorlightsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "getlightsmain";
                BackgroundWorker backgroundWorker = new BackgroundWorker(LightsActivity.this);
                backgroundWorker.execute(type);
            }


        });


        firstfloorlightsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "getlightsfirst";
                BackgroundWorker backgroundWorker = new BackgroundWorker(LightsActivity.this);
                backgroundWorker.execute(type);



            }
        });


        backlightsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightsActivity.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                Intent intent = new Intent(LightsActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
