

public class Cracker {
	/***
	 * 
	 * @param cipher
	 * @param alphabet
	 * @return
	 */
	public static String rotationCipherCrack(String cipher, String alphabet) {
		String decrypted = "";
		double bestScore = Integer.MAX_VALUE;

		for (int i = 0; i < alphabet.length(); i++) {
			String decryptedToScore = Decrypter.rotationCipherDecrypt(cipher, i, alphabet);
			double currentScore = HelperMethods.getScore(decryptedToScore);
			if (currentScore < bestScore) {
				decrypted = decryptedToScore;
				bestScore = currentScore;
			}
		}

		return decrypted;
	}

	/***
	 * 
	 * @param cipher
	 * @param alphabet
	 * @param passSize
	 * @return
	 */
	public static String vigenereCipherCrack(String cipher, String alphabet, int passSize) {
		String[] encryptedGroups = HelperMethods.getGroups(cipher, passSize);
		String[] decryptedGroups = new String[passSize];
		int[] code = new int[passSize];

		for (int j = 0; j < encryptedGroups.length; j++) {
			double[] scores = new double[alphabet.length()];
			for (int i = 0; i < alphabet.length(); i++) {
				decryptedGroups[j] = Decrypter.rotationCipherDecrypt(encryptedGroups[j], i, alphabet);
				scores[i] = HelperMethods.getScore(decryptedGroups[j]);
			}
			int bestIndex = 0;
			double bestScore = Integer.MAX_VALUE;
			for (int i = 0; i < scores.length; i++)
				if (scores[i] < bestScore) {
					bestIndex = i;
					bestScore = scores[i];
				}
			code[j] = bestIndex;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < code.length; i++)
			
			sb.append(alphabet.substring(code[i], code[i] + 1));
		String password = sb.toString();

		return Decrypter.vigenereCipherDecrypt(cipher, password, alphabet);
	}

	/***
	 * 
	 * @param cipher
	 * @param alphabet
	 * @return
	 */
	public static String vigenereCipherCrack(String cipher, String alphabet) {
		String[] decrypted = new String[5];
		for (int i = 0; i < decrypted.length; i++) {
			decrypted[i] = vigenereCipherCrack(cipher, alphabet, i + 1);
		}

		double[] scores = new double[decrypted.length];
		for (int i = 0; i < scores.length; i++)
			scores[i] = HelperMethods.getScore(decrypted[i]);

		int bestIndex = 0;
		double bestScore = scores[0];
		for (int i = 0; i < scores.length; i++)
			if (scores[i] < bestScore) {
				bestScore = scores[i];
				bestIndex = i;
			}
		return decrypted[bestIndex];
	}

}
