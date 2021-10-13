

public class CryptoManager {
	//Constant vars
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		for (int i  = 0; i < plainText.length(); i++)
		{
			//check if character is not between the two bounds
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
				return false;
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//Fail if out of bounds
		if (!stringInBounds(plainText))
			return "OUT OF BOUNDS";
		//Convert if key is negative
		if (key < 0)
			key = RANGE - (key % RANGE);
		
		String temp = "";
		for (int i = 0; i < plainText.length(); i++)
		{
			//add key, subtract lower bound, find overflow, add lower bound back
			temp += (char)((plainText.charAt(i) + key - LOWER_BOUND) % RANGE + LOWER_BOUND);
		}
		return temp;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//Fail if out of bounds
		if (!stringInBounds(plainText))
			return "OUT OF BOUNDS";
		String temp = "";
		char key;
		for (int i = 0; i < plainText.length(); i++)
		{
			//set key equal to character at the index of string key
			key = bellasoStr.charAt(i % bellasoStr.length());//modulus length to loop key
			
			//add key, subtract lower bound, find overflow, add lower bound back
			temp += (char)((plainText.charAt(i) + key - LOWER_BOUND) % RANGE + LOWER_BOUND);
		}
		return temp;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//Fail if out of bounds
		if (encryptedText.equals("OUT OF BOUNDS"))
			return "";
		//Convert negative key
		if (key < 0)
			key = RANGE - (key % RANGE);
		
		//char - key can be rewritten as char + (range - key), so we set key equal to range - key and encrypt
		key = RANGE - (key % RANGE);//key % range to prevent overflow
		//Same code as encryption
		String temp = "";
		for (int i = 0; i < encryptedText.length(); i++)
		{
			//add key, subtract lower bound, find overflow, add lower bound back
			temp += (char)((encryptedText.charAt(i) + key - LOWER_BOUND) % RANGE + LOWER_BOUND);
		}
		return temp;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//Fail if out of bounds
		if (encryptedText.equals("OUT OF BOUNDS"))
			return "";
		
		char key;
		String temp = "";
		
		for (int i = 0; i < encryptedText.length(); i++)
		{
			//char - key can be rewritten as char + (range - key), so we set key equal to range - key and encrypt
			key = (char)(RANGE - (bellasoStr.charAt(i % bellasoStr.length()) % RANGE));//key % range to prevent overflow
			
			//add key, subtract lower bound, find overflow, add lower bound back
			temp += (char)((encryptedText.charAt(i) + key - LOWER_BOUND) % RANGE + LOWER_BOUND);
		}
		return temp;
	}
}
