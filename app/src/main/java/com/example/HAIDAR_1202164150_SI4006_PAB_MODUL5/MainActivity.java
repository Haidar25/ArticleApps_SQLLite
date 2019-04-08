package com.example.HAIDAR_1202164150_SI4006_PAB_MODUL5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnListArticle, btnCreateArticle, btnSetting;
    TextView textView_pagi;
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
        setContentView(R.layout.activity_main);

        btnCreateArticle = findViewById(R.id.btn_create_article);
        btnListArticle = findViewById(R.id.btn_list_article);
        btnSetting = findViewById(R.id.btn_setting);
        textView_pagi = findViewById(R.id.textview_selamatpagi);

        btnCreateArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BuatArtikel.class));
            }
        });

        btnListArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArtikelList.class));
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) textView_pagi.setText("Good Night");
    }
}
