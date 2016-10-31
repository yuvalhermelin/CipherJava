

public class Bag {
	static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private int[] characterFrequencies = new int[alphabet.length()];

	public void clear() {
		characterFrequencies = new int[alphabet.length()];
	}

	public void addFull(String s) {
		for (int i = 0; i < s.length(); i++) {
			String letter = s.substring(i, i + 1);
			letter.toLowerCase();
			if (!alphabet.contains(letter)) {
				System.err.println("LETTER NOT FOUND");
				return;
			}
			characterFrequencies[alphabet.indexOf(letter)]++;
		}
	}

	/***
	 * Gets all of the added characters and appends them into a string.
	 * 
	 * @return A string containing all of the added characters (the ones added
	 *         to the bag).
	 */
	public String getTotalWords() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < characterFrequencies.length; i++)
			if (characterFrequencies[i] > 0)
				for (int j = 0; j < characterFrequencies[i]; j++)
					sb.append(alphabet.subSequence(i, i + 1));
		return sb.toString();
	}

	/***
	 * Adds a letter to the bag for storage.
	 * 
	 * @param letter
	 *            The letter to add to the bag
	 */
	public void add(String letter) {
		letter.toLowerCase();
		if (!alphabet.contains(letter))
			return;
		characterFrequencies[alphabet.indexOf(letter)]++;
	}

	/***
	 * Gets the number of unique characters (doesnt count repeated characters)
	 * 
	 * @return The number of unique characters
	 */
	public int getNumUniqueWords() {
		int unique = 0;
		for (Integer i : characterFrequencies)
			if (i > 0)
				unique++;
		return unique;
	}

	/***
	 * Gets the number of times a specific letter appears in the bag
	 * 
	 * @param letter
	 *            The letter to look for inside of the bag
	 * @return The number of times said letter occured inside of the bag.
	 */
	public int getNumOccurances(String letter) {
		if (!alphabet.contains(letter))
			return 0;
		return characterFrequencies[alphabet.indexOf(letter)];
	}

	/***
	 * Gets the most frequently appearing character inside of the bag
	 * 
	 * @return The most frequently appearing character.
	 */
	public String getMostFrequent() {
		int largestFrequency = characterFrequencies[0], largestIndex = 0;
		for (int i = 0; i < characterFrequencies.length; i++) {
			int currentFrequency = characterFrequencies[i];
			if (currentFrequency > largestFrequency) {
				largestFrequency = currentFrequency;
				largestIndex = i;
			}
		}

		return alphabet.substring(largestIndex, largestIndex + 1);
	}

	public String[] getMostFrequentN(int numberOfMostFrequent) {
		int[] copyOfCharacterFrequency = characterFrequencies;
		String[] mostFrequent = new String[numberOfMostFrequent];
		for (int i = 0; i < numberOfMostFrequent; i++) {
			mostFrequent[i] = getMostFrequent(copyOfCharacterFrequency);
			int index = alphabet.indexOf(mostFrequent[i]);
			copyOfCharacterFrequency[index] = 0;
		}
		return mostFrequent;
	}

	private String getMostFrequent(int[] frequencies) {
		int largestFrequency = frequencies[0], largestIndex = 0;
		for (int i = 0; i < frequencies.length; i++) {
			int currentFrequency = frequencies[i];
			if (currentFrequency > largestFrequency) {
				largestFrequency = currentFrequency;
				largestIndex = i;
			}
		}

		return alphabet.substring(largestIndex, largestIndex + 1);
	}
}
