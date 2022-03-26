package Eat_Fish;

import java.awt.Color;
import java.awt.Graphics;

public class Bg {
	void paintSelf(Graphics g, int fishLevel) {
		g.drawImage(GameUtils.begin1, 0, 0, null);
		switch(MyFrame.state) {
			case 0:
				GameUtils.drawWord(g, "開始遊戲", Color.red, 60 , 800, 550);
				break;
			case 1:	
				g.drawImage(GameUtils.begin, 0, 0, null);
				GameUtils.drawWord(g, "分數: "+GameUtils.count, Color.ORANGE, 30 , 100, 120);
				GameUtils.drawWord(g, "難度: "+GameUtils.level, Color.ORANGE, 30 , 500, 120);
				GameUtils.drawWord(g, "等級: "+fishLevel, Color.ORANGE, 30 , 900, 120);
				break;
			case 2:
				GameUtils.drawWord(g, "分數: "+GameUtils.count, Color.ORANGE, 30 , 100, 120);
				GameUtils.drawWord(g, "難度: "+GameUtils.level, Color.ORANGE, 30 , 500, 120);
				GameUtils.drawWord(g, "等級: "+fishLevel, Color.ORANGE, 30 , 900, 120);
				GameUtils.drawWord(g, "被吃掉囉~ ", Color.red, 60 , 700, 500);
				break;
			case 3:
				g.drawImage(GameUtils.end, 0, 0, null);
				GameUtils.drawWord(g, "分數: "+GameUtils.count, Color.ORANGE, 30 , 100, 120);
				GameUtils.drawWord(g, "難度: "+GameUtils.level, Color.ORANGE, 30 , 500, 120);
				GameUtils.drawWord(g, "等級: "+fishLevel, Color.ORANGE, 30 , 900, 120);
				GameUtils.drawWord(g, "勝利 ξ( ✿＞◡❛) ", Color.red, 50 ,400, 500);
				break;
			case 4:
				default:
				break;
		}
	}
}

