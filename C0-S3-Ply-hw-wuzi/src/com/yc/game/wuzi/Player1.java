package com.yc.game.wuzi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.yc.game.wuzi.core.WuziGameImpl;
import com.yc.game.wuzi.swing.WuziWin;

public class Player1 {
	public static final int WHITE = 2;

	public static void main(String[] args) throws IOException {
		//创建服务器
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();

		//五子连珠游戏实现类
		WuziGameImpl gameImpl = new WuziGameImpl();
		//打开窗口开始运行
		WuziWin player1 = new WuziWin(gameImpl,1);

		player1.start();


		/**
		 * 读取客户端传入的 坐标 
		 */
		new Thread() {
			public void run() {
				byte[] buffer = new byte[1024];
				int count;
				while (true) {
					try {
						count = in.read(buffer);
						String index = new String(buffer, 0, count);
						synchronized (this) {
							String[] demo = index.split(",");
							if (demo.length == 2) {
								int x = Integer.valueOf(demo[0]);
								int y = Integer.valueOf(demo[1]);


								gameImpl.down(x, y,WHITE);
							}
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		/**
		 * 输出 存放坐标的 back字符串
		 */
		new Thread() {
			public void run() {
				while (true) {
					try {
						out.write(player1.back.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();





	}

}