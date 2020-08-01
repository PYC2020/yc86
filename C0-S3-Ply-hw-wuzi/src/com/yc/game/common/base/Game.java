package com.yc.game.common.base;

public interface Game {

	/**
	 * 开始游戏
	 */
	void begin();
	
	/**
	 * 返回获胜方,前提: 如果有
	 * @return
	 */
	Object getWinner();
	
	/**
	 * 判断游戏是否结束
	 * @return
	 */
	boolean isOver();
}
