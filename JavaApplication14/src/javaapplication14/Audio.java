import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio implements Runnable {

	@Override
	public void run() {
		try {
			Player p = new Player(new FileInputStream("res/Tragediya belok -Igrovaya zona 2 www.mp3lio.net .mp3"));
			p.play();
		} catch (FileNotFoundException | JavaLayerException e) {

			e.printStackTrace();
		}
	}

}
