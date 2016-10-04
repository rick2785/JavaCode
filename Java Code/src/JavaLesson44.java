// Simple API for XML only allows you to read from an XML 
// file. SAX doesn't require you to read the document into memory

import org.xml.sax.*;

// Used to read an XML file into memory where the doc is 
// stored as a bunch of objects. You can write back to the file

import org.w3c.dom.*;

// Used to gather XML elements into DOM objects

import javax.xml.parsers.*;

public class JavaLesson44{
	
	public static void main(String[] args){
		
		// Creates a DOM object in memory. Now you can access
		// data in the xml file
		
		Document xmlDoc = getDocument("./src/tvshow5.xml");
		
		// Get the name of the root element
		
		xmlDoc.getDocumentElement();
        System.out.println("Root element is " + 
        		xmlDoc.getDocumentElement().getNodeName());
        
        // The nodelist contains all of the nodes in the xml file
        
        NodeList listOfShows = xmlDoc.getElementsByTagName("show");
        
     // Get the number of children in the root element
        
        System.out.println("Number of shows " + listOfShows.getLength());
        
        // The element you want to print out
        
        String elementName = "network";
        
        // The attribute to search for
        
        String attrName = "country";
        
        // Send the NodeList for processing
        
        getElementAndAttrib(listOfShows, elementName, attrName);
        
        // Additional Code not in the Video -------------------
        
		// Returns an Element object represented by the root element
		// of the xml file
		
		Element theRoot = xmlDoc.getDocumentElement();
		
		// Get the first child or show element in this situation
		
		Element showElement = (Element)theRoot.getFirstChild();
		
		// Object that will contain all of the show data
		
		tvShow tvs;
		
		// Cycle through all of the show elements until the end
		
		while(showElement != null){
			
			// Go get the first element in show which is name
			
			tvs = getShowData(showElement);
			
			// Print out the value of showName
			
			System.out.println(tvs.showName);
			
			// Get the next show
			
			showElement = (Element)showElement.getNextSibling();
			
		}
		
		
	}

	// Reads an XML file into a DOM document
	
	private static Document getDocument(String docString) {
		
		try {
			
			// API used to convert XML into a DOM object tree
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			// Ignore all of the comments
			
			factory.setIgnoringComments(true);
			
			// Ignore white space in elements
			
			factory.setIgnoringElementContentWhitespace(true);
			
			// Validate the XML as it is parsed
			
			factory.setValidating(true);
			
			// Provides access to the documents data
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Takes the document 
			
			return builder.parse(new InputSource(docString));
			
		}
		
		catch(Exception ex){
			
			System.out.println(ex.getMessage());
			
		}
		
		return null;
	}
	
	private static tvShow getShowData(Element ele){
		
		// Returns the first child element in the xml file. 
		// That element is name
		
		Element nameElement = (Element)ele.getFirstChild();
		
		// Save the value in this element as a String
		
		String showName = getTextValue(nameElement).trim();
		
		// Create a tvShow object that holds the values stored
		// in the show elements
		
		return new tvShow(showName);
		
	}

	private static String getTextValue(Node theNode) {
		
		// Get the value of the first child element
		
		return theNode.getFirstChild().getNodeValue();
	}
	
	private static void getElementAndAttrib(NodeList listOfShows, String elementName, String attrName){
		
		try{
	        
			// Cycle through the number of shows
			
        	for(int i=0; i < listOfShows.getLength(); i++){
        	
        		// Get the first show node
        		
        		Node showNode = listOfShows.item(i);
        		
        		// Convert into an element to gain access to element methods
        		
        		Element showElement = (Element)showNode;
        		
        		// Create a list of nodes that have the name defined in elementName
        		
        		NodeList networkList = showElement.getElementsByTagName(elementName);
        		
        		// Get the first and only element in this situation
        		
        		Element networkElement = (Element)networkList.item(0);

        		// Returns a list of node elements
        		// Each value is in a node in side of the network node
        		// That's why you have to get the child nodes for network
        		
                NodeList elementList = networkElement.getChildNodes();
                
                // Check if the element has the attribute set
                
                if(networkElement.hasAttribute(attrName)){

                	System.out.println(elementName + " : " + ((Node)elementList.item(0)).getNodeValue().trim() +
                		" has attribute " + networkElement.getAttribute(attrName));
                
                } else {
                	
                	System.out.println(((Node)elementList.item(0)).getNodeValue().trim());
                	
                }
        	
        	}
        
        }
        
        catch(Exception ex){
			
			System.out.println(ex.getMessage());
			
		}
		
	}
	
	private static class tvShow{
		
		public String showName, showNetwork;
		
		public tvShow(String showName){
			
			this.showName = showName;
			
		}
		
	}
	
}