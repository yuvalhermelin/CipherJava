

public class Decrypter {

	public static String vigenereCipherDecrypt(String cipher, String password, String alphabet) {
		return Encrypter.viegenereCipherEncrypt(cipher, password, alphabet, true);
	}

	public static String rotationCipherDecrypt(String cipher, int shift, String alphabet) {
		return Encrypter.rotationCipherEncrypt(cipher, -shift, alphabet);
	}

}
