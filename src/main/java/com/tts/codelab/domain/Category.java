package com.tts.codelab.domain;

public enum Category {

    JAVA("Java"), Frontend("Frontend"), IOT("IOT");

    private String friendlyName;

    private Category(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }

}
