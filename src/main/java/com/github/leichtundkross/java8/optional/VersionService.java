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

	public String getUSBVersionWithJava8(Computer computer) {
		String version = computer.getSoundcardNullSafe() //
				.flatMap(Soundcard::getUsbNullSafe) //
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

	public boolean supportsUSB30WithJava8(Computer computer) {
		boolean supportsUSB30 = computer.getSoundcardNullSafe() //
				.flatMap(Soundcard::getUsbNullSafe) //
				.map(usb -> "3.0".equals(usb.getVersion())) //
				.isPresent();

		return supportsUSB30;
	}
}
