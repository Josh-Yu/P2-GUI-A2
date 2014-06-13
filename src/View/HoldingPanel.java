package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lms.model.Book;
import lms.model.Holding;
import lms.model.Video;

public class HoldingPanel extends JPanel
{
	
	private String holdingID;
	private String holdingTitle;
	private String holdingFee;
	private String holdingLoanPeriod;
	
	
	//constructor
	//individual holding object is passed in
	public HoldingPanel(ApplicationFrame parent,Holding individualHolding )
	{
	 //fetching data from the holding object passed in
		holdingID = Integer.toString(individualHolding.getCode());
		holdingTitle = individualHolding.getTitle();
		holdingFee = Integer.toString(individualHolding.getDefaultLoanFee());
		holdingLoanPeriod = Integer.toString(individualHolding.getMaxLoanPeriod());
		
		setLayout(new GridLayout(0, 1));
		
		
		add(new JLabel("Holding ID: "+this.holdingID));
		add(new JLabel("Holding Title: " + this.holdingTitle));
		add(new JLabel("Holding Fee: $" + this.holdingFee));
		add(new JLabel("Loan Period: " + this.holdingLoanPeriod + " Days"));

		setBackground(Color.LIGHT_GRAY);
		
		if(individualHolding instanceof Book)
			this.setBorder(BorderFactory.createMatteBorder(10,10,10,10, Color.BLUE));
		
		else if(individualHolding instanceof Video)
			this.setBorder(BorderFactory.createMatteBorder(10,10,10,10, Color.RED));
		
	} //end constructor
	
	public String getHoldingID()
	{
		return holdingID;
	}
}


