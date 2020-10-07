package th.ac.bcnr.babykick;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.TextView;

public class CauseMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cause_main);

        TextView mTitleWindow = findViewById(R.id.titleWindow);
        TextView mMessageWindow = findViewById(R.id.messageWindow);

        mTitleWindow.setText(R.string.causelukdin);

        StringBuilder stringBuilder = new StringBuilder();

        String someMessage = "    "+getString(R.string.cause_1) + "    "+getString(R.string.cause_2) +"    "+ getString(R.string.cause_3);


        stringBuilder.append(someMessage);

        mMessageWindow.setText(stringBuilder.toString());
    }
}