package com.example.HAIDAR_1202164150_SI4006_PAB_MODUL5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ArtikelDetail extends AppCompatActivity {

    TextView tvAuthor, tvTitle, tvArticle, tvNotif;
    final String PREF_FONT_SIZE = "BigSize";
    SharedPreferences spFont;
    sharedpref mysharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mysharedpref = new sharedpref(this);
        if (mysharedpref.loadNightModeState() == true) {
            if (mysharedpref.loadBigFontState() == true) {

                setTheme(R.style.bigfontdark);
            } else
                setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.AppTheme);
            if (mysharedpref.loadBigFontState() == true) {
                setTheme(R.style.bigfontwhite);
            } else setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_detail);

        tvAuthor = findViewById(R.id.textview_penulis);
        tvArticle = findViewById(R.id.textview_deskripsinya);
        tvTitle = findViewById(R.id.textview_judulnya);
        tvNotif = findViewById(R.id.notiftext);

        if (getIntent() != null) {
            tvAuthor.setText(getIntent().getStringExtra("penulis"));
            tvArticle.setText(getIntent().getStringExtra("deskripsi"));
            tvTitle.setText(getIntent().getStringExtra("judul"));
        }

        spFont = getSharedPreferences(PREF_FONT_SIZE, Context.MODE_PRIVATE);
    }
}
