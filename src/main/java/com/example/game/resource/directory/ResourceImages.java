package com.example.game.resource.directory;

import com.example.game.resource.ResourcePath;

/**
 *
 * ResourceImages class.
 * Extends ResourcePath class.
 * Get resource file in images folder.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ResourceImages extends ResourcePath {
    private final String folderName = "images/";
    private final String[] fileTypes = {"png", "gif"};

    /**
     *
     * Get all file type in images folder (.png, .gif)
     *
     * @return String[] all file type in images folder
     */
    @Override
    public String[] getFileTypes() {
        return fileTypes;
    }

    /**
     *
     * Get URI to document file from resource folder.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to images file
     */
    @Override
    public String getPath(String fileType, String fileName) {
        return generalPath() + folderName + fileName +"."+ fileType;
    }
}
