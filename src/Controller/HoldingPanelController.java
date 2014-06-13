package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import lms.model.Holding;
import lms.model.facade.LMSModel;
import View.ApplicationFrame;
import View.HoldingPanel;

//this controller is conected to all holdingPanels
// its main purpose is to delete the holding that the user selects from
// the grid

//all cells in the grid share the same instance of Holding Panel Controller
public class HoldingPanelController extends MouseAdapter
{
	private LMSModel model;
	private ApplicationFrame frame;
	private int holdingID;
	
	public HoldingPanelController(LMSModel model, ApplicationFrame frame)
	{
		this.model = model;
		this.frame = frame;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		// gets the correct panel
		HoldingPanel cell = (HoldingPanel) e.getSource();
		
		// calls accessor located in HoldingPanel that returns the String
		// value of Holding ID that is associated with panel
		holdingID = Integer.parseInt(cell.getHoldingID());
		
		System.out.println("Holding ID: " + holdingID
				+ " Cell Selected for deletion");
		
		String prompt = "Remove holding " + holdingID + " from the collection?";
		String title = "Confirmation Required";
		int input = JOptionPane.showConfirmDialog(null, prompt, title, 0);
		
		if (input == 0)
		{
			System.out.println("Removing Holding " + holdingID);
			model.removeHolding(holdingID);
			
			// fetch all holdings (array) pass to the frame>updateHoldingGrid
			Holding[] holdingsArray = model.getAllHoldings();
			frame.updateHoldingGrid(holdingsArray);
			
			// fetch from model and pass to frame>statusBar to update
			String collectionToString = model.getCollection().toString();
			frame.updateStatusBar(collectionToString, holdingsArray);
			
		}
	} // end mouseClicked
}
