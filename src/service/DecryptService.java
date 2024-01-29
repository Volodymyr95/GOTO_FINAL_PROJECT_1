package service;

public class DecryptService {

    public String decrypt(String ciphertext, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : ciphertext.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char shiftedChar = (char) ((character - base + key) % 26 + base);
                if (shiftedChar < base) {
                    shiftedChar += 26;
                }
                result.append(shiftedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}
