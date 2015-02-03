import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class StartScreen extends JFrame {

	private int selectedCategoryID;
	public String selectedCategoryTitle;
	private String[] categories = {"beers", "Fruits", "kamasutra"};
	
	public static void main(String[] args) {
			 
		EventQueue.invokeLater(new Runnable() {
			@Override
			
			public void run(){

				StartScreen buttons = new StartScreen();
				
				buttons.setVisible(true);
				
			}
		});

	}
	
	public StartScreen(){
		
		initUI();
	}
	
	
	private void initUI(){
		Container pane = getContentPane();
		//JPanel paneTwo = (JPanel) getContentPane();
		GroupLayout layout = new GroupLayout(pane);
		pane.setLayout(layout);
		pane.setBackground(Color.LIGHT_GRAY);
		//paneTwo.setToolTipText("Content paneTwo");
		
		JComboBox categoriesDropDown = new JComboBox(categories);
		selectedCategoryTitle = "beers";
		categoriesDropDown.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedCategoryID = categoriesDropDown.getSelectedIndex();
				selectedCategoryTitle = categories[selectedCategoryID];
			}
			
		});
		categoriesDropDown.setBounds(175, 60, 150,30);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(200, 180, 100, 30);
		
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
			
		});
		
		JButton startButton = new JButton("Start new game");
		startButton.setBounds(120, 120, 250, 30);
		startButton.setToolTipText("Start new game.");
		startButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	        	SwingUtilities.invokeLater(new Runnable(){
	    			@Override
	    			public void run(){
	    				// We instantiate a new game.
	    				 String imgFolderPath = "Images" + "/" + selectedCategoryTitle;
	    				 MainFrame frame = new MainFrame(2, 3, new Deck(2 * 3, imgFolderPath));
	    				 frame.startNewGame();
	    				 setVisible(false);
	    			}
	    		});
	        }
	    });
		 
		 add(categoriesDropDown);
		 add(startButton);
		 add(quitButton);
		
		pack();
		setTitle("Start screen");
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	

	}
}
