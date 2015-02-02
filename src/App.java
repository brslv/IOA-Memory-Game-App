import javax.swing.SwingUtilities;

public class App{

	public static void main(String[] args){
		
		/**
		 * The method invokeLater() is for thread-safety purposes.
		 */
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				// We instantiate a new game.
				new StartScreen(); 
			}
		});
		
	}
	
}