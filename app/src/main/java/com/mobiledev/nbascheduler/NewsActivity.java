package com.mobiledev.nbascheduler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class NewsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        WebView newsbroser = (WebView) findViewById(R.id.NewsView);

        newsbroser.loadUrl("http://www.espn.com/nba/");
    }
}
