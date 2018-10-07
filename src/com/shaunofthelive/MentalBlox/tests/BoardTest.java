package com.shaunofthelive.MentalBlox.tests;

import com.shaunofthelive.MentalBlox.models.Board;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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
