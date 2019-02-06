package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DWSensorsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dwsensors);

        final Button ondwsensorsbtn = (Button) findViewById(R.id.ondwsensorsbtn);
        final Button offdwsensorsbtn = (Button) findViewById(R.id.offdwsensorsbtn);
        final Button onfirstdwsensorsbtn = (Button) findViewById(R.id.onfirstdwsensorsbtn);
        final Button offfirstdwsensorsbtn = (Button) findViewById(R.id.offfirstdwsensorsbtn);
        final Button backdwsensorbtn = (Button) findViewById(R.id.backdwsensorbtn);



        backdwsensorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DWSensorsActivity.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    public void OnMainon(View view){
        String mainon = "10";
        String mainoff = "0";
        String type = "Mainon";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,mainon,mainoff);
    }

    public void OnMainoff(View view){
        String mainon = "0";
        String mainoff = "1";
        String type = "Mainoff";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,mainon,mainoff);
    }

    public void OnFirston(View view){
        String firston = "1";
        String firstoff = "0";
        String type = "Firston";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,firston,firstoff);
    }

    public void OnFirstoff(View view){
        String firston = "0";
        String firstoff = "1";
        String type = "Firstoff";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,firston,firstoff);
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
                Intent intent = new Intent(DWSensorsActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    }
