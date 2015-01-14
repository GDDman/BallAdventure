package main;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.net.URL;

public class Sounds {
	
	private final int BUFFER_SIZE = 128000;
	private AudioInputStream song;
	private AudioFormat format;
	private SourceDataLine sourceLine;
	private URL input;
	
	public void starting(String filename, float f) {
		
		String strFilename = filename;
		float volume = f;
		
		try {
			
			input = this.getClass().getResource(strFilename);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		try {
			song = AudioSystem.getAudioInputStream(input);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		format = song.getFormat();
        
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try {
			sourceLine = (SourceDataLine) AudioSystem.getLine(info);
			sourceLine.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
      
		FloatControl gainControl = (FloatControl) sourceLine.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(volume);
		
		sourceLine.start();
			
		int nBytesRead = 0;
		byte[] abData = new byte[BUFFER_SIZE];
			
		while (nBytesRead != -1) {
			try {
				nBytesRead = song.read(abData, 0, abData.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (nBytesRead >= 0) {
				@SuppressWarnings("unused")
				int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
			}
		} 
		
		sourceLine.drain();
		sourceLine.flush();
		sourceLine.close();
			
	}
}
