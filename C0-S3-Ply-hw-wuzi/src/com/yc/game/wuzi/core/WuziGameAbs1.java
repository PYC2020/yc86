package com.yc.game.wuzi.core;

import com.yc.game.wuzi.base.WuziGame;

/**
 * 五子连珠游戏抽象类，完成了除 down 方法以外的方法，<br>
 * 因为 down 方法最复杂，实现方式也最丰富，所以留给子类实现
 * @author 廖彦
 *
 */
public abstract class WuziGameAbs1 implements WuziGame {

	// 棋盘
	protected int[][] board;
	// 五子连珠成功后记录的棋子坐标数组
	protected int[][] wuzi;
	// 当前下子的颜色，五子棋规则：黑先白后
	protected int color = BLACK;

	/**
	 * 初始化游戏
	 */
	public WuziGameAbs1() {
		begin();
	}

	public void begin() {
		board = new int[SIZE][SIZE];
		color = BLACK;
		wuzi = null;
	}

	public int[][] getWuzi() {
		return wuzi;
	}

	public Object getWinner() {
		// 如果五子连珠未成功，则返回 null， 否则取出五子连珠中的其中一子的颜色
		return wuzi == null ? SPACE : board[wuzi[0][1]][wuzi[0][0]];
	}

	public int getColor() {
		return color;
	}

	public String getPointerName(int x, int y) {
		if (board[y][x] == BLACK) {
			return POINT_BLACK;
		} else if (board[y][x] == WHITE) {
			return POINT_WHITE;
		} else if (x == 0 && y == 0) {
			return POINT_UP_LEFT;
		} else if (x == SIZE - 1 && y == 0) {
			return POINT_UP_RIGHT;
		} else if (x == 0 && y == SIZE - 1) {
			return POINT_DOWN_LEFT;
		} else if (x == SIZE - 1 && y == SIZE - 1) {
			return POINT_DOWN_RIGHT;
		} else if (x == 0 && y > 0) {
			return POINT_LEFT;
		} else if (x > 0 && y == 0) {
			return POINT_UP;
		} else if (x == SIZE - 1 && y > 0) {
			return POINT_RIGHT;
		} else if (x > 0 && y == SIZE - 1) {
			return POINT_DOWN;
		} else {
			return POINT_CENTER;
		}
	}

	public int[][] getBoard() {
		return board;
	}

}
