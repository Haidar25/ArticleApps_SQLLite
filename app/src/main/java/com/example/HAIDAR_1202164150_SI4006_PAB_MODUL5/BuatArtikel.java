package com.example.HAIDAR_1202164150_SI4006_PAB_MODUL5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BuatArtikel extends AppCompatActivity {

    EditText etTitle, etArticle, etAuthor;
    Button btnPost;
    String mTitle, mArticle, mAuthor;
    private ArtikelDbHelper db;
    sharedpref mysharedpref;


    final String PREF_NIGHT_MODE = "NightMode";
    SharedPreferences spNight;

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
        setContentView(R.layout.activity_buat_artikel);

        db = new ArtikelDbHelper(this);
        etTitle = findViewById(R.id.et_title_create);
        etArticle = findViewById(R.id.et_desc_create);
        etAuthor = findViewById(R.id.et_author_create);
        btnPost = findViewById(R.id.btn_post);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postArticle();
            }
        });

    }

    private void postArticle() {
        mTitle = etTitle.getText().toString().trim();
        mArticle = etArticle.getText().toString().trim();
        mAuthor = etAuthor.getText().toString().trim();

        if (mTitle.isEmpty()){
            msg("Title Harus anda isi");
            return;
        }
        if (mArticle.isEmpty()){
            msg("ArtikelActivity harus anda isi");
            return;
        }
        if (mAuthor.isEmpty()){
            msg("Author harus anda isi");
            return;
        }

        saveToDb();

    }

    private void saveToDb() {
        if (db.insertData(new ArtikelActivity(mAuthor, mTitle, mArticle, getDateTime()))){
            msg("Data Anda berhasil ditambahkan");
            startActivity(new Intent(BuatArtikel.this, ArtikelList.class));
        }else {
            msg("Ada masalah penambahan data");
        }
    }

    private void msg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEE d MMM `yy", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
