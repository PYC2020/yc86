package com.yc.game.common.swing;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.yc.game.common.base.TwoArrayGame;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private TwoArrayGame game;
	private BoardLabel[][] labels;
	private ImageIcon[] cellIcons;

	private JPanel boardPanel;

	/**
	 * 不带背景的棋盘
	 * @param game
	 * @param cellIcons
	 */
	public BoardPanel(TwoArrayGame game, ImageIcon[] cellIcons) {
		this(game, cellIcons, null);
	}

	/**
	 * 带背景的棋盘
	 * @param game
	 * @param cellIcons
	 * @param boardIcon
	 */
	public BoardPanel(TwoArrayGame game, ImageIcon[] cellIcons, ImageIcon boardIcon) {
		this.game = game;
		this.cellIcons = cellIcons;
		labels = new BoardLabel[game.getBoard().length][game.getBoard()[0].length];
		int cellWidth = cellIcons[0].getIconWidth();
		int cellHeigth = cellIcons[0].getIconHeight();
		// 创建放置棋盘面板的面板
		setLayout(new FlowLayout(FlowLayout.CENTER));
		// 创建棋盘面板
		if (boardIcon == null) {
			boardPanel = new JPanel();
		} else {
			boardPanel = new JPanel() {
				private static final long serialVersionUID = 1L;

				// 画棋盘
				protected void paintComponent(Graphics g) {
					// 获取棋盘图片
					Image img = boardIcon.getImage();
					// 定义棋盘坐标( 棋盘图片略小于棋盘大小, 让其居中)
					int x = (game.getBoard()[0].length * cellWidth - boardIcon.getIconWidth()) / 2;
					int y = (game.getBoard().length * cellHeigth - boardIcon.getIconHeight()) / 2;
					// 将棋盘图片画到面板上, 实现类似桌面的效果
					g.drawImage(img, x, y, boardIcon.getIconWidth(), boardIcon.getIconHeight(),
							boardIcon.getImageObserver());
				}
			};
		}
		// 设置网格布局
		boardPanel.setLayout(new GridLayout(game.getBoard().length, game.getBoard()[0].length));
		// 添加棋盘面板
		add(boardPanel);
		// 初始化棋盘图片控件
		initBoard();
	}

	/**
	 * 初始化棋盘图片控件
	 */
	private void initBoard() {
		// 创建与游戏棋盘同步的棋盘控件( JLabel 二维数组 )
		for (int y = 0; y < game.getBoard().length; y++) {
			for (int x = 0; x < game.getBoard()[y].length; x++) {
				// MyLabel 是 JLabel 的子类, 添加了棋盘坐标熟悉, 方便定位对应的棋子坐标
				labels[y][x] = new BoardLabel(cellIcons[game.getBoard()[y][x]], x, y);
				// 将Label控件添加到面板中
				boardPanel.add(labels[y][x]);
			}
		}
	}

	public void refresh() {
		for (int y = 0; y < game.getBoard().length; y++) {
			for (int x = 0; x < game.getBoard()[0].length; x++) {
				labels[y][x].setIcon(cellIcons[game.getBoard()[y][x]]);
			}
		}
	}

	public BoardLabel[][] getLabels() {
		return labels;
	}

	public void setCellIcons(ImageIcon[] cellIcons) {
		this.cellIcons = cellIcons;
	}

	public ImageIcon[] getCellIcons() {
		return cellIcons;
	}

}
