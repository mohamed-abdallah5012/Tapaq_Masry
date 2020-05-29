package com.mohamedabdallah.tapqmasry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;


public class MainActivity extends AppCompatActivity {

    private Button btn_enter;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter();

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
    }
    public void enter( ) {
        btn_enter=(Button)findViewById(R.id.button_enter);
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.mohamedabdallah.tapqmasry.SecondActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();

            }
        } else {
            Toast.makeText(this, "Click Again To Exit", Toast.LENGTH_SHORT).show();

        }
        back_pressed = System.currentTimeMillis();

    }


}
