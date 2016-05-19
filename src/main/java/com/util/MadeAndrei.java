package com.util;



import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;


/**
 * Created by Andrei on 14.05.2016.
 */
@Component
public class MadeAndrei {
MediaPlayer mediaPlayer;
    public  void init(){
        Media m = new Media(Paths.get("src/main/resources/intro.mp3").toUri().toString());
        mediaPlayer = new MediaPlayer(m);

    }



    public void  play()  {
       init();
        mediaPlayer.play();

    }
    public void stop(){



        mediaPlayer.stop();

    }
}


