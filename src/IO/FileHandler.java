package IO;

import exception.InvalidArgumentException;
import model.Mode;

import java.io.*;

public class FileHandler {

    public String readFileToString(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public void writeTextToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Specify "ENCRYPT" or "DECRYPT" or "BRUTE_FORCE" in the mod line to add to the file name [ENCRYPTED] or [DECRYPTED] or [BRUTE_FORCED]
    public void writeStringToFile(String filePath, String txt, String mode) {
        boolean isCommandExist = false;
        for (Mode mods : Mode.values()) {
            if (mods.toString().equals(mode.toUpperCase())) {
                isCommandExist = true;
                break;
            }
        }
        if (isCommandExist) {
            int lastIndex = filePath.lastIndexOf(".");
            StringBuilder stringBuilder = new StringBuilder(filePath);
            String path1 = stringBuilder.substring(0, lastIndex);
            String path2 = stringBuilder.substring(lastIndex);
            switch (mode.toUpperCase()) {
                case "ENCRYPT":
                    writeTextToFile(path1 + " [ENCRYPTED]" + path2, txt);
                    break;
                case "DECRYPT":
                    writeTextToFile(path1 + " [DECRYPTED]" + path2, txt);
                    break;
                case "BRUTE_FORCE":
                    writeTextToFile(path1 + " [BRUTE_FORCED]" + path2, txt);
                    break;
            }
        }
        else {
            throw new InvalidArgumentException("Select the correct operating mode");
        }
    }
}
