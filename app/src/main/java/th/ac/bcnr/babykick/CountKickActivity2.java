package th.ac.bcnr.babykick;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class CountKickActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    String checkdate = "";
    String checkid = "";
    String  checkcount="";
    String checktime1="";
    String checktime2="";
    String checktime3="";
    DatabaseHelper mDatabaseHelper;
    int count = 0;
    int counttime1=0;
    int counttime2=0;
    int counttime3=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_kick2);
        mDatabaseHelper = new DatabaseHelper(this);
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        Cursor data = mDatabaseHelper.readAllData();
        Log.i("countbaby", "data : " + data);

        while (data.moveToNext()) {

            checkdate = data.getString(1);
            checkid = data.getString(0);
            checkcount = data.getString(2);
            checktime1 = data.getString(3);
            checktime2 = data.getString(4);
            checktime3 = data.getString(5);
            Log.i("countbaby", "checktime1 : " +checktime1);
            Log.i("countbaby", "checktime2 : " +checktime2);
            Log.i("countbaby", "checktime3 : " +checktime3);
        }
      if (checkcount.isEmpty()&&checktime1.isEmpty()&&checktime2.isEmpty()&&checktime3.isEmpty()){
          count=0;
          counttime1=0;
          counttime2=0;
          counttime3=0;

      }else{
          count=Integer.parseInt(checkcount);
          counttime1=Integer.parseInt(checktime1);
          counttime2=Integer.parseInt(checktime2);
          counttime3=Integer.parseInt(checktime3);

      }
        if (!currentDate.equals(checkdate)) {
            restcount();
        }



        TextView count_babykick = findViewById(R.id.textview_countkick);
        count_babykick.setText(String.valueOf(count));
        ProgressBar bar = findViewById(R.id.progressBar);
        bar.setProgress(count * 10);

        ImageView imageView_CountKick = findViewById(R.id.imageView_babykick);
        imageView_CountKick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                Log.i("countbaby", " onClick");
                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

                Cursor data = mDatabaseHelper.readAllData();
                Log.i("countbaby", "data : " + data);
                while (data.moveToNext()) {

                    checkdate = data.getString(1);
                    checkid = data.getString(0);
                    checkcount = data.getString(2);
                    checktime1 = data.getString(3);
                    checktime2 = data.getString(4);
                    checktime3 = data.getString(5);
                    Log.i("countbaby", "checktime1 : " +checktime1);
                    Log.i("countbaby", "checktime2 : " +checktime2);
                    Log.i("countbaby", "checktime3 : " +checktime3);
                }


                Log.i("countbaby", "checkdate222  : " + checkdate);
                Log.i("countbaby", "checkid222  : " + checkid);


                if (currentDate.equals(checkdate)) {
                    Log.i("countbaby", " if(currentDate == checkdate)" + currentDate + " == " + checkdate);
                    if(Integer.parseInt(currentTime.substring(0,2))>=0&&Integer.parseInt(currentTime.substring(0,2))<10){
                        counttime1++;
                        UpdateData(checkid, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                    }else if(Integer.parseInt(currentTime.substring(0,2))>=10&&Integer.parseInt(currentTime.substring(0,2))<16){
                        counttime2++;
                        UpdateData(checkid, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                    }else if(Integer.parseInt(currentTime.substring(0,2))>=16&&Integer.parseInt(currentTime.substring(0,2))<=23){
                        counttime3++;
                        UpdateData(checkid, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                    }

                    if(count==10){
                        openWindownDialog();
                    }
                } else {
                    if(Integer.parseInt(currentTime.substring(0,2))>=0&&Integer.parseInt(currentTime.substring(0,2))<12){
                        counttime1++;
                        AddData(currentDate, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                    }else if(Integer.parseInt(currentTime.substring(0,2))>=12&&Integer.parseInt(currentTime.substring(0,2))<12){
                        counttime2++;
                        AddData(currentDate, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                    }else if(Integer.parseInt(currentTime.substring(0,2))>=18&&Integer.parseInt(currentTime.substring(0,2))<=23){
                        counttime3++;
                        AddData(currentDate, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                    }

                    Log.i("countbaby", "else");
                }


                Log.i("countbaby", "countbaby : " + count);


                TextView count_babykick = findViewById(R.id.textview_countkick);
                count_babykick.setText(String.valueOf(count));
                ProgressBar bar = findViewById(R.id.progressBar);
                bar.setProgress(count * 10);
            }


        });


        Button button_next = findViewById(R.id.button_showdata);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CountKickActivity2.this, ShowData.class);
                startActivity(i);
            }
        });
        Button button_down = findViewById(R.id.button_down_count);
        button_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==0){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CountKickActivity2.this);
                    dialog.setTitle(R.string.Notifications_count_down);
                    dialog.setMessage(R.string.count_down_mes_noti);
                    dialog.setPositiveButton(R.string.ok_button, null);
                    dialog.show();
                }else{
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CountKickActivity2.this);
                    dialog.setTitle(R.string.Notifications_count_down);
                    dialog.setMessage(R.string.need_to_cont_down_ques);
                    dialog.setNegativeButton(R.string.cancel_button, null);
                    dialog.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                            count--;
                            if(Integer.parseInt(currentTime.substring(0,2))>=0&&Integer.parseInt(currentTime.substring(0,2))<12){
                                counttime1--;
                                UpdateData(checkid, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                            }else if(Integer.parseInt(currentTime.substring(0,2))>=12&&Integer.parseInt(currentTime.substring(0,2))<18){
                                counttime2--;
                                UpdateData(checkid, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                            }else if(Integer.parseInt(currentTime.substring(0,2))>=18&&Integer.parseInt(currentTime.substring(0,2))<=23){
                                counttime3--;
                                UpdateData(checkid, String.valueOf(count),String.valueOf(counttime1),String.valueOf(counttime2),String.valueOf(counttime3));
                            }

                            TextView count_babykick = findViewById(R.id.textview_countkick);
                            count_babykick.setText(String.valueOf(count));
                            ProgressBar bar = findViewById(R.id.progressBar);
                            bar.setProgress(count * 10);
                        }
                    });

                    dialog.show();

                }
            }
        });
    }


    public void AddData(String newEntry, String newEntry2,String time1,String time2,String time3) {
        mDatabaseHelper.addBook(newEntry, newEntry2,time1,time2,time3);
    }

    public void UpdateData(String newEntry, String newEntry2,String time1,String time2,String time3) {
        mDatabaseHelper.updateData(newEntry, newEntry2,time1,time2,time3);
    }

    /**
     * customizable toast
     *
     * @param message
     */
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void restcount() {
        this.count=0;
    }
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        System.gc();
        Intent refresh = new Intent(this,MainPage .class);
        finish();
        startActivity(refresh);
    }
    void openWindownDialog(){

        final Dialog dialog =  new Dialog(this);
        dialog.setContentView(R.layout.dialog_show);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);
        Button btnok =dialog.findViewById(R.id.BtnOK);
        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}