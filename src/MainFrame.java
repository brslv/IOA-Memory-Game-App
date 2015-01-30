import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
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
	}
	
}

