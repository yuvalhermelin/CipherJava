public class Encrypter {

	/***
	 * 
	 * @param plain
	 * @param password
	 * @param alphabet
	 * @param decrypt
	 * @return
	 */
	public static String viegenereCipherEncrypt(String plain, String password, String alphabet, boolean decrypt) {
		StringBuilder sb = new StringBuilder();
		int passwordIndex = 0;

		System.out.println("CHECK");
		
		for (int i = 0; i < plain.length(); i++) {
			if (passwordIndex == password.length())
				passwordIndex = 0;
			if (!decrypt)
				sb.append(rotationCipherEncrypt(plain.substring(i, i + 1),
						alphabet.indexOf(password.substring(passwordIndex, passwordIndex + 1)), alphabet));
			else
				sb.append(rotationCipherEncrypt(plain.substring(i, i + 1),
						-alphabet.indexOf(password.substring(passwordIndex, passwordIndex + 1)), alphabet));
			passwordIndex++;
		}
		return sb.toString();
	}

	/***
	 * 
	 * @param plain
	 * @param shift
	 * @param alphabet
	 * @return
	 */
	public static String rotationCipherEncrypt(String plain, int shift, String alphabet) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < plain.length(); i++) {
			String currentLetter = plain.substring(i, i + 1);
			int currentIndex = alphabet.indexOf(currentLetter);

			int newIndex = HelperMethods.getNewIndex(currentIndex, shift, alphabet);
			String newLetter = alphabet.substring(newIndex, newIndex + 1);

			sb.append(newLetter);
		}
		return sb.toString();
	}

}
