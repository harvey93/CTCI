package ch1;

public class StringCompression {

	public static String compress(String str){
		StringBuilder sb = new StringBuilder();
		char persist = str.charAt(0);
		sb.append(persist);
		sb.append(1);
		for(int i = 1; i < str.length(); i++){
			char currentChar = str.charAt(i);
			if(currentChar == persist){
				char currentCount = sb.charAt(sb.length() - 1);
				sb.setCharAt(sb.length() - 1, ++currentCount);
			}else{
				sb.append(currentChar);
				sb.append(1);
				persist = currentChar;
			}
		}
		
		return sb.toString();
	} 
}
