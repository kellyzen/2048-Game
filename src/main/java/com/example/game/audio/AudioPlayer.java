package com.example.game.audio;

import com.example.game.resource.ResourceDirectory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.net.URL;

/**
 *
 * AudioPlayer class.
 * Implements MediaPlayer interface.
 * Play audio from bgm resource folder.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class AudioPlayer implements com.example.game.audio.MediaPlayer {
    static URL resource = AudioPlayer.class.getResource(new ResourceDirectory().getResource("mp3","Clean and Dance - An Jone"));
    static Media media = new Media(resource.toString());

    static MediaPlayer mediaPlayer = new MediaPlayer(media);

    /**
     *
     * get the Media Player (bgm) played
     *
     * @return mediaPlayer
     *
     */
    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    /**
     *
     * Play audio infinitely.
     * Set volume to 0.5
     *
     */
    public void play() {
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
    }
}
