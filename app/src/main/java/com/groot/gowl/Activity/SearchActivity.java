package com.groot.gowl.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.TimeUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.groot.gowl.FirstFragment;
import com.groot.gowl.MainActivity;
import com.groot.gowl.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;




import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.groot.gowl.Activity.SerialActivity;
import com.groot.gowl.ArraysPage.StartPage_Arrays;
import com.groot.gowl.Fragments.FragmentsDefault;
import com.groot.gowl.RecycleView_Adapters.StartPage_Adapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private StartPage_Adapter startPage_adapter;
    private ProgressBar progressBar;
    private Document document;
    private ArrayList<StartPage_Arrays> startPage_arrays = new ArrayList<>();

    private boolean aBoolean = false;
    private String nextPage;
    private String bool;
    private FloatingActionButton fab;
    private FragmentsDefault fragmentsDefault;
    private Content content;
    private FirstFragment firstFragment;
    private BottomNavigationView bottomNavigationView;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        bottomNavigationView = findViewById(R.id.bottomNav);
        navController = Navigation.findNavController(this, R.id.fragments);
        navController.navigate(R.id.firstFragment);


            navController.navigate(R.id.firstFragment);

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return false;
//            }
//        });
//        progressBar = findViewById(R.id.StartPageProgressBar);

//        recyclerView = findViewById(R.id.rectangles);
//        gridLayoutManager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        startPage_adapter = new StartPage_Adapter(startPage_arrays, SearchActivity.this);
//        recyclerView.setAdapter(startPage_adapter);
//        fab = findViewById(R.id.floatingActionButton);
//        fragmentsDefault = new FragmentsDefault(recyclerView,startPage_adapter);
        int orientation = this.getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_PORTRAIT){
//            recyclerView.setLayoutManager(gridLayoutManager);
        }
        else{
//            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
//        recyclerView.setFocusable(true);
        nextPage = "https://uakino.club/page/3/";
        bool = "https://uakino.club/";




        //you will need to do something similar to this listener for all focusable things
//        recyclerView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                Log.i("ONFOCUSCHANGE- reclist", "focus has changed I repeat the focus has changed! current focus = " + currFocus);
//                if(currFocus != RECVIEW1){
//                    currFocus = RECVIEW1;
////                    recyclerView.getChildAt(0).requestFocus();
//                    System.out.println("positions" + currFocus);
//                }
//            }
//        });




//        fab.setFocusable(true);


//        fab.setOnClickListener(v ->{
//            v.setFocusable(true);
//            Intent intent = new Intent(com.groot.gowl.MainActivity.this, SerialActivity.class);
//            startActivity(intent);
//            finish();
//        });
//        layoutAnimation(recyclerView);


        content = new Content();
        content.execute();


//        fragmentsDefault = new FragmentsDefault(startPage_arrays);
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frameLayout,fragmentsDefault);

//        transaction.commit();

        firstFragment = new FirstFragment(startPage_arrays);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.firstFragment,firstFragment);
        transaction.commit();
//
//        System.out.println();

        getRecycle g = new getRecycle();
        g.execute();



    }



    private class Content  extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            progressBar.setVisibility(View.VISIBLE);
//            progressBar.setAnimation(AnimationUtils.loadAnimation(SearchActivity.this, android.R.anim.fade_in));
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            progressBar.setVisibility(View.GONE);
//            progressBar.setAnimation(AnimationUtils.loadAnimation(SearchActivity.this, android.R.anim.fade_out));
//
            fragmentsDefault.startPage_adapter.notifyDataSetChanged();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            if (bool.equals("https://uakino.club/")){
                try {
                    document = Jsoup.connect("https://uakino.club/").get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Element element = document.select("div[class=main-section-wr with-sidebar coloredgray clearfix]").first();
                Elements elements = element.select("div.movie-img");
//                Elements nameSpace = element.select("a.movie-title");
                Elements nameNotSerial = element.select("div.deck-title");
                Elements imageElement = elements.select("img");
                Elements urlElement = elements.select("a");
                int size = elements.size();
                for (int i = 0;i<size;i++){
                    Element nameSpaces = nameNotSerial.get(i);
                    Element sesons = elements.get(i);
                    Element urlSize = urlElement.get(i);
                    Element images = imageElement.get(i);
                    String getUrlPage = urlSize.attr("href");
                    String getNameSpaces = nameSpaces.text();
                    String sesonsString = sesons.text();
                    String imageElementUrl = images.absUrl("src");
                    startPage_arrays.add(new StartPage_Arrays(getUrlPage,imageElementUrl,sesonsString,getNameSpaces));
                    System.out.println("pagess l : " + bool);
                }
            }

            if (aBoolean){
                try {
                    document = Jsoup.connect(nextPage).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("pagess : " + nextPage);
                Element element = document.select("div[class=main-section-wr with-sidebar coloredgray clearfix]").first();
                Elements elements = element.select("div.movie-img");
                Elements nameSpace = element.select("a.movie-title");
                Elements imageElement = elements.select("img");
                Elements urlElement = elements.select("a");
                int size = elements.size();
                for (int i = 0;i<size;i++){
                    Element sesons = elements.get(i);
                    Element urlSize = urlElement.get(i);
                    String getUrlPage = urlSize.attr("href");
                    Element images = imageElement.get(i);
                    Element nameSpaces = nameSpace.get(i);
                    String getNameSpaces = nameSpaces.text();
                    String sesonsString = sesons.text();
                    String imageElementUrl = images.absUrl("src");
                    startPage_arrays.add(new StartPage_Arrays(getUrlPage,imageElementUrl,sesonsString,getNameSpaces));
                }
            }
            return null;
        }
    }


    private class getRecycle  extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            if(content.getStatus() == Status.RUNNING){
//                System.out.println("Status  Runn");
//
//            }
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(content.getStatus() == Status.RUNNING){
                System.out.println("Status  Runn");
            }
            final int[] d = {0};


//            fragmentsDefault.getrecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
//                @Override
//                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                    super.onScrolled(recyclerView, dx, dy);
//                    if (! recyclerView.canScrollVertically(1)){ //1 for down
////                        System.out.println("TTTTT " + d[0]++);
//                    }
//                }
//            });

            final int[] count = {2};


            System.out.println("Status  Running");
//            fragmentsDefault.getrecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
//                @Override
//                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//
//                    super.onScrollStateChanged(recyclerView, newState);
//
//                    if (!recyclerView.canScrollVertically(1)) {
////                        if(content.getStatus() == Status.RUNNING){
//
//
//
////                    }else
//                         if (content.getStatus() == Status.FINISHED){
//                            System.out.println("TTTTTTTTT" + d[0]++);
//                             bool = "notPage";
//                             String urlPosChange = "https://uakino.club/page/1/";
//                             StringBuffer stringBuffer = new StringBuffer(urlPosChange);
//                             stringBuffer.replace(25,27, String.valueOf(count[0]++));
//                             nextPage = stringBuffer.toString();
//                             Content content = new Content();
//                             content.execute();
//
//                             aBoolean = true;
//                        }
//
//                    }
//                }
//            });


        }

        @Override
        protected Void doInBackground(Void... voids) {
            if(content.getStatus() == Status.RUNNING){

            }

            return null;
        }
    }


}


//public class SearchActivity extends AppCompatActivity {
//    private final Handler uiHandler = new Handler();
//    private Document document;
//    private EditText textInputLayout;
//
//
//    class JSHtmlInterface {
//        @android.webkit.JavascriptInterface
//        public void showHTML(String html) {
//            final String htmlContent = html;
//            uiHandler.post(() -> {
//
//                        document = Jsoup.parse(htmlContent);
//
//                        System.out.println(document);
//
//
//                    }
//            );
//        }
//    }
//
//
//    private Button button;
//    private WebView webView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
////        button = findViewById(R.id.buttonSearch);
////        webView = findViewById(R.id.webSearch);
////        textInputLayout = findViewById(R.id.textView);
//
//
////        String s = tv;
//
//
//
//
//
//
////        button.setOnClickListener(v -> {
////
////            String tv = textInputLayout.getText().toString();
////            final int interval = 1000; // 1 Second
////            Handler handler = new Handler();
////            Runnable runnable = new Runnable(){
////                public void run() {
////                    b(tv);
////                }
////            };
////            handler.postAtTime(runnable, System.currentTimeMillis()+interval);
////            handler.postDelayed(runnable, interval);
////        });
//
////        final int interval = 10000;
////        Handler handler = new Handler();
////        Runnable runnable = new Runnable(){
////            public void run() {
////                webView.destroy();
////            }
////        };
////        handler.postAtTime(runnable, System.currentTimeMillis()+interval);
////        handler.postDelayed(runnable, interval);
//
//
//    }
//
////    public void searchBt(View view) {
////    }
////    public void b(String tv){
////        webView.getSettings().setJavaScriptEnabled(true);
////        webView.getSettings().setBlockNetworkImage(true);
////        webView.getSettings().setDomStorageEnabled(false);
////        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
////        webView.getSettings().setLoadsImagesAutomatically(false);
////        webView.getSettings().setGeolocationEnabled(false);
////        webView.getSettings().setSupportZoom(false);
////        webView.addJavascriptInterface(new JSHtmlInterface(), "JSBridge");
////
////        WebSettings faller = webView.getSettings();
////        String url = "https://uakino.club/index.php?do=search";
////        faller.setJavaScriptEnabled(true);
////        webView.loadUrl(url);
////        webView.setWebViewClient(new WebViewClient(){
////            public void onPageFinished(WebView view , String url){
////                view.loadUrl("javascript:(function(){document.getElementById('searchinput').value = '"+ tv +"';})();");
////                view.loadUrl("javascript:(function(){document.getElementById('dosearch').click();})();");
//////                        view.loadUrl("javascript:window.JSBridge.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
////            }
////        });
////    }
//}