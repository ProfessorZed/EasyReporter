import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class links extends JFrame {

	public links() {
		JPanel p = new JPanel();

		JLabel link = new JLabel("Click here to create your thread.");
		link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 0) {
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
			}
		});
		p.add(link);
		getContentPane().add(BorderLayout.NORTH, p);
	}

	public static void main(String[] args) {
		links linkTest = new links();
		linkTest.setSize(640,100);
		linkTest.setVisible(true);
	}
}