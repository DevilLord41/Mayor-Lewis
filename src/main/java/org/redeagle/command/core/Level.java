package org.redeagle.command.core;

import java.util.List;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import org.redeagle.Main;
import org.redeagle.command.Command;

public class Level extends Command {

	@Override
	public String getName() {
		return "level";
	}

	@Override
	public String getDescription() {
		return "Digunakan untuk check XP anda";
	}

	@Override
	public List<String> getParameter() {
		return super.getParameter();
	}

	@Override
	public List<String> getAliases() {
		return super.getAliases();
	}

	@Override
	public boolean ownerOnly() {
		return false;
	}

	@Override
	public void onExecute(JDA bot, GuildMessageReceivedEvent e, Message msg, String m, User u, Guild g, String... args) {
		int xp = Integer.parseInt(Main.getDB().select("userdata", "xp", "where discordId='" + u.getId() + "'").get(0));
		String sent = "XP : " + xp;
		if(xp <= 150) {
			sent+= "/150";
			sent+= "\nRank : **Newcomer**";
		} else if(xp <= 350) {
			sent+= "/350";
			sent+= "\nRank : **Greenhorn**";
		} else if(xp <= 600) {
			sent+= "/600";
			sent+= "\nRank : **Bumpkin**";
		} else if(xp <= 1000) {
			sent+= "/1000";
			sent+= "\nRank : **Cowpoke**";
		} else if(xp <= 1500) {
			sent+= "/1500";
			sent+= "\nRank : **Farmhand**";
		} else if(xp <= 2250) {
			sent+= "/2250";
			sent+= "\nRank : **Tiller**";
		} else if(xp <= 3300) {
			sent+= "/3300";
			sent+= "\nRank : **Smallholder**";
		} else if(xp <= 4500) {
			sent+= "/4500";
			sent+= "\nRank : **Sodbuster**";
		} else if(xp <= 6000) {
			sent+= "/6000";
			sent+= "\nRank : **Farmboy**";
		} else if(xp <= 7800) {
			sent+= "/7800";
			sent+= "\nRank : **Granger**";
		} else if(xp <= 9000) {
			sent+= "/9000";
			sent+= "\nRank : **Planter**";
		} else if(xp <= 12000) {
			sent+= "/12000";
			sent+= "\nRank : **Rancher**";
		} else if(xp <= 15000) {
			sent+= "/15000";
			sent+= "\nRank : **Farmer**";
		} else if(xp <= 22500) {
			sent+= "/22500";
			sent+= "\nRank : **Agriculturist**";
		} else if(xp <= 35000) {
			sent+= "/35000";
			sent+= "\nRank : **Cropmaster**";
		} else if(xp > 35000) {
			sent+= "/9999999";
			sent+= "\nRank : **Farmking**";
		}
		
		e.getChannel().sendMessage(sent).queue();
	}

}
