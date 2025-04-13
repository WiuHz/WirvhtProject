package project1telegramoop;

public class TestTelegramFile{
    public static void main(String[] args){
        File file = new File();
        System.out.println(file.getFileName());
        System.out.println(file.getFileSize());
        System.out.println(file.getFilePath());
        System.out.println(file.getFileType());
    }
}