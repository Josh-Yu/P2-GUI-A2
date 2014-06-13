package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import lms.model.facade.LMSModel;
import View.AddHoldingPopup;
import View.ApplicationFrame;

/*This controller is only designed to listen to Add Holding context menu and Add Holding button
 * which will create an instance of AddHoldingPopup onto the screen for user to input data
 * This does not interact with the model. Simply a listener for the addHolding button/context menu
 * 
 * 
 */
public class ActionListenerAddHolding implements ActionListener
{
	private AddHoldingPopup addHoldingPopup;
	private LMSModel model;
	private ApplicationFrame frame;

	
	public ActionListenerAddHolding(LMSModel model, ApplicationFrame frame)
	{
		this.model = model;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("AddHolding button/menu triggered - Inside ActionListenerAddHolding.java ");
		System.out.println("***********************");
		
		//if checks if a library collection has been created. by checking if an collection array is null
		//if it does return null then display a popup notification telling user to create an collection
		//also if it does return null then dont create an Addholding Popup
		if(model.getCollection() != null)
		{
		//create an new instance of a popup window for user to enter add holding details
		addHoldingPopup = new AddHoldingPopup(model, frame);
		}
		else
		{
			System.out.println("getCollection returns null, library hasnt been created - Inside ActionListenerAddHolding.java");
			String prompt = "The Library is Required to be created before adding an Holding";
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
		}
	}//end actionPerformed
	
}
