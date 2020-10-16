package xyz.olivermartin.multichat.bungee;

import net.md_5.bungee.api.plugin.Command;
import xyz.olivermartin.multichat.bungee.commands.ACCCommand;
import xyz.olivermartin.multichat.bungee.commands.ACCommand;
import xyz.olivermartin.multichat.bungee.commands.AnnouncementCommand;
import xyz.olivermartin.multichat.bungee.commands.BulletinCommand;
import xyz.olivermartin.multichat.bungee.commands.CastCommand;
import xyz.olivermartin.multichat.bungee.commands.ChannelCommand;
import xyz.olivermartin.multichat.bungee.commands.ClearChatCommand;
import xyz.olivermartin.multichat.bungee.commands.DisplayCommand;
import xyz.olivermartin.multichat.bungee.commands.FreezeChatCommand;
import xyz.olivermartin.multichat.bungee.commands.GCCommand;
import xyz.olivermartin.multichat.bungee.commands.GlobalCommand;
import xyz.olivermartin.multichat.bungee.commands.GroupCommand;
import xyz.olivermartin.multichat.bungee.commands.GroupListCommand;
import xyz.olivermartin.multichat.bungee.commands.HelpMeCommand;
import xyz.olivermartin.multichat.bungee.commands.IgnoreCommand;
import xyz.olivermartin.multichat.bungee.commands.LocalCommand;
import xyz.olivermartin.multichat.bungee.commands.GJMCommand;
import xyz.olivermartin.multichat.bungee.commands.GJMCCommand;
import xyz.olivermartin.multichat.bungee.commands.GMOCommand;
import xyz.olivermartin.multichat.bungee.commands.GMOCCommand;
import xyz.olivermartin.multichat.bungee.commands.GMANCommand;
import xyz.olivermartin.multichat.bungee.commands.GMANCCommand;
import xyz.olivermartin.multichat.bungee.commands.MsgCommand;
import xyz.olivermartin.multichat.bungee.commands.MultiChatBypassCommand;
import xyz.olivermartin.multichat.bungee.commands.MultiChatCommand;
import xyz.olivermartin.multichat.bungee.commands.MuteCommand;
import xyz.olivermartin.multichat.bungee.commands.ReplyCommand;
import xyz.olivermartin.multichat.bungee.commands.SocialSpyCommand;
import xyz.olivermartin.multichat.bungee.commands.StaffListCommand;
import xyz.olivermartin.multichat.bungee.commands.UseCastCommand;

public class CommandManager {

	static {

		acc = new ACCCommand();
		ac = new ACCommand();
		announcement = new AnnouncementCommand();
		bulletin = new BulletinCommand();
		cast = new CastCommand();
		channel = new ChannelCommand();
		clearchat = new ClearChatCommand();
		display = new DisplayCommand();
		freezechat = new FreezeChatCommand();
		gc = new GCCommand();
		global = new GlobalCommand();
		group = new GroupCommand();
		grouplist = new GroupListCommand();
		helpme = new HelpMeCommand();
		ignore = new IgnoreCommand();
		local = new LocalCommand();
		gjm = new GJMCommand();
		gjmc = new GJMCommand();
		gmo = new GMOCommand();
		gmoc = new GMOCCommand();
		gman = new GMANCommand();
		gmanc = new GMANCCommand();
		msg = new MsgCommand();
		multichat = new MultiChatCommand();
		multichatbypass = new MultiChatBypassCommand();
		mute = new MuteCommand();
		reply = new ReplyCommand();
		socialspy = new SocialSpyCommand();
		stafflist = new StaffListCommand();
		usecast = new UseCastCommand();

	}

	private static Command acc;
	private static Command ac;
	private static Command announcement;
	private static Command bulletin;
	private static Command cast;
	private static Command channel;
	private static Command clearchat;
	private static Command display;
	private static Command freezechat;
	private static Command gc;
	private static Command global;
	private static Command group;
	private static Command grouplist;
	private static Command helpme;
	private static Command ignore;
	private static Command local;
	private static Command gjm;
	private static Command gjmc;
	private static Command gmo;
	private static Command gmoc;
	private static Command gman;
	private static Command gmanc;
	private static Command msg;
	private static Command multichat;
	private static Command multichatbypass;

	private static Command mute;
	private static Command reply;
	private static Command socialspy;
	private static Command stafflist;
	private static Command usecast;

	/**
	 * @return the acc
	 */
	public static Command getAcc() {
		return acc;
	}
	/**
	 * @param acc the acc to set
	 */
	public static void setAcc(Command acc) {
		CommandManager.acc = acc;
	}
	/**
	 * @return the ac
	 */
	public static Command getAc() {
		return ac;
	}
	/**
	 * @param ac the ac to set
	 */
	public static void setAc(Command ac) {
		CommandManager.ac = ac;
	}
	/**
	 * @return the announcement
	 */
	public static Command getAnnouncement() {
		return announcement;
	}
	/**
	 * @param announcement the announcement to set
	 */
	public static void setAnnouncement(Command announcement) {
		CommandManager.announcement = announcement;
	}
	/**
	 * @return the bulletin
	 */
	public static Command getBulletin() {
		return bulletin;
	}
	/**
	 * @param bulletin the bulletin to set
	 */
	public static void setBulletin(Command bulletin) {
		CommandManager.bulletin = bulletin;
	}
	/**
	 * @return the cast
	 */
	public static Command getCast() {
		return cast;
	}
	/**
	 * @param cast the cast to set
	 */
	public static void setCast(Command cast) {
		CommandManager.cast = cast;
	}

	/**
	 * @return the channel
	 */
	public static Command getChannel() {
		return channel;
	}
	/**
	 * @param cast the cast to set
	 */
	public static void setChannel(Command channel) {
		CommandManager.channel = channel;
	}

	/**
	 * @return the clearchat
	 */
	public static Command getClearchat() {
		return clearchat;
	}
	/**
	 * @param clearchat the clearchat to set
	 */
	public static void setClearchat(Command clearchat) {
		CommandManager.clearchat = clearchat;
	}
	/**
	 * @return the display
	 */
	public static Command getDisplay() {
		return display;
	}
	/**
	 * @param display the display to set
	 */
	public static void setDisplay(Command display) {
		CommandManager.display = display;
	}
	/**
	 * @return the freezechat
	 */
	public static Command getFreezechat() {
		return freezechat;
	}
	/**
	 * @param freezechat the freezechat to set
	 */
	public static void setFreezechat(Command freezechat) {
		CommandManager.freezechat = freezechat;
	}
	/**
	 * @return the gc
	 */
	public static Command getGc() {
		return gc;
	}
	/**
	 * @param gc the gc to set
	 */
	public static void setGc(Command gc) {
		CommandManager.gc = gc;
	}
	/**
	 * @return the global
	 */
	public static Command getGlobal() {
		return global;
	}
	/**
	 * @param global the global to set
	 */
	public static void setGlobal(Command global) {
		CommandManager.global = global;
	}
	/**
	 * @return the group
	 */
	public static Command getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public static void setGroup(Command group) {
		CommandManager.group = group;
	}
	/**
	 * @return the grouplist
	 */
	public static Command getGrouplist() {
		return grouplist;
	}
	/**
	 * @param grouplist the grouplist to set
	 */
	public static void setGrouplist(Command grouplist) {
		CommandManager.grouplist = grouplist;
	}
	/**
	 * @return the helpme
	 */
	public static Command getHelpme() {
		return helpme;
	}
	/**
	 * @param helpme the helpme to set
	 */
	public static void setHelpme(Command helpme) {
		CommandManager.helpme = helpme;
	}
	/**
	 * @return the ignore
	 */
	public static Command getIgnore() {
		return ignore;
	}
	/**
	 * @param ignore the ignore to set
	 */
	public static void setIgnore(Command ignore) {
		CommandManager.ignore = ignore;
	}
	/**
	 * @return the local
	 */
	public static Command getLocal() {
		return local;
	}
	/**
	 * @param local the local to set
	 */
	public static void setLocal(Command local) {
		CommandManager.local = local;
	}
	/**
	 * @return the msg
	 */
	public static Command getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public static void setMsg(Command msg) {
		CommandManager.msg = msg;
	}
	/**
	 * @return the multichat
	 */
	public static Command getMultichat() {
		return multichat;
	}
	/**
	 * @param multichat the multichat to set
	 */
	public static void setMultichat(Command multichat) {
		CommandManager.multichat = multichat;
	}
	/**
	 * @return the multichatbypass
	 */
	public static Command getMultichatBypass() {
		return multichatbypass;
	}
	/**
	 * @param multichatbypass the multichatbypass to set
	 */
	public static void setMultichatBypass(Command multichatbypass) {
		CommandManager.multichatbypass = multichatbypass;
	}
	/**
	 * @return the mute
	 */
	public static Command getMute() {
		return mute;
	}
	/**
	 * @param mute the mute to set
	 */
	public static void setMute(Command mute) {
		CommandManager.mute = mute;
	}
	/**
	 * @return the reply
	 */
	public static Command getReply() {
		return reply;
	}
	/**
	 * @param reply the reply to set
	 */
	public static void setReply(Command reply) {
		CommandManager.reply = reply;
	}
	/**
	 * @return the socialspy
	 */
	public static Command getSocialspy() {
		return socialspy;
	}
	/**
	 * @param socialspy the socialspy to set
	 */
	public static void setSocialspy(Command socialspy) {
		CommandManager.socialspy = socialspy;
	}
	/**
	 * @return the stafflist
	 */
	public static Command getStafflist() {
		return stafflist;
	}
	/**
	 * @param stafflist the stafflist to set
	 */
	public static void setStafflist(Command stafflist) {
		CommandManager.stafflist = stafflist;
	}
	/**
	 * @return the usecast
	 */
	public static Command getUsecast() {
		return usecast;
	}
	/**
	 * @param usecast the usecast to set
	 */
	public static void setUsecast(Command usecast) {
		CommandManager.usecast = usecast;
	}
	public static Command getGjm() {
		return gjm;
	}
	public static Command getGjmc() {
		return gjmc;
	}
	public static Command getGman() {
		return gman;
	}
	public static Command getGmanc() {
		return gmanc;
	}
	public static Command getGmo() {
		return gmo;
	}
	public static Command getGmoc() {
		return gmoc;
	}
	public static void setGjm(Command gjm) {
		CommandManager.gjm = gjm;
	}
	public static void setGjmc(Command gjmc) {
		CommandManager.gjmc = gjmc;
	}
	public static void setGman(Command gman) {
		CommandManager.gman = gman;
	}
	public static void setGmanc(Command gmanc) {
		CommandManager.gmanc = gmanc;
	}
	public static void setGmo(Command gmo) {
		CommandManager.gmo = gmo;
	}
	public static void setGmoc(Command gmoc) {
		CommandManager.gmoc = gmoc;
	}
	/**
	 * Generates new instances of all commands
	 */
	public static void reload() {
		acc = new ACCCommand();
		ac = new ACCommand();
		announcement = new AnnouncementCommand();
		bulletin = new BulletinCommand();
		cast = new CastCommand();
		channel = new ChannelCommand();
		clearchat = new ClearChatCommand();
		display = new DisplayCommand();
		freezechat = new FreezeChatCommand();
		gc = new GCCommand();
		global = new GlobalCommand();
		group = new GroupCommand();
		grouplist = new GroupListCommand();
		helpme = new HelpMeCommand();
		ignore = new IgnoreCommand();
		local = new LocalCommand();
		gjm = new GJMCommand();
		gjmc = new GJMCommand();
		gmo = new GMOCommand();
		gmoc = new GMOCCommand();
		gman = new GMANCommand();
		gmanc = new GMANCCommand();
		msg = new MsgCommand();
		multichat = new MultiChatCommand();
		multichatbypass = new MultiChatBypassCommand();
		mute = new MuteCommand();
		reply = new ReplyCommand();
		socialspy = new SocialSpyCommand();
		stafflist = new StaffListCommand();
		usecast = new UseCastCommand();
	}

}
