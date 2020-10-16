package xyz.olivermartin.multichat.bungee;

import java.util.Optional;

import com.olivermartin410.plugins.TChatInfo;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import xyz.olivermartin.multichat.bungee.events.PostStaffChatEvent;

/**
 * Staff Chat Manager
 * <p>Manages chat input to the staff chats, both mod and admin</p>
 * 
 * @author Oliver Martin (Revilo410)
 */
public class StaffChatManager {
	public void sendJModMessage(String username, String displayname, String server, String message) {

		message = MultiChatUtil.reformatRGB(message);

		ChatManipulation chatfix = new ChatManipulation();
		String messageFormat = ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("jmodchat.format");
		String original = message;

		Optional<String> crm;

		crm = ChatControl.applyChatRules(original, "staff_chats", username);

		if (crm.isPresent()) {
			original = crm.get();
		} else {
			return;
		}

		for (ProxiedPlayer onlineplayer : ProxyServer.getInstance().getPlayers()) {

			if (onlineplayer.hasPermission("multichat.staff.jmod")) {

				if (!MultiChat.jmodchatpreferences.containsKey(onlineplayer.getUniqueId())) {

					TChatInfo chatinfo = new TChatInfo();
					chatinfo.setChatColor(ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("jmodchat.ccdefault").toCharArray()[0]);
					chatinfo.setNameColor(ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("jmodchat.ncdefault").toCharArray()[0]);

					MultiChat.jmodchatpreferences.put(onlineplayer.getUniqueId(), chatinfo);

				}

				message = chatfix.replaceJModChatVars(messageFormat, username, displayname, server, original, onlineplayer);
				if (MultiChat.legacyServers.contains(onlineplayer.getServer().getInfo().getName())) {
					onlineplayer.sendMessage(TextComponent.fromLegacyText(MultiChatUtil.approximateHexCodes(ChatColor.translateAlternateColorCodes('&', message))));
				} else {
					onlineplayer.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', message)));
				}

			}
		}

		// Trigger PostStaffChatEvent
		if (username.equalsIgnoreCase("console")) {
			ProxyServer.getInstance().getPluginManager().callEvent(new PostStaffChatEvent("jmod", ProxyServer.getInstance().getConsole() , original));
		} else {
			if (ProxyServer.getInstance().getPlayer(username) != null) {
				ProxyServer.getInstance().getPluginManager().callEvent(new PostStaffChatEvent("jmod", ProxyServer.getInstance().getPlayer(username) , original));
			}
		}

		ConsoleManager.logJModChat("(" + username + ") " + original);

	}
	public void sendModMessage(String username, String displayname, String server, String message) {

		message = MultiChatUtil.reformatRGB(message);

		ChatManipulation chatfix = new ChatManipulation();
		String messageFormat = ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("modchat.format");
		String original = message;

		Optional<String> crm;

		crm = ChatControl.applyChatRules(original, "staff_chats", username);

		if (crm.isPresent()) {
			original = crm.get();
		} else {
			return;
		}

		for (ProxiedPlayer onlineplayer : ProxyServer.getInstance().getPlayers()) {

			if (onlineplayer.hasPermission("multichat.staff.mod")) {

				if (!MultiChat.modchatpreferences.containsKey(onlineplayer.getUniqueId())) {

					TChatInfo chatinfo = new TChatInfo();
					chatinfo.setChatColor(ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("modchat.ccdefault").toCharArray()[0]);
					chatinfo.setNameColor(ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("modchat.ncdefault").toCharArray()[0]);

					MultiChat.modchatpreferences.put(onlineplayer.getUniqueId(), chatinfo);

				}

				message = chatfix.replaceModChatVars(messageFormat, username, displayname, server, original, onlineplayer);
				if (MultiChat.legacyServers.contains(onlineplayer.getServer().getInfo().getName())) {
					onlineplayer.sendMessage(TextComponent.fromLegacyText(MultiChatUtil.approximateHexCodes(ChatColor.translateAlternateColorCodes('&', message))));
				} else {
					onlineplayer.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', message)));
				}

			}
		}

		// Trigger PostStaffChatEvent
		if (username.equalsIgnoreCase("console")) {
			ProxyServer.getInstance().getPluginManager().callEvent(new PostStaffChatEvent("mod", ProxyServer.getInstance().getConsole() , original));
		} else {
			if (ProxyServer.getInstance().getPlayer(username) != null) {
				ProxyServer.getInstance().getPluginManager().callEvent(new PostStaffChatEvent("mod", ProxyServer.getInstance().getPlayer(username) , original));
			}
		}

		ConsoleManager.logModChat("(" + username + ") " + original);

	}

	public void sendManagerMessage(String username, String displayname, String server, String message) {

		message = MultiChatUtil.reformatRGB(message);

		ChatManipulation chatfix = new ChatManipulation();
		String messageFormat = ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("managerchat.format");
		String original = message;

		Optional<String> crm;

		crm = ChatControl.applyChatRules(original, "staff_chats", username);

		if (crm.isPresent()) {
			original = crm.get();
		} else {
			return;
		}

		for (ProxiedPlayer onlineplayer : ProxyServer.getInstance().getPlayers()) {

			if (onlineplayer.hasPermission("multichat.staff.manager")) {

				if (!MultiChat.managerchatpreferences.containsKey(onlineplayer.getUniqueId())) {

					TChatInfo chatinfo = new TChatInfo();
					chatinfo.setChatColor(ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("managerchat.ccdefault").toCharArray()[0]);
					chatinfo.setNameColor(ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("managerchat.ncdefault").toCharArray()[0]);

					MultiChat.managerchatpreferences.put(onlineplayer.getUniqueId(), chatinfo);

				}

				message = chatfix.replaceManagerChatVars(messageFormat, username, displayname, server, original, onlineplayer);
				if (MultiChat.legacyServers.contains(onlineplayer.getServer().getInfo().getName())) {
					onlineplayer.sendMessage(TextComponent.fromLegacyText(MultiChatUtil.approximateHexCodes(ChatColor.translateAlternateColorCodes('&', message))));
				} else {
					onlineplayer.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', message)));
				}

			}
		}

		// Trigger PostStaffChatEvent
		if (username.equalsIgnoreCase("console")) {
			ProxyServer.getInstance().getPluginManager().callEvent(new PostStaffChatEvent("manager", ProxyServer.getInstance().getConsole() , original));
		} else {
			if (ProxyServer.getInstance().getPlayer(username) != null) {
				ProxyServer.getInstance().getPluginManager().callEvent(new PostStaffChatEvent("manager", ProxyServer.getInstance().getPlayer(username) , original));
			}
		}

		ConsoleManager.logManagerChat("(" + username + ") " + original);

	}

	public void sendAdminMessage(String username, String displayname, String server, String message) {

		message = MultiChatUtil.reformatRGB(message);

		String original = message;
		ChatManipulation chatfix = new ChatManipulation();
		String messageFormat = ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("adminchat.format");

		Optional<String> crm;

		crm = ChatControl.applyChatRules(original, "staff_chats", username);

		if (crm.isPresent()) {
			original = crm.get();
		} else {
			return;
		}

		for (ProxiedPlayer onlineplayer : ProxyServer.getInstance().getPlayers()) {

			if (onlineplayer.hasPermission("multichat.staff.admin")) {

				if (!MultiChat.adminchatpreferences.containsKey(onlineplayer.getUniqueId())) {

					TChatInfo chatinfo = new TChatInfo();
					chatinfo.setChatColor(ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("adminchat.ccdefault").toCharArray()[0]);
					chatinfo.setNameColor(ConfigManager.getInstance().getHandler("config.yml").getConfig().getString("adminchat.ncdefault").toCharArray()[0]);

					MultiChat.adminchatpreferences.put(onlineplayer.getUniqueId(), chatinfo);

				}

				message = chatfix.replaceAdminChatVars(messageFormat, username, displayname, server, original, onlineplayer);
				if (MultiChat.legacyServers.contains(onlineplayer.getServer().getInfo().getName())) {
					onlineplayer.sendMessage(TextComponent.fromLegacyText(MultiChatUtil.approximateHexCodes(ChatColor.translateAlternateColorCodes('&', message))));
				} else {
					onlineplayer.sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', message)));
				}

			}
		}

		// Trigger PostStaffChatEvent
		if (username.equalsIgnoreCase("console")) {
			ProxyServer.getInstance().getPluginManager().callEvent(new PostStaffChatEvent("admin", ProxyServer.getInstance().getConsole() , original));
		} else {
			if (ProxyServer.getInstance().getPlayer(username) != null) {
				ProxyServer.getInstance().getPluginManager().callEvent(new PostStaffChatEvent("admin", ProxyServer.getInstance().getPlayer(username) , original));
			}
		}

		ConsoleManager.logAdminChat("(" + username + ") " + original);

	}
}
