package com.neusoft.solar.client;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.solar.constant.Constant;
import com.neusoft.solar.core.Plant;
import com.neusoft.solar.core.Sun;
import com.neusoft.solar.util.GameUtil;
import com.neusoft.solar.util.MyFrame;

public class SolarSystemClient extends MyFrame {
	Image bj = GameUtil.getImage("com/neusoft/solar/img/bj.jpg");
	
	Sun sun = new Sun();
	
	
	
	Plant earth = new Plant(sun,"com/neusoft/solar/img/earth.png",149,1,400,0.0167,true,false,"µØÇò");
	Plant huoxing = new Plant(sun,"com/neusoft/solar/img/huoxing.png",227,2,687,0.0933,true,false,"»ğĞÇ");
	Plant shui = new Plant(sun,"com/neusoft/solar/img/shui.png",10,0,100,0.2056,true,false,"Ë®ĞÇ");
	Plant jin = new Plant(sun,"com/neusoft/solar/img/jinxing.png",108,0,250,0.068,false,false,"½ğĞÇ");
	Plant mu = new Plant(sun,"com/neusoft/solar/img/mu.png",778/2,2,687,0.0489,true,false,"Ä¾ĞÇ");
	Plant tu = new Plant(sun,"com/neusoft/solar/img/tu.png",1429/3,1,10760,0.0539,true,false,"ÍÁĞÇ");
	Plant sky = new Plant(sun,"com/neusoft/solar/img/sky.png",2870/4,1,30700,0.043158,true,false,"ÌìÍõĞÇ");
	
	//ÎÀĞÇ
	Plant mon = new Plant(earth,"com/neusoft/solar/img/mon.png",100,0,100,0.0167,true,false,"ÔÂÇò");
	
	
	//åçĞÇ
	Plant huixing = new Plant(sun,"com/neusoft/solar/img/huixi.png",600,0,5*365,0.9,true,true,"åçĞÇ");
	
	
	
	public void paint(Graphics g){
		g.drawImage(bj,0,0,null);
		
		sun.draw(g);
		Font f = new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 50);
		//ÉèÖÃ×ÖÌå
		g.setFont(f);
		
		
		earth.draw(g);
		huoxing.draw(g);
		shui.draw(g);
		jin.draw(g);
		mu.draw(g);
		tu.draw(g);
		sky.draw(g);
		mon.draw(g);
		g.drawString("ÖĞĞÄÌ«Ñô", Constant.FRAME_WIDHT/2-40,Constant.FRAME_HEIGHT/2-80);
		huixing.draw(g);
	}
	
	public static void main(String[] args) {
		new SolarSystemClient().launchFrame();
	}
}
