package xyz.olivermartin.multichat.bungee;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class GlobalChannel extends Channel {
	public GlobalChannel(String format) {
		super("global", format, false, false);
	}

	public void sendMessage(ProxiedPlayer sender, String message, String format) {
		super.sendMessage(sender, message, format);
	}

}
