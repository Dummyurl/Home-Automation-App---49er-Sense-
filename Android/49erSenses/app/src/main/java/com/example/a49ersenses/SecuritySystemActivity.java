package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecuritySystemActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_securitysystem);


        final Button disarmsecuritysystembtn = (Button) findViewById(R.id.disarmsecuritysystembtn);
        final Button armstaysecuritysystembtn = (Button) findViewById(R.id.armstaysecuritysystembtn);
        final Button armawaysecuritysystembtn = (Button) findViewById(R.id.armawaysecuritysystembtn);
        final Button backsecuritysystembtn = (Button) findViewById(R.id.backsecuritysystembtn);


        backsecuritysystembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SecuritySystemActivity.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });

    }
    public void OnDisarm(View view){
        String disarm = "1";
        String armaway = "0";
        String armstay = "0";
        String type = "Disarm";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, disarm, armaway, armstay);
    }

    public void OnArmstay(View view){
        String disarm = "0";
        String armaway = "0";
        String armstay = "1";
        String type = "Armstay";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, disarm, armaway, armstay);
    }

    public void OnArmaway(View view){
        String disarm = "0";
        String armaway = "1";
        String armstay = "0";
        String type = "Armaway";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, disarm, armaway, armstay);
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
                Intent intent = new Intent(SecuritySystemActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
