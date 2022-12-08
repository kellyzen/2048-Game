package com.example.game.resource.directory;

import com.example.game.resource.ResourcePath;


/**
 *
 * Extends ResourcePath class.
 * Get resource file in GUI folder.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ResourceGUI extends ResourcePath {
    private final String folderName = "GUI/";
    private final String[] fileTypes = {"fxml"};

    /**
     *
     * Get all file type in GUI folder (.fxml)
     *
     * @return String[] all file type in GUI folder
     */
    @Override
    public String[] getFileTypes() {
        return fileTypes;
    }

    /**
     *
     * Get URI to GUI file from resource folder.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to GUI file
     */
    @Override
    public String getPath(String fileType, String fileName) {
        return generalPath() + folderName + fileName +"."+ fileType;
    }
}
