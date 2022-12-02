package com.example.game.resource.directory;

import com.example.game.resource.ResourcePath;

public class ResourceImages extends ResourcePath {
    private final String folderName = "images/";
    private final String[] fileTypes = {"png", "gif"};

    @Override
    public String[] getFileTypes() {
        return fileTypes;
    }

    @Override
    public String getPath(String fileType, String fileName) {
        return generalPath() + folderName + fileName +"."+ fileType;
    }
}
