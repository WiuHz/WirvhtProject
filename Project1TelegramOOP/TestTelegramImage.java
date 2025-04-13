package project1telegramoop;

public class TestTelegramFile{
    public static void main(String[] args){
        Image image = new Image();
        System.out.println(image.getFileName());
        System.out.println(image.getFileSize());
        System.out.println(image.getFilePath());
        System.out.println(image.getFileType());
        System.out.println(image.getHeight());
        System.out.println(image.getWidth());
        System.out.println(image.getResolution());
    }
}