import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class JavaLesson36{
	
	// Used to hold the column data for each player
	
	static Object[][] databaseInfo;
	
	// The column titles for the JTable
	
    static Object[] columns = {"Year", "PlayerID", "Name", "TTRC", "Team", "Salary", "CPR", "POS"};
    
    // A ResultSet contains a table of data filled 
    // with the results of the query.
    
    static ResultSet rows;
    
    // ResultSetMetaData contains information on
    // the data returned by the query
    
    static ResultSetMetaData metaData;
    
    // DefaultTableModel defines the methods JTable will use
    // I'm overriding the getColumnClass
    
    static DefaultTableModel dTableModel = new DefaultTableModel(databaseInfo, columns){
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
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    Connection conn = null;
    	
        try {
            // The driver allows you to query the database with Java
        	// forName dynamically loads the class for you
           
            Class.forName("com.mysql.jdbc.Driver");
            
            // DriverManager is used to handle a set of JDBC drivers
            // getConnection establishes a connection to the database
            // You must also pass the userid and password for the database
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/stats","mysqladm","rickmoss");
            
            // Statement objects executes a SQL query
            // createStatement returns a Statement object
            
            Statement sqlState = conn.createStatement();
            
            // This is the query I'm sending to the database
           
            String selectStuff = "select b.yearID, b.playerID, " +
            		"CONCAT(m.nameFirst, ' ', m.nameLast) AS Name, " + 
            		"((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.TB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB)) AS TTRC, " +
            		"b.teamID AS Team, s.salary AS Salary, " +
            		"CAST( s.salary/(((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.TB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB))) as decimal(10,2)) AS CPR, " +
            		"f.POS AS POS FROM Batting b, Master m, Salaries s, TOTBYR t, Fielding f " +
            		"WHERE b.playerID = m.playerID AND t.playerID = m.playerID " +
            		"AND t.yearID = 2010 AND b.yearID = t.yearID AND s.playerID = b.playerID " + 
            		"AND s.yearID = b.yearID AND b.AB > 50 AND b.playerID = f.playerID " +
            		"AND b.playerID = t.playerID GROUP BY b.playerID ORDER BY TTRC DESC LIMIT 200;";
            		
            /* Have to cut out salary because it isn't in database for 2011 
            String selectStuff = "select b.yearID, b.playerID, " +
            		"CONCAT(m.nameFirst, ' ', m.nameLast) AS NAME, " + 
            		"((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.TB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB)) AS TTRC, " +
            		"b.teamID AS Team, 0 AS Salary, " +
            		"0 AS CPR, f.POS AS POS " +
            		"FROM Batting b, Master m, Fielding f, TOTBYR as t " +
            		"WHERE b.playerID = m.playerID AND t.playerID = m.playerID " +
            		"AND t.yearID = 2011 AND b.yearID = t.yearID " + 
            		"AND b.AB > 100 AND f.playerID = b.playerID " +
            		"GROUP BY b.playerID ORDER BY TTRC DESC LIMIT 200;";
            */
            
            // A ResultSet contains a table of data representing the
            // results of the query. It can not be changed and can 
            // only be read in one direction
            
            rows = sqlState.executeQuery(selectStuff);
            
            /* 
            int numOfCol;
            
            // Retrieves the number, types and properties of the Query Results
            
            metaData = rows.getMetaData();
            
            // Returns the number of columns
            
            numOfCol = metaData.getColumnCount();
            
            // One way to get the column titles
            
            columns = new String[numOfCol];
            
            for(int i=1; i<=numOfCol; i++)
            {
            
            	// Returns the column name
            
            	columns[i] = metaData.getColumnName(i);
            	System.out.println(i);
            }
            */
            
            // Temporarily holds the row results
            
            Object[] tempRow;
            
         // next is used to iterate through the results of a query
            
            while(rows.next()){
            	
            	// Gets the column values based on class type expected
            	
            	tempRow = new Object[]{rows.getInt(1), rows.getString(2), rows.getString(3),
            		rows.getDouble(4), rows.getString(5), rows.getInt(6), rows.getDouble(7),
            		rows.getString(8)};
            	
            	// Adds the row of data to the end of the model
            	
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
        
        // Create a JTable using the custom DefaultTableModel
	    
        JTable table = new JTable(dTableModel);
        
        // Increase the font size for the cells in the table
        
        table.setFont(new Font("Serif", Font.PLAIN, 20));
        
        // Increase the size of the cells to allow for bigger fonts
        
        table.setRowHeight(table.getRowHeight()+10);
	    
	    // Allows the user to sort the data
	    
	    table.setAutoCreateRowSorter(true);

        /* If you want to right justify column
         * 
	    TableColumn tc = table.getColumn("TTRC");
	    RightTableCellRenderer rightRenderer = new RightTableCellRenderer();
	    tc.setCellRenderer(rightRenderer);
	    */
	    
	    // Disable auto resizing
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	    // Set the width for the columns
	    
	    TableColumn col1 = table.getColumnModel().getColumn(0);
	    col1.setPreferredWidth(100);
	    
	    TableColumn col2 = table.getColumnModel().getColumn(1);
	    col2.setPreferredWidth(190);
	    
	    TableColumn col3 = table.getColumnModel().getColumn(2);
	    col3.setPreferredWidth(260);
	    
	    TableColumn col5 = table.getColumnModel().getColumn(5);
	    col5.setPreferredWidth(200);
	    
	    TableColumn col6 = table.getColumnModel().getColumn(6);
	    col6.setPreferredWidth(200);
	    
	    // Change justification of column to Center
	    
	    TableColumn tc = table.getColumn("Team");
	    CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
	    tc.setCellRenderer(centerRenderer);
	    
	    tc = table.getColumn("POS");
	    centerRenderer = new CenterTableCellRenderer();
	    tc.setCellRenderer(centerRenderer);
	    
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setSize(800, 500);
	    frame.setVisible(true);
		
	}
	
}

// How to change justification to the right

class RightTableCellRenderer extends DefaultTableCellRenderer {   
	  public RightTableCellRenderer() {  
	    setHorizontalAlignment(JLabel.RIGHT);  
	  }   
	    
}   

// Change justification to the center

class CenterTableCellRenderer extends DefaultTableCellRenderer {   
	  public CenterTableCellRenderer() {  
	    setHorizontalAlignment(JLabel.CENTER);  
	  }   
	    
}   