package com.gmail.wahyuwidian7;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class newclassjava2 extends AppCompatActivity implements View.OnClickListener{
    EditText editwaktu;
    Button tombolMain, tombolStop;
    //pada script diatas digunakan untuk membuat class edit text dan button
    //sehingga nantinya di run project dapat dijalankan



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahsuara);

        editwaktu = (EditText) findViewById(R.id.et_waktu);
        tombolMain = (Button) findViewById(R.id.bt_play);
        tombolStop = (Button) findViewById(R.id.bt_stop);
        tombolMain.setOnClickListener(this);
        tombolStop.setOnClickListener(this);
        //script diatas digunakan untuk membuat tombol play dan stop
        //sehingga nanti ketika tombol play diklik maka akan ada suara musik dan stop akan menghentikannya
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_play:
                callPlay();
                break;
            case R.id.bt_stop:
                stopPlay();
                break;
            //script diatas untuk memanggil button play agar musik mengeluarkan suara ketika project di run
            //dan button stop dapat menghentikannya
        }
    }
    public void callPlay(){
        int detik = Integer.parseInt(editwaktu.getText().toString());
        //script diatas untuk mendeklarasikan waktu berjalannya musik yang akan dimulai

        Intent intent = new Intent(newclassjava2.this, Newclassjava.class);
        //script diatas digunakan untuk memanggil class myservise dan myactivity

        PendingIntent pendingIntent = PendingIntent.getService(newclassjava2.this ,0 , intent,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //script diatas digunakan untuk mengakses data dari sevice ke sistem alarm

        if (alarmManager !=null) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                    + (detik * 1000), pendingIntent);
            Toast.makeText(getApplicationContext(),"Song Play After " +detik+"seconds !", Toast.LENGTH_LONG).show();
            //script diatas digunakan untuk mendeklarasikan durasi musik yang dapat diputar ketika project dijalankan
        }
    }
    public void stopPlay(){
        stopService(new Intent(newclassjava2.this, Newclassjava.class));

        //script diatas membuat class stop sehingga ketika button stop diklik maka dapat menghentikan musiknya
    }
}


