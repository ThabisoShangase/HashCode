package main.java;

import java.util.ArrayList;
import java.util.List;

public class Photo {
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
