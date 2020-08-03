package xyz.olivermartin.multichat.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiChatUtil {
	
	/**
	 * <p>Takes a raw string and translates any colour codes using the & symbol</p>
	 * <p>Any RGB codes in the format &#abcdef, &xabcdef or &x&a&b&c&d&e&f will also be translated</p>
	 * @param rawMessage The raw message to translate
	 * @return the translated message
	 */
	public static String translateColourCodes(String rawMessage) {
		return translateColourCodes(rawMessage, TranslateMode.ALL);
	}

	/**
	 * <p>Takes a raw string and translates formatting codes according to the TranslateMode</p>
	 * @param rawMessage The raw message to translate
	 * @param modes The TranslateModes to process
	 * @return the translated message
	 */
	public static String translateColourCodes(String rawMessage, TranslateMode... modes) {

		String translatedMessage = rawMessage;

		boolean rgb = Arrays.stream(modes).anyMatch(value -> value.equals(TranslateMode.ALL) || value.equals(TranslateMode.COLOUR_ALL));

		// If we are translating RGB codes, reformat these to the correct format
		if (rgb) translatedMessage = MultiChatUtil.reformatRGB(translatedMessage);

		// Process each of the translations
		for (TranslateMode mode : modes) {
			translatedMessage = mode.translate(translatedMessage);
		}

		return translatedMessage;

	}

	/**
	 * Reformat the RGB codes into Spigot Native version
	 * 
	 * @param message
	 * @return message reformatted
	 */
	private static String reformatRGB(String message) {
		// Translate RGB codes
		return message.replaceAll("(?i)\\&(x|#)([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])", "&x&$2&$3&$4&$5&$6&$7");
	}

	public static String approximateHexCodes(String message) {

		message = message.replaceAll("(?i)(\\&|�)x(\\&|�)([0-9A-F])(\\&|�)([0-9A-F])(\\&|�)([0-9A-F])(\\&|�)([0-9A-F])(\\&|�)([0-9A-F])(\\&|�)([0-9A-F])", "&#$3$5$7$9$11$13");

		List<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile("(?i)\\&(x|#)([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])")
				.matcher(message);
		while (m.find()) {
			allMatches.add(m.group());
		}

		for (String match : allMatches) {

			String hexonly;
			if (match.contains("#")) {
				hexonly = match.split("#")[1];
			} else if (match.contains("x")) {
				hexonly = match.split("x")[1];
			} else {
				hexonly = match.split("X")[1];
			}
			String minecraftCode = hexToMinecraft(hexonly);
			message = message.replace(match,"�"+minecraftCode);
		}

		return approximateJsonHexCodes(message);

	}

	private static String approximateJsonHexCodes(String message) {

		message = message.replaceAll("(?i)(\"color\":\")#([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])(\")", "$1&#$2$3$4$5$6$7$8");

		List<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile("(?i)\\&(x|#)([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])")
				.matcher(message);
		while (m.find()) {
			allMatches.add(m.group());
		}

		for (String match : allMatches) {

			String hexonly;
			if (match.contains("#")) {
				hexonly = match.split("#")[1];
			} else if (match.contains("x")) {
				hexonly = match.split("x")[1];
			} else {
				hexonly = match.split("X")[1];
			}
			String minecraftCode = hexToMinecraft(hexonly);
			message = message.replace(match,getMinecraftCodeName(minecraftCode));
		}

		return message;

	}

	public static String getMinecraftCodeName(String code) {

		code = code.toLowerCase();

		switch (code) {
		case "0":
			return "black";
		case "1":
			return "dark_blue";
		case "2":
			return "dark_green";
		case "3":
			return "dark_aqua";
		case "4":
			return "dark_red";
		case "5":
			return "dark_purple";
		case "6":
			return "gold";
		case "7":
			return "gray";
		case "8":
			return "dark_gray";
		case "9":
			return "blue";
		case "a":
			return "green";
		case "b":
			return "aqua";
		case "c":
			return "red";
		case "d":
			return "light_purple";
		case "e":
			return "yellow";
		case "f":
			return "white";
		default:
			return "white";
		}

	}

	public static String hexToMinecraft(String hex) {

		String rcode = hex.substring(0,2);
		String gcode = hex.substring(2,4);
		String bcode = hex.substring(4,6);

		int rint = Integer.parseInt(rcode,16);
		int gint = Integer.parseInt(gcode,16);
		int bint = Integer.parseInt(bcode,16);

		String[] cga = {"000000","0000aa","00aa00","00aaaa","aa0000","aa00aa","ffaa00","aaaaaa","555555","5555ff","55ff55","55ffff","ff5555","ff55ff","ffff55","ffffff"};

		int diff = 999999999;
		int best = -1;

		for (int i = 0; i < 16; i++) {

			String current = cga[i];

			String rcode2 = current.substring(0,2);
			String gcode2 = current.substring(2,4);
			String bcode2 = current.substring(4,6);

			int rint2 = Integer.parseInt(rcode2,16);
			int gint2 = Integer.parseInt(gcode2,16);
			int bint2 = Integer.parseInt(bcode2,16);

			int val = Math.abs(rint-rint2) + Math.abs(gint-gint2) + Math.abs(bint-bint2);

			if (val < diff) {
				best = i;
				diff = val;
			}

		}

		return Integer.toHexString(best);

	}

	/**
	 * Concatenate the arguments together to get the message as a string
	 * 
	 * @param args The arguments of the command
	 * @param start The (zero-indexed) starting index of the message (inclusive)
	 * @param end The (zero-indexed) finishing index of the message (inclusive)
	 * @return The concatenated message
	 */
	public static String getMessageFromArgs(String[] args, int start, int end) {

		int counter = 0;
		String message = "";
		for (String arg : args) {
			if (counter >= start && counter <= end) {
				if (counter != end) {
					message = message + arg + " ";
				} else {
					message = message + arg;
				}
			}
			counter++;
		}

		return message;

	}

	/**
	 * Concatenate the arguments together to get the message as a string
	 * 
	 * @param args The arguments of the command
	 * @param start The (zero-indexed) starting index of the message (inclusive)
	 * @return The concatenated message
	 */
	public static String getMessageFromArgs(String[] args, int start) {

		return getMessageFromArgs(args, start, args.length - 1);

	}

	/**
	 * Concatenate the arguments together to get the message as a string
	 * 
	 * @param args The arguments of the command
	 * @return The concatenated message
	 */
	public static String getMessageFromArgs(String[] args) {

		return getMessageFromArgs(args, 0, args.length - 1);

	}

	public static String getStringFromCollection(Collection<String> collection) {

		String result = "";

		for (String item : collection) {
			if (result.equals("")) {
				result = result + item;
			} else {
				result = result + " " + item;
			}
		}

		return result;

	}

}
