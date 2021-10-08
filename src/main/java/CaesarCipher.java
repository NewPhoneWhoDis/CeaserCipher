public class CaesarCipher {

    private static final int ALPHABET_SIZE = 26;
    private static final char LETTER_A = 'a';
    private static final char LETTER_Z = 'z';

    public String cipher(String msg, int offset) {
        offset %= ALPHABET_SIZE; // making sure offset does not exceed 26
        char[] chars = msg.toCharArray();
        offsetBy(chars, offset);

        return new String(chars);
    }

    private void offsetBy(char[] chars, int offset) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[i] = offsetChar(chars[i], offset, LETTER_A, LETTER_Z);
            }
        }
    }

    private char offsetChar(char c, int offset, char letterA, char letterZ) {
        c += offset;
        if (c < letterA) return (char) (c + ALPHABET_SIZE); // allows only left rotation
        if (c > letterZ) return (char) (c - ALPHABET_SIZE); // allows right rotation
        return c;
    }

    public String decipher(String msg, int offset) {
        return cipher(msg, 26 - (offset % 26));
    }
}
