

public class Cipher {

	public static String vigenereCipherEncrypt(String plain, String password, String alphabet) {
		return Encrypter.viegenereCipherEncrypt(plain, password, alphabet, false);
	}

	public static String vigenereCipherDecrypt(String cipher, String password, String alphabet) {
		return Decrypter.vigenereCipherDecrypt(cipher, password, alphabet);
	}

	public static String rotationCipherEncrypt(String plain, int shift, String alphabet) {
		return Encrypter.rotationCipherEncrypt(plain, shift, alphabet);
	}

	public static String rotationCipherDecrypt(String cipher, int shift, String alphabet) {
		return Decrypter.rotationCipherDecrypt(cipher, shift, alphabet);
	}

	public static String rotationCipherCrack(String cipher, String alphabet) {
		return Cracker.rotationCipherCrack(cipher, alphabet);
	}

	public static String vigenereCipherCrackThreeLetter(String cipher, String alphabet) {
		return Cracker.vigenereCipherCrack(cipher, alphabet, 3);
	}

	public static String vigenereCipherCrack(String cipher, int passwordLength, String alphabet) {
		return Cracker.vigenereCipherCrack(cipher, alphabet, passwordLength);
	}

	public static String vigenereCipherCrack(String cipher, String alphabet) {
		return Cracker.vigenereCipherCrack(cipher, alphabet);
	}
}
