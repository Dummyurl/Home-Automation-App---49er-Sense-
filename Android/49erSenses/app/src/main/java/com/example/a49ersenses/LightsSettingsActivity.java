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

public class LightsSettingsActivity extends AppCompatActivity {

    int lrseekposition ;
    int porchseekposition ;
    int kitchenseekposition ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightssettings);

        final Button backlightssettingsbtn = (Button) findViewById(R.id.backlightssettingsbtn);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekbarlroom);
        final TextView textView = (TextView) findViewById(R.id.lrtext);

        final SeekBar seekBarkitchen = (SeekBar) findViewById(R.id.seekbarkitchen);
        final TextView kitchentext = (TextView) findViewById(R.id.kitchentext);
        final SeekBar porchseekbar = (SeekBar) findViewById(R.id.seekbarporch);
        final TextView porchtext = (TextView) findViewById(R.id.porchtext);

        seekBar.setProgress(BackgroundWorker.lights_main_values[0]);
        seekBarkitchen.setProgress(BackgroundWorker.lights_main_values[1]);
        porchseekbar.setProgress(BackgroundWorker.lights_main_values[2]);


        backlightssettingsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BackgroundWorker backgroundWorker = new BackgroundWorker(LightsSettingsActivity.this);
                backgroundWorker.execute("lightsmain",String.valueOf(seekBarkitchen.getProgress()),String.valueOf(porchseekbar.getProgress()),String.valueOf(seekBar.getProgress()));

                finish();
                    }


        });

        porchseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i){
                    case 0:
                        porchtext.setText("OFF");
                        porchseekposition = 0;
                        break;
                    case 1:
                        porchtext.setText("BRIGHT");
                        porchseekposition =1;
                        break;
                    case 2:
                        porchtext.setText("BRIGHTER");
                        porchseekposition = 2;
                        break;
                    case 3:
                        porchtext.setText("ON");
                        porchseekposition = 3;
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

        seekBarkitchen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i){
                    case 0:
                        kitchentext.setText("OFF");
                        kitchenseekposition = 0;
                        break;
                    case 1:
                        kitchentext.setText("BRIGHT");
                        kitchenseekposition =1;
                        break;
                    case 2:
                        kitchentext.setText("BRIGHTER");
                        kitchenseekposition = 2;
                        break;
                    case 3:
                        kitchentext.setText("ON");
                        kitchenseekposition = 3;
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

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i){
                    case 0:
                            textView.setText("OFF");
                            lrseekposition = 0;
                            break;
                    case 1:
                        textView.setText("BRIGHT");
                        lrseekposition =1;
                        break;
                    case 2:
                        textView.setText("BRIGHTER");
                        lrseekposition = 2;
                        break;
                    case 3:
                        textView.setText("ON");
                        lrseekposition = 3;
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
                Intent intent = new Intent(LightsSettingsActivity.this,FirstPage.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
