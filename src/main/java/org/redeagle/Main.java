package org.redeagle;
import java.io.IOException;
import java.util.Random;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import org.redeagle.command.CommandHandler;
import org.redeagle.command.core.Help;
import org.redeagle.command.core.Level;
import org.redeagle.command.core.Rank;
import org.redeagle.command.core.Wiki;
import org.redeagle.sqlmanager.SQLManager;

public class Main extends ListenerAdapter {
	public JDA bot;
	public static SQLManager database;
	public static CommandHandler commandHandle = new CommandHandler();
	
	public static CommandHandler getCommandHandler() {
		return commandHandle;
	}

	
	public static SQLManager getDB() {
		return database;
	}
	
	public static void main(String[] args) throws LoginException, RateLimitedException, InterruptedException, IOException {
		registerCommand();
		BotConfiguration.configure();
		
		database = new SQLManager();
		JDA bot = new JDABuilder(AccountType.BOT).setToken(BotConfiguration.BOT_TOKEN).build();
		bot.addEventListener(new Main(bot));
		bot.getPresence().setGame(Game.listening("Lucione | !help"));
	}  
	
	public Main(JDA bot) {
		this.bot = bot;
	}
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if (event.getAuthor().isBot()) return;
		if (event.getMessage().getContentRaw().startsWith(BotConfiguration.BOT_PREFIX)) {
			commandHandle.handle(event, bot);
		}
		if(event.getChannel().getId().equals("558651415241949204") || event.getChannel().getId().equals("560707847264927795")) {
			
			if(Main.getDB().select("userdata", "xp", "where discordId='" + event.getAuthor().getId() + "'").size() == 0) {
				Main.getDB().insert("INSERT INTO userdata VALUES('" + event.getAuthor().getId() + "','0')");
			}
			int xp = Integer.parseInt(Main.getDB().select("userdata", "xp", "where discordId='" + event.getAuthor().getId() + "'").get(0));
			Random rnd = new Random();
			xp += rnd.nextInt(3);
			Main.getDB().update("UPDATE userdata SET xp='" + xp + "' where discordId='" + event.getAuthor().getId() + "'");
				
			if(xp > 35000) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650871729618959"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650871729618959")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Farm King**").queue();
				}
			} else if(xp > 22500) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650875223343140"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650875223343140")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Cropmaster**").queue();
				}
			} else if(xp > 15000) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650875726921745"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650875726921745")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Agriculturist**").queue();	
				}
			} else if(xp > 12000) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650876557262868"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650876557262868")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Farmer**").queue();
				}
			} else if(xp > 9000) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650876938813442"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650876938813442")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Rancher**").queue();
				}
			} else if(xp > 7800) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650884874698773"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650884874698773")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Planter**").queue();
				}
			} else if(xp > 6000) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650885621284864"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650885621284864")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Granger**").queue();
				}
			} else if(xp > 4500) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650886200098817"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650886200098817")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Farmboy**").queue();
				}
			} else if(xp > 3300) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650886535512090"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650886535512090")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Sodbuster**").queue();
				}
			} else if(xp > 2250) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650887273840643"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650887273840643")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Smallholder**").queue();
				}
			} else if(xp > 1500) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650888016101386"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650888016101386")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Tiller**").queue();
				}
			} else if(xp > 1000) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650888188067874"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650888188067874")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Farmhand**").queue();
				}
			} else if(xp > 600) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562650888938717201"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562650888938717201")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Cowpoke**").queue();
				}
			} else if(xp > 350) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562651376212246560"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562651376212246560")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Bumpkin**").queue();
				}
			} else if(xp > 150) {
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById("562651378460131335"))) {
					event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("562651378460131335")).queue();
					event.getChannel().sendMessage(event.getMember().getAsMention() + ", Selamat anda telah naik ke **Greenhorn**").queue();
				}
			}
		}
	}

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("558636017972936704")).queue();
		event.getGuild().getTextChannelById("558512212814069760").sendMessage("Hello " + event.getMember().getAsMention() + ", Selamat datang di discord **Stardew Valley Indonesia** :tada: :hugging: !").queue();
		Main.getDB().insert("INSERT INTO userdata VALUES('" + event.getUser().getId() + "','0')");
	}

	public static void registerCommand() {	
		commandHandle.register(new Help());
		commandHandle.register(new Rank());
		commandHandle.register(new Wiki());
		commandHandle.register(new Level());
	}
}