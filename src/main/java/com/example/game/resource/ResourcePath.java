package com.example.game.resource;

/**
 *
 * ResourcePath abstract class.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public abstract class ResourcePath implements Resource{

    /**
     *
     * Get all file type in specific folder.
     *
     * @return String[] all file type in specific folder
     */
    public abstract String[] getFileTypes();
    /**
     *
     * general URI to resource folder.
     *
     * @return String URI to resource folder.
     */
    public String generalPath() {
        return "/com/example/game/";
    }
    /**
     *
     * full URI to resource folder.
     *
     * @return String URI to resource folder.
     */
    public String fullPath() {
        return "src/main/resources/com/example/game/";
    }
}
