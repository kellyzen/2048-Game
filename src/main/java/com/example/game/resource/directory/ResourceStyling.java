package com.example.game.resource.directory;

import com.example.game.resource.ResourcePath;

public class ResourceStyling extends ResourcePath {
    private final String folderName = "styling/";
    private final String[] fileTypes = {"css"};

    @Override
    public String[] getFileTypes() {
        return fileTypes;
    }

    @Override
    public String getPath(String fileType, String fileName) {
        return generalPath() + folderName + fileName +"."+ fileType;
    }
}
