package com.github.leichtundkross.java8.optional;

public class VersionService {

	private static final String VERSION_3_0 = "3.0";

	private static final String VERSION_UNKNOWN = "UNKNOWN";

	public String getUSBVersion(Computer computer) {
		String version = VERSION_UNKNOWN;
		Soundcard soundcard = computer.getSoundcard();
		if (soundcard != null) {
			USB usb = soundcard.getUsb();
			if (usb != null) {
				version = usb.getVersion();
			}
		}

		return version;
	}

	public String getUSBVersion(ComputerWithJava8 computer) {
		String version = computer.getSoundcard() //
				.flatMap(SoundcardWithJava8::getUsb) //
				.map(USB::getVersion) //
				.orElse(VERSION_UNKNOWN);

		return version;
	}

	public boolean supportsUSB30(Computer computer) {
		boolean supportsUSB30 = false;
		Soundcard soundcard = computer.getSoundcard();
		if (soundcard != null) {
			USB usb = soundcard.getUsb();
			if (usb != null) {
				String version = usb.getVersion();
				if (VERSION_3_0.equals(version)) {
					supportsUSB30 = true;
				}
			}
		}

		return supportsUSB30;
	}

	public boolean supportsUSB30(ComputerWithJava8 computer) {
		boolean supportsUSB30 = computer.getSoundcard() //
				.flatMap(SoundcardWithJava8::getUsb) //
				.filter(usb -> "3.0".equals(usb.getVersion())) //
				.isPresent() ? true : false;

		return supportsUSB30;
	}
}
