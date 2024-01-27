import IO.FileHandler;
import exception.InvalidArgumentException;
import service.BruteForceService;
import service.DecryptService;
import service.EncryptService;
import util.InputValidation;


public class Main {

    private static final int COMMAND_ARGUMENT_POSITION = 0;
    private static final int FILE_PATH_ARGUMENT_POSITION = 1;
    private static final int KEY_ARGUMENT_POSITION = 2;

    public static void main(String[] args) {

        InputValidation inputValidation = new InputValidation();
        inputValidation.validateInput(args);
        inputValidation.validateCommand(args[COMMAND_ARGUMENT_POSITION]);
        inputValidation.validateFilePath(args[FILE_PATH_ARGUMENT_POSITION]);

        if (args.length == 3) {
            inputValidation.validateKey(args[KEY_ARGUMENT_POSITION]);
            FileHandler fileHandler = new FileHandler();
            String text = fileHandler.readFileToString(args[1]);
            String filePath = args[1];


            switch (args[COMMAND_ARGUMENT_POSITION]) {
                case "ENCRYPT":
                    EncryptService encryptService = new EncryptService();
                    fileHandler.writeStringToFile(filePath, encryptService.encrypt(text, Integer.parseInt(args[2])), "ENCRYPT");
                    System.out.println("Successfully encrypted");
                    break;

                case "DECRYPT":
                    DecryptService decryptService = new DecryptService();
                    fileHandler.writeStringToFile(filePath, decryptService.decrypt(text, -Integer.parseInt(args[2])), "DECRYPT");
                    System.out.println("Successfully decrypted");
                    break;

                case "BRUTE_FORCE":
                    BruteForceService bruteForceService = new BruteForceService();
                    fileHandler.writeStringToFile(filePath, bruteForceService.bruteForceDecrypt(text), "BRUTE_FORCE");
                    System.out.println("Successfully brute forced");
            }
        } else {
            FileHandler fileHandler = new FileHandler();
            String text = fileHandler.readFileToString(args[1]);
            if (args[COMMAND_ARGUMENT_POSITION].equals("BRUTE_FORCE")) {
                String filePath = args[1];
                BruteForceService bruteForceService = new BruteForceService();
                fileHandler.writeStringToFile(filePath, bruteForceService.bruteForceDecrypt(text), "BRUTE_FORCE");
                System.out.println("Successfully brute forced");
            } else {
                throw new InvalidArgumentException("For arguments ENCRYPT, DECRYPT you need to set a key (shift)");
            }
        }
    }


}