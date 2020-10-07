package th.ac.bcnr.babykick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button_my = findViewById(R.id.button_my);
        button_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("my");
            }
        });

        Button button_th = findViewById(R.id.button_th);
        button_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("th");
            }
        });

        Button button_next = findViewById(R.id.button_next_st);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainPage.class);
                startActivity(i);
            }
        });

    }
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }
}

