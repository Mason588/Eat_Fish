package Eat_Fish;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class MyFish {
	//圖片
	Image img = GameUtils.MyFish_L;
	//座標
	int x = 700;
	int y = 500;
	int width = 60;
	int height = 60;
	//移動速度
	int speed = 20;
	//等級
	int level = 1;
	
	//定義移動
	void logic() {
		if(GameUtils.UP) {
			y = y-speed;
		}
		if(GameUtils.DOWN) {
			y = y+speed;
		}
		if(GameUtils.LEFT) {
			x = x-speed;
			img = GameUtils.MyFish_L;
		}
		if(GameUtils.RIGHT) {
			x = x+speed;
			img = GameUtils.MyFish_R;
		}
	}
	
	//繪製自身的方法
	public void paintSelf(Graphics g) {
		logic();
		g.drawImage(img, x, y, width+GameUtils.count, height+GameUtils.count, null);
	}
	
	//繪製自身矩形的方法，用於碰撞檢測
	public Rectangle getRec() {
		return new Rectangle(x, y, width+GameUtils.count, height+GameUtils.count);
	} 
	
	
}
