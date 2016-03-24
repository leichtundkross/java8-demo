package com.github.leichtundkross.java8.optional;

import java.util.Optional;

public class ComputerWithJava8 {

	private Optional<SoundcardWithJava8> soundcard = Optional.empty();

	public Optional<SoundcardWithJava8> getSoundcard() {
		return soundcard;
	}

	public void setSoundcard(SoundcardWithJava8 soundcard) {
		this.soundcard = Optional.ofNullable(soundcard);
	}
}
