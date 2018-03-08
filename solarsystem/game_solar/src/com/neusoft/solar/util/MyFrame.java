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
		setTitle("̫��ϵ");
		
		
		
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new MyThread().start();// ��������

	}
	Image backImg = null;
	
	class MyThread extends Thread {
		@Override
		public void run() {
			// ��ѭ��
			while (true) {
				// ��ͣ�ĵ���paint()����
				repaint();
				// Ϊ���ʺ�����ʶ�𣬽��߳�˯��һ��ʱ��
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ��дupdate()�������ڴ��ڵ��������һ�������ͼƬ
	@Override
	public void update(Graphics g) {
		if (backImg == null) {
			// �������ͼƬ�����ڣ�����һ���ʹ���һ����С��ͼƬ
			backImg = createImage(Constant.FRAME_WIDHT, Constant.FRAME_HEIGHT);
		}
		// ��ȡ������ͼƬ�Ļ���
		Graphics backg = backImg.getGraphics();
		Color c = backg.getColor();
		backg.setColor(Color.GRAY);
		backg.fillRect(0, 0, Constant.FRAME_WIDHT, Constant.FRAME_HEIGHT);
		backg.setColor(c);
		// ��������ͼƬ��paint()������ÿ50msˢ��һ��
		paint(backg);
		g.drawImage(backImg, 0, 0, null);
	}

}