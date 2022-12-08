package com.example.game.resource.directory;

import com.example.game.resource.ResourcePath;

/**
 *
 * Extends ResourcePath class.
 * Get resource file in styling folder.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ResourceStyling extends ResourcePath {
    private final String folderName = "styling/";
    private final String[] fileTypes = {"css"};

    /**
     *
     * Get all file type in styling folder (.css)
     *
     * @return String[] all file type in styling folder
     */
    @Override
    public String[] getFileTypes() {
        return fileTypes;
    }

    /**
     *
     * Get URI to styling file from resource folder.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to styling file
     */
    @Override
    public String getPath(String fileType, String fileName) {
        return generalPath() + folderName + fileName +"."+ fileType;
    }

    /**
     *
     * Get URI to styling directory from resource folder.
     *
     * @return String URI to styling directory
     */
    public String getFolderPath() {
        return generalPath() + folderName;
    }
}
