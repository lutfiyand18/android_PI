package com.example.lutfi.menuprogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splashscreen extends AppCompatActivity implements Loading.LoadingTaskFinishedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressbar_Horizontal);
        new Loading(progressBar,this).execute("");

    }
@Override
    public void onTaskFinished(){completeSplash();}

    private void completeSplash() {
        startApp();
        finish();
    }

    private void startApp() {

        Intent intent =new Intent(Splashscreen.this,Menu1.class);
        startActivity(intent);
    }

}

