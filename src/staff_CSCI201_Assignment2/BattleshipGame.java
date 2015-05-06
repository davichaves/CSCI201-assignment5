package staff_CSCI201_Assignment2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class BattleshipGame {
	
	//public static Scanner scan = new Scanner(System.in);
	
	private BattleshipFrame bsf;
	
	BattleshipGame() {
		bsf = new BattleshipFrame();
		bsf.enterEditMode();
		Thread t = new Thread(new WaterChanger(bsf));
		t.start();
	}
	
	public static void main(String[] args) throws IOException {
		new ConnectMenu();
	}

}

class ConnectMenu extends JFrame {
	private String ip;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectMenu() throws IOException {
		super("Battleship Menu");
		setVisible(true);
		try {
			URL toCheckIp = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(toCheckIp.openStream()));
			ip = in.readLine();
		} catch (IOException ioe) {
			ip = "Error!";
		} finally {
			JLabel serverNameLabel = new JLabel("Your IP: " + ip, SwingConstants.CENTER);
			JLabel nameLabel = new JLabel("Name: ", SwingConstants.CENTER);
			final JTextField nameField = new JTextField("Player1",10);
			JButton connect = new JButton("Connect");
			JButton refresh = new JButton("Refresh");
			JCheckBox maps = new JCheckBox();
			JLabel mapsLabel = new JLabel("201 Maps", SwingConstants.CENTER);
			final JTextField mapsField = new JTextField("",10);
			JCheckBox hostGame = new JCheckBox();
			JLabel hostGameLabel = new JLabel("Host Game  |  Enter an IP: ", SwingConstants.CENTER);
			final JTextField hostGameField = new JTextField("",10);
			JCheckBox port = new JCheckBox();
			JLabel portLabel = new JLabel("Custom Port  |  Port: ", SwingConstants.CENTER);
			final JTextField portField = new JTextField("",10);
			
			setLayout(new BorderLayout());
			
			JPanel north = new JPanel();
			north.setLayout(new BorderLayout());
			JPanel centerNorth = new JPanel();
			centerNorth.setLayout(new BorderLayout());
			JPanel center = new JPanel();
			center.setLayout(new BorderLayout());
			JPanel centerCenterNorth = new JPanel();
			centerCenterNorth.setLayout(new BorderLayout());
			JPanel centerCenter = new JPanel();
			centerCenter.setLayout(new BorderLayout());
			JPanel centerCenterSouth = new JPanel();
			centerCenterSouth.setLayout(new BorderLayout());
			JPanel centerSouth = new JPanel();
			centerSouth.setLayout(new BorderLayout());
			JPanel south = new JPanel();
			south.setLayout(new BorderLayout());
			
			north.add(serverNameLabel, BorderLayout.CENTER);
			centerNorth.add(nameLabel, BorderLayout.LINE_START);
			centerNorth.add(nameField, BorderLayout.LINE_END);
			centerSouth.add(maps, BorderLayout.LINE_START);
			centerSouth.add(mapsLabel, BorderLayout.CENTER);
			centerSouth.add(mapsField, BorderLayout.LINE_END);
			centerCenterNorth.add(hostGame, BorderLayout.LINE_START);
			centerCenterNorth.add(hostGameLabel, BorderLayout.CENTER);
			centerCenterNorth.add(hostGameField, BorderLayout.LINE_END);
			centerCenterSouth.add(port, BorderLayout.LINE_START);
			centerCenterSouth.add(portLabel, BorderLayout.CENTER);
			centerCenterSouth.add(portField, BorderLayout.LINE_END);
			centerCenter.add(centerCenterNorth, BorderLayout.PAGE_START);
			centerCenter.add(centerCenterSouth, BorderLayout.PAGE_END);
			center.add(centerNorth, BorderLayout.PAGE_START);
			center.add(centerCenter, BorderLayout.CENTER);
			center.add(centerSouth, BorderLayout.PAGE_END);
			south.add(refresh, BorderLayout.LINE_START);
			south.add(connect, BorderLayout.LINE_END);
			
			add(north, BorderLayout.PAGE_START);
			add(center, BorderLayout.CENTER);
			add(south, BorderLayout.PAGE_END);
			
			setSize(400, 180);
			setLocationRelativeTo(null);
			
			connect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			    
				}
			});
			
			refresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			    
				}
			});
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
}
