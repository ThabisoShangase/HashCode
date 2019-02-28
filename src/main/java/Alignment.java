package main.java;

public enum Alignment {

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
