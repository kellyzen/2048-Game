package com.example.game.resource;

/**
 *
 * Resource interface.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public interface Resource {
    /**
     *
     * Get URI to specific file from resource folder.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to the file
     */
    String getPath(String fileType, String fileName);
}
