package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MultiFolderImpl implements MultiFolder{

    private String name;
    private String size;
    private List<Folder> folders;

    public MultiFolderImpl(String name, String size, List<Folder> folders) {
        this.name = name;
        this.size = size;
        this.folders = new ArrayList<>();
    }

    public MultiFolderImpl(String name, String size) {
        this.name = name;
        this.size = size;
        this.folders = new ArrayList<>();
    }

    @Override
    public List<Folder> getFolders() {
        return folders;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }
}
