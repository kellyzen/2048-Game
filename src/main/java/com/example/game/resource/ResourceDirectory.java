package com.example.game.resource;

import com.example.game.resource.directory.ResourceDocuments;
import com.example.game.resource.directory.ResourceGUI;
import com.example.game.resource.directory.ResourceImages;
import com.example.game.resource.directory.ResourceStyling;

/**
 *
 * ResourceDirectory class.
 * Calls specific resource class based on fileType.
 *
 * @author Kelly Kai Ling Tan
 * @version Dec 16, 2022
 * @author Coursework: COMP2042
 *
 */
public class ResourceDirectory {
    /**
     *
     * Get URI to specific file from resource folder.
     * Calls respective resource directory based on filetype.
     * Load the file based on filename if exists.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to the file requested
     */
    public String getResource(String fileType, String fileName) {
        if(getStylingDirectory (fileType, fileName) !=null) {
            return getStylingDirectory (fileType, fileName);
        }
        if(getImagesDirectory (fileType, fileName) !=null) {
            return getImagesDirectory (fileType, fileName);
        }
        if(getGUIDirectory (fileType, fileName) !=null) {
            return getGUIDirectory (fileType, fileName);
        }
        if(getDocumentsDirectory (fileType, fileName) !=null) {
            return getDocumentsDirectory (fileType, fileName);
        }
        return null;
    }

    /**
     *
     * Get URI to styling directory from resource folder.
     * Load the styling file based on filename if exists.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to the file requested
     */
    private String getStylingDirectory (String fileType, String fileName) {
        String[] fileTypes = new ResourceStyling().getFileTypes();
        for (String type: fileTypes) {
            if(type.equalsIgnoreCase(fileType)){
                return new ResourceStyling().getPath(fileType,fileName);
            }
        }
        return null;
    }

    /**
     *
     * Get URI to images directory from resource folder.
     * Load the styling file based on filename if exists.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to the file requested
     */
    private String getImagesDirectory (String fileType, String fileName) {
        String[] fileTypes = new ResourceImages().getFileTypes();
        for (String type: fileTypes) {
            if(type.equalsIgnoreCase(fileType)){
                return new ResourceImages().getPath(fileType,fileName);
            }
        }
        return null;
    }

    /**
     *
     * Get URI to GUI directory from resource folder.
     * Load the styling file based on filename if exists.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to the file requested
     */
    private String getGUIDirectory (String fileType, String fileName) {
        String[] fileTypes = new ResourceGUI().getFileTypes();
        for (String type: fileTypes) {
            if(type.equalsIgnoreCase(fileType)){
                return new ResourceGUI().getPath(fileType,fileName);
            }
        }
        return null;
    }

    /**
     *
     * Get URI to documents directory from resource folder.
     * Load the styling file based on filename if exists.
     *
     * @param fileName file name to be loaded
     * @param fileType file type to be loaded
     * @return String URI to the file requested
     */
    private String getDocumentsDirectory (String fileType, String fileName) {
        String[] fileTypes = new ResourceDocuments().getFileTypes();
        for (String type: fileTypes) {
            if(type.equalsIgnoreCase(fileType)){
                return new ResourceDocuments().getPath(fileType,fileName);
            }
        }
        return null;
    }
}
