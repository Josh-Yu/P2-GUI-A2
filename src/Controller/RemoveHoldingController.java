package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import lms.model.Holding;
import lms.model.facade.LMSModel;
import View.ApplicationFrame;
import View.RemoveHoldingPopup;

//once user clicks submit button in the RemoveHoldingPopup
//this removeHolding controller fires off
//No exception handling needed for the removeHolding because there are nothing the user can do
//to stuff up the removing of the holding because of comboBox
public class RemoveHoldingController implements ActionListener
{
	
	private LMSModel model;
	private ApplicationFrame frame;
	private RemoveHoldingPopup popup;
	private int holdingID;
	private String collectionToString;
	private Holding[] holdings;
	
	public RemoveHoldingController(RemoveHoldingPopup removePopup,
			LMSModel model, ApplicationFrame frame)
	{
		this.model = model;
		this.frame = frame;
		this.popup = removePopup;
	} // end constructor
	
	public void actionPerformed(ActionEvent e)
	{
		//telling the RemoveHolding popup to disappear
		popup.setVisible(false);
		
		System.out.println("inside RemoveHoldingController.java");
		//RemoveHoldingPopup has an accessor that returns the selected value
		//from the combobox
		holdingID = popup.getHoldingID();
		
		String prompt = "Remove holding " + holdingID + " from the collection?";
		String title = "Confirmation Required! ";
		int input = JOptionPane.showConfirmDialog(null, prompt, title, 0);
		
		if (input == 0)
		{
			System.out.println("Removing Holding: " + holdingID);
			model.removeHolding(holdingID);
			System.out.println("Holding " + holdingID + " Has been removed");
			
			// fetching data from the model to pass to the frame>statusbar to
			// update
			collectionToString = model.getCollection().toString();
			holdings = model.getAllHoldings();

			frame.updateStatusBar(collectionToString, holdings);
			frame.updateHoldingGrid(holdings);
		}// end if
		
	} // end actionPerformed
	
}
