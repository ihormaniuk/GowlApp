package com.groot.gowl.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.groot.gowl.MainActivity;

public class ActivityOpenBrowser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Uri data = intent.getData();
        String url = data.toString();

        if (url.equals("https://uakino.club/")){
            Intent main = new Intent(ActivityOpenBrowser.this, MainActivity.class);
            startActivity(main);
        }else if (url.equals("cartoon/cartoonseries")){
            Intent serial = new Intent(ActivityOpenBrowser.this, SerialActivity.class);
            startActivity(serial);
        }
        else if (url.contains("seriesss")) {
            Intent serialAct = new Intent(ActivityOpenBrowser.this, SelectActivity_Serials.class);
            serialAct.putExtra("url",url);
            startActivity(serialAct);

        }else if (url.contains("https://uakino.club/cartoon/")) {
            Intent cartoonsers = new Intent(ActivityOpenBrowser.this, ActivityOpenUrl.class);
            cartoonsers.putExtra("url", url);
            Toast.makeText(this,"intent put " + url,Toast.LENGTH_SHORT).show();
            startActivity(cartoonsers);
        }
        else if (url.contains("anime-series")) {
            Intent serialAct = new Intent(ActivityOpenBrowser.this, SelectActivity_Serials.class);
            serialAct.putExtra("url", url);
            startActivity(serialAct);
        }
        else if (url.contains("filmi")) {
            Intent carton = new Intent(ActivityOpenBrowser.this, SelectActivity_Fiml.class);
            carton.putExtra("url", url);
            startActivity(carton);
        }
        System.out.println(url);
    }

}