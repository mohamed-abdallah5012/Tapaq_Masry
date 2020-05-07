package com.example.tapqmasry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SecondActivity extends AppCompatActivity {
    private ListView listView;
    private String [] item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
        listView=(ListView)findViewById(R.id.listView);
        item=getResources().getStringArray(R.array.index);

        ArrayAdapter arrayAdapter =new ArrayAdapter<String>(this,R.layout.row_item,R.id.rowitem_textview,item);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(SecondActivity.this,WEbHtml.class);
                intent.putExtra("page",position);
                startActivity(intent);
            }
        });

    }
}
