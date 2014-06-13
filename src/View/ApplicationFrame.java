package View;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import lms.model.Holding;
import lms.model.facade.LMSFacade;
import lms.model.facade.LMSModel;
import Controller.CloseWindowListener;

public class ApplicationFrame extends JFrame
{
	private ApplicationFrame frame;
	private MenuBar menuBarContainer;
	private StatusBar statusBarContainer;
	private MenuToolBar menuToolbarContainer;
	private HoldingGrid holdingGridContainer;
	private Container c;
	
	// constructor
	public ApplicationFrame(LMSModel model)
	{
		super("Joshua Yu 323 5184 - LMS 2012");
		c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		menuBarContainer = new MenuBar(model, this);
		
		// Add the menubar to the frame
		setJMenuBar(menuBarContainer);
		
		statusBarContainer = new StatusBar();
		c.add(statusBarContainer, BorderLayout.SOUTH);
		
		menuToolbarContainer = new MenuToolBar(model, this);
		c.add(menuToolbarContainer, BorderLayout.NORTH);
		
		holdingGridContainer = new HoldingGrid(model, this);
		c.add(holdingGridContainer, BorderLayout.CENTER);
		
		addWindowListener(new CloseWindowListener(this));
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

	} // end ApplicationFrame constructor
	
	// chaining, pass the collectiontoString rep and the total holings to the
	// status bar which processes it (string)
	
	public void updateStatusBar(String collectionToString, Holding[] holdings)
	{
		statusBarContainer.updateMessage(collectionToString, holdings);
	}
	
	// method used by the AddHoldingController, RemoveHoldingController,
	// HoldingGrid to
	// update the HoldingGrid when a holding is added or remove collection
	public void updateHoldingGrid(Holding[] Gridholdings)
	{
		holdingGridContainer.updateGrid(Gridholdings);

	}
	
	public static void main(String[] args)
	{
		// new instance of model;
		LMSModel model = new LMSFacade();
		ApplicationFrame frame = new ApplicationFrame(model);
		
		frame.setVisible(true);
		frame.setSize(600, 800);
		frame.setLocation(100, 100);
	}
}