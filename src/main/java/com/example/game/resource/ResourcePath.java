package com.example.game.resource;

public abstract class ResourcePath implements Resource{

    public abstract String[] getFileTypes();
    public String generalPath() {
        return "/com/example/game/";
    }
    public String fullPath() {
        return "src/main/resources/com/example/game/";
    }
}
