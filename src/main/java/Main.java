package main.java;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int horizontals = 0;
    static int verticals = 0;

    public static void main(String[] args) throws Exception {
//        FileReader fileReader = new FileReader("C:\\do\\hash\\HashCode\\src\\main\\resources\\c_memorable_moments.txt");
        FileReader fileReader = new FileReader("C:\\do\\hash\\HashCode\\src\\main\\resources\\b_lovely_landscapes.txt");
//        FileReader fileReader = new FileReader("C:\\do\\hash\\HashCode\\src\\main\\resources\\d_pet_pictures.txt");

        Scanner fileScanner = new Scanner(fileReader);

        List<Photo> photos = new ArrayList<>();
        int numberOfPhotos = Integer.valueOf(fileScanner.nextLine());
        int id = 0;
        while (fileScanner.hasNext()) {
            String nextLine = fileScanner.nextLine();
            Scanner valueScanner = new Scanner(nextLine);
            Photo photo = new Photo();
            photo.setId(id);
            Alignment alignment = Alignment.findByDescription(valueScanner.next());
            photo.setAlignment(alignment);
            if (alignment == Alignment.HORIZONTAL) {
                horizontals++;
            } else {
                verticals++;
            }
            photo.setNumOfTags(Integer.valueOf(valueScanner.next()));

            while (valueScanner.hasNext()) {
                photo.getTags().add(valueScanner.next());
            }
            photos.add(photo);
            id++;
        }

        System.out.println(photos.size());

        FileWriter fileWriter = new FileWriter("C:\\do\\hash\\HashCode\\src\\main\\resources\\output.txt");
//        dealWithThemPhotos(photos, fileWriter);
        dealWithVerticalPhotos(photos, fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void dealWithThemPhotos(List<Photo> photos, FileWriter fileWriter) throws IOException {
        fileWriter.append("" + horizontals + "\n");
        for (Photo photo: photos) {
            if (photo.getAlignment() == Alignment.HORIZONTAL) {
                fileWriter.append("" + photo.getId() + "\n");
            }
        }
    }

    public static void dealWithVerticalPhotos(List<Photo> photos, FileWriter fileWriter) throws IOException {
        int numberOfFrames = 0;
        String end = "";
        Frame frame = new Frame();

        for (Photo photo: photos) {
            if (photo.getAlignment() == Alignment.VERTICAL && !frame.isComplete()) {
                frame.addPhoto(photo);
            } else if(photo.getAlignment() == Alignment.HORIZONTAL){
                end = end + photo.getId() + "\n";
                numberOfFrames++;
            }

            if (frame.isComplete()){
                end = end + frame.getPhotos().get(0).getId() + " " + frame.getPhotos().get(1).getId() + "\n";
                frame = new Frame();
                numberOfFrames++;
            }
        }
        fileWriter.append(numberOfFrames + "\n");
        fileWriter.append(end);
    }



}

enum Alignment {

    VERTICAL("V"),
    HORIZONTAL("H");

    String description;

    Alignment(String description) {
        this.description = description;
    }

    public static Alignment findByDescription(String description) {
        for (Alignment alignment: values()) {
            if (alignment.description.equals(description)) {
                return alignment;
            }
        }
        return null;
    }
}

class Photo {
    int id;
    Alignment alignment;
    int numOfTags;
    List<String> tags = new ArrayList<>();

    public Photo() {
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(final Alignment alignment) {
        this.alignment = alignment;
    }

    public int getNumOfTags() {
        return numOfTags;
    }

    public void setNumOfTags(final int numOfTags) {
        this.numOfTags = numOfTags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
    }
}

class Frame{
    List<Photo> photos = new ArrayList<>();

    public Frame() {
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public void addPhoto(Photo photo){
        photos.add(photo);
    }

    public boolean isComplete(){
        return photos.size() == 2;
    }
}

