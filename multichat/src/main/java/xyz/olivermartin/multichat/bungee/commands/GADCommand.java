package xyz.olivermartin.multichat.bungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import xyz.olivermartin.multichat.bungee.DebugManager;
import xyz.olivermartin.multichat.bungee.Events;
import xyz.olivermartin.multichat.bungee.MessageManager;
import xyz.olivermartin.multichat.bungee.MultiChatUtil;
import xyz.olivermartin.multichat.bungee.StaffChatManager;

/**
 * Admin-Chat command
 * <p>Allows the user to toggle / send a message to admin-chat</p>
 * 
 * @author Oliver Martin (Revilo410)
 *
 */
public class GADCommand extends Command {

	private static String[] aliases = new String[] {};

	public GADCommand() {
		super("gad", "multichat.staff.admin", aliases);
	}

	public void execute(CommandSender sender, String[] args) {

		boolean toggleresult;

		if (args.length < 1) {

			if ((sender instanceof ProxiedPlayer)) {

				DebugManager.log("[GADCommand] Command sender is a player");

				ProxiedPlayer player = (ProxiedPlayer)sender;
				toggleresult = Events.toggleGAD(player.getUniqueId());

				DebugManager.log("[GADCommand] AC new toggle state: " + toggleresult);

				if (toggleresult == true) {
					MessageManager.sendMessage(sender, "command_gad_toggle_on");
				} else {
					MessageManager.sendMessage(sender, "command_gad_toggle_off");
				}

			} else {

				MessageManager.sendMessage(sender, "command_gad_only_players");

			}

		} else if ((sender instanceof ProxiedPlayer)) {

			DebugManager.log("[GADCommand] Command sender is a player");

			String message = MultiChatUtil.getMessageFromArgs(args);

			ProxiedPlayer player = (ProxiedPlayer)sender;
			StaffChatManager chatman = new StaffChatManager();

			DebugManager.log("[GADCommand] Next line of code will send the message, if no errors, then it worked!");

			chatman.sendAdminMessage(player.getName(), player.getDisplayName(), player.getServer().getInfo().getName(), message);
			chatman = null;

		} else {

			DebugManager.log("[GADCommand] Command sender is the console");

			String message = MultiChatUtil.getMessageFromArgs(args);

			StaffChatManager chatman = new StaffChatManager();

			DebugManager.log("[GADCommand] Next line of code will send the message, if no errors, then it worked!");

			chatman.sendAdminMessage("CONSOLE", "CONSOLE", "#", message);
			chatman = null;

		}
	}
}
