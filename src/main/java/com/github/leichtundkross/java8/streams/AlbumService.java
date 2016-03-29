package com.github.leichtundkross.java8.streams;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlbumService {

	public List<Album> findAlbumNamesHavingTracksRatedFourOrHigherSortedByName(Collection<Album> albumsToSearch) {
		List<Album> favs = new ArrayList<>();
		for (Album a : albumsToSearch) {
			boolean hasFavorite = false;
			for (Track t : a.getTracks()) {
				if (t.getRating() >= 4) {
					hasFavorite = true;
					break;
				}
			}

			if (hasFavorite) {
				favs.add(a);
			}
		}

		Collections.sort(favs, new Comparator<Album>() {

			public int compare(Album a1, Album a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});

		return favs;
	}

	public List<Album> findAlbumNamesHavingTracksRatedFourOrHigherSortedByNameWithJava8(Collection<Album> albumsToSearch) {
		return albumsToSearch.stream() //
				.filter(a -> a.getTracks().stream().anyMatch(t -> (t.getRating() >= 4))) //
				.sorted(comparing(a -> a.getName())) //
				.collect(Collectors.toList());
	}
}
