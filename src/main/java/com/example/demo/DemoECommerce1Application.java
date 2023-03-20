package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DemoECommerce1Application {

	public static String[] uniqueNames(String[] names1, String[] names2) {
		Set<String> setStr = new HashSet<>();
		setStr.addAll(Arrays.asList(names1));
		setStr.addAll(Arrays.asList(names2));
		return setStr.toArray(new String[0]);
	}

	// Print duplicate characters from String?
	public static char[] printDuplicateCharacters(String word) {
		char[] s = word.toCharArray();
		List<Character> listChar = new ArrayList<>();
		Map<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < s.length; i++) {
			if (hashMap.containsKey(s[i])) {
				hashMap.put(s[i], hashMap.get(s[i]) + 1);
			} else {
				hashMap.put(s[i], 1);
			}

		}

		for (Map.Entry<Character, Integer> charMap : hashMap.entrySet()) {
			if (charMap.getValue() > 1) {
				listChar.add(charMap.getKey());
			}
		}

		char[] newS = new char[listChar.size() + 1];

		for (int i = 0; i < listChar.size(); i++) {
			newS[i] = listChar.get(i);
		}

		return newS;
	}

	// Check if two Strings are anagrams of each other?
	public static boolean isAnagram(String word, String anagram) {
		char[] Ochar = word.toCharArray();
		char[] Schar = anagram.toCharArray();

		Arrays.sort(Ochar);
		Arrays.sort(Schar);

		for (int i = 0; i < Ochar.length; i++) {
			if (Ochar[i] != Schar[i]) {
				return false;
			}

		}

		return true;
	}

//	Print the first non-repeated character from String?
	public static char firstNonRepeatingChar(String word) {
		char[] Ochar = word.toCharArray();

		Map<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < Ochar.length; i++) {
			if (hashMap.containsKey(Ochar[i])) {
				hashMap.put(Ochar[i], hashMap.get(Ochar[i]) + 1);
			} else {
				hashMap.put(Ochar[i], 1);
			}
		}

		for (Map.Entry<Character, Integer> newMap : hashMap.entrySet()) {
			if (newMap.getValue() == 1) {
				return newMap.getKey();
			}
		}

		throw new RuntimeException("didn't find any non repeated Character");
	}

	// Reverse a given String using recursion?
	public static String reverse(String str) {

		StringBuilder strBuilder = new StringBuilder();

		char[] charS = str.toCharArray();

		for (int i = charS.length - 1; i >= 0; i--) {
			strBuilder.append(charS[i]);

		}

		return strBuilder.toString();

	}

	// Palindrome Number
	public static boolean isPalindrome(int x) { // 1221
		if (x < 0) {
			return false;
		}

		int revert = 0;
		int result = x;

		while (result > 0) {
			int digit = result % 10;
			revert = revert * 10 + digit;
			result /= 10;
		}

		return revert == x;
	}

	public static String[] checkDigits(String[] strs) {

		Pattern pattern = Pattern.compile(".*[^0-9].*");

		List<String> listStr = new ArrayList<>();
		for (String i : strs) {
			if (!pattern.matcher(i).matches()) {
				listStr.add(i);
			}
		}

		return listStr.toArray(new String[0]);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoECommerce1Application.class, args);

		String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
		String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
		String[] names3 = new String[] { "123", "1s23", "156" };

//		System.out.println(printDuplicateCharacters("LeQuangVan"));
//		System.out.println(isAnagram("Van", "naV"));

//		System.out.println(Arrays.toString(checkDigits(names3)));

	}

}
