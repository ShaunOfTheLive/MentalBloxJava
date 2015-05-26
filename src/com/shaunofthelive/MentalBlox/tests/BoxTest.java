package com.shaunofthelive.MentalBlox.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.shaunofthelive.MentalBlox.models.Box;

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

	@Test
	public void testGetHoleRow() {
		Box box = new Box(3);
		assertThat(box.getHoleRow(box.getHole(3)), is(0));
		assertThat(box.getHoleRow(box.getHole(4)), is(0));
		assertThat(box.getHoleRow(box.getHole(5)), is(0));
		assertThat(box.getHoleRow(box.getHole(6)), is(1));
		assertThat(box.getHoleRow(box.getHole(7)), is(1));
		assertThat(box.getHoleRow(box.getHole(8)), is(1));
		assertThat(box.getHoleRow(box.getHole(9)), is(2));
		assertThat(box.getHoleRow(box.getHole(10)), is(2));
		assertThat(box.getHoleRow(box.getHole(11)), is(2));
	}
	
	@Test
	public void testGetHoleCol() {
		Box box = new Box(3);
		assertThat(box.getHoleCol(box.getHole(3)), is(0));
		assertThat(box.getHoleCol(box.getHole(4)), is(1));
		assertThat(box.getHoleCol(box.getHole(5)), is(2));
		assertThat(box.getHoleCol(box.getHole(6)), is(0));
		assertThat(box.getHoleCol(box.getHole(7)), is(1));
		assertThat(box.getHoleCol(box.getHole(8)), is(2));
		assertThat(box.getHoleCol(box.getHole(9)), is(0));
		assertThat(box.getHoleCol(box.getHole(10)), is(1));
		assertThat(box.getHoleCol(box.getHole(11)), is(2));
	}
}
