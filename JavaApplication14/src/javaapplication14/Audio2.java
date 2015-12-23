import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio2 implements Runnable {

	@Override
	public void run() {
		try {
			Player p = new Player(new FileInputStream("res/77bb8a8b000a2b45e0b78e58988dac51.mp3"));
			p.play();
		} catch (FileNotFoundException | JavaLayerException e) {

			e.printStackTrace();
		}
	}

}
