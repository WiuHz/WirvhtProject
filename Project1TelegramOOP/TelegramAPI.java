package project1telegramoop;

import java.util.List;

public interface TelegramAPI {

    void startSecretChat(Users user1, Users user2);
    String encryptMessage(String message, Users sender);
    boolean verifyAccess(String token);

    boolean checkSpam(String message, Users sender);
}