package com.yc.game.wuzi.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.yc.game.common.base.TwoArrayGame;
import com.yc.game.common.swing.BoardLabel;
import com.yc.game.common.swing.BoardPanel;
import com.yc.game.common.swing.BoardWin;
import com.yc.game.wuzi.base.WuziGame;
import com.yc.game.wuzi.core.Imgs;
import com.yc.game.wuzi.core.WuziGameImpl;

/**
 * 游戏主窗口，创建时必须传入游戏对象（参数是接口）
 * @author 廖彦
 *
 */
public class WuziWin extends BoardWin {

	// 不解释
	private static final long serialVersionUID = 1L;
	private MouseAdapter ma;
	//private WuziGame game;
	private WuziGameImpl game;
	/**
	 * 下棋的身份  player1 服务器端   player2客户端 模拟两个人对战
	 */
	private int player;
	/**
	 * 用于存放 对方下棋的坐标
	 */
	public String back=",";
	/**
	 * 构建窗体
	 */
	//public WuziWin(WuziGame game) {
		public WuziWin(WuziGameImpl game,int player) {
		super("开森五子棋", game, Imgs.CHESS);
		this.game = game;
		this.player=player;
	}

	@Override
	protected BoardPanel customCreateBoard(TwoArrayGame game, ImageIcon[] cellIcons) {
		return new BoardPanel(game, cellIcons, Imgs.BOARD);
	}

	@Override
	protected void initBoardLabel(BoardLabel bl, int x, int y) {
		if (ma == null) {
			ma = new MouseAdapter() {
				@Override
				// 鼠标移动事件
				public void mouseEntered(MouseEvent e) {
					refresh();
					BoardLabel ml = (BoardLabel) e.getSource();
					String pointName = game.getPointerName(ml.getBoardX(), ml.getBoardY());
					Icon icon = Imgs.getPointIcon(pointName);
					ml.setIcon(icon);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 判断5子是否成立
					if (game.getWuzi() != null) {
						return;
					}
					// 获取当前点击的控件
					BoardLabel ml = (BoardLabel) e.getSource();
					// 获取控件中保存的坐标, 并在该坐标处下子
					//game.down(ml.getBoardX(), ml.getBoardY());
					game.down(ml.getBoardX(), ml.getBoardY(),player);

					/**
					 * 每次执行下棋操作后 更新一次存入的坐标
					 */
					back=ml.getBoardX()+","+ml.getBoardY();
					// 刷新界面, 显示下的子
					refresh();
					// 如果五子连珠成立, 则提示完成
					if (game.getWuzi() != null) {
						String color = (int) game.getWinner() == WuziGame.BLACK ? "黑" : "白";
						JOptionPane.showMessageDialog(null, color + "棋赢了!");
					}
				}
			};
		}
		bl.addMouseListener(ma);
	}

}
