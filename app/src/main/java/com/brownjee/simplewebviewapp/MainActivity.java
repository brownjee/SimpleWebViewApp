package com.brownjee.simplewebviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button loadurl;
    EditText enterurl;
    private WebView displaysite;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  WebView browser = (WebView) findViewById(R.id.webview);

       // browser.loadUrl("http://starthub.com.ng/");

        url = "http://starthub.com.ng/";
       loadPage(url);




        loadurl=(Button)findViewById(R.id.button);
        enterurl=(EditText)findViewById(R.id.editText);



        loadurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url =  "";
                 url = enterurl.getText().toString();
                 loadPage(url);

            }
        });
    }
private  void loadPage(String url){
    displaysite=(WebView)findViewById(R.id.webView);
    displaysite.setWebViewClient(new MyBrowser());
    displaysite.getSettings().setLoadsImagesAutomatically(true);
    displaysite.getSettings().setJavaScriptEnabled(true);
    displaysite.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    displaysite.loadUrl(url);
}
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
