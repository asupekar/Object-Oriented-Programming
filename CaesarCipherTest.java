package asupekar_hw2.encrypt;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CaesarCipherTest {

	@Test
	void testCaesarCipher() {
		CaesarCipher cc = new CaesarCipher();
		assertNotNull(cc);
	}

	@Test
	void testCaesarCipherInt() {
		CaesarCipher cc = new CaesarCipher(4);
		assertNotNull(cc);
		assertEquals(4, cc.getShift());
	}

	@Test
	void testEncrypt() {
		CaesarCipher cc = new CaesarCipher();
		String text = "password1";
		String encryptedText = cc.encrypt(text);
		assertNotSame("text", "encrptedText");
	}

	@Test
	void testDecrypt() {
		CaesarCipher cc = new CaesarCipher();
		String encrpyted = "tewwasvh5";
		String text = "password1";
		String decrypted = cc.decrypt(encrpyted);
		assertEquals(text, decrypted);
		
		//assertThrows(expectedType, executable)

	}

}
