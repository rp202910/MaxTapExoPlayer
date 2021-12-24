package com.example.maxtapexoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.ui.PlayerView;

import java.net.URL;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
    ExoPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creating an instance of ExoPlayer.
         player = new ExoPlayer.Builder(this).build();
       final  ImageView image =findViewById(R.id.imageView);
        PlayerView playerView=findViewById(R.id.exoPlayer);
        //Binding the player with the view that is there in our xml.
        playerView.setPlayer(player);
        //Building the media Item.
        MediaItem mediaItem = MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4" );
        //Setting the media item that is to be played.
        player.setMediaItem(mediaItem);
        //preparing the player
       player.prepare();
       //playing the video.
       player.play();

        long videoWatchedTime;
        Log.i("Coming.....",player.getDuration()+" ");
       for(int i=0;i<50;i++){
           int mill=1000*(i+1);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

//                image.setImageResource(R.drawable.download);
                long  x= player.getCurrentPosition()/1000;
                if(x==10) {
                    image.setImageResource(R.drawable.download);
                Toast.makeText(MainActivity.this,"Image came",Toast.LENGTH_SHORT).show();
                image.setVisibility(View.VISIBLE);
                }
                else if(x==18){
                    Toast.makeText(MainActivity.this,"Image gone ",Toast.LENGTH_SHORT).show();
                         image.setVisibility(View.GONE);

                 }
//
            }
        },mill);



       }






//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                image.setImageResource(R.drawable.download);
//                Toast.makeText(MainActivity.this,"10 seconds  later",Toast.LENGTH_SHORT).show();
//                image.setVisibility(View.VISIBLE);
//            }
//        },10000);
//
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.i("dffffffdssdfdf>>>>>>>>>>  ",player.getCurrentPosition()+" ");
//                Toast.makeText(MainActivity.this,player.getCurrentPosition()/1000+" ",Toast.LENGTH_SHORT).show();
//                image.setVisibility(View.GONE);
//            }
//        }, 15000);


    }

    //If the back button is pressed then we have to relaese the mediaplayer.
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        if (player != null) {
            player.release();
        }
    }





}