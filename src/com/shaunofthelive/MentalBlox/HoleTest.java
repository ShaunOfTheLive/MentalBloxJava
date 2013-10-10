package com.shaunofthelive.MentalBlox;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class HoleTest {

	@Test
	public void testHole() {
		Hole hole = new Hole(3, null);
		assertThat(hole, notNullValue());
	}

	@Test
	public void testIsCaptured() {
		Hole hole = new Hole(3, null);
		assertThat(hole.isCaptured(), is(false));
		hole.capture(1);
		assertThat(hole.isCaptured(), is(true));
		hole.capture(0);
		assertThat(hole.isCaptured(), is(false));
	}

	@Test
	public void testGetSetOwner() {
		Hole hole = new Hole(3, null);
		hole.capture(1);
		assertThat(hole.getOwner(), is(1));
	}

	@Test
	public void testGetNumber() {
		Hole hole = new Hole(3, null);
		assertThat(hole.getNumber(), is(3));
		hole = new Hole(6, null);
		assertThat(hole.getNumber(), is(6));
	}

}
