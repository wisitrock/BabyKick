package th.ac.bcnr.babykick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AdviceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_main);


        TextView mTitleWindow = findViewById(R.id.titleWindow_advice);
        TextView mMessageWindow = findViewById(R.id.messageWindow_advice);

        mTitleWindow.setText(R.string.advicelukdin);

        StringBuilder stringBuilder = new StringBuilder();

        String someMessage = "    "+getString(R.string.advice_text_)+"\n\n"+getString(R.string.advice_warning);


        stringBuilder.append(someMessage);

        mMessageWindow.setText(stringBuilder.toString());
    }
}