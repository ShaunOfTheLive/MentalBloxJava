package com.shaunofthelive.MentalBlox.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.shaunofthelive.MentalBlox.models.Board;

public class BoardTest {

	@Test
	public void testBoard() {
		Board board = new Board();
		assertThat(board, notNullValue());
	}

	@Test
	public void testGetBox() {
		Board board = new Board();
		assertThat(board.getBox(3).getNumber(), is(3));
		assertThat(board.getBox(3).getHole(5).getNumber(), is(5));
	}

}
