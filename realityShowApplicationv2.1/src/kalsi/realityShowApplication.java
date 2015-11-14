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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextArea;

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
	
	String[] contestantString;
	static TextField[] inputField;
	public static final String fileName = "save.prop";
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
	 * @throws IOException 
	 */
	public realityShowApplication() throws IOException {		
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
		
		DefaultListModel<String> model = new DefaultListModel();
		JList contestantsList = new JList(model);
		contestantsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		contestantsList.setBounds(10, 37, 232, 318);
		//JScrollPane listScroller = new JScrollPane(contestantsList);
		panel.add(contestantsList);
		
		Button deleteItemButton = new Button("Delete selected item");
		deleteItemButton.setBounds(10, 10, 148, 22);
		panel.add(deleteItemButton);
		
		Button viewInfoButton = new Button("View Info");
		viewInfoButton.setBounds(164, 9, 78, 22);
		panel.add(viewInfoButton);
		
		JTextArea outputTextArea = new JTextArea();
		outputTextArea.setEditable(false);
		outputTextArea.setBounds(252, 37, 421, 318);
		panel.add(outputTextArea);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 385, 304, 106);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Button saveButton = new Button("Save");
		saveButton.setBounds(10, 10, 133, 50);
		panel_1.add(saveButton);
		
		Button loadButton = new Button("Load");
		loadButton.setBounds(168, 10, 126, 50);
		panel_1.add(loadButton);
		
		Button sortButton = new Button("Sort Button");
		sortButton.setBounds(10, 66, 284, 30);
		panel_1.add(sortButton);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(322, 383, 228, 108);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		TextField firstNameSearchTextField = new TextField();
		firstNameSearchTextField.setBounds(10, 10, 112, 22);
		panel_2.add(firstNameSearchTextField);
		
		Label label_10 = new Label("Search first name");
		label_10.setBounds(128, 10, 114, 22);
		panel_2.add(label_10);
		
		TextField lastNameSearchTextField = new TextField();
		lastNameSearchTextField.setBounds(10, 38, 112, 22);
		panel_2.add(lastNameSearchTextField);
		
		Label label_11 = new Label("Search last name");
		label_11.setBounds(128, 38, 104, 22);
		panel_2.add(label_11);
		
		Button button = new Button("Search");
		button.setBounds(10, 66, 209, 32);
		panel_2.add(button);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(556, 401, 449, 90);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JTextArea txtrIfYouDecide = new JTextArea();
		txtrIfYouDecide.setLineWrap(true);
		txtrIfYouDecide.setText("If you decide not to add a contestant mid way through the entering prcess you must add a contestant with fake information then delete itthorugh  the gui");
		txtrIfYouDecide.setEditable(false);
		txtrIfYouDecide.setBounds(10, 11, 429, 68);
		panel_3.add(txtrIfYouDecide);	
		
		Label label_13 = new Label("Information Pane");
		label_13.setBounds(727, 383, 102, 22);
		contentPane.add(label_13);
		this.setTitle("Reality Show Application");
		ContestantInformation contestant1 = new ContestantInformation();
		ArrayList<ContestantInformation> contestants = new ArrayList();
		Scanner scanner = new Scanner(System.in);
		String[] answers = new String[9];
		ArrayList<String> nameField = new ArrayList<String>();
		TextField[] inputField = { firstNameTextField, lastNameTextField, streetNameTextField, streetNumberTextField,
				cityTextField, provinceTextField, postalCodeTextField, poneNumberTextField, birthDateTextField };
		
		for(int i = 0; i < inputField.length;i++){
			inputField[i].setText("");
		}
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<inputField.length;i++){
					answers[i] = inputField[i].getText().toString();
				}
				
			   try {
				   contestantString = new String[contestants.size()];
				   contestants.add(contestant1);
				storeValues(contestants.get(contestants.size()-1) , answers);
			} catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   nameField.add(answers[0]+" "+answers[1]);
			   model.addElement(nameField.get(nameField.size()-1));				
			   contestantsList.setModel(model);
			   clearTextField(inputField);
			}
		});
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> namesList = new ArrayList<String>(model.size());
				for(int  i= 0; i< model.size();i++){
					namesList.add(model.get(i));
				}
				Collections.sort(namesList);
				Collections.sort(contestants);
				model.removeAllElements();
				for(int i = 0;i< namesList.size();i++){
					model.addElement(namesList.get(i));
				}
			}
		});
		deleteItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedIndex = contestantsList.getSelectedIndex();
				 if(selectedIndex !=-1){
					 contestants.remove(selectedIndex);
					 model.remove(selectedIndex);
				 }
			}
		});
		viewInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = contestantsList.getSelectedIndex();
				 if(selectedIndex !=-1){
					LabelClass label = new LabelClass(contestants.get(selectedIndex));
					outputTextArea.setText("");
					outputTextArea.setText(label.toString());
				 }
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstNameSearch = firstNameSearchTextField.getText().toString();
				String lastNameSearch = lastNameSearchTextField.getText().toString();
				if(search.linearSearch(contestants , firstNameSearch , lastNameSearch) != -1){
					int searchIndex = search.linearSearch(contestants , firstNameSearch , lastNameSearch);
					LabelClass label = new LabelClass(contestants.get(searchIndex));
					outputTextArea.setText("");
					outputTextArea.setText(label.toString());
				}
				else{
					JOptionPane.showMessageDialog(null, "Contestant does not exist");
					firstNameSearchTextField.setText("");
					lastNameSearchTextField.setText("");
				}
			}
		});
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream fileOutputStream = null;
				try {
					fileOutputStream = new FileOutputStream(fileName);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintStream fps = new PrintStream(fileOutputStream);
				fps.println(contestants.size());
				for (int j = 0; j < contestants.size(); j++) {
					fps.println(contestants.get(j).getFirstName());
					fps.println(contestants.get(j).getLastName());
					fps.println(contestants.get(j).getStreetNumber());
					fps.println(contestants.get(j).getStreetName());
					fps.println(contestants.get(j).getCity());
					fps.println(contestants.get(j).getProvince());
					fps.println(contestants.get(j).getPostalCode());
					fps.println(contestants.get(j).getPhoneNum());
				}
				JOptionPane.showMessageDialog(null, "List Saved");
			}
		});
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(fileName));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int contestantNumbers = 0;
				try {
					contestantNumbers = Integer.parseInt(bufferedReader.readLine());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (int k = 0; k < contestantNumbers; k++) {
					contestants.add(new ContestantInformation());
					String firstNameFromSave = null ;
					String lastNameFromSave = null;
					String streetNumberFromSave = null;
					String streetAdressFromSave = null;
					String cityFromSave= null;
					String porvinceFromSave= null;
					String postalCodeFromSave= null;
					String phoneNumberFromSave= null;
					try {
						firstNameFromSave = bufferedReader.readLine();
						lastNameFromSave = bufferedReader.readLine();
						streetNumberFromSave = bufferedReader.readLine();
						streetAdressFromSave = bufferedReader.readLine();
						cityFromSave = bufferedReader.readLine();
						porvinceFromSave = bufferedReader.readLine();
						postalCodeFromSave = bufferedReader.readLine();
						phoneNumberFromSave = bufferedReader.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						contestants.get(k).setFirstName(firstNameFromSave);
						contestants.get(k).setLastName(lastNameFromSave);
						contestants.get(k).setStreetNumber(streetNumberFromSave);
						contestants.get(k).setStreetName(streetAdressFromSave);
						contestants.get(k).setCity(cityFromSave);
						contestants.get(k).setProvince(porvinceFromSave);
						contestants.get(k).setPostalCode(postalCodeFromSave);
						contestants.get(k).setPhoneNum(phoneNumberFromSave);
					} catch (InvalidInputExeption e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}	
		}});

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
						answersArray[i] = JOptionPane.showInputDialog(null, e.getCause().getMessage());
						if(answersArray[i].equals(JOptionPane.CANCEL_OPTION)){
							clearTextField(inputField);
							System.exit(0);
						}
					}
				}
			} while (flag);
		}
	}

	public static void pl(String s) {
		System.out.println(s);
	}
	public static void clearTextField(TextField[] txtField){
		for(int i = 0; i < txtField.length;i++){
			txtField[i].setText("");
		}
	}
}
