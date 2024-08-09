package com.jd.reflection.intro;

public class PopupTypeInfo {
    private boolean isPrimitive;
    private boolean isInterface;
    private boolean isEnum;

    private String name;
    private boolean isJdk;

    public PopupTypeInfo setPrimitive(boolean isPrimitive) {
        this.isPrimitive = isPrimitive;
        return this;
    }

    public PopupTypeInfo setInterface(boolean isInterface) {
        this.isInterface = isInterface;
        return this;
    }

    public PopupTypeInfo setEnum(boolean isEnum) {
        this.isEnum = isEnum;
        return this;
    }

    public PopupTypeInfo setName(String name) {
        this.name = name;
        return this;
    }

    public PopupTypeInfo setJdk(boolean isJdkType) {
        this.isJdk = isJdkType;
        return this;
    }

    public boolean isPrimitive() {
        return isPrimitive;
    }

    public boolean isInterface() {
        return isInterface;
    }

    public boolean isEnum() {
        return isEnum;
    }

    public String getName() {
        return name;
    }

    public boolean isJdk() {
        return isJdk;
    }


    @Override
    public String toString() {
        return "PopupTypeInfo{" +
                "isPrimitive=" + isPrimitive +
                ", isInterface=" + isInterface +
                ", isEnum=" + isEnum +
                ", name='" + name + '\'' +
                ", isJdk=" + isJdk +
                '}';
    }
}
