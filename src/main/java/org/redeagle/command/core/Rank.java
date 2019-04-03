package org.redeagle.command.core;

import java.util.Arrays;
import java.util.List;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import org.redeagle.command.Command;

public class Rank extends Command {

	@Override
	public String getName() {
		return "rank";
	}

	@Override
	public String getDescription() {
		return "Menampilkan informasi rank";
	}

	@Override
	public List<String> getParameter() {
		return Arrays.asList("rankname");
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
	public void onExecute(JDA bot, GuildMessageReceivedEvent e, Message msg,
			String m, User u, Guild g, String... args) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Informasi Rank");
		eb.setDescription("Rank pada server ini, didapatkan dengan cara mencapai level tertentu dengan chatting.\n"
				+ "Rank disini berupa roles pada discord.\n"
				+ "Terdapat 16 rank tersedia, yaitu:");
		eb.addField("Farm King", "xp > 35000", false);
		eb.addField("Cropmaster", "xp > 22500", false);
		eb.addField("Agriculturist", "xp > 15000", false);
		eb.addField("Farmer", "xp > 12000", false);
		eb.addField("Rancher", "xp > 9000", false);
		eb.addField("Planter", "xp > 7800", false);
		eb.addField("Granger", "xp > 6000", false);
		eb.addField("Farmboy", "xp > 4500", false);
		eb.addField("Sodbuster", "xp > 3300", false);
		eb.addField("Smallholder", "xp > 2250", false);
		eb.addField("Tiller", "xp > 1500", false);
		eb.addField("Farmhand", "xp > 1000", false);
		eb.addField("Cowpoke", "xp > 600", false);
		eb.addField("Bumpkin", "xp > 350", false);
		eb.addField("Greenhorn", "xp > 150", false);
		eb.addField("Newcomer", "xp <= 150", false);

		e.getChannel().sendMessage(eb.build()).queue();
	}

}
