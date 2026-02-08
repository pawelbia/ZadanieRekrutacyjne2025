package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;
;

public class FileCabinet implements Cabinet {
    private List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = new ArrayList<>();
    }

    public FileCabinet() {
        this.folders = new ArrayList<>();
    }

    public List<Folder> getAllFolders() {
        List<Folder> allFolders = new ArrayList<>();
        Queue<Folder> queue = new LinkedList<>(folders);

        while (!queue.isEmpty()) {
            Folder current = queue.poll();
            allFolders.add(current);

            if (current instanceof MultiFolder) {
                MultiFolder multiFolder = (MultiFolder) current;
                queue.addAll(multiFolder.getFolders());
            }
        }

        return allFolders;
    }


        @Override
    public Optional<Folder> findFolderByName(String name) {
        return getAllFolders().stream().filter(f -> f.getName().equals(name)).findFirst();
        }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return getAllFolders().stream().filter(f -> f.getSize().equals(size)).toList();
    }

    @Override
    public int count() {
        return getAllFolders().size();
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }
}
