package com.example.a49ersenses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.VideoView;

public class VideoMonitoringActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videomonitoring);

        //final Button backvideomonitoringbtn = (Button) findViewById(R.id.backvideomonitoringbtn);

        webView = (WebView) findViewById(R.id.myVideo);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://192.168.1.105:8080");


//        backvideomonitoringbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(VideoMonitoringActivity.this,MainMenuActivity.class);
//                startActivity(intent);
//            }
//        });
           }


}
