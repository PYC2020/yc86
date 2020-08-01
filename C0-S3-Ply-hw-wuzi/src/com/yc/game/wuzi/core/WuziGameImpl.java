package com.yc.game.wuzi.core;

import java.util.ArrayList;

/**
 * 五子连珠游戏实现类，完成了五子连珠判断
 * @author 廖彦
 *
 */
public class WuziGameImpl extends WuziGameAbs1 {

	// 定义四个方向的 x , y 的变化趋势
	protected static final int[][] DIRECTION = { { 1, 0 }, { 0, 1 }, { -1, -1 }, { 1, -1 } };

	public void down(int x, int y) {
		if (wuzi != null) {
			return;
		}
		down(x, y, color);
		// 交换颜色
		color = color == BLACK ? WHITE : BLACK;
	}

	/**
	 * 下子
	 * @param x
	 * @param y
	 * @param color
	 */
	public void down(int x, int y, int color) {
		if (wuzi != null || color > WHITE || color < SPACE || board[y][x] != SPACE) {
			return;
		}
		board[y][x] = color;
		// 判断胜负( 四个方向 )
		for (int i = 0; i < DIRECTION.length; i++) {
			int[][] ret = count(x, y, color, DIRECTION[i][0], DIRECTION[i][1]);
			if (ret.length >= 5) {
				wuzi = ret;
			}
		}
	}

	/**
	 * 统计棋子的一个方法上的同色不间断的棋子数, 例如: 
	 * 	- 向是 	ox=1,	y=0, 
	 * 	\ 向是  	ox=-1,	y=-1
	 * 	| 向是 	ox=0,	y=1, 
	 * 	/ 向是  	ox=1,	y=-1
	 * @param x
	 * @param y
	 * @param color
	 * @param ox	x的变化值
	 * @param oy	y的变化值
	 * @return
	 */
	private int[][] count(int x, int y, int color, int ox, int oy) {
		// 定义保存五子连珠的棋子的集合
		ArrayList<int[]> list = new ArrayList<int[]>();
		// 添加当前的棋子
		list.add(new int[] { x, y });
		// 统计正方向的棋子数
		for (int nx = x + ox, ny = y + oy; equals(nx, ny, color); nx += ox, ny += oy) {
			list.add(new int[] { nx, ny });
		}
		// 方向反转
		ox *= -1;
		oy *= -1;
		// 统计反方向的棋子数
		for (int nx = x + ox, ny = y + oy; equals(nx, ny, color); nx += ox, ny += oy) {
			list.add(new int[] { nx, ny });
		}
		// 集合转数组
		return list.toArray(new int[list.size()][]);
	}

	/**
	 * 判断坐标处( x , y ) 的棋子 ( 颜色 ):
	 * 	1. 判断 x，y 所表示的坐标值是否在棋盘的范围内
	 * 	2. 判断 x，y 处的棋子颜色是否与传入的颜色 （color） 相同
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	private boolean equals(int x, int y, int color) {
		return y < board.length && y > 0 && x < board[0].length && x > 0 && board[y][x] == color;
	}

	@Override
	public boolean isOver() {
		return wuzi != null;
	}

}
