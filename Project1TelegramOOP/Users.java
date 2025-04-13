package project1telegramoop;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.nio.file.Files;

public class Users implements TelegramAPI {
    private int userID;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String message;
    private String behavior;
    private static Users user;
    private static Users recipient;
    private List<String> inbox;
    private List<Users> blockedList;
    private Set<String> validTokens = new HashSet<>(); 
    private static final Set<String> SPAM_KEYWORDS = Set.of("buy now", "click here", "free", "winner");

    public Users(int userID, String userName, String firstName, String lastName, String email, String phoneNumber, String message, String behavior){
        this.userID = userID;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.behavior = behavior;
        this.inbox = new ArrayList<>();
        this.blockedList = new ArrayList<>();
    }

    public void setUserID(int userID){
        this.userID = userID;
    }
    public int getUserID(){
        return userID;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

    public void setBehavior(String behavior){
        this.behavior = behavior;
    }
    public String getBehavior(){
        return behavior;
    }

    public boolean checkAccount(){
        if((this.firstName + this.lastName).equals(this.userName)){
            return true;
        }
        else{
            return false;
        }
    }

    public void blockedUser(Users user){
        blockedList.add(user);
        System.out.println("This " + user.getUserName() + " has been blocked!");
    }

    public void unblockedUser(Users user){
        blockedList.remove(user);
        System.out.println("This " + user.getUserName() + " has been unblocked!");
    }

    public boolean isBlocked(Users user){
        for(Users i : blockedList){
            if(user.equals(i)){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void sendingMessage(Users recipient, String message){
        if(!recipient.isBlocked(user)){
            recipient.inbox.add(message);
            System.out.println(recipient.getMessage());
        }
        else{
            System.out.println("User is blocked!");
        }
    }

    public void receivingMessage(Users user, String message){
        if(isBlocked(user)){
            System.out.println("This " + user.getUserName() + " has been already blocked before!");
        }
        else{
            inbox.add(message);
            System.out.println(user.getMessage());
        }
    }

    @Override
    public void startSecretChat(Users user1, Users user2) {
        System.out.println("Starting secret chat between " + user1.getUserName() + " and " + user2.getUserName());
    }
    @Override
    public String encryptMessage(String message, Users sender){
        int key = sender.getUserID() % 256;
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            encryptedMessage.append((char) (c ^ key));
        }
        return encryptedMessage.toString();
    }
    @Override
    public boolean verifyAccess(String token) {
        return validTokens.contains(token);
    }
    @Override
    public boolean checkSpam(String message, Users sender) {
        String lowered = message.toLowerCase();
        for (String keyword : SPAM_KEYWORDS) {
            if (lowered.contains(keyword)) {
                System.out.println("Spam detected from " + sender.getUserName());
                return true;
            }
        }
        return false;
    }
    public void addValidToken(String token) {
        validTokens.add(token);
    }
    public void removeToken(String token) {
        validTokens.remove(token);
    }
}