package Eat_Fish;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
	//��V
	static boolean UP = false;
	static boolean DOWN = false;
	static boolean LEFT = false;
	static boolean RIGHT = false;
	
	//����
	static int count = 0;
	
	//���d����
	static int level = 0;
	
	//�Ĥ賽�����X
	public static List<Enamy> EnamyList = new ArrayList<>();
	
	//�I����
	public static Image begin = Toolkit.getDefaultToolkit().createImage("Img/Sea4.jpg");
	//�I����2(�}�l)
	public static Image begin1 = Toolkit.getDefaultToolkit().createImage("Img/ssea.jpg");
	//�I����3(�q��)
	public static Image end = Toolkit.getDefaultToolkit().createImage("Img/End.jpg");
	
	//�Ĥ賽��
	public static Image enamy_l_img = Toolkit.getDefaultToolkit().createImage("Img/yfish1.png");
	public static Image enamy_r_img = Toolkit.getDefaultToolkit().createImage("Img/yfish.png");
	
	public static Image enamy_l_2img = Toolkit.getDefaultToolkit().createImage("Img/sfish1.png");
	public static Image enamy_r_2img = Toolkit.getDefaultToolkit().createImage("Img/sfish.png");
	
	public static Image enamy_l_3img = Toolkit.getDefaultToolkit().createImage("Img/jellyfish1.png");
	public static Image enamy_r_3img = Toolkit.getDefaultToolkit().createImage("Img/jellyfish.png");
	
	public static Image enamy_l_4img = Toolkit.getDefaultToolkit().createImage("Img/Shark1.png");
	public static Image enamy_r_4img = Toolkit.getDefaultToolkit().createImage("Img/Shark.png");
	
	public static Image bossImg = Toolkit.getDefaultToolkit().createImage("Img/Ging1.png");
	
	//�ڤ賽��
	public static Image MyFish_L = Toolkit.getDefaultToolkit().createImage("Img/Nimo.png");
	public static Image MyFish_R = Toolkit.getDefaultToolkit().createImage("Img/1Nimo.png");

	//ø�s��r���u����
	public static void drawWord(Graphics g, String str, Color color,int size, int x, int y) {
		g.setColor(color);
		g.setFont(new Font("�駺", Font.BOLD,size));
		g.drawString(str, x, y);
	}
}
