package View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import lms.model.facade.LMSModel;
import Controller.ActionListenerAddHolding;
import Controller.ActionListenerRemoveHolding;
import Controller.InitialiseLibraryController;

public class MenuBar extends JMenuBar
{
	private ApplicationFrame parent;
	
	public MenuBar(LMSModel model, ApplicationFrame frame)
	{
		parent = frame;
		
		// creating topics/menu
		JMenu library = new JMenu("Library");
		JMenu holding = new JMenu("Holding");
		// JMenu videoHolding = new JMenu("Video Holding");
		JMenu help = new JMenu("Help");
		
		add(library);
		add(holding);
		// add(videoHolding);
		add(help);
		
		// Create and add simple menu item to one of the drop down menu
		JMenuItem initialise = new JMenuItem(
				"Initialise/Create Library Collection");
		// add listener to the intilise in the context menu
		initialise.addActionListener(new InitialiseLibraryController(model,
				parent));
		
		JMenuItem add = new JMenuItem("Add Holding");
		add.addActionListener(new ActionListenerAddHolding(model, parent));
		
		JMenuItem remove = new JMenuItem("Remove Holding");
		remove.addActionListener(new ActionListenerRemoveHolding(model, parent));
		
		// add context to each heading
		library.add(initialise);
		holding.add(add);
		holding.add(remove);
		
	}
	
}
