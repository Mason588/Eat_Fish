package Eat_Fish;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class MyFish {
	//�Ϥ�
	Image img = GameUtils.MyFish_L;
	//�y��
	int x = 700;
	int y = 500;
	int width = 60;
	int height = 60;
	//���ʳt��
	int speed = 20;
	//����
	int level = 1;
	
	//�w�q����
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
	
	//ø�s�ۨ�����k
	public void paintSelf(Graphics g) {
		logic();
		g.drawImage(img, x, y, width+GameUtils.count, height+GameUtils.count, null);
	}
	
	//ø�s�ۨ��x�Ϊ���k�A�Ω�I���˴�
	public Rectangle getRec() {
		return new Rectangle(x, y, width+GameUtils.count, height+GameUtils.count);
	} 
	
	
}
