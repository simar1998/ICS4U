package kalsi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Label;

public class realityShowApplication extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					realityShowApplication frame = new realityShowApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ArrayList<ContestantInformation> contestant = new ArrayList();

	}

	/**
	 * Create the frame.
	 */
	public realityShowApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TextField firstNameTextField = new TextField();
		firstNameTextField.setBounds(10, 50, 150, 22);
		contentPane.add(firstNameTextField);

		Label label = new Label("First Name");
		label.setBounds(166, 50, 62, 22);
		contentPane.add(label);

		TextField lastNameTextField = new TextField();
		lastNameTextField.setBounds(10, 78, 150, 22);
		contentPane.add(lastNameTextField);

		Label label_1 = new Label("Last Name");
		label_1.setBounds(166, 78, 62, 22);
		contentPane.add(label_1);

		TextField stretNumberTextField = new TextField();
		stretNumberTextField.setBounds(10, 106, 150, 22);
		contentPane.add(stretNumberTextField);

		Label label_2 = new Label("Street Number");
		label_2.setBounds(166, 106, 83, 22);
		contentPane.add(label_2);

		TextField streetNameTextField = new TextField();
		streetNameTextField.setBounds(10, 134, 150, 22);
		contentPane.add(streetNameTextField);

		Label label_3 = new Label("Street Name");
		label_3.setBounds(166, 134, 62, 22);
		contentPane.add(label_3);

		TextField cityTextField = new TextField();
		cityTextField.setBounds(10, 162, 150, 22);
		contentPane.add(cityTextField);

		Label label_4 = new Label("City");
		label_4.setBounds(166, 162, 62, 22);
		contentPane.add(label_4);

		TextField provinceTextField = new TextField();
		provinceTextField.setBounds(10, 190, 150, 22);
		contentPane.add(provinceTextField);

		Label label_5 = new Label("Province");
		label_5.setBounds(166, 190, 62, 22);
		contentPane.add(label_5);

		TextField phoneTextField = new TextField();
		phoneTextField.setBounds(10, 246, 150, 22);
		contentPane.add(phoneTextField);

		Label label_6 = new Label("Phone Number");
		label_6.setBounds(166, 246, 83, 22);
		contentPane.add(label_6);

		TextField postalCodeTextField = new TextField();
		postalCodeTextField.setBounds(10, 218, 150, 22);
		contentPane.add(postalCodeTextField);

		Label label_7 = new Label("Postal Code");
		label_7.setBounds(166, 218, 62, 22);
		contentPane.add(label_7);
		this.setTitle("Reality Show Application");
	}
}
