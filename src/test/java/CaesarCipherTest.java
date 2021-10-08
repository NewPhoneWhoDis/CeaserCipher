import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {

    private CaesarCipher caesarCipher = new CaesarCipher();

    @Test
    void testCipheredMessageWithOffsetOf12() {
        assertEquals("tai mdq kag pauzs fapmk", caesarCipher.cipher("how are you doing today", 12));
    }

    @Test
    void testEmptyString() {
        assertEquals("", caesarCipher.cipher("", 12));
    }

    @Test
    void testDecipheredMessage() {
        String decipheredMsg = caesarCipher.decipher("fqefuzs ftq pqodkbfuzs yqftap", 12);
        assertEquals(decipheredMsg, "testing the decrypting method");
    }
}