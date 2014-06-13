package View;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import lms.model.facade.LMSModel;
import Controller.AddHoldingController;
import Controller.RadioButtonListener;

public class AddHoldingPopup extends JDialog
{	
	private JPanel radioPanel;
	private JComboBox LoanFeeBox;
	private JTextField holdingIDField;
	private JTextField holdingNameField;
	private JRadioButton bookButton;
	private JRadioButton videoButton;
	
	private JLabel videoFeeLabel;
	
	// constructor
	public AddHoldingPopup(LMSModel model, ApplicationFrame frame)
	{
		System.out.println("Inside AddHoldingPopup.java");
		this.setLayout(new GridLayout(0, 1));
		
		JLabel holdingIDLabel = new JLabel("Holding ID");
		holdingIDField = new JTextField(20);
		
		JLabel holdingNameLabel = new JLabel("Holding Title");
		holdingNameField = new JTextField(20);
		
		JLabel holdingTypeLabel = new JLabel("Holding Type");
		bookButton = new JRadioButton("Book");
		videoButton = new JRadioButton("Video");
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(bookButton);
		radioButtonGroup.add(videoButton);
		
		add(holdingIDLabel);
		add(holdingIDField);
		// add the Holding name label and textfield to
		add(holdingNameLabel);
		add(holdingNameField);
		
		add(holdingTypeLabel);
		bookButton.addActionListener(new RadioButtonListener(this));
		videoButton.addActionListener(new RadioButtonListener(this));
		
		radioPanel = new JPanel();
		radioPanel.add(bookButton);
		radioPanel.add(videoButton);
		add(radioPanel);
		bookButton.setSelected(true);
		
		// combo box
		String loanFee[] = { "4", "6" };
		
		videoFeeLabel = new JLabel("Video Fee");
		videoFeeLabel.setVisible(false);
		LoanFeeBox = new JComboBox(loanFee);
		LoanFeeBox.setVisible(false);

		
		add(videoFeeLabel);
		add(LoanFeeBox);
		
		JButton submit = new JButton("Submit");
		// need to pass the this popup ref inorder for the controller to
		// retreieve data from this popup dialog window
		submit.addActionListener(new AddHoldingController(this, model, frame));
		
		add(submit);
		this.setVisible(true); // required for panel/frame
		this.pack();
	} // end constructor
	
	public JComboBox getLoanFeeBox()
	{
		return LoanFeeBox;
	}
	
	// accessor used by RadioButtonListener to get value of radio button (book)
	public JRadioButton getbookButton()
	{
		return bookButton;
	}
	
	// accessor used by RadioButtonListener to get value of radio button (video)
	public JRadioButton getvideoButton()
	{
		return videoButton;
	}
	
	public String getVideoFee()
	{
		return LoanFeeBox.getSelectedItem().toString();
	}
	
	public String getHoldingID()
	{
		
		return holdingIDField.getText();
	}
	
	public String getHoldingTitle()
	{
		return holdingNameField.getText();
	}
	
	// sets the combo to visible or not depending on the radio button listener
	public void setVisibleComboBox(boolean value)
	{
		LoanFeeBox.setVisible(value);
		videoFeeLabel.setVisible(value);
		// repaint();
	} // end comboBox
}
