package com.shaunofthelive.MentalBlox;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGame() {
		Game game = new Game();
		assertThat(game, notNullValue());
	}
	
}
