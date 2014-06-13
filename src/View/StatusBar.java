package View;

import java.awt.Dimension;

import javax.swing.JLabel;

import lms.model.Book;
import lms.model.Holding;
import lms.model.Video;

public class StatusBar extends JLabel
{
	private int bookCount;
	private int videoCount;
	private String[] splitStringArray;
	private Holding[] holdingsArray;
	
	public StatusBar()
	{
		super();
		super.setPreferredSize(new Dimension(100, 16));
		setMessage("Collection Code: N/A Collection Name: N/A Books[0] Video[0]");
	}// end constructor
	
	public void setMessage(String message)
	{
		setText(" " + message);
	}
	
	// only used when person has only created new library and collection
	// pass only tostring repsentation
	public void updateMessage(String collectionToString, Holding[] holdings)
			throws ArrayIndexOutOfBoundsException
	{
		System.out
				.println("\n\n*****Updating Status Bar-- StatusBar.java*****");
		String collectionCode;
		String collectionName;
		bookCount = 0;
		videoCount = 0;
		{
			splitStringArray = collectionToString.split(":");
			collectionCode = splitStringArray[0];
			collectionName = splitStringArray[1];
			holdingsArray = holdings;
			
			if (holdingsArray != null) // cases where the array is empty
			{
				// counts how many types of each holding
				for (int i = 0; i < holdingsArray.length; i++)
				{
					System.out.println("Current Array Item" + holdingsArray[i]);
					if (holdingsArray[i] instanceof Book)
						bookCount++;
					
					if (holdingsArray[i] instanceof Video)
						videoCount++;
					
				} // end for
			}// end if
			
			System.out.println("Current Book count " + bookCount);
			System.out.println("Current Video count " + videoCount);
			System.out.println("****************************************\n");
			
			setText("Collection Code: " + " " + collectionCode
					+ " | Collection Name: " + collectionName + " "
					+ " | Books[" + bookCount + "]" + " | Videos[" + videoCount
					+ "]");
		}
	}
}
