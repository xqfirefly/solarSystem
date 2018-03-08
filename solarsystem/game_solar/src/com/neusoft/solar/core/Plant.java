package com.neusoft.solar.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.Image;

import com.neusoft.solar.constant.Constant;
import com.neusoft.solar.util.GameUtil;

public class Plant extends Star{
	private static final int PI = 0;
	int longAxis;
	int shortAxis;
	double degree;
	double speed;
	int satelliteCount;
	int t;
	double e;
	boolean clockWise=true;
	boolean come = true;
	Star center;
	String name;

	
	
	public Plant(Star center,String imgPath,int longAxis,int satelliteCount,int t,double e,boolean clockWise,boolean come,String name){
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		this.img = GameUtil.getImage(imgPath);
		this.longAxis = longAxis;
		this.e = e;
		this.shortAxis = getMyShortAxis();
		this.t = t;
		this.speed = getMySpeed();
		this.clockWise = clockWise;
		this.come = come;
		this.name = name;
		
	}
	
	public void draw(Graphics g){
		Font f = new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24);
		//ÉèÖÃ×ÖÌå
		g.setFont(f);
		drawTrace(g);
		g.drawImage(img,x,y,null);
		move();
		g.drawString(name, x , y);
		g.drawString("ÖÐÐÄÌ«Ñô", Constant.FRAME_WIDHT/2, Constant.FRAME_HEIGHT-100);
	}
	
	
	
	
	private void move(){
		if(clockWise){
			x=(int)(center.x+center.img.getWidth(null)/2-img.getWidth(null)/2+longAxis * Math.cos(degree));
			y=(int)(center.y+center.img.getWidth(null)/2-img.getHeight(null)/2+shortAxis * Math.sin(degree));
			degree += speed;
			
			if(come){
				x=(int)(longAxis*Math.cos(degree)*Math.cos(Math.PI/4)-shortAxis*Math.sin(degree)*Math.sin(Math.PI/4)+center.x+center.img.getWidth(null)/2-img.getWidth(null)/2-100);
				y=(int)(longAxis*Math.cos(degree)*Math.sin(Math.PI/4)+shortAxis*Math.sin(degree)*Math.cos(Math.PI/4)+center.y+center.img.getHeight(null)/2-img.getHeight(null)/2-100);
				degree += 0.01;
			}
		}else{
			x = (int)(center.x + center.img.getWidth(null)/2 -img.getWidth(null)/2 + longAxis * Math.sin(degree));
			y = (int)(center.y + center.img.getHeight(null)/2 -img.getHeight(null)/2 + shortAxis * Math.cos(degree));
			degree += speed;
			
			}
		
		
	
	}
	
	
	
	
	
	private int getMyShortAxis(){
		return (int)(longAxis * Math.sqrt(1-e*e));
	}
	private double getMySpeed(){
		return 20.5/t;
	}
	private void drawTrace(Graphics g){
		
		Color c=g.getColor();
		g.setColor(Color.PINK);
		if(come){
			
		}else{
			g.drawOval(center.x + center.img.getWidth(null)/2-longAxis,center.y + center.img.getHeight(null)/2-shortAxis,2*longAxis,2*shortAxis);
		}
	}
	
	

}
