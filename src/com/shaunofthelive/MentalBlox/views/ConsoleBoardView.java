package com.shaunofthelive.MentalBlox.views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsoleBoardView implements IBoardView {
    final int ROWS = 24;
    final int COLS = 80;
    char[][] board = new char [ROWS][COLS];

    public ConsoleBoardView() {
        String file = "res/ConsoleBoardView.txt";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                board[i] = line.toCharArray();
                ++i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(char[][] g) {
        for (int i = 0; i < g.length; ++i) {
            g[i] = board[i];
        }
    }
}
