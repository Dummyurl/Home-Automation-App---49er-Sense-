package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThermoSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermosettings);

        final Button heatthermosettingbtn = (Button) findViewById(R.id.heatthermosettingbtn);
        final Button coolthermosettingbtn = (Button) findViewById(R.id.coolthermosettingbtn);
        final Button modeoffthermosettingbtn = (Button) findViewById(R.id.modeoffthermosettingbtn);
        final Button autothermosettingbtn = (Button) findViewById(R.id.autothermosettingbtn);
        final Button fanoffthermosettingbtn = (Button) findViewById(R.id.fanoffthermosettingbtn);
        final Button fanonthermosettingbtn = (Button) findViewById(R.id.fanonthermosettingbtn);
        final Button backthermosettingbtn = (Button) findViewById(R.id.backthermosettingbtn);

        backthermosettingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThermoSettingsActivity.this,ThermostatActivity.class);
                startActivity(intent);
            }
        });
    }

    public void OnHeatmain(View view){
        String heat = "1";
        String cool = "0";
        String off = "0";
        String type = "Heatmain";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,heat,cool,off);
    }

    public void OnCoolmain(View view){
        String heat = "0";
        String cool = "1";
        String off = "0";
        String type = "Coolmain";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,heat,cool,off);
    }

    public void OnOffmain(View view){
        String heat = "0";
        String cool = "0";
        String off = "1";
        String type = "Offmain";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,heat,cool,off);
    }

    public void OnFanonmain(View view){
        String fan_off = "0";
        String fan_auto = "0";
        String fan_on = "1";
        String type = "Fanonmain";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,fan_off,fan_auto,fan_on);
    }

    public void OnFanautomain(View view){
        String fan_off = "0";
        String fan_auto = "1";
        String fan_on = "0";
        String type = "Fanautomain";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,fan_off,fan_auto,fan_on);
    }

    public void OnFanoffmain(View view){
        String fan_off = "1";
        String fan_auto = "0";
        String fan_on = "0";
        String type = "Fanoffmain";
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
                Intent intent = new Intent(ThermoSettingsActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
