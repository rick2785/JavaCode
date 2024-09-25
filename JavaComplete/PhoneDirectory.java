import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class PhoneDirectory extends JFrame implements ActionListener {

  
	// HashMap to store contacts
    HashMap<String, Contact> contacts = new HashMap<>();
    
    // GUI components
    JTextField firstNameField, lastNameField, emailField, phoneNumberField, jobNameField, searchField;
    JTextArea displayArea;
    JButton addButton, deleteButton, updateButton, searchButton, showAllButton;
    
    // Constructor to initialize the GUI
    public PhoneDirectory() {
        setTitle("Phone Directory");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));
        
        // Input fields
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        emailField = new JTextField(15);
        phoneNumberField = new JTextField(15);
        jobNameField = new JTextField(15);
        searchField = new JTextField(15);
        
        // Buttons
        addButton = new JButton("Add Contact");
        deleteButton = new JButton("Delete Contact");
        updateButton = new JButton("Update Contact");
        searchButton = new JButton("Search Contact");
        showAllButton = new JButton("Show All Contacts");
        
        // Display area
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        
        // Panel for input fields and labels
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2));
        inputPanel.add(new JLabel("First Name:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("Job Name:"));
        inputPanel.add(jobNameField);
        
        // Panel for search field
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search by Phone/Name:"));
        searchPanel.add(searchField);
        
        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(showAllButton);
        
        // Add action listeners to buttons
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        searchButton.addActionListener(this);
        showAllButton.addActionListener(this);
        
        // Add components to the frame
        add(inputPanel);
        add(searchPanel);
        add(buttonPanel);
        add(new JScrollPane(displayArea));
        
        setVisible(true);
    }
    
    // Inner class to define a Contact
    class Contact {
        String firstName, lastName, email, phoneNumber, jobName;
        
        Contact(String firstName, String lastName, String email, String phoneNumber, String jobName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.jobName = jobName;
        }
        
        @Override
        public String toString() {
            return firstName + " " + lastName + " - " + email + " - " + phoneNumber + " - " + jobName;
        }
    }
    
    // Method to handle button actions
    public void actionPerformed(ActionEvent e) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String jobName = jobNameField.getText();
        
        if (e.getSource() == addButton) {
            // Add contact
            if (!phoneNumber.isEmpty()) {
                contacts.put(phoneNumber, new Contact(firstName, lastName, email, phoneNumber, jobName));
                displayArea.setText("Contact added: " + phoneNumber);
            } else {
                displayArea.setText("Phone number is required to add contact.");
            }
        } else if (e.getSource() == deleteButton) {
            // Delete contact
            if (!phoneNumber.isEmpty()) {
                contacts.remove(phoneNumber);
                displayArea.setText("Contact deleted: " + phoneNumber);
            } else {
                displayArea.setText("Enter phone number to delete contact.");
            }
        } else if (e.getSource() == updateButton) {
            // Update contact
            if (!phoneNumber.isEmpty() && contacts.containsKey(phoneNumber)) {
                contacts.put(phoneNumber, new Contact(firstName, lastName, email, phoneNumber, jobName));
                displayArea.setText("Contact updated: " + phoneNumber);
            } else {
                displayArea.setText("Contact not found.");
            }
        } else if (e.getSource() == searchButton) {
            // Search contact
            String searchKey = searchField.getText();
            if (contacts.containsKey(searchKey)) {
                displayArea.setText(contacts.get(searchKey).toString());
            } else {
                displayArea.setText("Contact not found.");
            }
        } else if (e.getSource() == showAllButton) {
            // Show all contacts
            StringBuilder allContacts = new StringBuilder();
            for (Contact contact : contacts.values()) {
                allContacts.append(contact.toString()).append("\n");
            }
            displayArea.setText(allContacts.toString());
        }
    }
    
    public static void main(String[] args) {
        new PhoneDirectory();
    }
}
