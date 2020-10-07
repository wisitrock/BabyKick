package th.ac.bcnr.babykick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class dangerous_MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangerous__main2);


        TextView mTitleWindow = findViewById(R.id.titleWindow_dangerous);
        TextView mMessageWindow = findViewById(R.id.messageWindow_dangerous);

        mTitleWindow.setText(R.string.signaldangeous);

        StringBuilder stringBuilder = new StringBuilder();

        String someMessage ="    "+getString(R.string.dangwe_message);



        stringBuilder.append(someMessage);

        mMessageWindow.setText(stringBuilder.toString());
    }
}