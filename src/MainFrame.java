import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	/**
	 * Panels declarations.
	 */
	private JPanel toolbar;
	private JPanel gameField;
	
	/**
	 * Buttons declarations & instantiations.
	 */
	private JButton startButton = new JButton("Start new game");
	
	/**
	 * The width and height of the app's main window;
	 */
	public final int APP_WIDTH = 500;
	public final int APP_HEIGHT = 500;
	
	/**
	 * Constructor of the MainFrame class.
	 * 
	 * - Sets the title of the app;
	 * - Instantiates the window, where the app runs;
	 * - Sets some basic frame settings like size, default close behavior, etc.;
	 * - Sets the layout of the main frame;
	 * - Instantiates some custom panels;
	 * - Places some components in the panels.
	 */
	public MainFrame(){
		
		
		
		
		
		/**
		 * Basic frame settings.
		 */
		// Setting the title of the app.
		// For now, some gibberish.
		super("The IOA Memory Game App, version 'too-alpha-to-be-cool'.");
		
		// In Swing we have layouts (the way the app positions elements on the screen).
		// Here we set the layout of the main frame (JFrame, the main window) of the app.
		// Read more here: http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		this.setLayout(new BorderLayout());
		
		// The default state of the main frame is hidden.
		// This line sets it to visible, which means the app will be visible
		// when the user starts it.
		this.setVisible(true); 
		
		// The default close operation doesn't terminate the app.
		// This line does the trick.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// This line sets the size of the app's window.
		this.setSize(APP_WIDTH, APP_HEIGHT);
		
		
		
		
		
		/**
		 * Toolbar.
		 * Let's keep it simple for now.
		 * Let's just have only one button - the "Start new game" button.
		 */
		// Instantiating the toolbar
		toolbar = new JPanel();
		
		// Adding the toolbar to the top of the frame.
		add(toolbar, BorderLayout.NORTH);
		
		// Setting the layout of the toolbar to be FlowLayout and to position content in it's center.
		toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Adding the "Start new game" button to the toolbar.
		toolbar.add(startButton);
		
		
		
		
		
		/**
		 * The gamefield.
		 * It's a square under the toolbar, where the magic should happen.
		 */
		// Instantiating the gameField object.
		gameField = new JPanel();
		
		// Adding the gameField to the frame.
		add(gameField, BorderLayout.CENTER);
		
		// Setting the layout of the gameField
		gameField.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Setting the background color of the panel to dark-gray.
		gameField.setBackground(Color.DARK_GRAY);
		
		// Adding the gameField to the frame.
		add(gameField);
		
		
		
		
		
	} // End of MainFrame()
	
} // End of MainFrame

