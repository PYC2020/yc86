package com.yc.game.wuzi.base;

import com.yc.game.common.base.TwoArrayGame;

/**
 * 五子连珠游戏
 * @author 廖彦
 */
public interface WuziGame extends TwoArrayGame{

	public static final String POINT_UP_LEFT = "左上";
	public static final String POINT_UP_RIGHT = "右上";
	public static final String POINT_UP = "上边";
	public static final String POINT_DOWN_LEFT = "左下";
	public static final String POINT_DOWN_RIGHT = "右下";
	public static final String POINT_DOWN = "下边";
	public static final String POINT_LEFT = "左边";
	public static final String POINT_RIGHT = "右边";
	public static final String POINT_CENTER = "中间";
	public static final String POINT_BLACK = "黑子上";
	public static final String POINT_WHITE = "白子上";

	// 无子
	public static final int SPACE = 0;
	// 黑子
	public static final int BLACK = 1;
	// 白子
	public static final int WHITE = 2;
	// 棋盘大小
	public static final int SIZE = 15;

	/**
	 * 下子
	 * @param x
	 * @param y
	 */
	public void down(int x, int y);

	/**
	 * 返回五子连珠的棋子坐标数组,例如: <br>
	 * 	{{4,4},{5,5},{6,6},{6,6},{7,7}} <br>
	 * 如果棋局未结束则返回 null<br>
	 * @return
	 */
	public int[][] getWuzi();

	/**
	 * 返回赢家的颜色，如果没有胜负结果则返回 0 
	 * @return
	 */
	public Object getWinner();

	/**
	 * 获取当前棋子颜色( 轮谁下 )
	 * @return
	 */
	public int getColor();

	/**
	 * 获取指定的坐标的位置名，如果该坐标上有棋子，则返回棋子颜色,<br> 
	 * 例如:左上角, 中间, 白子上, 黑子上<br>
	 * 该方法是用于桌面版五子棋，实现当鼠标悬停在棋盘上时，棋盘坐标处显示不同的光标<br>
	 * 如果是控制台版五子棋，可以不用实现
	 * @param x
	 * @param y
	 */
	public String getPointerName(int x, int y);

}
