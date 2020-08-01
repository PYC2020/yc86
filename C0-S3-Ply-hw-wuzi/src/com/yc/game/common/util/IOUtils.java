package com.yc.game.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * IO操作工具类
 * @author 廖彦
 *
 */
public class IOUtils {

	/**
	 * 关闭资源
	 */
	public static void close(AutoCloseable... cs) {
		for (AutoCloseable c : cs) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将类路径中的文件读取出来
	 * @param classpath
	 * @return
	 */
	public static byte[] toByteArray(InputStream in) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int count;
		try {
			while ((count = in.read(buffer)) != -1) {
				baos.write(buffer, 0, count);
			}
		} catch (IOException e) {
			throw new RuntimeException("文件读取失败", e);
		} finally {
			close(in);
		}
		return baos.toByteArray();
	}
	
}
