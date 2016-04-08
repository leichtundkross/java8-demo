package com.github.leichtundkross.java8.optional.model;

import java.util.Optional;

public class Computer {

	private Soundcard soundcard = null;

	public Soundcard getSoundcard() {
		return soundcard;
	}

	public Optional<Soundcard> getSoundcardNullSafe() {
		return Optional.ofNullable(soundcard);
	}

	public void setSoundcard(Soundcard soundcard) {
		this.soundcard = soundcard;
	}
}
