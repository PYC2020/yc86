package com.yc.game.wuzi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.yc.game.wuzi.core.WuziGameImpl;
import com.yc.game.wuzi.swing.WuziWin;

public class Player2 {
	public static final int BLACK = 1;

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8888);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();

		
		WuziGameImpl gameImpl=new WuziGameImpl();
		WuziWin player2=new WuziWin(gameImpl,2);

		player2.start();

		new Thread() {
			public void run() {
				byte[] buffer = new byte[1024];
				int count;
				while (true) {
					try {
						count = in.read(buffer);
						String index=new String(buffer, 0, count);
						synchronized (this) {
							String[] demo=index.split(",");
							if (demo.length == 2) {
								int x = Integer.valueOf(demo[0]);
								int y = Integer.valueOf(demo[1]);

								gameImpl.down(x, y,BLACK);
							}
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				while (true) {
					try {
						out.write(player2.back.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();


	}
}