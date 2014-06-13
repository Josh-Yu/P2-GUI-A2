package View;

import javax.swing.JOptionPane;

import lms.model.facade.LMSModel;

public class AddCollectionPopup extends JOptionPane
{
	private String collectionID;
	private String collectionName;
	
	// private LMSModel library;
	public AddCollectionPopup(LMSModel model, ApplicationFrame frame)
	{
		System.out.println("Inside AddCollectionPopup.Java");
		
		collectionID = JOptionPane.showInputDialog("Collection ID");
		collectionName = JOptionPane.showInputDialog("Collection Name");

	}
	
	public String getCollectionID()
	{
		return collectionID;
	}
	
	public String getCollectionName()
	{
		return collectionName;
	}

}
