package Eat_Fish;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
	//方向
	static boolean UP = false;
	static boolean DOWN = false;
	static boolean LEFT = false;
	static boolean RIGHT = false;
	
	//分數
	static int count = 0;
	
	//關卡等級
	static int level = 0;
	
	//敵方魚類集合
	public static List<Enamy> EnamyList = new ArrayList<>();
	
	//背景圖
	public static Image begin = Toolkit.getDefaultToolkit().createImage("Img/Sea4.jpg");
	//背景圖2(開始)
	public static Image begin1 = Toolkit.getDefaultToolkit().createImage("Img/ssea.jpg");
	//背景圖3(通關)
	public static Image end = Toolkit.getDefaultToolkit().createImage("Img/End.jpg");
	
	//敵方魚類
	public static Image enamy_l_img = Toolkit.getDefaultToolkit().createImage("Img/yfish1.png");
	public static Image enamy_r_img = Toolkit.getDefaultToolkit().createImage("Img/yfish.png");
	
	public static Image enamy_l_2img = Toolkit.getDefaultToolkit().createImage("Img/sfish1.png");
	public static Image enamy_r_2img = Toolkit.getDefaultToolkit().createImage("Img/sfish.png");
	
	public static Image enamy_l_3img = Toolkit.getDefaultToolkit().createImage("Img/jellyfish1.png");
	public static Image enamy_r_3img = Toolkit.getDefaultToolkit().createImage("Img/jellyfish.png");
	
	public static Image enamy_l_4img = Toolkit.getDefaultToolkit().createImage("Img/Shark1.png");
	public static Image enamy_r_4img = Toolkit.getDefaultToolkit().createImage("Img/Shark.png");
	
	public static Image bossImg = Toolkit.getDefaultToolkit().createImage("Img/Ging1.png");
	
	//我方魚類
	public static Image MyFish_L = Toolkit.getDefaultToolkit().createImage("Img/Nimo.png");
	public static Image MyFish_R = Toolkit.getDefaultToolkit().createImage("Img/1Nimo.png");

	//繪製文字的工具類
	public static void drawWord(Graphics g, String str, Color color,int size, int x, int y) {
		g.setColor(color);
		g.setFont(new Font("仿宋", Font.BOLD,size));
		g.drawString(str, x, y);
	}
}
