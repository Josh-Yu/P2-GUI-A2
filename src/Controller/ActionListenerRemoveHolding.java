package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import lms.model.Holding;
import lms.model.facade.LMSModel;
import View.ApplicationFrame;
import View.RemoveHoldingPopup;

/*This controller is only designed to listen to Remove Holding context menu and Remove Holding button
 * which will create an instance of RemoveHoldingPopup onto the screen for user to input data
 * This does not interact with the model. Simply a listener for the RemoveHolding button/context menu
 * 
 * 
 */
public class ActionListenerRemoveHolding implements ActionListener
{
	private RemoveHoldingPopup removeHoldingPopup;
	private LMSModel model;
	private ApplicationFrame frame;
	private Holding[] ArrayHoldings;
	
	public ActionListenerRemoveHolding(LMSModel model, ApplicationFrame frame)
	{
		this.model = model;
		this.frame = frame;
	}//end constructor
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("RemoveHolding button/menu triggered - Inside ActionListenerRemoveHolding.java ");
		System.out.println("******************************");
		
		try{
		//required to getall holdings to pass to the popup to poulate the combo box
		ArrayHoldings = model.getAllHoldings();
		}
		catch(NullPointerException E)
		{
			System.out.println("ActionListenerRemove.JAVA NullPointerException TRIGGERED  ");
			String prompt = "ERROR Cannot Remove Holding If Collection is Empty ";
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		catch(Exception E)
		{
			System.out.println("ActionListenerRemove.JAVA EXCEPTION TRIGGERED  ");
			String prompt = "UNKNOWN ERROR";
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//create an new instance of a popup window for user to choose holding to remove
		//also need to pass in the current holdings to populate the combobox
		removeHoldingPopup = new RemoveHoldingPopup(model, frame, ArrayHoldings);
		
	}
	
}
