package com.yc.game.common.base;

import java.util.Arrays;

/**
 * 二维数组游戏接口
 * @author 廖彦
 *
 */
public interface TwoArrayGame extends Game {
	int[][] getBoard();

	/**
	 * 打印棋盘, 用于实现控制台版本五子棋和调试
	 */
	default void print() {
		int[][] array = getBoard();
		for (int y = 0; y < array.length; y++) {
			System.out.println(Arrays.toString(array[y]));
		}
	}
}
