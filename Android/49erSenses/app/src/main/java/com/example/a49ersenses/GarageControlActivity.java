package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GarageControlActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garagecontrol);

        final Button opendoorgaragecontrolbtn = (Button) findViewById(R.id.opendoorgaragecontrolbtn);
        final Button closedoorgaragecontrolbtn = (Button) findViewById(R.id.closedoorgaragecontrolbtn);
        final Button backgaragecontrolbtn = (Button) findViewById(R.id.backgaragecontrolbtn);


        backgaragecontrolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GarageControlActivity.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });

    }

    public void OnGarageopen(View view){
        String opendoor = "1";
        String closedoor = "0";
        String type = "Garageopen";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, opendoor, closedoor);
    }

    public void OnGarageclose(View view){
        String opendoor = "0";
        String closedoor = "1";
        String type = "Garageclose";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, opendoor, closedoor);
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
                Intent intent = new Intent(GarageControlActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }
