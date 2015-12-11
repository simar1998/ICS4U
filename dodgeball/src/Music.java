import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.TimerTask;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 * This class plays the music for the mini game
 * @author Simar Pal Kalsi
 *Time -- 9:30:18 PM Date Dec 10, 2015
 */
class Music extends TimerTask {
    AudioStream audioStream;
    /**
     * This method plays the music
     */
public void run(){
    String filename = "cant_touch_this.wav";
    InputStream in = null;
    try {
	in = new FileInputStream(new File(filename));
    } catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
	try {
	   audioStream = new AudioStream(in);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	AudioPlayer.player.start(audioStream);
}
}
