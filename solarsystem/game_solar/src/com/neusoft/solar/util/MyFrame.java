package com.neusoft.solar.util;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.neusoft.solar.constant.Constant;

public class MyFrame extends Frame {
	public void launchFrame(){
		setSize(Constant.FRAME_WIDHT,Constant.FRAME_HEIGHT);
		setLocation(10,10);
		setVisible(true);
		setTitle("太阳系");
		
		
		
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new MyThread().start();// 匿名对象

	}
	Image backImg = null;
	
	class MyThread extends Thread {
		@Override
		public void run() {
			// 死循环
			while (true) {
				// 不停的调用paint()方法
				repaint();
				// 为了适合人眼识别，将线程睡眠一定时间
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 重写update()方法，在窗口的里层添加一个虚拟的图片
	@Override
	public void update(Graphics g) {
		if (backImg == null) {
			// 如果虚拟图片不存在，创建一个和窗口一样大小的图片
			backImg = createImage(Constant.FRAME_WIDHT, Constant.FRAME_HEIGHT);
		}
		// 获取到虚拟图片的画笔
		Graphics backg = backImg.getGraphics();
		Color c = backg.getColor();
		backg.setColor(Color.GRAY);
		backg.fillRect(0, 0, Constant.FRAME_WIDHT, Constant.FRAME_HEIGHT);
		backg.setColor(c);
		// 调用虚拟图片的paint()方法，每50ms刷新一次
		paint(backg);
		g.drawImage(backImg, 0, 0, null);
	}

}
