package service;
import java.io.File;
public class EncryptService {

    public String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) ((character - base + key) % 26 + base);
                if (encryptedChar < base) {
                    encryptedChar += 26;
                }
                result.append(encryptedChar);
            } else {
                result.append(character);
            }
        }
        return result.toString();
}

}
