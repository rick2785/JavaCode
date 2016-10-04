import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//The API for accessing and processing data stored in a database

import java.sql.*;
import java.text.ParseException;

// Allows you to convert from string to date or vice versa

import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JavaLesson37 extends JFrame{
	
	static JLabel lFirstName, lLastName, lState, lBirthDate;
	
	static JTextField tfFirstName, tfLastName, tfState, tfBirthDate;
	
	static java.util.Date dateBirthDate, sqlBirthDate;
	
	// Holds row values for the table
	
	static Object[][] databaseResults;
	
	// Holds column names for the table
	
	static Object[] columns = {"First Name", "Last Name", "State", "Birth Date"};
	
	// DefaultTableModel defines the methods JTable will use
    // I'm overriding the getColumnClass
	
    static DefaultTableModel dTableModel = new DefaultTableModel(databaseResults, columns){
        public Class getColumnClass(int column) {
            Class returnValue;
            
            // Verifying that the column exists (index > 0 && index < number of columns
            
            if ((column >= 0) && (column < getColumnCount())) {
              returnValue = getValueAt(0, column).getClass();
            } else {
            	
              // Returns the class for the item in the column	
            	
              returnValue = Object.class;
            }
            return returnValue;
          }
        };
        
        // Create a JTable using the custom DefaultTableModel
        
        static JTable table = new JTable(dTableModel);
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// A connection object is used to provide access to a database
    	
    	Connection conn = null;
    	
        try {
            // The driver allows you to query the database with Java
        	// forName dynamically loads the class for you
           
            Class.forName("com.mysql.jdbc.Driver");
            
            // DriverManager is used to handle a set of JDBC drivers
            // getConnection establishes a connection to the database
            // You must also pass the userid and password for the database
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/samp_db","mysqladm","rickmoss");
            
            // Statement objects executes a SQL query
            // createStatement returns a Statement object
            
            Statement sqlState = conn.createStatement();
            
            // This is the query I'm sending to the database
            
            String selectStuff = "Select first_name, last_name, state, birth from president";
            
            // A ResultSet contains a table of data representing the
            // results of the query. It can not be changed and can 
            // only be read in one direction
            
            ResultSet rows = sqlState.executeQuery(selectStuff);
            
            // Temporarily holds the row results
            
            Object[] tempRow;
            
            // next is used to iterate through the results of a query
            
            while(rows.next()){
            	
            	tempRow = new Object[]{rows.getString(1), rows.getString(2), rows.getString(3), rows.getDate(4)};
            	
            	
            	/* You can also get other types
            	 * int getInt()
            	 * boolean getBoolean()
            	 * double getDouble()
            	 * float getFloat()
            	 * long getLong()
            	 * short getShort()
            	 */
            	
            	dTableModel.addRow(tempRow);
            }
        } 
        
        catch (SQLException ex) {
            
        	// String describing the error
        	
            System.out.println("SQLException: " + ex.getMessage());
            
            // Vendor specific error code
            
            System.out.println("VendorError: " + ex.getErrorCode());
        } 
        
        catch (ClassNotFoundException e) {
			// Executes if the driver can't be found
			e.printStackTrace();
		} 
        
        // Increase the font size for the cells in the table
        
        table.setFont(new Font("Serif", Font.PLAIN, 26));
        
        // Increase the size of the cells to allow for bigger fonts
        
        table.setRowHeight(table.getRowHeight()+16);
        
        // Allows the user to sort the data
	    
	    table.setAutoCreateRowSorter(true);
	    
	    // Adds the table to a scrollpane
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    
	    // Adds the scrollpane to the frame
	    
	    frame.add(scrollPane, BorderLayout.CENTER);
	    
	    // Creates a button that when pressed executes the code
	    // in the method actionPerformed
	    
	    JButton addPres = new JButton("Add President");
	    
	    addPres.addActionListener(new ActionListener(){
	    
	    	public void actionPerformed(ActionEvent e){
	    		
	    		String sFirstName = "", sLastName = "", sState = "", sDate = "";
	    		
	    		// getText returns the value in the text field
	    		
	    		sFirstName = tfFirstName.getText();
	    		sLastName = tfLastName.getText();
	    		sState = tfState.getText();
	    		sDate = tfBirthDate.getText();
	    		
	    		// Will convert from string to date
	    		
	    		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	    		
	    		try {
					dateBirthDate = dateFormatter.parse(sDate);
					sqlBirthDate = new java.sql.Date(dateBirthDate.getTime());
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
	    		
	    		Object[] president = {sFirstName, sLastName, sState, sqlBirthDate};
	    		dTableModel.addRow(president);
	    		
	    	}
	    	
	    });
	    
	    JButton removePres = new JButton("Remove President");
	    
	    removePres.addActionListener(new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e){
	    		
	    		// Will remove which ever row that is selected
	    		
	    		dTableModel.removeRow(table.getSelectedRow());
	    		
	    	}
	    	
	    });
	    
	    // Define values for my labels
	    
	    lFirstName = new JLabel("First Name");
	    lLastName = new JLabel("Last Name");
	    lState = new JLabel("State");
	    lBirthDate = new JLabel("Birthday");
	    
	    // Define the size of text fields
	    
	    tfFirstName = new JTextField(15);
	    tfLastName = new JTextField(15);
	    tfState = new JTextField(2);
	    
	    // Set default text and size for text field
	    
	    tfBirthDate = new JTextField("yyyy-MM-dd", 10);
	    
	    // Create a panel to hold editing buttons and fields
	    
	    JPanel inputPanel = new JPanel();
	    
	    // Put components in the panel
	    
	    inputPanel.add(lFirstName);
	    inputPanel.add(tfFirstName);
	    inputPanel.add(lLastName);
	    inputPanel.add(tfLastName);
	    inputPanel.add(lState);
	    inputPanel.add(tfState);
	    inputPanel.add(lBirthDate);
	    inputPanel.add(tfBirthDate);
	    inputPanel.add(addPres);
	    inputPanel.add(removePres);
	    
	    // Add the component panel to the frame
	    
	    frame.add(inputPanel, BorderLayout.SOUTH);
	    
	    frame.setSize(1200, 500);
	    frame.setVisible(true);
		
	}
	
}