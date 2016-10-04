import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Thrown when a URL doesn't contain http://
// and other rules like that

import java.net.MalformedURLException;
import java.net.URL;

// A text component that allows for rich text
// and basic html display

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

// Provides information on events triggered
// through interaction with links

import javax.swing.event.HyperlinkEvent;

// Monitors user activity with links

import javax.swing.event.HyperlinkListener;

public class JavaLesson39 extends JFrame implements HyperlinkListener, ActionListener{

	public static void main(String[] args){
		
		new JavaLesson39("file:///Volumes/My%20Book/Presentations/HTML%20Tutorial/htmlexample.html");
		
	}
	
	String defaultURL;
	
	JPanel toolPanel = new JPanel();
	JTextField theURL = new JTextField(25);
	
	// Displays basic html pages
	// Doesn't understand JavaScript
	
	JEditorPane htmlPage;
	
	public JavaLesson39(String defaultURL){
		
		JFrame frame = new JFrame("Java Browser");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.defaultURL = defaultURL;
		
	    // If the user interacts with the JTextField the
	    // actionPerformed method is called
	    
		theURL.addActionListener(this);
		
		// Set default text in the JTextField
		
		theURL.setText(defaultURL);
		
		// Add the text field to a panel
		
		toolPanel.add(theURL);
		
		// Add the panel to the northern quadrant of a frame
		
		frame.add(toolPanel, BorderLayout.NORTH);
		
		try {
			htmlPage = new JEditorPane(defaultURL);
			
			// If the user interacts with the JEditorPane
			// actions are triggered. Ex. Click on a link
			// change the JEditorPane page location
			
			htmlPage.addHyperlinkListener(this);
			
			// You can leave this true for rich text documents
			// but it will mess up web page display
			
			htmlPage.setEditable(false);
			
			// Add the JEditorPane to a Scroll pane
			
			JScrollPane scroller = new JScrollPane(htmlPage);
			
			// Add Scroll pane and JEditorPane to the frame
			
			frame.add(scroller, BorderLayout.CENTER);
			
		} 
		
		// If something goes wrong with locating the html page
		// this will handle that error
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Set size of the frame and display it
		
		frame.setSize(1200, 800);
	    frame.setVisible(true);
		
	}

	public void hyperlinkUpdate(HyperlinkEvent e) {
		
		// Checks if a link was clicked
		// EventType.ENTERED : Checks for hovering
		// EventType.EXITED : Checks for leaving link
		
		if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
			
			try {
				
				// Sets the URL to be displayed
				// getURL gets the URL for the link
				
				htmlPage.setPage(e.getURL());
				
				// toExternalForm creates a String representation of the URL
				
				theURL.setText(e.getURL().toExternalForm());
				
			}
			
			catch(IOException e1){
    			e1.printStackTrace();
    		}
			
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		
		String pageURL = "";
		
		// Gets the Object that had an event triggered
		
		if(e.getSource() == theURL){
			
			// Get the text in the JTextField
			
			pageURL = theURL.getText();
			
		} else {
			
			pageURL = defaultURL;
			
			// Opens an alert box when an error is made
			
			JOptionPane.showMessageDialog(JavaLesson39.this, 
					"Please Enter a Web Address", "Error", 
					JOptionPane.ERROR_MESSAGE);
			
		}
		
		try{
			
			// Sets the URL to be displayed
			
			htmlPage.setPage(new URL(pageURL));
			theURL.setText(pageURL);
			
		}
		
		catch(MalformedURLException e2){
			JOptionPane.showMessageDialog(JavaLesson39.this, 
					"Please use http://", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		catch(IOException e1){
			e1.printStackTrace();
		}
		
	}
	
}