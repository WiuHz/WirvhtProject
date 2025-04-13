package project1telegramoop;


import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

public class File{
    private File file;
    private int fileID;
    private String fileName;
    private int fileSize;
    private String filePath;
    private String fileType;

    public File(File file, int fileID, String fileName, int fileSize, String filePath, String fileType){
        new File(filePath);
        this.fileID = fileID;
        this.fileName = fileName;
        this.fileSize = (int) file.length();
        this.filePath = filePath;
        this.fileType = fileType;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getFileName(String fileName){
        return fileName;
    }

    public void setFileSize(int fileSize){
        this.fileSize = fileSize;
    }
    public int getFileSize(){
        return fileSize;
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
    public String getFilePath(){
        return filePath;
    }

    public void setFileType(String fileType){
        this.fileType = fileType;
    }
    public String getFileType(){
        return fileType;
    }

    private String getFileType(File file){
        String fileName = file.getFileName();
        int dotPlace = fileName.lastIndexOf('.');
        if (dotPlace > 0){
            return fileName.subString(dotPlace +1);
        }
        else{
            return "Unknown";
        }
    }
}