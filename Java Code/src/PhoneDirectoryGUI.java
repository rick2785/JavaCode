import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

public class PhoneDirectoryGUI {

    static class Contact {
        String firstName, lastName, email, phone, job;

        Contact(String f, String l, String e, String p, String j) {
            firstName = f;
            lastName = l;
            email = e;
            phone = p;
            job = j;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + ", " + email + ", " + phone + ", " + job;
        }
    }

    static List<Contact> contacts = new ArrayList<>();
    static JTextArea outputArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Phone Directory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 5, 5));

        JTextField tfFirst = new JTextField();
        JTextField tfLast = new JTextField();
        JTextField tfEmail = new JTextField();
        JTextField tfPhone = new JTextField();
        JTextField tfJob = new JTextField();
        JTextField tfSearch = new JTextField();

        panel.add(new JLabel("First Name:"));
        panel.add(tfFirst);
        panel.add(new JLabel("Last Name:"));
        panel.add(tfLast);
        panel.add(new JLabel("Email:"));
        panel.add(tfEmail);
        panel.add(new JLabel("Phone:"));
        panel.add(tfPhone);
        panel.add(new JLabel("Job Title:"));
        panel.add(tfJob);
        panel.add(new JLabel("Search (Name/Phone):"));
        panel.add(tfSearch);

        JButton addBtn = new JButton("Add Contact");
        JButton showBtn = new JButton("Show All");
        JButton deleteBtn = new JButton("Delete");
        JButton updateBtn = new JButton("Update");
        JButton searchBtn = new JButton("Search");

        panel.add(addBtn);
        panel.add(showBtn);
        panel.add(deleteBtn);
        panel.add(updateBtn);
        panel.add(searchBtn);

        outputArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        addBtn.addActionListener(e -> {
            Contact c = new Contact(tfFirst.getText(), tfLast.getText(), tfEmail.getText(), tfPhone.getText(),
                    tfJob.getText());
            contacts.add(c);
            outputArea.setText("Added: " + c + "\n");
            clearFields(tfFirst, tfLast, tfEmail, tfPhone, tfJob);
        });

        showBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("All Contacts:\n");
            for (Contact c : contacts)
                sb.append(c).append("\n");
            outputArea.setText(sb.toString());
        });

        deleteBtn.addActionListener(e -> {
            String key = tfSearch.getText();
            contacts.removeIf(c -> c.firstName.equalsIgnoreCase(key) || c.phone.equals(key));
            outputArea.setText("Deleted contacts with name or phone: " + key);
        });

        searchBtn.addActionListener(e -> {
            String key = tfSearch.getText();
            StringBuilder sb = new StringBuilder("Search Results:\n");
            for (Contact c : contacts) {
                if (c.firstName.equalsIgnoreCase(key) || c.phone.equals(key))
                    sb.append(c).append("\n");
            }
            outputArea.setText(sb.toString());
        });

        updateBtn.addActionListener(e -> {
            String key = tfSearch.getText();
            for (Contact c : contacts) {
                if (c.firstName.equalsIgnoreCase(key) || c.phone.equals(key)) {
                    c.firstName = tfFirst.getText();
                    c.lastName = tfLast.getText();
                    c.email = tfEmail.getText();
                    c.phone = tfPhone.getText();
                    c.job = tfJob.getText();
                    outputArea.setText("Updated: " + c + "\n");
                    break;
                }
            }
        });

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    static void clearFields(JTextField... fields) {
        for (JTextField f : fields)
            f.setText("");
    }
}
