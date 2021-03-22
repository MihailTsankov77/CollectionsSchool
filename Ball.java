package zad4;

import java.awt.Color;
import java.util.Random;

class Ball {
	int x = (int) Math.round((Math.random()*760)+10);
	int y = (int) Math.round((Math.random()*760)+10); // Current ball position
	int dx = (int) Math.round((Math.random()*3)+2); // Increment on ball's x-coordinate
	int dy = (int) Math.round((Math.random()*3)+2); // Increment on ball's y-coordinate
	int radius = (int)(Math.random()*5) + 4; // Ball radius
	Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
}