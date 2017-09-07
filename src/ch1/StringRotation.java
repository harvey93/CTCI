package ch1;

public class StringRotation {
	
	public static boolean isRotation(String str1, String str2){
		String str3 = str1 + str1;
		return isSubstring(str3, str2);
	}
	
	public static boolean isSubstring(String str1, String str2){
		return str1.contains(str2);
	}
}
