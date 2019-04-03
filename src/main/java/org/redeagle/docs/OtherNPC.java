package org.redeagle.docs;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import org.redeagle.BotConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OtherNPC {
	private JDA bot;
	private GuildMessageReceivedEvent e;
	private String[] data;
	
	private String result = "";
	
	public OtherNPC(JDA bot, GuildMessageReceivedEvent e, String[] data) {
		this.bot = bot;
		this.e = e;
		this.data = data;
	}
	
	public void buildDocs() {
		try {
			
			File xml = new File(BotConfiguration.PATH + "docs/NPC/Other/" + data[0] + ".xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(xml);
	        doc.getDocumentElement().normalize();
	        
	        Node node = doc.getElementsByTagName("Other").item(0);
	        
	        for(int i = 0;i < node.getChildNodes().getLength();i++) {
	        	Node N = node.getChildNodes().item(i);
	        	if(data.length == 1) {
	        		if(N.getNodeName().equalsIgnoreCase("quote")) {
	        			result = N.getTextContent();
	        			break;
	        		}
	        	} else {
	        		if(N.getNodeName().equalsIgnoreCase(data[1])) {
	        			Element eNode = (Element)N;
	        			if(data[1].equalsIgnoreCase("schedule") || data[1].equalsIgnoreCase("relationships")) {
	        				result = eNode.getElementsByTagName("desc").item(0).getTextContent().replace("\t", "");
	        				break;
	        			}
	        			if(data[1].equalsIgnoreCase("gifts")) {
	        				if(data.length != 3) {
	        					result = "Gifts subheader :\n"
	        							+ "- #love\n"
	        							+ "- #like\n"
	        							+ "- #neutral\n"
	        							+ "- #dislike\n"
	        							+ "- #hate";
	        					return;
	        				}
	        				if(!(data[2].equalsIgnoreCase("love") || 
	        					data[2].equalsIgnoreCase("like") ||
	        					data[2].equalsIgnoreCase("neutral") ||
	        					data[2].equalsIgnoreCase("dislike") ||
	        					data[2].equalsIgnoreCase("hate"))) {
	        					result = "Heart Events subheader :\n"
	        							+ "- #onehearts\n"
	        							+ "- #twohearts\n"
	        							+ "- #threehearts\n"
	        							+ "- #fourhearts\n"
	        							+ "- #fivehearts\n"
	        							+ "- #sixhearts\n"
	        							+ "- #sevenhearts\n"
	        							+ "- #eighthearts\n"
	        							+ "- #ninehearts\n"
	        							+ "- #tenhearts\n";
	        					return;
	        				}
	        				Element eChildNode = (Element)eNode.getElementsByTagName(data[2]).item(0);
	        				result = "**Quote**: " + eChildNode.getElementsByTagName("quote").item(0).getTextContent();
	        				result += "\n\n**Items**:" + eChildNode.getElementsByTagName("item").item(0).getTextContent().replace("\t", "");
	        				break;
	        			}
	        			
	        			if(data[1].equalsIgnoreCase("heartevents")) {
	        				if(data.length != 3) {
	        					result = "Heart Events subheader :\n"
	        							+ "- #onehearts\n"
	        							+ "- #twohearts\n"
	        							+ "- #threehearts\n"
	        							+ "- #fourhearts\n"
	        							+ "- #fivehearts\n"
	        							+ "- #sixhearts\n"
	        							+ "- #sevenhearts\n"
	        							+ "- #eighthearts\n"
	        							+ "- #ninehearts\n"
	        							+ "- #tenhearts\n";
	        					return;
	        				}
	        				if(!(data[2].equalsIgnoreCase("onehearts") ||
	        					data[2].equalsIgnoreCase("twohearts") ||
	        					data[2].equalsIgnoreCase("threehearts") ||
	        					data[2].equalsIgnoreCase("fourhearts") ||
	        					data[2].equalsIgnoreCase("fivehearts") ||
	        					data[2].equalsIgnoreCase("sixhearts") ||
	        					data[2].equalsIgnoreCase("sevenhearts") ||
	        					data[2].equalsIgnoreCase("eighthearts") ||
	        					data[2].equalsIgnoreCase("ninehearts") ||
	        					data[2].equalsIgnoreCase("tenhearts"))) {
	        					result = "Heart Events subheader :\n"
	        							+ "- #onehearts\n"
	        							+ "- #twohearts\n"
	        							+ "- #threehearts\n"
	        							+ "- #fourhearts\n"
	        							+ "- #fivehearts"
	        							+ "- #sixhearts"
	        							+ "- #sevenhearts"
	        							+ "- #eighthearts"
	        							+ "- #ninehearts"
	        							+ "- #tenhearts";
	        					return;
	        				}
	        				Element eChildNode = (Element)eNode.getElementsByTagName(data[2]).item(0);
	        				result = "**Event**\n " + eChildNode.getElementsByTagName("desc").item(0).getTextContent().replace("\t", "");
	        				break;
	        			}
	        		}
	        	}
	        }
	        result += "\n\n*Contributed by : " + node.getChildNodes().item(node.getChildNodes().getLength()-2).getTextContent().toString().replace("\n", "") + "*";
		} catch(Exception e) {
			result = "Terdapat error saat membaca files";
		}
	}
	
	public String getResult() {
		return result;
	}
	
	
}
