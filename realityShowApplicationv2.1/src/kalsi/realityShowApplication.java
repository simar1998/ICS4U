package kalsi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import java.awt.Panel;

public class realityShowApplication extends JFrame {

	private JPanel contentPane;
	private TextField cityTextField;
	private TextField firstNameTextField;
	private TextField lastNameTextField;
	private TextField streetNameTextField;
	private TextField streetNumberTextField;
	private TextField provinceTextField;
	private TextField postalCodeTextField;
	private TextField poneNumberTextField;
	private TextField birthDateTextField;

	String firstName = "";
	String lastName = "";
	String streetName = "";
	String streetNumber = "";
	String city = "";
	String province = "";
	String postalCode = "";
	String phoneNumber = "";
	String birthDate = "";
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
		setBounds(100, 100, 1050, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	    firstNameTextField = new TextField();
		firstNameTextField.setBounds(10, 64, 181, 22);
		contentPane.add(firstNameTextField);

		Label label = new Label("First Name");
		label.setBounds(197, 64, 94, 22);
		contentPane.add(label);

	    lastNameTextField = new TextField();
		lastNameTextField.setBounds(10, 92, 181, 22);
		contentPane.add(lastNameTextField);

		Label label_1 = new Label("Last Name");
		label_1.setBounds(197, 92, 94, 22);
		contentPane.add(label_1);

		streetNameTextField = new TextField();
		streetNameTextField.setBounds(10, 120, 181, 22);
		contentPane.add(streetNameTextField);

		Label label_2 = new Label("Street Name");
		label_2.setBounds(197, 120, 94, 22);
		contentPane.add(label_2);

		streetNumberTextField = new TextField();
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

		provinceTextField = new TextField();
		provinceTextField.setBounds(10, 204, 181, 22);
		contentPane.add(provinceTextField);

		Label label_5 = new Label("Province");
		label_5.setBounds(197, 204, 78, 22);
		contentPane.add(label_5);

		postalCodeTextField = new TextField();
		postalCodeTextField.setBounds(10, 232, 181, 22);
		contentPane.add(postalCodeTextField);

		Label label_6 = new Label("Postal Code");
		label_6.setBounds(197, 232, 94, 22);
		contentPane.add(label_6);

		poneNumberTextField = new TextField();
		poneNumberTextField.setBounds(10, 260, 181, 22);
		contentPane.add(poneNumberTextField);

		Label label_7 = new Label("Phone Number");
		label_7.setBounds(197, 260, 111, 22);
		contentPane.add(label_7);

		birthDateTextField = new TextField();
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
		contestantsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		contestantsList.setBounds(10, 11, 232, 344);
		JScrollPane listScroller = new JScrollPane(contestantsList);
		panel.add(contestantsList);
		
		Label InformationOutputLabel = new Label("");
		InformationOutputLabel.setBounds(248, 10, 425, 346);
		panel.add(InformationOutputLabel);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 385, 304, 106);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		TextField standardSaveLocation = new TextField();
		standardSaveLocation.setBounds(10, 10, 172, 22);
		panel_1.add(standardSaveLocation);
		
		Label label_12 = new Label("Save Location");
		label_12.setBounds(188, 10, 92, 22);
		panel_1.add(label_12);
		
		Button saveButton = new Button("Save");
		saveButton.setBounds(10, 38, 80, 22);
		panel_1.add(saveButton);
		
		Button loadButton = new Button("Load");
		loadButton.setBounds(96, 38, 86, 22);
		panel_1.add(loadButton);
		
		Button sortButton = new Button("Sort Button");
		sortButton.setBounds(10, 66, 172, 30);
		panel_1.add(sortButton);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(322, 383, 228, 108);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(10, 10, 112, 22);
		panel_2.add(textField);
		
		Label label_10 = new Label("Search first name");
		label_10.setBounds(128, 10, 114, 22);
		panel_2.add(label_10);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(10, 38, 112, 22);
		panel_2.add(textField_1);
		
		Label label_11 = new Label("Search last name");
		label_11.setBounds(128, 38, 104, 22);
		panel_2.add(label_11);
		
		Button button = new Button("Search");
		button.setBounds(10, 66, 209, 32);
		panel_2.add(button);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(556, 401, 449, 90);
		contentPane.add(panel_3);
		
		Label label_13 = new Label("Advanced Search");
		label_13.setBounds(727, 383, 102, 22);
		contentPane.add(label_13);
		this.setTitle("Reality Show Application");
		ContestantInformation contestant1 = new ContestantInformation();
		ArrayList<ContestantInformation> contestants = new ArrayList();
		Scanner scanner = new Scanner(System.in);
		String[] answers = new String[9];
		TextField[] inputField = { firstNameTextField, lastNameTextField, streetNameTextField, streetNumberTextField,
				cityTextField, provinceTextField, postalCodeTextField, poneNumberTextField, birthDateTextField };
		
		for(int i = 0; i < inputField.length;i++){
			inputField[i].setText("");
		}
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				answers[0] = firstNameTextField.getText().toString();
				answers[1] = lastNameTextField.getText().toString();
				answers[2] = streetNameTextField.getText().toString();
				answers[3] = streetNumberTextField.getText().toString();
				answers[4] = cityTextField.getText().toString();
				answers[5] = provinceTextField.getText().toString();
				answers[6] = postalCodeTextField.getText().toString();
				answers[7] = poneNumberTextField.getText().toString();
				answers[8] = birthDateTextField.getText().toString();
				
			   try {
				   contestants.add(contestant1);
				storeValues(contestants.get(contestants.size()-1) , answers);
			} catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});

	}

	public static void storeValues(ContestantInformation ci, String[] answersArray) throws IllegalAccessException,
			IllegalArgumentException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);

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
					classContestantInfo.getDeclaredMethod(methods[i], stringParameter).invoke(ci, answersArray[i]);
					flag = false;
				} catch (InvocationTargetException e) {
					if (e.getCause() instanceof InvalidInputExeption) {
						JOptionPane.showMessageDialog(null, e.getCause().getMessage());
					}
				}
			} while (flag);
		}
	}

	public static void pl(String s) {
		System.out.println(s);
	}

	public static void updateList(JList list, ArrayList<ContestantInformation> contestants){
		String[] contestantString = new String[contestants.size()];
		for(int i = 0; i < contestants.size();i++){
			
		}
	}
}
