package com.shaunofthelive.MentalBlox;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BoxTest {

	@Test
	public void testBox() {
		Box box = new Box(3);
		assertThat(box, notNullValue());
	}

	@Test
	public void testGetHole() {
		Box box = new Box(3);
		assertThat(box.getHole(5).getNumber(), is(5));
	}

	@Test
	public void testIsCaptured() {
		Box box = new Box(3);
		box.capture(1);
		assertThat(box.isCaptured(), is(true));
	}

	@Test
	public void testCapture() {
		Box box = new Box(3);
		box.capture(1);
		assertThat(box.getOwner(), is(1));
		for (int i = 0; i < 9; i++) {
			assertThat(box.getHole(i+3).getOwner(), is(1));
		}
	}

	@Test
	public void testGetOwner() {
		Box box = new Box(3);
		box.capture(1);
		assertThat(box.getOwner(), is(1));
	}

	@Test
	public void testGetNumber() {
		Box box = new Box(3);
		assertThat(box.getNumber(), is(3));
	}

}
