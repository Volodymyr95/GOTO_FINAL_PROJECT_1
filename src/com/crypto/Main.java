package com.crypto;

import com.crypto.model.Mode;
import com.crypto.service.DecryptService;

public class Main {
    public static void main(String[] args) {
        Mode someValueFromConsole = Mode.valueOf("Some value from console");
        switch (someValueFromConsole) {
            case DECRYPT:
                new DecryptService().decrypt(null, 1);
        }

    }
}
