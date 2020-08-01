package com.yc.game.wuzi.core;

import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.yc.game.common.util.SwingUtils;

public class Imgs {

	public static final ImageIcon SPACE = icon("space.png");
	public static final ImageIcon BLACK = icon("black.png");
	public static final ImageIcon WHITE = icon("white.png");
	public static final ImageIcon BOARD = icon("chessboard.png");

	public static final ImageIcon[] CHESS = { SPACE, BLACK, WHITE };

	private static final HashMap<String, Icon> POINT_IMG_MAP = new HashMap<String, Icon>();

	static {
		POINT_IMG_MAP.put(WuziGameImpl.POINT_UP, icon("hover_up.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_UP_LEFT, icon("hover_up_left.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_UP_RIGHT, icon("hover_up_right.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_DOWN, icon("hover_down.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_DOWN_LEFT, icon("hover_down_left.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_DOWN_RIGHT, icon("hover_down_right.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_LEFT, icon("hover_left.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_RIGHT, icon("hover_right.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_BLACK, icon("black_last.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_WHITE, icon("white_last.png"));
		POINT_IMG_MAP.put(WuziGameImpl.POINT_CENTER, icon("hover.png"));
	}

	/**
	 *  获取位置图片,用于鼠标悬停在棋盘上显示的图片
	 * @param pointName 位置名: 左上,右上,白子上...
	 * @return
	 */
	public static Icon getPointIcon(String pointName) {
		return POINT_IMG_MAP.get(pointName);
	}

	private static ImageIcon icon(String path) {
		return SwingUtils.getImageIcon(Imgs.class, "imgs/" + path);
	}

}
