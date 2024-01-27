package service;

import sets.KeywordDictionary;

public class BruteForceService {

    public String bruteForceDecrypt(String ciphertext) {
        DecryptService decryptService = new DecryptService();
        String bestDecryptedText = "";
        int bestKey = 0;
        for (int key = 0; key < 26; key++) {
            String decryptedText = decryptService.decrypt(ciphertext, -key);

            if (score(decryptedText) > score(bestDecryptedText)) {
                bestDecryptedText = decryptedText;
                bestKey = key;
            }

        }
        return bestDecryptedText;
    }

    private int score(String decryptedText) {
        KeywordDictionary keywordDictionary = new KeywordDictionary();
        int keywordCount = 0;

        for (String keyword : keywordDictionary.KEYWORDS) {
            if (decryptedText.toUpperCase().contains(keyword)) {
                keywordCount++;
            }
        }

        return keywordCount;
    }
}
