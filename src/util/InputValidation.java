package util;

import exception.InvalidArgumentException;
import model.Mode;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputValidation {

    public void validateInput(String[] args) {
        if (args.length < 2) {
            throw new InvalidArgumentException("Command and File are required!");
        }
        if (args.length > 3) {
            throw new InvalidArgumentException("More than 3 arguments");
        }
    }

    public void validateCommand(String command) {
        boolean isCommandExist = false;
        for (Mode mode : Mode.values()) {
            if (mode.toString().equals(command)) {
                isCommandExist = true;
                break;
            }
        }

        if (!isCommandExist) {
            throw new InvalidArgumentException("Command is not exist!");
        }
    }

    public void validateFilePath(String path) {
        if (path.isBlank()) {
            throw new InvalidArgumentException("Filename is empty!");
        }
        if (!Files.exists(Path.of(path))) {
            throw new InvalidArgumentException("File not found!");
        }
    }

    public void validateKey(String key) {
        for (int i = 0; i < key.length(); i++) {
            if (!Character.isDigit(key.charAt(i))) {
                throw new InvalidArgumentException("Enter numbers in the key argument");
            }
        }
    }
}
