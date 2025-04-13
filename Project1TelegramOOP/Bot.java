package project1telegramoop;

import java.util.Arrays;
import java.util.List;

public class Bot implements TelegramAPI{
    private int botID;
    private String botName;
    private String question;
    private static final List<String> badWords = Arrays.asList("badword", "spam", "offensive");

    public Bot(int botID, String botName, String question){
        this.botID = botID;
        this.botName = botName;
        this.question = question;
    }
    public void setBotID(int botID){
        this.botID = botID;
    }
    public int getBotID(){
        return botID;
    }
    public void setBotName(String botName){
        this.botName = botName;
    }
    public String getBotName(){
        return botName;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getQuestion(){
        return question;
    }

    public void sendMessage(String message){
        System.out.println("Bot " + botName + " sent: " + message);
    }
    public void receiveMessage(String message){
        System.out.println("Bot " + botName + " received: " + message);
    }
    public void answerUserQuestion(String question){
        System.out.println("Bot " + botName + " answered: " + question);
    }
    public void checkingBadMessage(String message) {
        for (String badWord : badWords) {
            if (message.toLowerCase().contains(badWord)) {
                System.out.println("Bot " + botName + " detected a bad message: " + message);
                return;
            }
        }
        System.out.println("Bot " + botName + " did not detect any bad messages.");
    }
}