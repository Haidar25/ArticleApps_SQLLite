package com.example.HAIDAR_1202164150_SI4006_PAB_MODUL5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    private Switch switchnight, switchbigfont;
    sharedpref mysharedpref;
    private TextView tes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mysharedpref = new sharedpref(this);
        if (mysharedpref.loadNightModeState() == true) {
            if (mysharedpref.loadBigFontState() == true){
                setTheme(R.style.BigTheme);
            }else {
                setTheme(R.style.NormalTheme);
            }
            setTheme(R.style.DarkTheme);
        } else {
            if (mysharedpref.loadBigFontState() == true){
                setTheme(R.style.BigTheme);
            }else {
                setTheme(R.style.NormalTheme);
            }
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        switchbigfont = findViewById(R.id.sw_font_size);
        if (mysharedpref.loadBigFontState() == true) {
            switchbigfont.setChecked(true);
        }else
        {
            switchbigfont.setChecked(false);
        }

        switchnight = findViewById(R.id.sw_night_mode);
        if (mysharedpref.loadNightModeState() == true){
            switchnight.setChecked(true);
        } else
        {
            switchnight.setChecked(false);
        }

        switchbigfont = findViewById(R.id.sw_font_size);

        CompoundButton.OnCheckedChangeListener multiListener = new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                switch (v.getId()){
                    case R.id.sw_night_mode:
                        if (isChecked)
                        {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            mysharedpref.setNightModeState(true);
                            startActivity(new Intent(getApplicationContext(), SettingActivity.class));
                            finish();
                        } else
                        {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            mysharedpref.setNightModeState(false);
                            startActivity(new Intent(getApplicationContext(), SettingActivity.class));
                            finish();
                        }
                        break;
                    case R.id.sw_font_size:
                        if (isChecked)
                        {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            mysharedpref.setBigFontState(true);
                            startActivity(new Intent(getApplicationContext(), SettingActivity.class));
                            finish();
                        } else
                        {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            mysharedpref.setBigFontState(false);
                            startActivity(new Intent(getApplicationContext(), SettingActivity.class));
                            finish();
                        }
                        break;
                }
            }
        };

        switchnight.setOnCheckedChangeListener(multiListener);
        switchbigfont.setOnCheckedChangeListener(multiListener);
    }

    public void setting_save(View view) {
        startActivity(new Intent(SettingActivity.this, MainActivity.class));
    }
}
