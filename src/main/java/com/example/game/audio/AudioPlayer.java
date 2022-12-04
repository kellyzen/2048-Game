package com.example.game.audio;

import com.example.game.resource.ResourceDirectory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.net.URL;

public class AudioPlayer {
    static URL resource = AudioPlayer.class.getResource(new ResourceDirectory().getResource("mp3","Clean and Dance - An Jone"));
    static Media media = new Media(resource.toString());

    static MediaPlayer mediaPlayer = new MediaPlayer(media);

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void playAudio () {
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
    }

    public void changeAudioVolume () {
        mediaPlayer.play();
    }
}
