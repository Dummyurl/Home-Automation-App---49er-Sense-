package com.example.a49ersenses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        final Button securitysystemmainmenubtn = (Button) findViewById(R.id.securitysystemmainmenubtn);
        final Button garagecontrolmainmenubtn = (Button) findViewById(R.id.garagecontrolmainmenubtn);
        final Button thermostatmainmenybtn = (Button) findViewById(R.id.thermostatmainmenubtn);
        final Button lightsmainmenybtn = (Button) findViewById(R.id.lightsmainmenubtn);
        final Button locksmainmenubtn = (Button) findViewById(R.id.locksmainmenubtn);
        final Button doorwindowsensormainmenubtn = (Button) findViewById(R.id.doorwindowsensorsmainemenubtn);
        final Button videomonitoringmainmenubtn = (Button) findViewById(R.id.videomonitoringmainmenubtn);
        final Button backmainmenubtn = (Button) findViewById(R.id.backmainmenubtn);

        securitysystemmainmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,SecuritySystemActivity.class);
                startActivity(intent);
            }
        });

        garagecontrolmainmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,GarageControlActivity.class);
                startActivity(intent);
            }
        });

        thermostatmainmenybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,ThermostatActivity.class);
                startActivity(intent);
            }
        });

        lightsmainmenybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,LightsActivity.class);
                startActivity(intent);            }
        });

        locksmainmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,LocksActivity.class);
                startActivity(intent);
            }
        });

        doorwindowsensormainmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,DWSensorsActivity.class);
                startActivity(intent);
            }
        });


        videomonitoringmainmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,VideoMonitoringActivity.class);
                startActivity(intent);

            }
        });

        backmainmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,FirstPage.class);
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
                Intent intent = new Intent(MainMenuActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
