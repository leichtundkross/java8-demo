package com.github.leichtundkross.java8.optional.model;

import java.util.Optional;

public class Soundcard {

	private USB usb = null;

	public USB getUsb() {
		return usb;
	}

	public Optional<USB> getUsbNullSafe() {
		return Optional.ofNullable(usb);
	}

	public void setUsb(USB usb) {
		this.usb = usb;
	}
}
