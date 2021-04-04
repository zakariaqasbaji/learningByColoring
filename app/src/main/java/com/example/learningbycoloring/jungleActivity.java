package com.example.learningbycoloring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class jungleActivity extends AppCompatActivity {

    GridView gdView;
    int[] img=GlobalParameters.img;
    //int[] sound= GlobalParameters.sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jungle);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<img.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("img", Integer.toString(img[i]));
            aList.add(hm);
        }
        // Keys used in Hashmap
        String[] from = { "img"};
        // Ids of views in listview_layout
        int[] to = { R.id.number};
        // Instantiating an adapter to store each items
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.layout_list, from, to);
        // Getting a reference to listview of main.xml layout file
        //ListView listView = ( ListView ) findViewById(R.id.l1);
        gdView = ( GridView ) findViewById(R.id.gridView);
        // Setting the adapter to the listView
        gdView.setAdapter(adapter);
        gdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), coloringActivityJungle.class);
                intent.putExtra("indice",i);
                startActivity(intent);
            }
        });

    }

}