import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.*;

// In swing you use a JFrame, to make the program
// work online you use JApplet

public class JavaLesson40 extends JApplet{
	
	// The main panel that holds everything
	
	JPanel thePanel;
	
	// The panels that hold the radio buttons
	
	JPanel ques1Panel, ques2Panel, ques3Panel, ques4Panel;
	
	// When clicked the personality report is displayed
	
	JButton getResultBut;
	
	// The radio buttons for each personality quirk
	
	JRadioButton extravertRadio, introvertRadio,
		sensorRadio, intuitiveRadio, feelerRadio,
		thinkerRadio, judgingRadio, perceivingRadio;
	
	// Holds the personality report
	
	JEditorPane yourReport;
	
	// You use init() instead of main() with Applets
	
	public void init(){
		
		// Sets the size of the frame
		
		this.setSize(675, 870);
		
		// Creates the main panel and makes everything justify left
		
		thePanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
		
		// The panels for the radio buttons
		
		ques1Panel = new JPanel();
		ques2Panel = new JPanel();
		ques3Panel = new JPanel();
		ques4Panel = new JPanel();
		
		// Creates borders that surround the radio buttons
		
		Border border1 = BorderFactory.createTitledBorder("Do you prefer to work");
		Border border2 = BorderFactory.createTitledBorder("Which is most important");
		Border border3 = BorderFactory.createTitledBorder("Do you act on");
		Border border4 = BorderFactory.createTitledBorder("Which do you prefer");
		
		// Attaches the border to the right panels
		
		ques1Panel.setBorder(border1);
		ques2Panel.setBorder(border2);
		ques3Panel.setBorder(border3);
		ques4Panel.setBorder(border4);
		
		// Makes are only one radio button can be selected
		
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		ButtonGroup group3 = new ButtonGroup();
		ButtonGroup group4 = new ButtonGroup();
		
		// Creates and sets text for radio buttons
		
		extravertRadio = new JRadioButton("In groups");
		introvertRadio = new JRadioButton("On your own");
		sensorRadio = new JRadioButton("The specifics");
		intuitiveRadio = new JRadioButton("The big picture"); 
		feelerRadio = new JRadioButton("What feels right");
		thinkerRadio = new JRadioButton("List of facts"); 
		judgingRadio = new JRadioButton("To plan"); 
		perceivingRadio = new JRadioButton("To adapt");
		
		// Sets some radio buttons to true by default
		
		extravertRadio.setSelected(true);
		sensorRadio.setSelected(true);
		feelerRadio.setSelected(true);
		judgingRadio.setSelected(true);
		
		// Adds radio buttons to their panels
		
		ques1Panel.add(extravertRadio);
		ques1Panel.add(introvertRadio);
		ques2Panel.add(sensorRadio);
		ques2Panel.add(intuitiveRadio);
		ques3Panel.add(feelerRadio);
		ques3Panel.add(thinkerRadio);
		ques4Panel.add(judgingRadio);
		ques4Panel.add(perceivingRadio);
		
		// Assigns radio buttons to be in groups together
		
		group1.add(extravertRadio);
		group1.add(introvertRadio);
		group2.add(sensorRadio);
		group2.add(intuitiveRadio);
		group3.add(feelerRadio);
		group3.add(thinkerRadio);
		group4.add(judgingRadio);
		group4.add(perceivingRadio);
		
		// Adds the radio button panels to the main panel
		
		thePanel.add(ques1Panel);
		thePanel.add(ques2Panel);
		thePanel.add(ques3Panel);
		thePanel.add(ques4Panel);
		
		// Creates a button
		
		getResultBut = new JButton("Get Result");
		
		// Creates an object that will monitor button clicks
		
		GetResultsListener butListener = new GetResultsListener();
		
		// Assigns an object that will monitor this buttons clicks
		// When clicked a method will execute
		
		getResultBut.addActionListener(butListener);
		
		// Add the button & panel to the frame and show the frame
		
		thePanel.add(getResultBut);
		
		this.add(thePanel);
		
		this.setVisible(true);
		
		
		
	}
	
	class GetResultsListener implements ActionListener{

		// Called when the button is clicked
		
		public void actionPerformed(ActionEvent e) {
			
			// Define strings that will make the html that the 
			// JEditorPane will display
			
			String pageToOpen = "",
					directoryLoc = "file:///Users/rickeyhrabowskie/Documents/workspace/Java Code/src/";
			
			String textToDisplay ="<html><div><img src=\"" + directoryLoc;
			
			// Check if the result button was clicked
			
			if (e.getSource() == getResultBut){
				
				// Add to the string based on selected radio button
				
				if (extravertRadio.isSelected()) pageToOpen += "E";
				if (introvertRadio.isSelected()) pageToOpen += "I";
				
				if (sensorRadio.isSelected()) pageToOpen += "S";
				if (intuitiveRadio.isSelected()) pageToOpen += "N";
				
				if (feelerRadio.isSelected()) pageToOpen += "F";
				if (thinkerRadio.isSelected()) pageToOpen += "T";
				
				if (judgingRadio.isSelected()) pageToOpen += "J";
				if (perceivingRadio.isSelected()) pageToOpen += "P";
				
				// Remove panels to make way for a report
				
				thePanel.remove(ques1Panel);
				thePanel.remove(ques2Panel);
				thePanel.remove(ques3Panel);
				thePanel.remove(ques4Panel);
				
				// Finish the html file that JEditorPane will display
					
				textToDisplay += pageToOpen + ".png" + "\" /></html>";
					
				// Define what JEditorPane will display
					
				yourReport = new JEditorPane("text/html", textToDisplay);
					
				// Shut off editing and size the JEditorPane
				
				yourReport.setEditable(false);
				
				yourReport.setSize(650, 825);
				
				// Add the JEditorPane to a scroller and define how
				// to handle scrollbars
				
				JScrollPane scroller = new JScrollPane(yourReport, 
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				
				// Size the scroll pane
				
				scroller.setPreferredSize(new Dimension(650, 825));
				
				// Add Scroll pane and JEditorPane to the frame
				
				thePanel.add(scroller);
				
				getResultBut.setVisible(false);
				
				// Redraw the frame after the changes are made
				
				thePanel.revalidate();
				thePanel.repaint();
				
				
			}
			
		}
		
	}
	
}