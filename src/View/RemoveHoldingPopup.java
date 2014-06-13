package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import lms.model.Holding;
import lms.model.facade.LMSModel;
import Controller.RemoveHoldingController;

public class RemoveHoldingPopup extends JDialog
{
	private JComboBox allHoldingsBox;
	private JLabel holdingLabel;
	private String holdingIDArray[];
	
	// constructor
	public RemoveHoldingPopup(LMSModel model, ApplicationFrame frame,
			Holding[] ArrayHoldings)
	{
		
		System.out.println("Inside RemoveHoldingPopup.java");
		this.setLayout(new GridLayout(0, 1));
		
		//cases where there is no holdings in the collection
		if (ArrayHoldings != null)
		{
			// create an new array to only hold holding id's for combo box
			holdingIDArray = new String[ArrayHoldings.length];
			
			//add holding objects holding id into a new array of type string for combo box to use
			for (int i = 0; i < holdingIDArray.length; i++)
			{
				holdingIDArray[i] = Integer
						.toString(ArrayHoldings[i].getCode());
			}
			allHoldingsBox = new JComboBox(holdingIDArray);
			holdingLabel = new JLabel("Select an Holding ID to remove: ");
			
			add(holdingLabel);
			add(allHoldingsBox);
			
			JButton submit = new JButton("Submit");
			// need to pass the this popup ref inorder for the controller to
			// retreieve data from this popup dialog window
			 submit.addActionListener(new RemoveHoldingController(this, model, frame));
			
			add(submit);
			this.setVisible(true); // required for panel/frame
			this.pack();
		}// end if
	} // end constructor
	
	//accessor returns holdingID as int to the Remove holding controller so it can remove the holding.
	//is selected is the value selected by the user
	public int getHoldingID()
	{
		return Integer.parseInt(allHoldingsBox.getSelectedItem().toString()); 
	}
	
}// end class
