package com.phptravels.hexatest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhpTravelsValidations {

	public static boolean stringStartsWith(String string, String startswith, int offset){
		if(string.startsWith(startswith, offset)) return true;
		else return false;
	}

	public static boolean stringEndsWith(String string, String endswith){
		if(string.endsWith(endswith)) return true;
		else return false;
	}

	public static boolean stringContains(String string, String contains){
		if(string.contains(contains)) return true;
		else return false;
	}

	public static boolean stringEqualsWith(String string, String with){
		if(string.equals(with)) return true;
		else return false;
	}

	public static boolean isAlphanumeric(String string){

		String regex="[A-Za-z0-9]{0,}";
		if(Pattern.matches(regex, string)){
			System.out.println("Aplphanumeric String");
			return true;
		}
		else{
			System.out.println("Not Aplphanumeric String");
			return false;
		}
	}

	public static boolean isAlphabetesOnly(String string){
		String regex= "[A-Za-z]{0,}";
		if(Pattern.matches(regex, string)){
			System.out.println("Alphabets only");
			return true;
		}
		else{
			System.out.println("Not Alphabets only");
			return false;
		}
	}
	//	String contains uppercase character
	public static boolean containsUpperCaseChar(String string){
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(string);
		return matcher.find();
	}
	//	String contains special character excluding blank spaces
	public static boolean containsSpecialChar(String string){
		
		Pattern p = Pattern.compile("[^A-Za-z0-9\\s]");
		Matcher m = p.matcher(string);
		// boolean b = m.matches();
		boolean b = m.find();
		if (b == true)
			System.out.println("There is a special character in my string ");
		else
			System.out.println("There is no special char.");
		return b;
	}
	//   x. List contains a specific value
	public static boolean listContains(ArrayList<?> list, Object obj ){
		if(list.contains(obj))
			return true;
		else
			return false;		
	}
	//	Index of a specific value in a list
	public static int indexofElement (List<?> list1, Object item)
	{
		int value = list1.indexOf(item);
		return value;
		
	}
	//	  xii. Compare two List<List<String>> and find out the
	//    cells contains different values

	public static void main(String []args){
		String s = "my name is Kartik";//  \\S not allow spaces and \\s allow spaces
		System.out.println(stringStartsWith(s,"my", 0));
		System.out.println(stringEndsWith(s, "K@rtik"));
		System.out.println(stringContains(s, "is"));
		System.out.println(stringEqualsWith(s, s));
		isAlphanumeric(s);
		isAlphabetesOnly(s);
		containsUpperCaseChar(s);
		containsSpecialChar(s);
		ArrayList<String> list = new ArrayList<>();
		list.add("Kartik");
		list.add("Harshita");
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(12);
		list1.add(28);
		System.out.println(listContains(list, "Kartik"));
		System.out.println(listContains(list1, 13));
		System.out.println((int)('a')+ " "+(int)('z'));
		System.out.println((int)('A')+ " "+(int)('Z'));
		System.out.println((int)('0')+" "+(int)('9'));
	}
}
