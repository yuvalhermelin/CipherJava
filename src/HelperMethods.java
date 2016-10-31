
import java.util.ArrayList;

public class HelperMethods {
	
	/***
	 * 
	 * @param index
	 * @param shift
	 * @param alphabet
	 * @return
	 */
	public static int getNewIndex(int index, int shift, String alphabet) {
		int newIndex = index + shift;
		while (newIndex < 0)
			newIndex += alphabet.length();
		while (newIndex >= alphabet.length())
			newIndex -= alphabet.length();
		return newIndex;
	}
	
	
	/***
	 * 
	 * @param plain
	 * @param passLength
	 * @return
	 */
	public static String[] getGroups(String plain, int passLength) {
		StringBuilder[] sb = new StringBuilder[passLength];
		for (int i = 0; i < passLength; i++)
			sb[i] = new StringBuilder();

		for (int i = 0; i < plain.length(); i++) {
			int group = i;
			while (group >= passLength)
				group -= passLength;

			sb[group].append(plain.substring(i, i + 1));
		}

		String[] s = new String[passLength];
		for (int i = 0; i < passLength; i++)
			s[i] = sb[i].toString();

		return s;
	}

	/***
	 * 
	 * @param decrypted
	 * @return
	 */
	public static double getScore(String decrypted) {
		double score = 0;
		double[] englishFrequencies = new double[] { .0817, .0149, .0278, .0425, .1270, .0223, .0201, .0609, .0697,
				.0015, .0077, .0403, .0240, .0675, .0750, .0193, .0009, .0599, .0633, .091, .028, .0098, .0236, .0015,
				.0198, .0007 };
		String[] englishCharacters = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
				"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
		String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
		Bag b = new Bag();

		double length = 0;
		decrypted.toLowerCase();
		for (int i = 0; i < decrypted.length(); i++)
			if (lowercaseLetters.contains(decrypted.substring(i, i + 1))) {
				length++;
				b.add(decrypted.substring(i, i + 1));
			}

		for (int i = 0; i < englishCharacters.length; i++) {
			double x = (((double) b.getNumOccurances(englishCharacters[i])) / length);
			score += Math.abs(englishFrequencies[i] - x);
		}
		return score;
	}

	/***
	 * 
	 * @param input
	 * @return
	 */
	public static String[] getWords(String input) {
		input.trim();
		ArrayList<Integer> spaces = getIndeciesOf(input, " ");
		String[] output = getSeparateWords(input, spaces);

		return output;
	}

	/***
	 * 
	 * @param input
	 * @param toLookFor
	 * @return
	 */
	private static ArrayList<Integer> getIndeciesOf(String input, String toLookFor) {
		ArrayList<Integer> spaces = new ArrayList<>();
		for (int i = 1; i < input.length(); i++) {
			if (input.substring(i, i + 1).equals(toLookFor) && !input.substring(i - 1, i).equals(" "))
				spaces.add(i);
		}
		return spaces;
	}

	/***
	 * 
	 * @param input
	 * @param spaceIndexes
	 * @return
	 */
	private static String[] getSeparateWords(String input, ArrayList<Integer> spaceIndexes) {
		String[] output = new String[spaceIndexes.size()];
		int last = 0;

		for (int i = 0; i < output.length; i++) {
			int index = spaceIndexes.get(i);
			output[i] = input.substring(last, index).trim();
			last = index;
		}

		if (output.length != 0)
			output[output.length - 1] = input.substring(last, input.length()).trim();
		else {
			output = new String[1];
			output[0] = input;
		}
		
		return output;
	}

}
