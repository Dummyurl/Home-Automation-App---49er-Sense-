package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThermostatActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);


        final Button mainfloorthermostatbtn = (Button) findViewById(R.id.mainfloorthermostatbtn);
        final Button firstfloorthermostatbtn = (Button) findViewById(R.id.firstfloorthermostatbtn);
        final Button backthermostatbtn = (Button) findViewById(R.id.backthermostatbtn);


        mainfloorthermostatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThermostatActivity.this,ThermoSettingsActivity.class);
                startActivity(intent);
            }


        });


        firstfloorthermostatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThermostatActivity.this,ThermoSettings1Activity.class);
                startActivity(intent);
            }
        });


        backthermostatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThermostatActivity.this,MainMenuActivity.class);
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
                Intent intent = new Intent(ThermostatActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }
