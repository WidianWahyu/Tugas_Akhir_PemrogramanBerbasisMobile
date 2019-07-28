package com.gmail.wahyuwidian7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class Newclassjava extends Service {
    MediaPlayer mediaPlayer;
    //script diatas digunakan untuk mengakses mediaplayers agar nantinya musik dapat diputar ketika project sudah dijalankan

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
        //script diatas digunakan untuk memanggil atau menjalankan project

    }
    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this, R.raw.perfect);
        mediaPlayer.setLooping(true);
        //script diatas digunakan untuk membuat kelas raw mediaplayer untuk memasukan musik kedalam class tersebut
        //sehingga nanti ketika project dijalankan maka musik dapat diputar
    }
    @Override
    public int onStartCommand(Intent intent, int flaga, int startId){
        mediaPlayer.start();
        return START_NOT_STICKY;
        //script diatas digunakan untuk mendeklarasikan awal mulai mediaplayer ketika nanti musik sudah dapat berjalan dan diputar
    }
    @Override
    public void onDestroy(){
        mediaPlayer.stop();
        //script diatas digunakan untuk dapat menghentikan musik nanti ketika sudah diputar
    }
}

