package main.java;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("C:\\do\\hash\\HashCode\\src\\main\\resources\\b_lovely_landscapes.txt");

        Scanner fileScanner = new Scanner(fileReader);

        List<Photo> photos = new ArrayList<>();
        int numberOfPhotos = Integer.valueOf(fileScanner.nextLine());
        while (fileScanner.hasNext()) {
            String nextLine = fileScanner.nextLine();
            Scanner valueScanner = new Scanner(nextLine);
            Photo photo = new Photo();
            photo.setAlignment(Alignment.findByDescription(valueScanner.next()));
            photo.setNumOfTags(Integer.valueOf(valueScanner.next()));

            while (valueScanner.hasNext()) {
                photo.getTags().add(valueScanner.next());
            }
            photos.add(photo);
        }

        System.out.println(photos.size());

        FileWriter fileWriter = new FileWriter("C:\\do\\hash\\HashCode\\src\\main\\resources\\output.txt");
        fileWriter.append("What the fuck");
        fileWriter.flush();
        fileWriter.close();
    }
}
