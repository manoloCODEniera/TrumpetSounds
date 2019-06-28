package com.example.trumpetsounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int a4,b4,c4,d4,e4,f4,g4,c5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else{
            soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        }

        a4 = soundPool.load(this, R.raw.a4_trumpet,1);
        b4 = soundPool.load(this, R.raw.b4_trumpet,1);
        c4 = soundPool.load(this, R.raw.c4_trumpet,1);
        d4 = soundPool.load(this, R.raw.d4_trumpet,1);
        e4 = soundPool.load(this, R.raw.e4_trumpet,1);
        f4 = soundPool.load(this, R.raw.f4_trumpet,1);
        g4 = soundPool.load(this, R.raw.g4_trumpet,1);
        c5 = soundPool.load(this, R.raw.c5_trumpet,1);
    }

    public void playSound(View v) {
        switch (v.getId()){

            case R.id.button_sound1:
                soundPool.play(c4, 1, 1, 0,0, 0 );
                break;

            case R.id.button_sound2:
                soundPool.play(d4, 1, 1, 0,0, 0 );
                break;
            case R.id.button_sound3:
                soundPool.play(e4, 1, 1, 0,0, 0 );
                break;
            case R.id.button_sound4:
                soundPool.play(f4, 1, 1, 0,0, 0 );
                break;
            case R.id.button_sound5:
                soundPool.play(g4, 1, 1, 0,0, 0 );
                break;
            case R.id.button_sound6:
                soundPool.play(a4, 1, 1, 0,0, 0 );
                break;
            case R.id.button_sound7:
                soundPool.play(b4, 1, 1, 0,0, 0 );
                break;
            case R.id.button_sound8:
                soundPool.play(c5, 1, 1, 0,0, 0 );
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
