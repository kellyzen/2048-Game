package com.example.game.resource.directory;

import com.example.game.resource.ResourcePath;

public class ResourceDocuments extends ResourcePath {
    private final String folderName = "documents/";
    private final String[] fileTypes = {"txt"};

    @Override
    public String[] getFileTypes() {
        return fileTypes;
    }

    @Override
    public String getPath(String fileType, String fileName) {
        return fullPath() + folderName + fileName +"."+ fileType;
    }
}
