package xyz.olivermartin.multichat.bungee.commands;

import com.olivermartin410.plugins.TGroupChatInfo;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import xyz.olivermartin.multichat.bungee.ChatControl;
import xyz.olivermartin.multichat.bungee.ChatManipulation;
import xyz.olivermartin.multichat.bungee.ConfigManager;
import xyz.olivermartin.multichat.bungee.Events;
import xyz.olivermartin.multichat.bungee.MessageManager;
import xyz.olivermartin.multichat.bungee.MultiChat;

/**
 * Group Chat Messaging Command
 * <p>Allows players to send a message direct to a group chat or toggle group chats</p>
 * 
 * @author Oliver Martin (Revilo410)
 *
 */
public class GCCommand extends Command {

	private static String[] aliases = new String[] {};

	public GCCommand() {
		super("gc", "multichat.group", aliases);
	}

	public void execute(CommandSender sender, String[] args) {

		if (args.length < 1) {

			if ((sender instanceof ProxiedPlayer)) {

				ProxiedPlayer player = (ProxiedPlayer)sender;
				boolean toggleresult = Events.toggleGC(player.getUniqueId());

				if (toggleresult == true) {
					MessageManager.sendMessage(sender, "command_gc_toggle_on");
				} else {
					MessageManager.sendMessage(sender, "command_gc_toggle_off");
				}

			} else {

				MessageManager.sendMessage(sender, "command_gc_only_players_toggle");
			}

		} else if ((sender instanceof ProxiedPlayer)) {

			ProxiedPlayer player = (ProxiedPlayer)sender;

			if (MultiChat.viewedchats.get(player.getUniqueId()) != null) {

				String groupName = (String)MultiChat.viewedchats.get(player.getUniqueId());

				if (MultiChat.groupchats.containsKey(groupName)) {

					TGroupChatInfo groupInfo = (TGroupChatInfo) MultiChat.groupchats.get(groupName);

					String message = "";
					for (String arg : args) {
						message = message + arg + " ";
					}

					String playerName = sender.getName();

					if ((groupInfo.getFormal() == true)
							&& (groupInfo.getAdmins().contains(player.getUniqueId()))) {
						playerName = "&o" + playerName;
					}

					sendMessage(message, playerName, groupInfo);

				} else {

					MessageManager.sendMessage(sender, "command_gc_no_longer_exists");
				}

			} else {
				MessageManager.sendMessage(sender, "command_gc_no_chat_selected");
			}

		} else {
			MessageManager.sendMessage(sender, "command_gc_only_players_speak");
		}
	}

	public static void sendMessage(String message, String playerName, TGroupChatInfo groupInfo) {

		ChatManipulation chatfix = new ChatManipulation();

		message = ChatControl.applyChatRules(message, "group_chats");

		String messageFormat = ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("groupchat.format");
		message = chatfix.replaceGroupChatVars(messageFormat, playerName, message, groupInfo.getName());

		for (ProxiedPlayer onlineplayer : ProxyServer.getInstance().getPlayers()) {

			if (((groupInfo.existsViewer(onlineplayer.getUniqueId())) && (onlineplayer.hasPermission("multichat.group"))) || ((MultiChat.allspy.contains(onlineplayer.getUniqueId())) && (onlineplayer.hasPermission("multichat.staff.spy")))) {
				onlineplayer.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', message)));
			}

		}

		String groupName = groupInfo.getName();

		System.out.println("\033[32m[MultiChat] /gc {" + groupName.toUpperCase() + "} {" + playerName + "}  " + message);
	}
}
