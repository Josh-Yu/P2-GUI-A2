package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.AddHoldingPopup;

public class RadioButtonListener implements ActionListener
{
	private AddHoldingPopup popup;
	
	public RadioButtonListener(AddHoldingPopup popup)
	{
		this.popup = popup;
	}
	
	// checks if the radio button clicked is either book or video
	// depending holding type, it will tell the popup to set visible
	// for video fee combo box via mutator
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Inside action performed Radio Button listener");
		if (e.getSource() == popup.getbookButton())
		{
			popup.setVisibleComboBox(false);
		}
		
		else if (e.getSource() == popup.getvideoButton())
		{
			// System.out.println(popup.getvideoButton());
			popup.setVisibleComboBox(true);
		}
	}
	
}
