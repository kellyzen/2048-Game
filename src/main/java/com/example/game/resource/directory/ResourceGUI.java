package com.example.game.resource.directory;


import com.example.game.resource.ResourcePath;

public class ResourceGUI extends ResourcePath {
    private final String folderName = "GUI/";
    private final String[] fileTypes = {"fxml"};

    @Override
    public String[] getFileTypes() {
        return fileTypes;
    }

    @Override
    public String getPath(String fileType, String fileName) {
        return generalPath() + folderName + fileName +"."+ fileType;
    }
}
