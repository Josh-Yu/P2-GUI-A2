package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import View.ApplicationFrame;

public class CloseWindowListener extends WindowAdapter
{
	  private ApplicationFrame frame;
	  public CloseWindowListener(ApplicationFrame frame)
	  {
	    this.frame = frame;
	  }// end constructor

	  public void windowClosing(WindowEvent e) {
		  System.out.println("\n\nCloseWindowListener.Java - Triggered");
		  
		  
	    String title = "Confirmation Required";
	    
	    
	    
	    String prompt = "Exit application? This will Exit the LMS.";
	    int input = JOptionPane.showConfirmDialog(null, prompt, title, 0);
	   
	    if (input == 0)
	    {
	    	System.out.println("*****Gui Application Terminated*****");
	    	System.exit(0);
	    }
	  }//end windowClosing
}
