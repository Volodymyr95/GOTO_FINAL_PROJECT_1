import IO.FileHandler;
import exception.InvalidArgumentException;
import model.Mode;
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
            switch (args[COMMAND_ARGUMENT_POSITION]) {
                case "ENCRYPT":
                    EncryptService encryptService = new EncryptService();
                    System.out.println(encryptService.encrypt(text, Integer.parseInt(args[2])));
                    break;

                case "DECRPYT":
                    DecryptService decryptService = new DecryptService();
                    System.out.println(decryptService.decrypt(text, Integer.parseInt(args[2])));
                    break;

                case "BRUTE_FORCE":
                    BruteForceService bruteForceService = new BruteForceService();
                    System.out.println(bruteForceService.bruteForceDecrypt(text));
            }
        }
        else {
            FileHandler fileHandler = new FileHandler();
            String text = fileHandler.readFileToString(args[1]);
            if (args[COMMAND_ARGUMENT_POSITION].equals("BRUTE_FORCE")) {
                BruteForceService bruteForceService = new BruteForceService();
                System.out.println(bruteForceService.bruteForceDecrypt(text));
            }
            else {
                throw new InvalidArgumentException("For arguments ENCRYPT, DECRYPT you need to set a key (shift)");
            }
        }
    }


}