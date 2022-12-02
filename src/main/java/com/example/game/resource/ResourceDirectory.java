package com.example.game.resource;

import com.example.game.resource.directory.ResourceDocuments;
import com.example.game.resource.directory.ResourceGUI;
import com.example.game.resource.directory.ResourceImages;
import com.example.game.resource.directory.ResourceStyling;

public class ResourceDirectory {
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

    private String getStylingDirectory (String fileType, String fileName) {
        String[] fileTypes = new ResourceStyling().getFileTypes();
        for (String type: fileTypes) {
            if(type.equalsIgnoreCase(fileType)){
                return new ResourceStyling().getPath(fileType,fileName);
            }
        }
        return null;
    }

    private String getImagesDirectory (String fileType, String fileName) {
        String[] fileTypes = new ResourceImages().getFileTypes();
        for (String type: fileTypes) {
            if(type.equalsIgnoreCase(fileType)){
                return new ResourceImages().getPath(fileType,fileName);
            }
        }
        return null;
    }

    private String getGUIDirectory (String fileType, String fileName) {
        String[] fileTypes = new ResourceGUI().getFileTypes();
        for (String type: fileTypes) {
            if(type.equalsIgnoreCase(fileType)){
                return new ResourceGUI().getPath(fileType,fileName);
            }
        }
        return null;
    }

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
