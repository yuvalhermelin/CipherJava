import static org.junit.Assert.*;

import org.junit.Test;

public class CipherTest {
	final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.() '\"![]/%-_;?=:"
			+ '\n' + '\r';

	@Test
	public void test1() {
		String s = Cipher.rotationCipherEncrypt("abc", 2, alphabet);
		assertEquals("cde", s);
	}

	@Test
	public void test2() {
		int newIndex = HelperMethods.getNewIndex(20, 43, alphabet);
		assertEquals(63, newIndex);
	}

	@Test
	public void test3() {
		int newIndex = HelperMethods.getNewIndex(20, -10, alphabet);
		assertEquals(10, newIndex);
	}

	@Test
	public void test4() {
		String[] groups = HelperMethods.getGroups("aabbcc", 2);
		String[] trueValue = new String[] { "abc", "abc" };
		for (int i = 0; i < groups.length; i++)
			assertEquals(trueValue[i], groups[i]);
	}

	@Test
	public void test5() {
		String encrypted = Cipher.vigenereCipherEncrypt("aaaaaa", "aaa", alphabet);
		assertEquals("aaaaaa", encrypted);
	}

	@Test
	public void test6() {
		String decrypted = Cipher.vigenereCipherDecrypt(Cipher.vigenereCipherEncrypt(",sadj oinw92nd", "mas", alphabet),
				"mas", alphabet);
		assertEquals(",sadj oinw92nd", decrypted);
	}

	@Test
	public void test7() {
		String decrypted = Cipher.rotationCipherDecrypt(
				Cipher.rotationCipherEncrypt("inda onw = adons \n sdiadm", 100, alphabet), 100, alphabet);
		assertEquals("inda onw = adons \n sdiadm", decrypted);
	}

	@Test
	public void test8() {
		String encrypted = Cipher.rotationCipherEncrypt(
				"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?",
				82, alphabet);
		String cracked = Cipher.rotationCipherCrack(encrypted, alphabet);
		assertEquals(
				"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?",
				cracked);
	}

	@Test
	public void test9() {
		String encrypted = Cipher.vigenereCipherEncrypt(
				"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?",
				"doma 3o", alphabet);
		String cracked = Cipher.vigenereCipherCrack(encrypted, 7, alphabet);
		assertEquals(
				"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?",
				cracked);
	}
}
