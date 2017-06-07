package com.slamgantdroid.searchviewinlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    SearchView sv;

    String[] nama = {"Indonesia",
            "Malaysia",
            "Singapura",
            "Vietnam",
            "Brunei",
            "Brazil",
            "Spanyol",
            "Inggris"};
    int[] gambar = {R.drawable.like,
            R.drawable.touristsssss,
            R.drawable.tourist,
            R.drawable.indonesiaaaaaaaa,
            R.drawable.indonesia,
            R.drawable.googleplay,
            R.drawable.iconenjoyindonesia,
            R.drawable.iconenjoyindonesiadua};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listView);
        sv = (SearchView)findViewById(R.id.searchView);

        //Adapter
        final Adapter adapter = new Adapter(this, getModel());

        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {

                adapter.getFilter().filter(text);

                return false;
            }
        });

    }

    private ArrayList<Model> getModel() {
        ArrayList<Model> models = new ArrayList<Model>();
        Model model;

        for (int i = 0; i < nama.length; i++) {
            model = new Model(nama[i], gambar[i]);
            models.add(model);
        }

        return models;

    }

}
