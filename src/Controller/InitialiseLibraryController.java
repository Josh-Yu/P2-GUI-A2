package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import lms.model.Holding;
import lms.model.LibraryCollection;
import lms.model.facade.LMSModel;
import View.AddCollectionPopup;
import View.ApplicationFrame;

public class InitialiseLibraryController implements ActionListener
{
	private AddCollectionPopup addCollectionPopup;
	
	private LMSModel model;
	private ApplicationFrame frame;
	
	private String collectionID;
	private String collectionName;
	
	private String collectionToString;
	
	private Holding[] holdings;
	
	public InitialiseLibraryController(LMSModel model, ApplicationFrame frame)
	{
		this.model = model;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("The InitialiseLibraryController is working");
		
		addCollectionPopup = new AddCollectionPopup(model, frame);
		
		collectionID = addCollectionPopup.getCollectionID();
		collectionName = addCollectionPopup.getCollectionName();
		try
		{
			if (collectionID.charAt(0) == ' ')
				throw new Exception("");
			
		} catch (Exception E)
		{
			String prompt = "Collection ID invalid";
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try
		{
			if (collectionName.charAt(0) == ' ')
				throw new Exception();
			
		} catch (Exception E)
		{
			String prompt = "Collection Name Invalid";
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			model.addCollection(new LibraryCollection(collectionID,
					collectionName));
		} catch (ArrayIndexOutOfBoundsException E)
		{
			String prompt = "ERROR to Create Collection invalid";
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// fetching data from the model and passing them to the update status
		// bar in the application frame;
		
		collectionToString = model.getCollection().toString();
		holdings = model.getAllHoldings();
		
	
			frame.updateStatusBar(collectionToString, holdings);
			frame.updateHoldingGrid(holdings);
//		} catch (ArrayIndexOutOfBoundsException E)
//		{
//			String prompt = "Collection was Created Incorrectly";
//			String title = "Error";
//			JOptionPane.showMessageDialog(null, prompt, title,
//					JOptionPane.ERROR_MESSAGE);
//			return;
//			
//		}

		
	}
	
}
