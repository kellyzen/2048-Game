package com.example.game.resource.directory;

import com.example.game.resource.ResourcePath;

/**
 *
 * ResourceDocuments class.
 * Extends ResourcePath class.
 * Get resource file in document folder.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ResourceDocuments extends ResourcePath {
    private final String folderName = "documents/";
    private final String[] fileTypes = {"txt"};

    /**
     *
     * Get all file type in document folder (.txt)
     *
     * @return String[] all file type in document folder
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
     * @return String URI to document file
     */
    @Override
    public String getPath(String fileType, String fileName) {
        return fullPath() + folderName + fileName +"."+ fileType;
    }
}
