package Eat_Fish;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class MyFrame extends JFrame{
	/** 遊戲狀態 0未開始, 1遊戲中, 2通關失敗, 3通關成功, 4暫停 */
	static int state = 0;
	int width = 1500;
	int height = 900;
	
	double random;
	//計數器(記錄重繪次數)
	int time = 0;
	Image offScreenImage;
	//背景
	Bg bg = new Bg();
	
	//敵方魚類
	Enamy  enamy;
	
	//boss類
	Enamy boss;
	
	//我方魚類
	MyFish  myFish = new MyFish();
	
	public void launch() {
		this.setVisible(true);
		this.setSize(width, height);
		//設置窗口在居中位置
		this.setLocationRelativeTo(null);
		//設置窗口不可編輯
		this.setResizable(false);
		this.setTitle("大魚吃小魚♥(´∀` )人");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(e.getButton() == 1 &&state==0) {
					state=1;
				}
				if(e.getButton() == 1 &&(state==2||state==3)) {
					reStart();
					state = 1;
				}
			}
		});
		
		//鍵盤移動
		this.addKeyListener(new KeyAdapter() {
			//按壓WASD對應的數值
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == 87) {
					GameUtils.UP = true;
				}
				if(e.getKeyCode() == 83) {
					GameUtils.DOWN = true;
				}
				if(e.getKeyCode()==65) {
					GameUtils.LEFT = true;
				}
				if(e.getKeyCode()==68) {
					GameUtils.RIGHT = true;
				}
				if(e.getKeyCode()==32) {
					switch(state) 
					{
						case 1:
							state = 4;
							GameUtils.drawWord(getGraphics(), "遊戲暫停!!!",Color.red, 50, 600, 400);
							break;
						case 4:
							state = 1;
							break;
					}
				}
			}
			
			//抬起
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				if(e.getKeyCode()==87) {
					GameUtils.UP = false;
				}
				if(e.getKeyCode()==83) {
					GameUtils.DOWN = false;
				}
				if(e.getKeyCode()==65) {
					GameUtils.LEFT = false;
				}
				if(e.getKeyCode()==68) {
					GameUtils.RIGHT = false;
				}
				
			}
		});
		
		while(true) {
			repaint();
			time++;
			try {
				Thread.sleep(40);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		//加載模式初始化
		offScreenImage = createImage(width, height);
		Graphics gImage = offScreenImage.getGraphics();
		//繪製遊戲背景圖
		bg.paintSelf(gImage, myFish.level);
		switch(state){
			case 0:
				break;
			case 1:
				myFish.paintSelf(gImage);
				logic();
				for(Enamy enamy:GameUtils.EnamyList) {
					enamy.paintSelf(gImage);
				}
				
				break;
			case 2:
				for(Enamy enamy:GameUtils.EnamyList) {
					enamy.paintSelf(gImage);
				}
				
				break;
			case 3:
				myFish.paintSelf(gImage);
				break;
			case 4:
				return;
				default:
		}
		g.drawImage(offScreenImage, 0, 0 ,null);
	}
	
	void logic() {
		//關卡難度等級
		//分數<5時
		if(GameUtils.count<5) {
			GameUtils.level = 0;
			myFish.level = 1;
		} else if(GameUtils.count<=15) {
			GameUtils.level = 2;
		} else if(GameUtils.count<=50) {
			GameUtils.level = 2;
			myFish.level = 2;
		} else if(GameUtils.count<=150) {
			GameUtils.level = 3;
		} else if(GameUtils.count<=300) {
			GameUtils.level = 4;
			myFish.level = 7;
		} else if(GameUtils.count<=330) {
			GameUtils.level = 5;
			myFish.level = 10;
		} else if(GameUtils.count>500) {
			state = 3;
		}
		
		//讓左方跟右方的魚能比較平均生成的隨機函數
		random = Math.random();
		//關卡跟不同等級魚的生成，用switch實現敵方魚生成
		switch(GameUtils.level) {
		case 5:
			if(time%30 ==0){
				if(random>0.5) {
					enamy = new Enamy_3_L();
				}	else {
					enamy = new Enamy_3_R();
				}
				GameUtils.EnamyList.add(enamy);
			}
		case 4:
			if(time%40 == 0) 
			{
				if(random>0) {
					enamy = new Enamy_Boss();
				}
				GameUtils.EnamyList.add(enamy);
			}
		case 3:
			if(time%30 ==0) {
				if(random>0.2) {
					enamy = new Enamy_4_L();
				}	else {
					enamy = new Enamy_4_R();
				}
				GameUtils.EnamyList.add(enamy);
			}
		case 2:
			if(time%20 ==0){
				if(random>0.5) {
					enamy = new Enamy_3_L();
				}	else {
					enamy = new Enamy_3_R();
				}
				GameUtils.EnamyList.add(enamy);
			}
		case 1:
			if(time %20==0){
				if(random>0.5) {
					enamy = new Enamy_2_L();
				}	else {
					enamy = new Enamy_2_R();
				}
				GameUtils.EnamyList.add(enamy);
			}
		
		   case 0:
			if(time %10 ==0) {
				if(random > 0.5) {
				enamy = new Enamy_1_L();
			} else {
				enamy = new Enamy_1_R();
			}	
				GameUtils.EnamyList.add(enamy);
			}
			break;
			default:
		}
		//移動方向
		for(Enamy enamy:GameUtils.EnamyList) {
			enamy.x = enamy.x + enamy.dir * enamy.speed;
			//我方魚與敵方魚碰撞檢測
			if(myFish.getRec().intersects(enamy.getRec())) {
				if(myFish.level >= enamy.type) {
					enamy.x = -200;
					enamy.y = -200;
					GameUtils.count = GameUtils.count + enamy.count;
				} else {
					//移除操作
					state = 2;
				}
			}
		}
	}
	//重新開始遊戲，全部都需要初始化(如果勝利或結束可以用滑鼠點從新開始)
	void reStart() {
		GameUtils.EnamyList.clear();
		time = 0;
		myFish.level = 1;
		GameUtils.count = 0;
		myFish.x = 700;
		myFish.y = 500;
		myFish.width = 60;
		myFish.height = 60;
		boss = null;
	}
	public static void main(String args[]) {
		MyFrame Window = new MyFrame();
		Window.launch();
	}
}



