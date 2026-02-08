package com.example.demo;

import java.util.*;
;

public class FileCabinet implements Cabinet {
    private List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = new ArrayList<>();
    }

    public FileCabinet() {
        this.folders = new ArrayList<>();
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        Queue<Folder> queue = new LinkedList<>();

        queue.addAll(folders);

        while (!queue.isEmpty()) {
            Folder current = queue.poll();

            if (current.getName().equals(name)) {
                return Optional.of(current);
            }

            if (current instanceof MultiFolder) {
                MultiFolder multiFolder = (MultiFolder) current;
                queue.addAll(multiFolder.getFolders());
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        List<Folder> result = new ArrayList<>();
        Queue<Folder> queue = new LinkedList<>();

        queue.addAll(folders);

        while (!queue.isEmpty()) {
            Folder current = queue.poll();

            if (current.getSize().equals(size)) {
                result.add(current);
            }

            if (current instanceof MultiFolder) {
                MultiFolder multiFolder = (MultiFolder) current;
                queue.addAll(multiFolder.getFolders());
            }
        }
        return result;
    }

    @Override
    public int count() {
        int count = 0;
        Queue<Folder> queue = new LinkedList<>();

        queue.addAll(folders);

        while (!queue.isEmpty()) {
            Folder current = queue.poll();
            count++;

            if (current instanceof MultiFolder) {
                MultiFolder multiFolder = (MultiFolder) current;
                queue.addAll(multiFolder.getFolders());
            }
        }
        return count;
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }
}
