package com.example.HAIDAR_1202164150_SI4006_PAB_MODUL5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class ArtikelList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArtikelAdapter adapterArtikel;
    List<ArtikelActivity> artikelActivityList;
    ArtikelDbHelper dbHelper;
    sharedpref mysharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mysharedpref = new sharedpref(this);
        if (mysharedpref.loadNightModeState() == true) {
            setTheme(R.style.DarkTheme);
        } else
        {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_list);

        dbHelper = new ArtikelDbHelper(this);
        recyclerView = findViewById(R.id.recycleview_artikel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        artikelActivityList = new ArrayList<>();

        dbHelper.readData(artikelActivityList);

        adapterArtikel = new ArtikelAdapter(this, artikelActivityList);
        recyclerView.setAdapter(adapterArtikel);

        adapterArtikel.notifyDataSetChanged();
    }
}
