import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;


public class forums extends JFrame {

	public forums() {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("https://hypixel.net/forums/report-abuse-hackers.37/create-thread");
							desktop.browse(uri);
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
	}
	public static void main(String[] args) {
		forums linkTest = new forums();
		linkTest.setSize(640,100);
		linkTest.setVisible(true);
	}
}