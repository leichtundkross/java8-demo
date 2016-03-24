package com.github.leichtundkross.java8.optional;

import java.util.Optional;

public class SoundcardWithJava8 {

	private Optional<USB> usb = Optional.empty();

	public Optional<USB> getUsb() {
		return usb;
	}

	public void setUsb(USB usb) {
		this.usb = Optional.ofNullable(usb);
	}
}
