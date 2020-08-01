package com.yc.game.common.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;

import com.yc.game.common.base.TwoArrayGame;
import com.yc.game.common.util.SwingUtils;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 游戏主窗口，创建时必须传入游戏对象（参数是接口）
 * @author 廖彦
 *
 */
public class BoardWin extends JFrame {

	// 不解释
	private static final long serialVersionUID = 1L;
	// 棋盘面板
	protected BoardPanel boardPanel;
	protected TwoArrayGame game;

	/**
	 * 开始游戏
	 * @param game
	 */
	public void start() {
		/**
		 * 这是自动生成的代码, 用于启动窗口
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 构建窗体
	 */
	public BoardWin(String name, TwoArrayGame game, ImageIcon[] cellIcons) {
		super(name);
		this.game = game;
		// 设置关闭窗口既是退出程序, 不设置默认是隐藏窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置边界布局
		setLayout(new BorderLayout(0, 0));
		// 构建棋盘面板
		buildBoard(cellIcons);
		// 构建控制面板
		buildControll();
		// 窗体适应控件大小
		pack();
		// 窗体居中
		SwingUtils.center(this);
		this.start();
	}

	/**
	 * 构建控制面板
	 */
	protected void buildControll() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panel.setPreferredSize(new Dimension(150, 0));
		buildButton(panel);
		add(panel, BorderLayout.EAST);
	}

	/**
	 * 构建控制面板上的按钮
	 */
	protected void buildButton(JPanel panel) {
		panel.add(createButton("重新开始", (e) -> {
			game.begin();
			refresh();
		}));
		panel.add(createButton("不玩了", (e) -> BoardWin.this.dispose()));
	}

	public void refresh() {
		//SwingUtils.call(() -> {
			boardPanel.refresh();
			repaint();
		//});
	}

	/**
	 * 创建按钮控件
	 * @param string
	 * @return
	 */
	protected JButton createButton(String name, ActionListener al) {
		JButton ret = new JButton(name);
		ret.setPreferredSize(new Dimension(100, 30));
		ret.addActionListener(al);
		return ret;
	}

	/**
	 * 构建棋盘面板
	 * @param cellIcons 
	 * @param game 
	 */
	protected void buildBoard(ImageIcon[] cellIcons) {
		// 创建放置棋盘面板的面板
		JPanel panel = new JPanel();
		// 设置流式布局
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setBorder(BorderUIResource.getEtchedBorderUIResource());
		// 创建棋盘面板
		boardPanel = customCreateBoard(game, cellIcons);
		if (boardPanel == null) {
			boardPanel = new BoardPanel(game, cellIcons);
		}
		for (int y = 0; y < boardPanel.getLabels().length; y++) {
			for (int x = 0; x < boardPanel.getLabels()[y].length; x++) {
				BoardLabel c = boardPanel.getLabels()[y][x];
				initBoardLabel(c, x, y);
			}
		}
		// 添加棋盘面板
		panel.add(boardPanel);
		// 将面板)放入窗体
		add(panel, BorderLayout.CENTER);
	}

	/**
	 * 初始化图片控件
	 * @param c
	 * @param x
	 * @param y
	 */
	protected void initBoardLabel(BoardLabel bl, int x, int y) {

	}

	/**
	 * 定义模版
	 * @param game2
	 * @param cellIcons
	 * @return
	 */
	protected BoardPanel customCreateBoard(TwoArrayGame game, ImageIcon[] cellIcons) {
		return null;
	}

}
