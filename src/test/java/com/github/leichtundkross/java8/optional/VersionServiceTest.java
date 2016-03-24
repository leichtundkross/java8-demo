package com.github.leichtundkross.java8.optional;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VersionServiceTest {

	// ------------------------------------------

	@Test
	public void getUSBVersion() {
		Computer computer = createComputer();

		String usbVersion = new VersionService().getUSBVersion(computer);

		assertEquals("3.0", usbVersion);
	}

	@Test
	public void getUSBVersion_Java8() {
		ComputerWithJava8 computer = createComputerWithJava8();

		String usbVersion = new VersionService().getUSBVersion(computer);

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
	public void supportsUSB30_Java8() {
		ComputerWithJava8 computer = createComputerWithJava8();

		boolean supportsUSB30 = new VersionService().supportsUSB30(computer);

		assertEquals(true, supportsUSB30);
	}

	// ------------------------------------------

	private Computer createComputer() {
		USB usb = new USB();
		usb.setVersion("3.0");
		Soundcard soundcard = new Soundcard();
		soundcard.setUsb(usb);
		Computer computer = new Computer();
		computer.setSoundcard(soundcard);
		return computer;
	}

	private ComputerWithJava8 createComputerWithJava8() {
		USB usb = new USB();
		usb.setVersion("3.0");
		SoundcardWithJava8 soundcard = new SoundcardWithJava8();
		soundcard.setUsb(usb);
		ComputerWithJava8 computer = new ComputerWithJava8();
		computer.setSoundcard(soundcard);
		return computer;
	}
}
