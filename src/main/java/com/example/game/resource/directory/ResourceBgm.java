package com.example.game.resource.directory;

import com.example.game.resource.ResourcePath;

/**
 *
 * ResourceBgm class.
 * Extends ResourcePath class.
 * Get resource file in bgm folder.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ResourceBgm extends ResourcePath {
    private final String folderName = "bgm/";
    private final String[] fileTypes = {"mp3"};

    /**
     *
     * Get all file type in bgm folder (.mp3)
     *
     * @return String[] all file type in bgm folder
     */
    @Override
    public String[] getFileTypes() {
        return fileTypes;
    }

    /**
     *
     * Get URI to bgm file from resource folder.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to bgm file
     */
    @Override
    public String getPath(String fileType, String fileName) {
        return generalPath() + folderName + fileName +"."+ fileType;
    }

    /**
     *
     * Get URI to bgm directory from resource folder.
     *
     * @return String URI to bgm directory
     */
    public String getFolderPath() {
        return generalPath() + folderName;
    }
}
