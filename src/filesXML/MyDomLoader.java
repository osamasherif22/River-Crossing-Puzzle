package filesXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Logic.Boat;
import Logic.Cabbage;
import Logic.Carrot;
import Logic.Farmer;
import Logic.GmeController;
import Logic.Snake;
import Logic.Tomato;
import Logic.Goat;
import Logic.ICrosser;
import Logic.RiverBanks;
import Logic.Sheep;
import Logic.Wolf;

import org.w3c.dom.Element;

public class MyDomLoader {
	public static ICrosser getCrosser(String name , String wight)
	{
		ICrosser iCrosser = null;
			if (name.equals("Farmer")) 
			{
				iCrosser = new Farmer(Integer.valueOf(wight));
			}
			else if (name.equals("Snake")) 
			{
				iCrosser= new Snake(Integer.valueOf(wight));

			}
			else if (name.equals("Tomato")) 
			{
				
				iCrosser= new Tomato(Integer.valueOf(wight));

			}
			else if (name.equals("Wolf")) 
			{
				iCrosser= new Wolf(Integer.valueOf(wight));

			}
			else if (name.equals("Carrot")) 
			{
				iCrosser=  new Carrot(Integer.valueOf(wight));

			}	
			else if (name.equals("Goat")) 
			{
				iCrosser= new Goat(Integer.valueOf(wight));
			}
			else if (name.equals("Sheep")) 
			{
				iCrosser= new Sheep(Integer.valueOf(wight));
			}			
			return iCrosser;			
	}
	public static void Load () {
		RiverBanks riverBanks=RiverBanks.getInstance();
        List<ICrosser> leftBankList = new ArrayList<>();
        List<ICrosser> rightBankList = new ArrayList<>();
        Boat boatObiject = Boat.getInstance();//abdo was joking :)
        GmeController controller= GmeController.getInstance();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =factory.newDocumentBuilder();
			Document doc =builder.parse("inputFile1.xml");
			
			//working in boat
			Element boateElement = (Element) doc.getElementsByTagName("boat").item(0);		
			String position = boateElement.getAttribute("Position");
			boatObiject.setPosition(position);//adding the list to the singleTone(Boat)
			
			//working in score
			Element scoreElement = (Element) doc.getElementsByTagName("score").item(0);		
			int scoreNum = Integer.valueOf(scoreElement.getAttribute("score"));
			controller.setNumberOfSails(scoreNum);
			
			//working in Stroy
			Element stroyElement = (Element) doc.getElementsByTagName("story").item(0);		
			int storyNum = Integer.valueOf(stroyElement.getAttribute("Number"));
			controller.setStoryNum(storyNum);
			
			
			//working in leftCrossers
			NodeList nLiftList = doc.getElementsByTagName("leftCrossers");//returns list of "leftCrossers"
			 for ( int i=0 ; i<nLiftList.getLength();i++)
			 {
				 Node nNode = nLiftList.item(i);//store the ith node with in nNode 
				 System.out.println("current element from Type:"+nNode.getNodeName());
				 if ( nNode.getNodeType()==Node.ELEMENT_NODE)
				 {
					 Element element = (Element) nNode;		
					 String name = element.getElementsByTagName("name").item(0).getTextContent();
					 String weight = element.getElementsByTagName("weight").item(0).getTextContent();
					 
					 leftBankList.add(MyDomLoader.getCrosser(name, weight));
				 }
			 }
			 riverBanks.setCrossersOnLeftBank(leftBankList);//adding the list to the singleTone(riverBanks)

			
			//working in rightCrossers
			 NodeList nRightList = doc.getElementsByTagName("rightCrossers");//returns list of "rightCrossers"
			 for (int i=0 ; i<nRightList.getLength();i++)
			 {
				 Node nNode = nRightList.item(i);//store the ith node with in n 
				 System.out.println("current element from Type:"+nNode.getNodeName());
				 if ( nNode.getNodeType()==Node.ELEMENT_NODE)
				 {
					 Element element = (Element) nNode;		
					 String name = element.getElementsByTagName("name").item(0).getTextContent();
					 String weight = element.getElementsByTagName("weight").item(0).getTextContent();
				
					 rightBankList.add(MyDomLoader.getCrosser(name, weight));
				 }
			 }
			 riverBanks.setCrossersOnRightBank(rightBankList);//adding the list to the singleTone(riverBanks)

			 
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
