package xyz.android.appdesarrollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class tutoriales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoriales);

        //toolbar retroceder
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://www.superprof.es/apuntes/escolar/matematicas/algebralineal/matrices/matrices-12.html");

    }
    //toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}