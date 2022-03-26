package Eat_Fish;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Enamy {
	//定義圖片
	Image img;
	//定義物體座標
	int x;
	int y;
	int width;
	int height;
	//移動速度
	int speed;
	//方向
	int dir = 1;
	//類型
	int type;
	//分數
	int count;
	//繪製自身方法
	public void paintSelf(Graphics g) {
		g.drawImage(img ,x,y,width,height, null);
	}
	//繪製自身矩形用魚碰撞檢測
	public Rectangle getRec() {
		return new Rectangle(x,y,width,height);
	}
}

//敵方魚左類
class Enamy_1_L extends Enamy{
	Enamy_1_L(){
		this.x = -45;
		this.y = (int)(Math.random()*700+100);
		this.width = 45;
		this.height = 50;
		this.speed = 10;
		this.count = 1;
		this.type = 1;
		this.img = GameUtils.enamy_l_img;
	}
}

class Enamy_1_R extends Enamy_1_L {
	Enamy_1_R(){
		this.x = 1400;
		dir = -1;
		this.img = GameUtils.enamy_r_img;
	}
}

class Enamy_2_L extends Enamy {
	Enamy_2_L(){
		this.x = -100;
		this.y = (int) (Math.random()*700+100);
		this.width = 120;
		this.height = 120;
		this.speed = 6;
		this.count = 2;
		this.type = 2;
		this.img = GameUtils.enamy_l_2img;
	}
	
}

class Enamy_2_R extends Enamy_2_L {
	Enamy_2_R(){
		this.x = 1400;
		dir = -1;
		this.img = GameUtils.enamy_r_2img;
	}
}

class Enamy_3_L extends Enamy{
	Enamy_3_L(){
		this.x = -150;
		this.y=(int)(Math.random()*700+100);
		this.width = 150;
		this.height = 120;
		this.count = 5;
		this.speed = 8;
		this.type = 3;
		this.img = GameUtils.enamy_l_3img;
	}
	
} 

	
class Enamy_3_R extends Enamy_3_L{
	Enamy_3_R(){
		this.x = 1200;
		dir =-1;
		this.img = GameUtils.enamy_r_3img;
	}
}

class Enamy_4_L extends Enamy{
	Enamy_4_L() {
		this.x = -300;
		this.y=(int)(Math.random()*700+100);
		this.width = 300;
		this.height = 220;
		this.count = 12;
		this.speed = 12;
		this.type = 6;
		this.img = GameUtils.enamy_l_4img;
	}
}
	
class Enamy_4_R extends Enamy_4_L{
		Enamy_4_R(){
			this.x =1300;
			dir =-1;
			this.img = GameUtils.enamy_r_4img;
		}
	
}

class Enamy_Boss extends Enamy {
	Enamy_Boss(){
		this.x=-1000;
		this.y = (int)(Math.random()*700+100);
		this.width = 420;
		this.height = 400;
		this.speed = 14;
		this.count = 0;
		this.type = 10;
		this.img = GameUtils.bossImg;
	}
}


