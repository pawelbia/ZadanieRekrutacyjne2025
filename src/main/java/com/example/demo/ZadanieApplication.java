package com.example.demo;

import java.util.List;
import java.util.Optional;

public class ZadanieApplication {
	public static void main(String[] args) {
		FileCabinet cabinet = new FileCabinet();

		// Tworzenie folderów
		FolderImpl documents = new FolderImpl("Dokumenty", "MEDIUM");
		FolderImpl photos = new FolderImpl("Zdjęcia", "LARGE");
		FolderImpl music = new FolderImpl("Muzyka", "LARGE");

		// Tworzenie MultiFolder
		MultiFolderImpl projects = new MultiFolderImpl("Projekty", "LARGE");
		projects.addFolder(new FolderImpl("ProjektA", "SMALL"));
		projects.addFolder(new FolderImpl("ProjektB", "MEDIUM"));

		// Tworzenie zagnieżdżonego MultiFolder
		MultiFolderImpl clientProjects = new MultiFolderImpl("Klienci", "LARGE");
		clientProjects.addFolder(new FolderImpl("Klient1", "SMALL"));
		clientProjects.addFolder(new FolderImpl("Klient2", "SMALL"));
		projects.addFolder(clientProjects);

		cabinet.addFolder(documents);
		cabinet.addFolder(photos);
		cabinet.addFolder(music);
		cabinet.addFolder(projects);


		Optional<Folder> found = cabinet.findFolderByName("Klient1");

		List<Folder> largeFolders = cabinet.findFoldersBySize("LARGE");

		int total = cabinet.count();

		List<Folder> allFolders = cabinet.getAllFolders();
	}
}


