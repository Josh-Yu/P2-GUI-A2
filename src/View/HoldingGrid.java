package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lms.model.Holding;
import lms.model.facade.LMSModel;
import Controller.HoldingPanelController;

public class HoldingGrid extends JPanel
{
	private ApplicationFrame parent;
	private HoldingPanelController holdPanelController;
	private JPanel base;
	private JPanel blankPanel;
	private HoldingPanel individualPanel;
	
	// constructor
	public HoldingGrid(LMSModel model, ApplicationFrame frame)
	{
		parent = frame;
		base = new JPanel();
		setLayout(new GridLayout(0, 1));
		
		base.add(new JLabel("No Holdings Added"));
		base.setBackground(Color.WHITE);
		add(base);
		holdPanelController = new HoldingPanelController(model, parent);
	} // end constructor
	
	// each array index is a individual holding object passed in from multiple
	// controllers
	public void updateGrid(Holding[] Gridholdings)
	{
		
		System.out.println("Updating Grid- HoldingGrid.java");
		// clear out previous drawn grid
		removeAll();
		
		// this if for cases where only 1 holding remaining and want to remove
		// it
		// if removed, the model will return null hence need to avoid
		if (Gridholdings != null)
		{
			// Determine the layout from number of holdings in array
			if (Gridholdings.length < 4)
				setLayout(new GridLayout(1, 0, 1, 1));
			else
				setLayout(new GridLayout(0, 4, 1, 1));
			
			// loop to add each panel and controller to each grid
			for (int i = 0; i < Gridholdings.length; i++)
			{
				System.out.println("Creating each individual panel"
						+ Gridholdings[i]);
				individualPanel = new HoldingPanel(parent, Gridholdings[i]);
				
				System.out
						.println("Adding Mouse Click Event for each panel aswell ");
				individualPanel.addMouseListener(holdPanelController);
				
				// create a scroll pane then add the panel to the scrollpane
				JScrollPane scrollpane = new JScrollPane(individualPanel);
				
				// adding the scroll pane to the grid
				this.add(scrollpane);
			} // end for loop
			
			// checks if greater than 4. first row is skipped
			if (Gridholdings.length > 4)
			{
				int remainder = Gridholdings.length % 4;
				int requiredPanels = 4 - remainder;
				
				// if statement to prevent cases of full row of blank panels
				// only really applicable on the >= 3rd
				if (requiredPanels != 4)
				{
					System.out
							.println("GridHoldings > 4, Required white panels : "
									+ requiredPanels);
					// add empty panel depending on number of required panels
					for (int i = 0; i < requiredPanels; i++)
					{
						System.out.println("Adding Blank JPanel");
						blankPanel = new JPanel();
						blankPanel.setBackground(Color.WHITE);
						blankPanel.setBorder(BorderFactory
								.createLineBorder(Color.black));
						this.add(blankPanel);
					}// end forloop
				}// end if
			}// end if
		} // end if
		else
		{
			
		}
	} // updateGrid
	
}
