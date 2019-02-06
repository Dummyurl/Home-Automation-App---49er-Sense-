package com.example.a49ersenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class LightsSettings1Activity extends AppCompatActivity {


    int masterseekposition ;
    int guestseekposition ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightssettings1);

        final Button backlightssettings1btn = (Button) findViewById(R.id.backlightssettings1btn);

        final SeekBar seekbarguestbed = (SeekBar) findViewById(R.id.seekbarguestbed);
        final TextView guestbedtext = (TextView) findViewById(R.id.guestbedtext);

        final SeekBar seekbarmasterbed = (SeekBar) findViewById(R.id.seekbarmasterbed);
        final TextView masterbedtext = (TextView) findViewById(R.id.masterbedtext);


        seekbarmasterbed.setProgress(BackgroundWorker.light_first_values[0]);
        seekbarguestbed.setProgress(BackgroundWorker.light_first_values[1]);


        System.out.println(BackgroundWorker.light_first_values.length +" "+BackgroundWorker.light_first_values[0] + " "+BackgroundWorker.light_first_values[1] );
        backlightssettings1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BackgroundWorker backgroundWorker1 = new BackgroundWorker(LightsSettings1Activity.this);
                backgroundWorker1.execute("lightsfirst",String.valueOf(seekbarmasterbed.getProgress()),String.valueOf(seekbarguestbed.getProgress()));

                finish();
            }


        });


        seekbarmasterbed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i){
                    case 0:
                        masterbedtext.setText("OFF");
                        masterseekposition = 0;
                        break;
                    case 1:
                        masterbedtext.setText("BRIGHT");
                        masterseekposition =1;
                        break;
                    case 2:
                        masterbedtext.setText("BRIGHTER");
                        masterseekposition = 2;
                        break;
                    case 3:
                        masterbedtext.setText("ON");
                        masterseekposition = 3;
                        break;

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekbarguestbed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i){
                    case 0:
                        guestbedtext.setText("OFF");
                        guestseekposition = 0;
                        break;
                    case 1:
                        guestbedtext.setText("BRIGHT");
                        guestseekposition =1;
                        break;
                    case 2:
                        guestbedtext.setText("BRIGHTER");
                        guestseekposition = 2;
                        break;
                    case 3:
                        guestbedtext.setText("ON");
                        guestseekposition = 3;
                        break;

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
                Intent intent = new Intent(LightsSettings1Activity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
