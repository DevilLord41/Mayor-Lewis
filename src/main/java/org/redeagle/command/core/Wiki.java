package org.redeagle.command.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import org.redeagle.command.Command;
import org.redeagle.docs.Bachelorettes;
import org.redeagle.docs.Bachelors;
import org.redeagle.docs.OtherNPC;
import org.redeagle.docs.Townspeople;

public class Wiki extends Command {
	
	ArrayList<String> npcBachelor = bachelorList();
	ArrayList<String> npcBachelorette = bacheloretteList();
	ArrayList<String> npcTownspeople = townspeopleList();
	ArrayList<String> npcOther = otherList();

	@Override
	public String getName() {
		return "wiki";
	}

	@Override
	public String getDescription() {
		return "Wikipedia untuk game, gunakan !wiki tag#subhead contoh :\n"
				+ "`!wiki Alex\n"
				+ "`!wiki Alex#Relationship`\n"
				+ "`!wiki Alex#HeartEvents#TwoHearts`\n"
				+ "`!wiki Spring#Crops`\n"
				+ "`!wiki Alex#Gifts#Neutral`\n"
				+ "Hampir semua garis besar pada https://stardewvalleywiki.com/ bisa digunakan pada command ini.";
	}

	@Override
	public List<String> getParameter() {
		return Arrays.asList("wikiPageName","#subHeader (optional)");
	}

	@Override
	public List<String> getAliases() {
		return Arrays.asList("w","gp","wp","docs");
	}

	@Override
	public boolean ownerOnly() {
		return false;
	}

	@Override
	public void onExecute(JDA bot, GuildMessageReceivedEvent e, Message msg,String m, User u, Guild g, String... args) {
		String[] data = args[1].split("#");
		for(String D : npcBachelor) {
			if(D.equals(data[0])) {
				Bachelors docs = new Bachelors(bot, e, data);
				docs.buildDocs();
				if(docs.getResult().equals("")) break;
				e.getChannel().sendMessage(docs.getResult()).queue();
				return;
			}
		}
		
		for(String D : npcBachelorette) {
			if(D.equals(data[0])) {
				Bachelorettes docs = new Bachelorettes(bot, e, data);
				docs.buildDocs();
				if(docs.getResult().equals("")) break;
				e.getChannel().sendMessage(docs.getResult()).queue();
				return;
			}
		}
		
		for(String D : npcTownspeople) {
			if(D.equals(data[0])) {
				Townspeople docs = new Townspeople(bot, e, data);
				docs.buildDocs();
				if(docs.getResult().equals("")) break;
				e.getChannel().sendMessage(docs.getResult()).queue();
				return;
			}
		}
		
		for(String D : npcOther) {
			if(D.equals(data[0])) {
				OtherNPC docs = new OtherNPC(bot, e, data);
				docs.buildDocs();
				if(docs.getResult().equals("")) break;
				e.getChannel().sendMessage(docs.getResult()).queue();
				return;
			}
		}
		
		e.getChannel().sendMessage("Tidak ada data dengan tag : " + args[1]).queue();
	}
	
	public ArrayList<String> bachelorList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Alex");
		list.add("Elliot");
		list.add("Sebastian");
		list.add("Harvey");
		list.add("Sam");
		list.add("Shane");
		return list;
	}
	
	public ArrayList<String> townspeopleList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Caroline");
		list.add("Clint");
		list.add("Demetrius");
		list.add("Dwarf");
		list.add("Evelyn");
		list.add("George");
		list.add("Gus");
		list.add("Jas");
		list.add("Jodi");
		list.add("Kent");
		list.add("Krobus");
		list.add("Linus");
		list.add("Lewis");
		list.add("Marnie");
		list.add("Pan");
		list.add("Pierre");
		list.add("Robin");
		list.add("Sandy");
		list.add("Vincent");
		list.add("Willy");
		list.add("Wizard");
		
		return list;
	}	
	
	public ArrayList<String> bacheloretteList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Abigail");
		list.add("Emily");
		list.add("Haley");
		list.add("Leah");
		list.add("Maru");
		list.add("Penny");
		return list;
	}	
	
	public ArrayList<String> otherList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Bouncer");
		list.add("Gil");
		list.add("Governor");
		list.add("Grandpa");
		list.add("Gunther");
		list.add("Henchman");
		list.add("Marlon");
		list.add("Morris");
		list.add("Mrqi");	
		return list;
	}	

}
