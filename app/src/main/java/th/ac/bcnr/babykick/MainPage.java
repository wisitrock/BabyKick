package th.ac.bcnr.babykick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ImageView imageView_nublokdin  = findViewById(R.id.imageView_main_1);
        imageView_nublokdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainPage.this,CountKickActivity2.class);
                startActivity(i);
            }
        });

        ImageView imageView_cause = findViewById(R.id.imageView_main_2);
        imageView_cause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainPage.this,CauseMainActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView_advice = findViewById(R.id.imageView_main_3);
        imageView_advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainPage.this,AdviceMainActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView_dangerous = findViewById(R.id.imageView_main_4);
        imageView_dangerous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainPage.this,dangerous_MainActivity2.class);
                startActivity(i);
            }
        });
    }
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        System.gc();
        Intent refresh = new Intent(this,MainActivity .class);
        finish();
        startActivity(refresh);
    }
}