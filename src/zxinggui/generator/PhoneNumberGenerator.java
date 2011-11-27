package zxinggui.generator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PhoneNumberGenerator implements GeneratorInterface {
	private JPanel panel = new JPanel();
	private JTextField txtPhoneNumber = new JTextField();
	
	public PhoneNumberGenerator() {
		
		SpringLayout layout = new SpringLayout();
		JLabel label = new JLabel("Phone Number: ");
		
		panel.setLayout(layout);
		panel.add(label);
		panel.add(txtPhoneNumber);
		
		layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, panel);
		
		layout.putConstraint(SpringLayout.WEST, txtPhoneNumber, 5, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, txtPhoneNumber, 5, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.EAST, panel, 5, SpringLayout.EAST, txtPhoneNumber);
	}

	public String getName() {
		return "Phone Number";
	}

	public JPanel getPanel() {
		return panel;
	}

	public String getText() throws GeneratorException {
		String number = txtPhoneNumber.getText();
		if (number.isEmpty())
			throw new GeneratorException("Phone number cannot be empty.", txtPhoneNumber);
		if (!Validator.isValidPhoneNumber(number))
			throw new GeneratorException("Incorrect phone number.", txtPhoneNumber);
		
		return "tel:" + number;
	}

	public void setFocus() {
		txtPhoneNumber.requestFocusInWindow();
	}

}
