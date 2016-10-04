// Memento Design Pattern Tutorial

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestMemento extends JFrame{
   public static void main(String[] args) {
       
	   new TestMemento();
       
   }
   
   private JButton saveBut, undoBut, redoBut;
   
   // JTextArea(rows, columns)
   
   private JTextArea theArticle = new JTextArea(40,60);
   
   // ---------------------------------------------
   
   // Create a caretaker that contains the ArrayList 
   // with all the articles in it. It can add and
   // retrieve articles from the ArrayList
   
   Caretaker caretaker = new Caretaker();

   // The originator sets the value for the article,
   // creates a new memento with a new article, and 
   // gets the article stored in the current memento
   
   Originator originator = new Originator();
   
   int saveFiles = 0, currentArticle = 0;
   
   // ---------------------------------------------
   
   public TestMemento(){
	   
	   // Set basic information for the panel that will
	   // hold all the GUI elements
	   
	   this.setSize(750,780);
	   this.setTitle("Memento Design Pattern");
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   JPanel panel1 = new JPanel();
	   
	   // Add label to the panel
	   
	   panel1.add(new JLabel("Article"));
	   
	   // Add JTextArea to the panel
	   
	   panel1.add(theArticle);
	   
	   // Add the buttons & ButtonListeners to the panel
	   
	   ButtonListener saveListener = new ButtonListener();
	   ButtonListener undoListener = new ButtonListener();
	   ButtonListener redoListener = new ButtonListener();
	   
	   saveBut = new JButton("Save");
	   saveBut.addActionListener(saveListener);
	   
	   undoBut = new JButton("Undo");
	   undoBut.addActionListener(undoListener);
	   
	   redoBut = new JButton("Redo");
	   redoBut.addActionListener(redoListener);
	   
	   panel1.add(saveBut);
	   panel1.add(undoBut);
	   panel1.add(redoBut);
	   
	   // Add panel to the frame that shows on screen
	   
	   this.add(panel1);
	   
	   this.setVisible(true);
	   
   }
   
   class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == saveBut){
				
				// Get text in JTextArea
				
				String textInTextArea = theArticle.getText();
				
				// Set the value for the current memento
				
				originator.set(textInTextArea);
				
				// Add new article to the ArrayList
				
				caretaker.addMemento( originator.storeInMemento() );
				
				// saveFiles monitors how many articles are saved
				// currentArticle monitors the current article displayed
				
				saveFiles++;
				currentArticle++;
				
				System.out.println("Save Files " + saveFiles);
				
				// Make undo clickable
				
				undoBut.setEnabled(true);
				
			} else 
				
				if(e.getSource() == undoBut){
					
					if(currentArticle >= 1){
						
						// Decrement to the current article displayed
						
						currentArticle--;
						
						// Get the older article saved and display it in JTextArea
					
						String textBoxString = originator.restoreFromMemento( caretaker.getMemento(currentArticle) );
						
						theArticle.setText(textBoxString);
						
						// Make Redo clickable
						
						redoBut.setEnabled(true);
					
					} else {
						
						// Don't allow user to click Undo
						
						undoBut.setEnabled(false);
						
					}
					
				} else
					
					if(e.getSource() == redoBut){
					
					if((saveFiles - 1) > currentArticle){
						
						// Increment to the current article displayed
						
						currentArticle++;
						
						// Get the newer article saved and display it in JTextArea
					
						String textBoxString = originator.restoreFromMemento( caretaker.getMemento(currentArticle) );
						
						theArticle.setText(textBoxString);
						
						// Make undo clickable
						
						undoBut.setEnabled(true);
					
					} else {
						
						// Don't allow user to click Redo
						
						redoBut.setEnabled(false);
						
					}
					
				}
			
		}
		
	}
   
}