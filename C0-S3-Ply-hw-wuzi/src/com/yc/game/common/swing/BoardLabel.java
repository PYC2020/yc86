package com.yc.game.common.swing;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * 自定义 Label 类，继承于JLabel， 扩展了棋盘坐标属性<br>
 * 用于确定当前 Label 与棋盘上过的哪个坐标点是相关联的
 * @author 廖彦
 *
 */
public class BoardLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	
	// 棋盘上对应的坐标值
	private int x, y;

	public int getBoardX() {
		return x;
	}

	public int getBoardY() {
		return y;
	}

	/**
	 * 构建对象时,传入坐标值 x,y
	 * @param image
	 * @param x
	 * @param y
	 */
	public BoardLabel(Icon image, int x, int y) {
		super(image);
		this.x = x;
		this.y = y;
	}

}
