package com.kabilan.cci;

public class OneAway {
	public static void main(String[] args) {
		String s1 = "pales";
		String s2 = "pale";
		System.out.println(isOneAway(s1, s2));
	}

	private static boolean isOneAway(String s1, String s2) {
		return isOneAway(s1, s2, false);
	}

	private static boolean isOneAway(String s1, String s2, boolean edits) {
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}

		if (s1.isEmpty() || s2.isEmpty()) {
			if (edits) {
				return false;
			} else if (s1.isEmpty()){
				String s1added = s2.charAt(0) + s1.substring(0);
				return isOneAway(s1added, s2, true);
			} else {
				String s2added = s1.charAt(0) + s2.substring(0);
				return isOneAway(s1, s2added, true);
			}
		}

		System.out.println("====");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("====");

		if (s1.charAt(0) == s2.charAt(0)) {
			return isOneAway(s1.substring(1), s2.substring(1), edits);
		}

		if (edits) {
			return false;
		}

		String s1added = s2.charAt(0) + s1.substring(0);
		String s2added = s1.charAt(0) + s2.substring(0);
		String s1replaced = s2.charAt(0) + s1.substring(1);
		String s2replaced = s1.charAt(0) + s2.substring(1);

		return isOneAway(s1added, s2, true) ||
		       isOneAway(s1, s2added, true) ||
		       isOneAway(s1replaced, s2, true) ||
		       isOneAway(s1, s2replaced, true);
	}
}