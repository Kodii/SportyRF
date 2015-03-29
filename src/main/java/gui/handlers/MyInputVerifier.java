package gui.handlers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyInputVerifier extends InputVerifier {

	public static final int NUMBER = 1;
	private int option;

	private JTextField textField;
	private boolean canProceed;

	private JComponent input;

	public MyInputVerifier(JTextField textField, int option) {
		this.textField = textField;
		this.option = option;
	}

	@Override
	public boolean verify(JComponent input) {
		this.input = input;
		if (option == NUMBER) {
			checkIsNumber();
		}
		return true;
	}

	private void checkIsNumber() {
		String regex = "[0-9]+";
		String text = ((JTextField) input).getText();
		if (text.matches(regex)) {
			System.out.println("jest Cyfra");
			Integer.parseInt(text);
			canProceed = true;

		} else {

			JOptionPane.showMessageDialog(new JFrame(),
					"NUMER STARTOWY MUSI BYÆ LICZB¥");
			textField.setText("");
			canProceed = false;
		}
	}

	public boolean isCanProceed() {
		return canProceed;
	}

	public void setCanProceed(boolean canProceed) {
		this.canProceed = canProceed;
	}

}
