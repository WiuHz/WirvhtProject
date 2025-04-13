package project1telegramoop;

import project1telegramoop.MyFile;

public class Image extends MyFile{
    private int height;
    private int width;
    private int resolution;
    private Image image;

    public Image(String fileName, int fileSize, String filePath, String fileType, int height, int width, int resolution, Image image){
        super(fileName, fileSize, filePath, fileType);
        this.height = height;
        this.width = width;
        this.resolution = resolution;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return height;
    }

    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return width;
    }

    public void setResolution(int resolution){
        this.resolution = resolution;
    }
    public int getResolution(){
        return resolution;
    }

    public int getPixelsResolution(){
        return height*width;
    }
}