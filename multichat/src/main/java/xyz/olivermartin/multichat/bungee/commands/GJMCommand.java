package xyz.olivermartin.multichat.bungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import xyz.olivermartin.multichat.bungee.Events;
import xyz.olivermartin.multichat.bungee.MessageManager;
import xyz.olivermartin.multichat.bungee.MultiChatUtil;
import xyz.olivermartin.multichat.bungee.StaffChatManager;

/**
 * Mod-Chat Commands
 * <p>Allows staff members to send mod-chat messages or toggle the chat</p>
 * 
 * @author Oliver Martin (Revilo410)
 *
 */
public class GJMCommand extends Command {

	private static String[] aliases = new String[] {};

	public GJMCommand() {
		super("gjm", "multichat.staff.jmod", aliases);
	}

	public void execute(CommandSender sender, String[] args) {

		boolean toggleresult;

		if (args.length < 1) {

			if ((sender instanceof ProxiedPlayer)) {

				ProxiedPlayer player = (ProxiedPlayer) sender;
				toggleresult = Events.toggleMC(player.getUniqueId());

				if (toggleresult == true) {
					MessageManager.sendMessage(sender, "command_gjm_toggle_on");
				} else {
					MessageManager.sendMessage(sender, "command_gjm_toggle_off");
				}

			} else {
				MessageManager.sendMessage(sender, "command_mcc_only_players");
			}

		} else if ((sender instanceof ProxiedPlayer)) {

			String message = MultiChatUtil.getMessageFromArgs(args);

			ProxiedPlayer player = (ProxiedPlayer) sender;

			StaffChatManager chatman = new StaffChatManager();
			chatman.sendJModMessage(player.getName(), player.getDisplayName(), player.getServer().getInfo().getName(), message);
			chatman = null;

		} else {

			String message = MultiChatUtil.getMessageFromArgs(args);

			StaffChatManager chatman = new StaffChatManager();
			chatman.sendModMessage("CONSOLE", "CONSOLE", "#", message);
			chatman = null;
		}
	}
}
