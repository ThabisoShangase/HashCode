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
        FileReader fileReader = new FileReader("C:\\do\\hash\\HashCode\\src\\main\\resources\\b_lovely_landscapes.txt");

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
        dealWithThemPhotos(photos, fileWriter);
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

}
