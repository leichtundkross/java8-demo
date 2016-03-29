package com.github.leichtundkross.java8.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Album {

	private String name;

	private Collection<Track> tracks = new ArrayList<>();

	public Album(String name) {
		this.name = name;
	}

	public Album addTrack(Track track) {
		tracks.add(track);
		return this;
	}

	public String getName() {
		return name;
	}

	public Collection<Track> getTracks() {
		return Collections.unmodifiableCollection(tracks);
	}
}
