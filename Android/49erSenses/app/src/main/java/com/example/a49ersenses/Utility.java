package com.example.a49ersenses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Utility extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utlity);

        final Button getuserdatabtn = (Button) findViewById(R.id.getuserdatabtn);
        final Button backutilitybtn = (Button) findViewById(R.id.backutilitybtn);


        getuserdatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "join";
                BackgroundWorker backgroundWorker = new BackgroundWorker(Utility.this);
                backgroundWorker.execute(type);
                          }

        });


        backutilitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Utility.this,MainActivity.class);
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
                Intent intent = new Intent(Utility.this,UtilityLoginActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
