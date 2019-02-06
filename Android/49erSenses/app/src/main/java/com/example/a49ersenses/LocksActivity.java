package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LocksActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locks);

        final Button lockfrontlocksbtn = (Button) findViewById(R.id.lockfrontlocksbtn);
        final Button unlockfrontlocksbtn = (Button) findViewById(R.id.unlockfrontlocksbtn);
        final Button lockbacklocksbtn = (Button) findViewById(R.id.lockbacklocksbtn);
        final Button unlockbacklocksbtn = (Button) findViewById(R.id.unlockbacklocksbtn);
        final Button backlocksbtn = (Button) findViewById(R.id.backlocksbtn);


        backlocksbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocksActivity.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });

    }
    public void OnFrontlock(View view){
        String frontlock = "1";
        String frontunlock = "0";
        String type = "Frontlock";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,frontlock,frontunlock);
    }

    public void OnFrontunlock(View view){
        String frontlock = "0";
        String frontunlock = "1";
        String type = "Frontunlock";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,frontlock,frontunlock);
    }
    public void OnBacklock(View view){
        String backlock = "1";
        String backunlock = "0";
        String type = "Backlock";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, backlock, backunlock);
    }

    public void OnBackunlock(View view){
        String backlock = "0";
        String backunlock = "1";
        String type = "Backunlock";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, backlock, backunlock);
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
                Intent intent = new Intent(LocksActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }
