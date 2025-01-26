package New_JavaCode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
}

public class PhoneDirectory {
    private JFrame frame;
    private ArrayList<Contact> contacts;

    public PhoneDirectory() {
        contacts = new ArrayList<>();
        createMainFrame();
    }

    private void createMainFrame() {
        frame = new JFrame("Phone Directory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Contact");
        JButton viewButton = new JButton("View Contacts");

        // Add Listeners to Buttons
        addButton.addActionListener(e -> openAddContactFrame());
        viewButton.addActionListener(e -> openViewContactsFrame());

        frame.add(addButton);
        frame.add(viewButton);

        frame.setVisible(true);
    }

    private void openAddContactFrame() {
        JFrame addFrame = new JFrame("Add Contact");
        addFrame.setSize(300, 250);
        addFrame.setLayout(new GridLayout(5, 2));

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JButton saveButton = new JButton("Save Contact");

        saveButton.addActionListener(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String phoneNumber = phoneField.getText();
            String email = emailField.getText();

            if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(addFrame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                contacts.add(new Contact(firstName, lastName, phoneNumber, email));
                JOptionPane.showMessageDialog(addFrame, "Contact saved successfully!");
                addFrame.dispose();
            }
        });

        addFrame.add(firstNameLabel);
        addFrame.add(firstNameField);
        addFrame.add(lastNameLabel);
        addFrame.add(lastNameField);
        addFrame.add(phoneLabel);
        addFrame.add(phoneField);
        addFrame.add(emailLabel);
        addFrame.add(emailField);
        addFrame.add(saveButton);

        addFrame.setVisible(true);
    }

    private void openViewContactsFrame() {
        JFrame viewFrame = new JFrame("View Contacts");
        viewFrame.setSize(600, 400);

        String[] columns = {"First Name", "Last Name", "Phone Number", "Email"};
        String[][] data = new String[contacts.size()][4];

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            data[i][0] = contact.getFirstName();
            data[i][1] = contact.getLastName();
            data[i][2] = contact.getPhoneNumber();
            data[i][3] = contact.getEmail();
        }

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton updateButton = new JButton("Update Contact");
        JButton deleteButton = new JButton("Delete Contact");

        // Update Contact Logic
        updateButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(viewFrame, "Please select a contact to update!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Contact contact = contacts.get(selectedRow);
            openUpdateContactFrame(contact, selectedRow, table);
        });

        // Delete Contact Logic
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(viewFrame, "Please select a contact to delete!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            contacts.remove(selectedRow);
            JOptionPane.showMessageDialog(viewFrame, "Contact deleted successfully!");
            viewFrame.dispose();
            openViewContactsFrame(); // Refresh the table
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        viewFrame.add(scrollPane, BorderLayout.CENTER);
        viewFrame.add(buttonPanel, BorderLayout.SOUTH);

        viewFrame.setLayout(new BorderLayout());
        viewFrame.setVisible(true);
    }

    private void openUpdateContactFrame(Contact contact, int index, JTable table) {
        JFrame updateFrame = new JFrame("Update Contact");
        updateFrame.setSize(300, 250);
        updateFrame.setLayout(new GridLayout(5, 2));

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(contact.getFirstName());

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(contact.getLastName());

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField(contact.getPhoneNumber());

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(contact.getEmail());

        JButton saveButton = new JButton("Update Contact");

        saveButton.addActionListener(e -> {
            contact.setFirstName(firstNameField.getText());
            contact.setLastName(lastNameField.getText());
            contact.setPhoneNumber(phoneField.getText());
            contact.setEmail(emailField.getText());

            JOptionPane.showMessageDialog(updateFrame, "Contact updated successfully!");
            updateFrame.dispose();
        });

        updateFrame.add(firstNameLabel);
        updateFrame.add(firstNameField);
        updateFrame.add(lastNameLabel);
        updateFrame.add(lastNameField);
        updateFrame.add(phoneLabel);
        updateFrame.add(phoneField);
        updateFrame.add(emailLabel);
        updateFrame.add(emailField);
        updateFrame.add(saveButton);

        updateFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new PhoneDirectory();
    }
}
