package com.Google;

public class LicenseKeyFormatting {

	public static void constructFormat(StringBuilder charList, StringBuilder formattedStr, int d, int partition,
			int k) {

		for (int i = 0; i < partition; i++) {
			int j = k*i+d;
			for (; j < k * i + k+d; j++) {
				char ch = charList.charAt(j);
				formattedStr.append(ch >= 'a' && ch <= 'z' ? (char) ((int)ch -32) : ch);
			}
			formattedStr.append("-");
		}
		formattedStr.deleteCharAt(formattedStr.length() - 1);

		return;
	}

	public static String licenseKeyFormatting(String s, int k) {
		StringBuilder charList = new StringBuilder("");
		int size = s.length();

		for (int i = 0; i < size; i++) {
			char ch = s.charAt(i);
			if (ch != '-')
				charList.append(ch);
		}
		size = charList.length();
		int d = size % k;
		int partition = size / k;

		StringBuilder formattedStr = new StringBuilder("");
		if (d == 0) {
			constructFormat(charList, formattedStr, d, partition, k);
		} else {
			for (int i = 0; i < d; i++) {
				char ch = charList.charAt(i);
				formattedStr.append(ch >= 'a' && ch <= 'z' ? (char) ((int) -32) : ch);
			}
			formattedStr.append("-");
			constructFormat(charList, formattedStr, d, partition, k);
		}
		return formattedStr.toString();

	}

	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("5F3Z-2e-94-w",4));

	}

}
