package service;

import sets.KeywordDictionary;

public class BruteForceService {

    public String bruteForceDecrypt(String ciphertext) {
        DecryptService decryptService = new DecryptService();
        for (int key = 0; key < 26; key++) {
            String decryptedText = decryptService.decrypt(ciphertext, key);

            if (containsKeywords(decryptedText)) {
                return decryptedText;
            }
        }

        return null;
    }

    private boolean containsKeywords(String text) {
        KeywordDictionary keywordDictionary = new KeywordDictionary();
        for (String keyword : keywordDictionary.KEYWORDS) {
            if (!text.toUpperCase().contains(keyword)) {
                return false;
            }
        }
        return true;
    }
}
