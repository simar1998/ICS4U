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
import java.awt.Button;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class realityShowApplication extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	ArrayList<ContestantInformation> contestant = new ArrayList<ContestantInformation>();
	String contestantObject = "";
	ContestantInformation contestant1 = new ContestantInformation();
	ContestantInformation contestant2 = new ContestantInformation();
	
	
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

		TextField streetNumberTextField = new TextField();
		streetNumberTextField.setBounds(10, 106, 150, 22);
		contentPane.add(streetNumberTextField);

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
		
		TextField birthDateTextField = new TextField();
		birthDateTextField.setBounds(10, 274, 150, 22);
		contentPane.add(birthDateTextField);
		
		Label label_8 = new Label("Birth Date (DD/MM/YYY)");
		label_8.setBounds(166, 274, 132, 22);
		contentPane.add(label_8);
		
		Label label_9 = new Label("-----------------------------------------------------------------OUTPUT------------------------------------------------------------------------------");
		label_9.setBounds(10, 302, 564, 22);
		contentPane.add(label_9);
		
		Button submitButton = new Button("Submit");
		submitButton.setBounds(504, 274, 70, 22);
		contentPane.add(submitButton);
		
		Label informationLabel = new Label("Information will be displayed here");
		informationLabel.setBounds(10, 10, 414, 22);
		contentPane.add(informationLabel);
		
		Label outputLabel = new Label("");
		outputLabel.setForeground(SystemColor.controlText);
		outputLabel.setBackground(SystemColor.info);
		outputLabel.setBounds(10, 330, 564, 147);
		contentPane.add(outputLabel);
		
		TextField debugTextEdit = new TextField();
		debugTextEdit.setBounds(430, 10, 144, 22);
		contentPane.add(debugTextEdit);
		
		Button debugSubmit = new Button("DEBUG");
		debugSubmit.setBounds(430, 38, 144, 22);
		contentPane.add(debugSubmit);
		this.setTitle("Reality Show Application");
		
		
		TextField[] textFieldArray = {firstNameTextField, lastNameTextField,streetNumberTextField,streetNameTextField, provinceTextField,
				postalCodeTextField , cityTextField};
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contestant1.setFirstName(firstNameTextField.getText().toString());
				contestant1.setLastName(lastNameTextField.getText().toString());
				contestant1.setStreetNumber(streetNumberTextField.getText().toString());
				contestant1.setStreetName(streetNameTextField.getText().toString());
				contestant1.setCity(cityTextField.getText().toString());
				contestant1.setProvince(provinceTextField.getText().toString());
				try {
					contestant1.setPostalCode(postalCodeTextField.getText().toString());
				} catch (InvalidInputExeption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	
	}
}
