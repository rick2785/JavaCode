import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class JavaLesson48 extends JFrame
{
	
		JButton brushBut, lineBut, ellipseBut, rectBut, strokeBut, fillBut;
		
		// Going to be used to monitor what shape to draw next
		
		int currentAction = 1;
		
		// Default stroke and fill colors
		
		Color strokeColor=Color.BLACK, fillColor=Color.BLACK;
	
        public static void main(String [] args)
        {
                new JavaLesson48();
        }

        public JavaLesson48()
        {
        	// Define the defaults for the JFrame
        	
            this.setSize(500, 500);
            this.setTitle("Java Paint");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel buttonPanel = new JPanel();
            
            // Swing box that will hold all the buttons
            
            Box theBox = Box.createHorizontalBox();
            
            // Make all the buttons in makeMeButtons by passing the
            // button icon. 
            
            brushBut = makeMeButtons("./src/brush.png", 1);
            lineBut = makeMeButtons("./src/Line.png", 2);
            ellipseBut = makeMeButtons("./src/Ellipse.png", 3);
            rectBut = makeMeButtons("./src/Rectangle.png", 4);
            
            // Make all the buttons in makeMeColorButton by passing the
            // button icon and true for stroke color or false for fill
            
            strokeBut = makeMeColorButton("./src/Stroke.png", 5, true);
            fillBut = makeMeColorButton("./src/Fill.png", 6, false);
            
            // Add the buttons to the box
            
            theBox.add(brushBut);
            theBox.add(lineBut);
            theBox.add(ellipseBut);
            theBox.add(rectBut);
            theBox.add(strokeBut);
            theBox.add(fillBut);
            
            // Add the box of buttons to the panel
            
            buttonPanel.add(theBox);

            // Position the buttons in the bottom of the frame
            
            this.add(buttonPanel, BorderLayout.SOUTH);
            
            // Make the drawing area take up the rest of the frame
            
            this.add(new DrawingBoard(), BorderLayout.CENTER);
            
            // Show the frame
            
            this.setVisible(true);
        }
        
        // Spits out buttons based on the image supplied
        // actionNum represents each shape to be drawn
        
        public JButton makeMeButtons(String iconFile, final int actionNum){
        	JButton theBut = new JButton();
            Icon butIcon = new ImageIcon(iconFile);
            theBut.setIcon(butIcon);
            
            // Make the proper actionPerformed method execute when the
            // specific button is pressed
            
            theBut.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					currentAction = actionNum;
					System.out.println("actionNum: " + actionNum);
					
				}
            });
            
            return theBut;  
        }
        
        // Spits out buttons based on the image supplied and
        // whether a stroke or fill is to be defined
        
        public JButton makeMeColorButton(String iconFile, final int actionNum, final boolean stroke){
        	JButton theBut = new JButton();
            Icon butIcon = new ImageIcon(iconFile);
            theBut.setIcon(butIcon);
            
            theBut.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					if(stroke){
						
						// JColorChooser is a popup that lets you pick a color
						
						strokeColor = JColorChooser.showDialog(null,  "Pick a Stroke", Color.BLACK);
					} else {
						fillColor = JColorChooser.showDialog(null,  "Pick a Fill", Color.BLACK);
					}
					
				}
            });
            
            return theBut;  
        }

        private class DrawingBoard extends JComponent
        {
        	
        	// ArrayLists that contain each shape drawn along with
        	// that shapes stroke and fill
        	
                ArrayList<Shape> shapes = new ArrayList<Shape>();
                ArrayList<Color> shapeFill = new ArrayList<Color>();
                ArrayList<Color> shapeStroke = new ArrayList<Color>();
                Point drawStart, drawEnd;

                // Monitors events on the drawing area of the frame
                
                public DrawingBoard()
                {
                        this.addMouseListener(new MouseAdapter()
                          {
                            public void mousePressed(MouseEvent e)
                            {
                            	
                            	// When the mouse is pressed get x & y position
                            	
                            	drawStart = new Point(e.getX(), e.getY());
                            	drawEnd = drawStart;
                                repaint();
                                }

                            public void mouseReleased(MouseEvent e)
                                {
                            	
                            	  // Create a shape using the starting x & y
                            	  // and finishing x & y positions
                            	
                                  Shape aShape = drawRectangle(
                                		  drawStart.x, drawStart.y,
                                                      e.getX(), e.getY());
                                  
                                  // Add shapes, fills and colors to there ArrayLists
                                  
                                  shapes.add(aShape);
                                  shapeFill.add(fillColor);
                                  shapeStroke.add(strokeColor);
                                  
                                  drawStart = null;
                                  drawEnd = null;
                                  
                                  // repaint the drawing area
                                  
                                  repaint();
                                }
                          } );

                        this.addMouseMotionListener(new MouseMotionAdapter()
                        {
                          public void mouseDragged(MouseEvent e)
                          {
                        	  
                        	// Get the final x & y position after the mouse is dragged
                        	  
                        	drawEnd = new Point(e.getX(), e.getY());
                            repaint();
                          }
                        } );
                }
                

                public void paint(Graphics g)
                {
                		// Class used to define the shapes to be drawn
                	
                        Graphics2D graphSettings = (Graphics2D)g;

                        // Antialiasing cleans up the jagged lines and defines rendering rules
                        
                        graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
                        
                        // Defines the line width of the stroke
                        
                        graphSettings.setStroke(new BasicStroke(2));

                        // Iterators created to cycle through strokes and fills
                        Iterator<Color> strokeCounter = shapeStroke.iterator();
                        Iterator<Color> fillCounter = shapeFill.iterator();
                        
                        // Eliminates transparent setting below
                        
                        graphSettings.setComposite(AlphaComposite.getInstance(
                                AlphaComposite.SRC_OVER, 1.0f));
                        
                        for (Shape s : shapes)
                        {
                        	// Grabs the next stroke from the color arraylist
                        	graphSettings.setPaint(strokeCounter.next());
                        	
                        	graphSettings.draw(s);
                        	
                        	// Grabs the next fill from the color arraylist
                        	graphSettings.setPaint(fillCounter.next());
                        	
                        	graphSettings.fill(s);
                        }

                        // Guide shape used for drawing
                        if (drawStart != null && drawEnd != null)
                        {
                        	// Makes the guide shape transparent
                            
                            graphSettings.setComposite(AlphaComposite.getInstance(
                                    AlphaComposite.SRC_OVER, 0.40f));
                        	
                            // Make guide shape gray for professional look
                            
                        	graphSettings.setPaint(Color.LIGHT_GRAY);
                        	
                        	// Create a new rectangle using x & y coordinates
                        	
                                Shape aShape = drawRectangle(drawStart.x, drawStart.y,
                                		drawEnd.x, drawEnd.y);
                                graphSettings.draw(aShape);
                        }
                }

                private Rectangle2D.Float drawRectangle(
                        int x1, int y1, int x2, int y2)
                {
                	// Get the top left hand corner for the shape
                	// Math.min returns the points closest to 0
                	
                        int x = Math.min(x1, x2);
                        int y = Math.min(y1, y2);
                        
                        // Gets the difference between the coordinates and 
                        
                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);

                        return new Rectangle2D.Float(
                                x, y, width, height);
                }
                
                // The other shapes will work similarly
                // More on this in the next tutorial
                
                private Ellipse2D.Float makeEllipse(
                        int x1, int y1, int x2, int y2)
                {
                        int x = Math.min(x1, x2);
                        int y = Math.min(y1, y2);
                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);

                        return new Ellipse2D.Float(
                                x, y, width, height);
                }
        }
}