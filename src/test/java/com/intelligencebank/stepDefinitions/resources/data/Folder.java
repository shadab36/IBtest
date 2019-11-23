package com.intelligencebank.stepDefinitions.resources.data;

public class Folder {

    String name;

    public Folder(String folderName) {
        setName(folderName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
