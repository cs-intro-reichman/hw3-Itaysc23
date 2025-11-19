/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	} 
 

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
    String processedStr1 = preProcess(str1);
    String processedStr2 = preProcess(str2);
    
    if (processedStr1.length() != processedStr2.length()) {
        return false;
    }
    
    StringBuilder tempStr2 = new StringBuilder(processedStr2);
    
    for (int i = 0; i < processedStr1.length(); i++) {
        char charToFind = processedStr1.charAt(i);
        
        int indexInStr2 = -1;
        for (int j = 0; j < tempStr2.length(); j++) {
            if (tempStr2.charAt(j) == charToFind) {
                indexInStr2 = j;
                break; 
            }
        }
        
        if (indexInStr2 == -1) {
            return false;
        }
        
        tempStr2.deleteCharAt(indexInStr2);
    }
    
    return true;
}	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		StringBuilder result = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (Character.isLetter(ch)) {
            result.append(Character.toLowerCase(ch));
        } 
    } 
    return result.toString(); 
} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		StringBuilder original = new StringBuilder(str);
    StringBuilder randomResult = new StringBuilder();
    
    while (original.length() > 0) {
        int randomIndex = (int) (Math.random() * original.length());
        
        char randomChar = original.charAt(randomIndex);
        randomResult.append(randomChar);
        
        original.deleteCharAt(randomIndex);
    }
    
    return randomResult.toString();
}
}