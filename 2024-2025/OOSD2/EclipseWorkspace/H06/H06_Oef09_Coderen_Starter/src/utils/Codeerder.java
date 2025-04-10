package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Codeerder {
	private final static Character[] MEDEKLINKERS = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q',
			'r', 's', 't', 'v', 'w', 'x', 'z' };

	public static String codeer(String bericht) {
		StringBuilder sb = new StringBuilder();
		char[] letters = bericht.toCharArray();
		Set<Character> medeklinkers = new HashSet<Character>(Arrays.asList(MEDEKLINKERS));
		
		StringBuilder buffer = new StringBuilder();
		for (char c : letters) {
			if (!medeklinkers.contains(c)) {
				if (!buffer.isEmpty()) {
					buffer.reverse();
					sb.append(buffer);
					buffer.setLength(0);
				}
				sb.append(c);
			}
			else {
				buffer.append(c);
			}
		}
		if (!buffer.isEmpty()) {
			buffer.reverse();
			sb.append(buffer);
		}
		
		
		return sb.toString();
	}

}
