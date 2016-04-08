package com.github.leichtundkross.java8.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.github.leichtundkross.java8.streams.model.Album;
import com.github.leichtundkross.java8.streams.model.Track;

public class Streams {

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
				.filter(album -> album.getTracks().stream().anyMatch(checkRatingFor(4))) //
				.sorted(Comparator.comparing(album -> album.getName())) //
				.collect(Collectors.toList());
	}

	private Predicate<? super Track> checkRatingFor(int minimumRating) {
		return track -> track.getRating() >= minimumRating;
	}
}
