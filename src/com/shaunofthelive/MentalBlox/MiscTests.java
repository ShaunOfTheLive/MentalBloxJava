package com.shaunofthelive.MentalBlox;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.shaunofthelive.MentalBlox.Box.Box;

public class MiscTests {

	@Test
	public void captureTestFiveHoles() {
		Box box = new Box(3);
		assertThat(box.isCaptured(), is(false));
		
		box.getHole(3).capture(1);
		assertThat(box.isCaptured(), is(false));
		
		box.getHole(4).capture(1);
		assertThat(box.isCaptured(), is(false));
		
		box.getHole(8).capture(1);
		assertThat(box.isCaptured(), is(false));
		
		box.getHole(9).capture(1);
		assertThat(box.isCaptured(), is(false));
		
		box.getHole(10).capture(1);
		assertThat(box.isCaptured(), is(true));
	}

}
