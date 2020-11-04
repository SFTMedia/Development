package xyz.olivermartin.multichat.bungee;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class GlobalChannel extends Channel {
	boolean send=true;
	public GlobalChannel(String format) {
		super("global", format, false, false);
	}

	public void sendMessage(ProxiedPlayer sender, String message, String format) {
		if(send){
			super.sendMessage(sender, message, format);
		}
	}

	public void setSend(boolean boolean1) {
		send=boolean1;
	}

}
