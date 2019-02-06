package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ThermoSettings1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermosettings1);

        final Button heatthermosetting1btn = (Button) findViewById(R.id.heatthermosetting1btn);
        final Button coolthermosetting1btn = (Button) findViewById(R.id.coolthermosetting1btn);
        final Button modeoffthermosetting1btn = (Button) findViewById(R.id.modeoffthermosetting1btn);
        final Button autothermosetting1btn = (Button) findViewById(R.id.autothermosetting1btn);
        final Button fanoffthermosetting1btn = (Button) findViewById(R.id.fanoffthermosetting1btn);
        final Button fanonthermosetting1btn = (Button) findViewById(R.id.fanonthermosetting1btn);
        final Button backthermosetting1btn = (Button) findViewById(R.id.backthermosetting1btn);

        backthermosetting1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThermoSettings1Activity.this,ThermostatActivity.class);
                startActivity(intent);
            }
        });
    }

    public void OnHeatfirst(View view){
        String heat = "1";
        String cool = "0";
        String off = "0";
        String type = "Heatfirst";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,heat,cool,off);
    }

    public void OnCoolfirst(View view){
        String heat = "0";
        String cool = "1";
        String off = "0";
        String type = "Coolfirst";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,heat,cool,off);
    }

    public void OnOfffirst(View view){
        String heat = "0";
        String cool = "0";
        String off = "1";
        String type = "Offfirst";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,heat,cool,off);
    }

    public void OnFanonfirst(View view){
        String fan_off = "0";
        String fan_auto = "0";
        String fan_on = "1";
        String type = "Fanonfirst";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,fan_off,fan_auto,fan_on);
    }

    public void OnFanautofirst(View view){
        String fan_off = "0";
        String fan_auto = "1";
        String fan_on = "0";
        String type = "Fanautofirst";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,fan_off,fan_auto,fan_on);
    }

    public void OnFanofffirst(View view){
        String fan_off = "1";
        String fan_auto = "0";
        String fan_on = "0";
        String type = "Fanofffirst";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,fan_off,fan_auto,fan_on);
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
                Intent intent = new Intent(ThermoSettings1Activity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
