import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class CardStyle{  // Initialized in Deck's constructor

	private ImageIcon backImg; 	// we need just 1 back img for all cards, because it's same
	private ArrayList<ImageIcon> frontImg;	// keep all different images for the front
	private static int index = -1; //-1 because cannot be changed after returning the value 
	// This is static, because it's not a part of the Object. Used for some logic
	
	
	public CardStyle(String imgFolderPath) throws IOException{	//I was lazy to throw this. Sorry	
		this.backImg = new ImageIcon(getBackImageFromFolder(imgFolderPath, "back"));						
		this.frontImg = new ArrayList<ImageIcon>();
		frontImg.addAll(getImageListFromFolder(imgFolderPath));	
	}
	
	public ImageIcon getBackImage(){
		return this.backImg;
	}
	
	public ImageIcon getNextFrontImage(){
		index++;
		try {
			return frontImg.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("This deck is empty!");
			return null;
		}		
	}
		
	//Not sure if there must be try-catch block but let's not risk it
	// Getting all images from a directory
	public static ArrayList<ImageIcon> getImageListFromFolder(String imgFolderPath) {
	    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();	    	    
	    File folder = new File(imgFolderPath);	    
	    File[] listOfFiles = folder.listFiles();	    
	    for (int i = 0; i < listOfFiles.length; i++) {
	        if (listOfFiles[i].isFile()) {
	        	try {
	        		if(listOfFiles[i].getName().startsWith("back")){
	        			continue;
	        		}
	        		images.add(new ImageIcon(listOfFiles[i].getAbsolutePath()));	
				} catch (Exception e) {
					System.out.println(listOfFiles[i].getAbsolutePath() 
							+ " is not recognized by ImageIcon class as an image");
				}	        	          
	        } 
	      }
	    return images;
	}
	
	// Finding a file by start String 
	public static String getBackImageFromFolder(String imgFolderPath, String fileStartsWith){
		
	    File dir = new File(imgFolderPath);
	      FilenameFilter filter = new FilenameFilter() {
	         public boolean accept
	         (File dir, String name) {
	            return name.startsWith(fileStartsWith);
	        }
	      };
	      String[] children = dir.list(filter);
	      if (children == null) {
	         System.out.println("File with start string \"" + fileStartsWith 
	        		 + "\" was not found in dir" + imgFolderPath);
	         return null;
	      } 
	      else {
	           return children[0];
	      } 	
	     
	}
   
}
