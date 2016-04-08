package com.github.leichtundkross.java8.optional;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.leichtundkross.java8.optional.model.Computer;
import com.github.leichtundkross.java8.optional.model.Soundcard;
import com.github.leichtundkross.java8.optional.model.USB;

public class VersionServiceTest {

	@Test
	public void getUSBVersion() {
		Computer computer = createComputer();

		String usbVersion = new VersionService().getUSBVersion(computer);

		assertEquals("3.0", usbVersion);
	}

	@Test
	public void getUSBVersionWithJava8() {
		Computer computer = createComputer();

		String usbVersion = new VersionService().getUSBVersionWithJava8(computer);

		assertEquals("3.0", usbVersion);
	}

	// ------------------------------------------

	@Test
	public void supportsUSB30() {
		Computer computer = createComputer();

		boolean supportsUSB30 = new VersionService().supportsUSB30(computer);

		assertEquals(true, supportsUSB30);
	}

	@Test
	public void supportsUSB30_usbNull() {
		Computer computer = createComputer();
		computer.getSoundcard().setUsb(null);

		boolean supportsUSB30 = new VersionService().supportsUSB30(computer);

		assertEquals(false, supportsUSB30);
	}

	@Test
	public void supportsUSB30WithJava8() {
		Computer computer = createComputer();

		boolean supportsUSB30 = new VersionService().supportsUSB30WithJava8(computer);

		assertEquals(true, supportsUSB30);
	}

	@Test
	public void supportsUSB30WithJava8_usbNull() {
		Computer computer = createComputer();
		computer.getSoundcard().setUsb(null);

		boolean supportsUSB30 = new VersionService().supportsUSB30(computer);

		assertEquals(false, supportsUSB30);
	}

	// ------------------------------------------

	private static Computer createComputer() {
		USB usb = new USB();
		usb.setVersion("3.0");
		Soundcard soundcard = new Soundcard();
		soundcard.setUsb(usb);
		Computer computer = new Computer();
		computer.setSoundcard(soundcard);
		return computer;
	}
}
