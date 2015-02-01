import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;


public class MainMenu extends JFrame {
		public MainMenu() {
			Toolbar();
		}
		private void Toolbar() {
			JMenuBar menubar = new JMenuBar();
			
			JMenu start = new JMenu("New Game");
			JMenuItem eStart = new JMenuItem("New Game");
			eStart.setMnemonic(KeyEvent.VK_N);			
			eStart.setToolTipText("Start new game.");
			eStart.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                //System.exit(0);
	            }
	        });
			JMenu difficulty = new JMenu("Difficulty");
			JMenuItem eDifficulty = new JMenuItem("Difficulty");
			eDifficulty.setToolTipText("Pick difficulty");
			eDifficulty.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					
				}
			});
			
			JMenu exit = new JMenu("Exit");
			 JMenuItem eExit = new JMenuItem("Exit");
		        eExit.setMnemonic(KeyEvent.VK_E);
		        eExit.setToolTipText("Exit application");
		        eExit.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent event) {
		                System.exit(0);
		            }
		        });

		        menubar.add(eStart);
		        menubar.add(eDifficulty);
		        menubar.add(eExit);
		        setJMenuBar(menubar);

		        setTitle("Main Menu");
		        setSize(300, 200);
		        setLocationRelativeTo(null);
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                MainMenu ex = new MainMenu();
	                ex.setVisible(true);
	            }
	        });
		}
}
