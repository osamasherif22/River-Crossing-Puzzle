package filesXML;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import Logic.*;
import Logic.Carrot;
import Logic.Farmer;
import Logic.ICrosser;
import Logic.RiverBanks;

public class MyDomSaver {
	public static String getName(ICrosser crosser)
	{
			if (crosser instanceof Farmer ) 
			{
			return "Farmer";
			}
			else if (crosser instanceof Cabbage ) 
			{
			return "Cabbage";
			}
			else if (crosser instanceof Carrot ) 
			{
			return "Carrot";
			}
			else if (crosser instanceof Goat ) 
			{
			return "Goat";
			}
			else if (crosser instanceof Sheep ) 
			{
			return "Sheep";
			}
			
			else if (crosser instanceof Snake ) 
			{
			return "Snake";
			}
			else if (crosser instanceof Wolf ) 
			{
			return "Wolf";
			}
			else if (crosser instanceof Tomato )  {
				return"Tomato";
				
			}
			return null;			
	}
	public static Element creatElement (Document doc ,String elementTagName)
    {
   	 //creat child element 
   	 try {
   		 Element element = doc.createElement(elementTagName);
      	 return element;
      	 }
   	 catch (Exception e) 
   	 {
   		 return null;
   	 }
   	}
	public static Attr addAttribute (Document doc ,String AttributeTag, String AttributeValue)
	{

   	// setting attribute to element
    try {    	Attr attr = doc.createAttribute(AttributeTag);
            attr.setValue(AttributeValue);
            return attr;  	 

    }catch (Exception e) {
		// TODO: handle exception
    	return null;
	}	
	
    }
	public static DOMSource writeInXML (Document doc)
	{
		
		try {
			// write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File("inputFile1.xml"));
	         transformer.transform(source, result);
		}
		catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	public static void Save(int scoreNum , int storyNum)
	{
		RiverBanks riverBanks = RiverBanks.getInstance();
		Boat normandi2=Boat.getInstance();
		try {
			//new File
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =factory.newDocumentBuilder();
	        Document doc = builder.newDocument();
	       
	        //parent (root)
			Element Crossers = doc.createElement("Crossers");
	        doc.appendChild(Crossers);
	        
	        //adding childs
		         //Boat
		         Element boat = doc.createElement("boat");
		         boat.setAttribute("Position", normandi2.getPosition());
		         Crossers.appendChild(boat);
		         
		       //score
		         Element score = doc.createElement("score");
		         score.setAttribute("score", String.valueOf(scoreNum));
		         Crossers.appendChild(score);
		         
		       //story
		         Element story = doc.createElement("story");
		         story.setAttribute("Number", String.valueOf(storyNum));
		         Crossers.appendChild(story);
		         
		         //leftCrossers
		         try{for (int i =0 ;i<riverBanks.getCrossersOnLeftBank().size();i++)
		         {
			         Element leftCrosser = doc.createElement("leftCrossers");
				         Element name = doc.createElement("name");
				         name.setTextContent(MyDomSaver.getName(riverBanks.getCrossersOnLeftBank().get(i)));
				         leftCrosser.appendChild(name);
				         
				         Element weight = doc.createElement("weight");
				         weight.setTextContent(String.valueOf(riverBanks.getCrossersOnLeftBank().get(i).getWeight()));
				         leftCrosser.appendChild(weight);
			         Crossers.appendChild(leftCrosser);
		         }}catch (Exception e) {
					// TODO: handle exception
				}
		         
		         //rightCrossers
		         try{for (int i =0 ;i<riverBanks.getCrossersOnRightBank().size();i++)
		         {
		        	 Element rightCrosser = doc.createElement("rightCrossers");
			         Element name = doc.createElement("name");
			         name.setTextContent(MyDomSaver.getName(riverBanks.getCrossersOnRightBank().get(i)));
			         rightCrosser.appendChild(name);
			         
			         Element weight = doc.createElement("weight");
			         weight.setTextContent(String.valueOf(riverBanks.getCrossersOnRightBank().get(i).getWeight()));
			         rightCrosser.appendChild(weight);
			         
		         Crossers.appendChild(rightCrosser);
		         }}catch (Exception e) {}
		   MyDomSaver.writeInXML(doc);	         
			}
		catch (ParserConfigurationException e) {e.printStackTrace();
		}
	}
}

