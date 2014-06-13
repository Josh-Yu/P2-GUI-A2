package View;

import javax.swing.JButton;
import javax.swing.JToolBar;

import lms.model.facade.LMSModel;
import Controller.ActionListenerAddHolding;
import Controller.ActionListenerRemoveHolding;
import Controller.InitialiseLibraryController;

public class MenuToolBar extends JToolBar
{
	private JButton addHolding;
	private JButton removeHolding;
	
	private JButton addLibrary;

	
	public MenuToolBar(LMSModel model, ApplicationFrame frame)
	{
		addLibrary = new JButton("Create/Reset Library");
		addLibrary.addActionListener(new InitialiseLibraryController(model, frame));
		addHolding = new JButton("Add Holding");
		addHolding.addActionListener(new ActionListenerAddHolding(model, frame));
		removeHolding = new JButton("Remove Holding");
		removeHolding.addActionListener(new ActionListenerRemoveHolding(model, frame));
	
		add(addLibrary);
		add(addHolding);
		add(removeHolding);
	}
}
