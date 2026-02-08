package com.example.demo;

import java.util.List;
import java.util.Optional;

public class ZadanieApplication {
	public static void main(String[] args) {
		FileCabinet cabinet = new FileCabinet();

		// Tworzenie folderów
		FolderImpl folder1 = new FolderImpl("folder1", "MEDIUM");
		FolderImpl folder2 = new FolderImpl("folder2", "LARGE");
		FolderImpl folder3 = new FolderImpl("folder3", "LARGE");

		// Tworzenie MultiFolder
		MultiFolderImpl projects = new MultiFolderImpl("Projekty", "LARGE");
		projects.addFolder(new FolderImpl("Projekt1", "SMALL"));
		projects.addFolder(new FolderImpl("Projekt2", "MEDIUM"));

		MultiFolderImpl clientProjects = new MultiFolderImpl("Klienci", "LARGE");
		clientProjects.addFolder(new FolderImpl("Klient1", "SMALL"));
		clientProjects.addFolder(new FolderImpl("Klient2", "SMALL"));
		projects.addFolder(clientProjects);

		cabinet.addFolder(folder1);
		cabinet.addFolder(folder2);
		cabinet.addFolder(folder3);
		cabinet.addFolder(projects);


		Optional<Folder> found = cabinet.findFolderByName("Klient1");

		List<Folder> largeFolders = cabinet.findFoldersBySize("LARGE");

		int total = cabinet.count();

	}
}


