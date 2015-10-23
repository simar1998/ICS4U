package kalsi;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import kalsi.ContestantInformation;
import kalsi.InvalidInputExeption;
import kalsi.LabelClass;
import javax.swing.JSplitPane;
import java.awt.TextField;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class realityShowApplication extends JFrame {

	private JPanel contentPane;
	private TextField cityTextField;

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
	}

	/**
	 * Create the frame.
	 */
	public realityShowApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TextField firstNameTextField = new TextField();
		firstNameTextField.setBounds(10, 64, 181, 22);
		contentPane.add(firstNameTextField);

		Label label = new Label("First Name");
		label.setBounds(197, 64, 94, 22);
		contentPane.add(label);

		TextField lastNameTextField = new TextField();
		lastNameTextField.setBounds(10, 92, 181, 22);
		contentPane.add(lastNameTextField);

		Label label_1 = new Label("Last Name");
		label_1.setBounds(197, 92, 94, 22);
		contentPane.add(label_1);

		TextField streetNameTextField = new TextField();
		streetNameTextField.setBounds(10, 120, 181, 22);
		contentPane.add(streetNameTextField);

		Label label_2 = new Label("Street Name");
		label_2.setBounds(197, 120, 94, 22);
		contentPane.add(label_2);

		TextField streetNumberTextField = new TextField();
		streetNumberTextField.setBounds(10, 148, 181, 22);
		contentPane.add(streetNumberTextField);

		Label label_3 = new Label("Street Number");
		label_3.setBounds(197, 148, 94, 22);
		contentPane.add(label_3);

		cityTextField = new TextField();
		cityTextField.setBounds(10, 176, 181, 22);
		contentPane.add(cityTextField);

		Label label_4 = new Label("City");
		label_4.setBounds(197, 176, 62, 22);
		contentPane.add(label_4);

		TextField provinceTextField = new TextField();
		provinceTextField.setBounds(10, 204, 181, 22);
		contentPane.add(provinceTextField);

		Label label_5 = new Label("Province");
		label_5.setBounds(197, 204, 78, 22);
		contentPane.add(label_5);

		TextField postalCodeTextField = new TextField();
		postalCodeTextField.setBounds(10, 232, 181, 22);
		contentPane.add(postalCodeTextField);

		Label label_6 = new Label("Postal Code");
		label_6.setBounds(197, 232, 94, 22);
		contentPane.add(label_6);

		TextField poneNumberTextField = new TextField();
		poneNumberTextField.setBounds(10, 260, 181, 22);
		contentPane.add(poneNumberTextField);

		Label label_7 = new Label("Phone Number");
		label_7.setBounds(197, 260, 111, 22);
		contentPane.add(label_7);

		TextField birthDateTextField = new TextField();
		birthDateTextField.setBounds(10, 288, 181, 22);
		contentPane.add(birthDateTextField);

		Label label_8 = new Label("Birth Date(yyyy/mm/dd)");
		label_8.setBounds(197, 288, 135, 22);
		contentPane.add(label_8);

		Button submitButton = new Button("Submit");
		submitButton.setBackground(Color.LIGHT_GRAY);
		submitButton.setBounds(10, 331, 181, 22);
		contentPane.add(submitButton);

		Label label_9 = new Label("Please enter the fields below then press submit");
		label_9.setBounds(10, 10, 304, 48);
		contentPane.add(label_9);

		JPanel panel = new JPanel();
		panel.setBounds(322, 11, 683, 366);
		contentPane.add(panel);
		panel.setLayout(null);

		JList contestantsList = new JList();
		contestantsList.setBounds(10, 66, 232, 289);
		panel.add(contestantsList);

		TextField searchFirstNameTextField = new TextField();
		searchFirstNameTextField.setBounds(10, 10, 112, 22);
		panel.add(searchFirstNameTextField);

		Label label_10 = new Label("Search first name");
		label_10.setBounds(128, 10, 114, 22);
		panel.add(label_10);

		TextField searchLastNameTextField = new TextField();
		searchLastNameTextField.setBounds(10, 38, 112, 22);
		panel.add(searchLastNameTextField);

		Label label_11 = new Label("Search last name");
		label_11.setBounds(128, 38, 104, 22);
		panel.add(label_11);
		
		Button submitSearchButton = new Button("Search");
		submitSearchButton.setBounds(248, 10, 70, 22);
		panel.add(submitSearchButton);
		this.setTitle("Reality Show Application");
		
		Scanner scanner = new Scanner(System.in);
		TextField[] textField = {firstNameTextField,lastNameTextField,streetNameTextField,streetNumberTextField,cityTextField,
				provinceTextField,postalCodeTextField,poneNumberTextField,birthDateTextField};
		String[] methods = { "setFirstName", "setLastName", "setStreetName", "setStreetNumber", "setCity",
				"setProvince", "setPostalCode", "setPhoneNum", "setBirthDate" };
		ArrayList<ContestantInformation> contestants = new ArrayList();
		ContestantInformation contestantInformation = new ContestantInformation();
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contestants.add(contestantInformation);
				Class<?> classContestantInfo = null;
				try {
					classContestantInfo = Class.forName("kalsi.ContestantInformation");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Class<String> stringParameter = String.class;
				Class<Integer> integerParameter = Integer.class;
				boolean flag = true;
				for (int i = 0; i < methods.length; i++) {
					flag = true;
					do {
						try {
							String inputTextField = scanner.nextLine();
							inputTextField = textField[i].getName().toString();
							Object invoke = classContestantInfo.getDeclaredMethod(methods[i], stringParameter).invoke(contestants.get(i), inputTextField);
							flag = false;
						} catch (InvocationTargetException e) {
							if (e.getCause() instanceof InvalidInputExeption) {
								JOptionPane.showMessageDialog(getContentPane(), e.getCause().getMessage());
							}
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} while (flag);
				}
			}
		});

	}

	public static void storeValues(ContestantInformation ci) throws IllegalAccessException, IllegalArgumentException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		
		String[] questions = { "What is your first name", "What is your last name", "What is your Street Name",
				"What is your Sreet Number", "What city do you live in", "What province are you in",
				"What is your postal code", "What is your phone no.", "What is your birth date yyyy/mm/dd" };
		String[] methods = { "setFirstName", "setLastName", "setStreetName", "setStreetNumber", "setCity",
				"setProvince", "setPostalCode", "setPhoneNum", "setBirthDate" };

		Class<?> classContestantInfo = Class.forName("kalsi.ContestantInformation");
		Class<String> stringParameter = String.class;
		Class<Integer> integerParameter = Integer.class;
		boolean flag = true;
		for (int i = 0; i < methods.length; i++) {
			flag = true;
			do {
				try {
					System.out.println(questions[i]);
					String scannerInput = scanner.nextLine();
					classContestantInfo.getDeclaredMethod(methods[i], stringParameter).invoke(ci, scannerInput);
					flag = false;
					if (scannerInput.equals("exit this")) {
						pl("Thank you for using reality show application form");
						return;
					}
				} catch (InvocationTargetException e) {
					if (e.getCause() instanceof InvalidInputExeption) {
						System.out.println(e.getCause().getMessage());
					}
				}
			} while (flag);
		}
	}
	public static void pl(String s) {
		System.out.println(s);
	}
}
