package com.example.videowithadd1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;





public class MainActivity extends AppCompatActivity {

   VideoView videoView;
   // String path = "android.resource://"+getPackageName()+"/"+R.raw.video;
   MediaController mediaController;
    private boolean mShouldStop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       videoView =(VideoView)findViewById(R.id.videoView);
      mediaController= new MediaController(this);
        //This will give play pause options .
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("android.resource://com.example.videowithadd1" + "/" + R.raw.video);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        new MyAsync().execute();







    }
    private class MyAsync extends AsyncTask<Void, Integer, Void>
    {
        int duration = 0;
        int current = 0;
        @Override
        protected Void doInBackground(Void... params) {
            videoView.start();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp) {
                    duration =  videoView.getDuration();
                }
            });

            while (!mShouldStop) {
                    if (videoView != null && videoView.isPlaying()) {
                        if (videoView.getCurrentPosition() >=10000) {

                            mShouldStop = true;
                        }
                    }
                }



            return null;
        }
    }





//    private void trackProgress() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!mShouldStop) {
//                    if (videoView != null && videoView.isPlaying()) {
//                        if (videoView.getCurrentPosition() >=10000) {
//                            videoView.stopPlayback();
//                           mediaController.setMediaPlayer(videoView);
//
//
//                            mShouldStop = true;
//                        }
//                    }
//                }
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        }).start();
//    }




//    MediaPlayer.OnPreparedListener PreparedListener=new MediaPlayer.OnPreparedListener() {
//        @Override
//        public void onPrepared(MediaPlayer mp) {
//
//                try {
////                for(int i=0;i<60;i++){
////                    System.out.println(mp.isPlaying());
////
////
////                        if(mp.getCurrentPosition()>=10 && mp.getCurrentPosition()<=20){
////                            mp.setVolume(0f,0f);
////
////
////                    }
////
////                }
////                mp.setLooping(false);
//                mp.start();
//                System.out.println(mp.isPlaying());
//                System.out.println(mp.getCurrentPosition());
//                System.out.println(mp.getCurrentPosition());
//
//
//            }
//            catch(Exception e){
//
//                e.printStackTrace();
//            }
//
//        }
//    };

}