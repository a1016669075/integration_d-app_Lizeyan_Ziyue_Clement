package com.demo.constant;

public enum Types {
    IMAGE("image"),
    FILE("file"),
    MP3("mp3"),


    /**
     * L'URL où la pièce jointe est stockée
     */
    ATTACH_URL("attach_url");


    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Types(String type) {
        this.type = type;
    }
}
