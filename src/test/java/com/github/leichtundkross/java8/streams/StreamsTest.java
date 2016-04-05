package com.github.leichtundkross.java8.streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.github.leichtundkross.java8.streams.model.Album;
import com.github.leichtundkross.java8.streams.model.Track;

public class StreamsTest {

	private Streams service = new Streams();

	@Test
	public void findAlbumNamesHavingTracksRatedFourOrHigherSortedByName() {
		Collection<Album> albumsToSearch = createAlbums();

		List<Album> favorites = service.findAlbumNamesHavingTracksRatedFourOrHigherSortedByName(albumsToSearch);

		assertEquals(2, favorites.size());
		assertEquals("album2", favorites.get(0).getName());
		assertEquals("album4", favorites.get(1).getName());
	}

	@Test
	public void findAlbumNamesHavingTracksRatedFourOrHigherSortedByNameWithJava8() {
		Collection<Album> albumsToSearch = createAlbums();

		List<Album> favorites = service.findAlbumNamesHavingTracksRatedFourOrHigherSortedByNameWithJava8(albumsToSearch);

		assertEquals(2, favorites.size());
		assertEquals("album2", favorites.get(0).getName());
		assertEquals("album4", favorites.get(1).getName());
	}

	private static Collection<Album> createAlbums() {
		Collection<Album> albumsToSearch = Arrays.asList(
				new Album("album1").addTrack(new Track(1)).addTrack(new Track(1)).addTrack(new Track(3)).addTrack(new Track(2)), //
				new Album("album4").addTrack(new Track(1)).addTrack(new Track(1)).addTrack(new Track(10)), //
				new Album("album3").addTrack(new Track(0)).addTrack(new Track(2)).addTrack(new Track(2)), //
				new Album("album2").addTrack(new Track(1)).addTrack(new Track(6)) //
		);

		return albumsToSearch;
	}
}
