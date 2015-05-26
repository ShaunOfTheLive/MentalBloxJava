package com.shaunofthelive.MentalBlox.views;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Path2D;

public class BoxView {
	private Point topLeft;
	private int width;
	
	public BoxView() {
		this.topLeft = null;
		this.width = 0;
	}
	
	public BoxView(Point topLeft, int width) {
		this.topLeft = topLeft;
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}

	public void draw(Graphics2D g2d) {
		//draw centre lines
		double perpDist = 0.4*width;
		double parDist = 0.48*width;
		double invPerpDist = (1-0.4)*width;
		double invParDist = (1-0.48)*width;
		
		double x = topLeft.x;
		double y = topLeft.y;

	    Path2D p1 = new Path2D.Double();
	    p1.moveTo(x+perpDist, y+parDist);
	    p1.lineTo(x+perpDist, y+invPerpDist);
	    p1.lineTo(x+invParDist, y+invPerpDist);
	    
	    Path2D p2 = new Path2D.Double();
	    p2.moveTo(x+parDist, y+perpDist);
	    p2.lineTo(x+invPerpDist, y+perpDist);
	    p2.lineTo(x+invPerpDist,  y+invParDist);
	    
	    g2d.draw(p1);
	    g2d.draw(p2);
	}
}
