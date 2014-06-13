package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import lms.model.Book;
import lms.model.Holding;
import lms.model.Video;
import lms.model.facade.LMSModel;
import View.AddHoldingPopup;
import View.ApplicationFrame;

public class AddHoldingController implements ActionListener
{
	private LMSModel model;
	private ApplicationFrame frame;
	private AddHoldingPopup popup;
	private int holdingID;
	private String holdingTitle;
	private int videoFee;
	private Holding book1;
	private Holding video1;
	private String collectionToString;
	private Holding[] holdings;
	
	public AddHoldingController(AddHoldingPopup popup, LMSModel model,
			ApplicationFrame frame)
	{
		this.model = model;
		this.frame = frame;
		this.popup = popup;
	} // end constructor
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Inside addHoldingController.java");
		try
		{
			
			holdingID = Integer.parseInt(popup.getHoldingID());
		} catch (NumberFormatException E)
		{
			String prompt = "Data Input Invalid- HoldingID Require Integer value";
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			holdingTitle = popup.getHoldingTitle();
			if (holdingTitle.charAt(0) == ' ')
				throw new Exception("Error: Holding Title requires Input");
			
			videoFee = Integer.parseInt(popup.getVideoFee());
		} catch (Exception E)
		{
			String prompt = E.getMessage();
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	
		// checks if the combobox in the addHoldingPopup was visible, determines if video or book was
		// selected
		// video is selected
		
		if (popup.getLoanFeeBox().isVisible())
		{
			// video model call
			System.out.println("Holding ID is " + holdingID);
			System.out.println("Holding Title is " + holdingTitle);
			System.out.println("VideoFee is " + videoFee);
			//create a Video object to pass to model
			video1 = new Video(holdingID, holdingTitle, videoFee);
			
			System.out.println("*****Attempt to add video " + video1.toString());
			try
			{
				//if, returns true if adding video worked, false if it didnt work
				if(model.addHolding(video1))
				{
					System.out.println("*Video "+ video1.toString() + " has been successfully added to collection");	
				}
				else
				{
					System.out.println("*****Adding Video " + video1.toString()
							+ " FAILED");
					String prompt = "Unable to Add Video to Collection";
					String title = "Error";
					JOptionPane.showMessageDialog(null, prompt, title,
							JOptionPane.ERROR_MESSAGE);
				}
			}//end try
			catch (Exception E){
			System.out.println("*****Adding book" + book1.toString()
					+ " FAILED");
			String prompt = "Unknown Error Occured -AddHoldingController.Java EXCEPTION ";
			String title = "Error";
			JOptionPane.showMessageDialog(null, prompt, title,
					JOptionPane.ERROR_MESSAGE);
			popup.setVisible(false);

			}//end catch
		} // end if
		else
		{
			// Book model method call
			System.out.println("Book is slected");
			System.out.println("Holding ID is " + holdingID);
			System.out.println("Holding Title is " + holdingTitle);
			//create a book object to pass to model
			book1 = new Book(holdingID, holdingTitle);
			
			System.out.println("*****Attempt to add book " + book1.toString());
			try{
				//if is used to check if the adding book was successful
				if(model.addHolding(book1))
				{
				System.out.println("*Book "+ book1.toString() + " has been successfully added to collection");	
				}
				else
				{
					System.out.println("*****Adding book " + book1.toString()
							+ " to collection FAILED");
					String prompt = "Unable to Add Book to Collection";
					String title = "Error";
					JOptionPane.showMessageDialog(null, prompt, title,
							JOptionPane.ERROR_MESSAGE);
				}
			}
			 catch (Exception E)
			{
				System.out.println("*****Adding book" + book1.toString()
						+ " FAILED");
				String prompt = "Unknown Error Occured -AddHoldingController.Java Triggered ";
				String title = "Error";
				JOptionPane.showMessageDialog(null, prompt, title,
						JOptionPane.ERROR_MESSAGE);
				popup.setVisible(false);
				return;
			}//end catch
		}// end else
		
		// fetching data from the model to pass to the frame>statusbar to
		// update
		collectionToString = model.getCollection().toString();
		holdings = model.getAllHoldings();
		
		frame.updateStatusBar(collectionToString, holdings);
		frame.updateHoldingGrid(holdings);
		//makes the AddHolding pop disappear at the end
		popup.setVisible(false);
	} // end actionPerformed
	
}
