package com.yc.game.common.util;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 * Swing 工具类
 * @author 廖彦
 *
 */
public class SwingUtils {
	/**
	 * 控件居中
	 * @param component
	 */
	public static void center(Component component) {
		int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowwidth = component.getSize().width;
		int windowheight = component.getSize().height;
		component.setLocation((screenwidth - windowwidth) / 2, (screenheight - windowheight) / 2);
	}

	/**
	 * 使用类路径构建图片Icon
	 * @param cls
	 * @param path
	 * @return
	 */
	public static ImageIcon getImageIcon(Class<?> cls, String path) {
		return new ImageIcon(IOUtils.toByteArray(cls.getResourceAsStream(path)));
	}

	/**
	 * 使用路径迭代器创建图片
	 * @param cls
	 * @param it
	 * @return
	 */
	public static ImageIcon[] buildImageIcons(Class<?> cls, Iterator<String> it) {
		return buildImageIcons(cls, it, 0, 0);
	}

	public static ImageIcon[] buildImageIcons(Class<?> cls, Iterator<String> it, double rate) {
		List<ImageIcon> list = new ArrayList<>();
		while (it.hasNext()) {
			String path = it.next();
			ImageIcon icon = getImageIcon(cls, path);
			if (rate > 0) {
				icon = change(icon, rate);
			}
			list.add(icon);
		}
		return list.toArray(new ImageIcon[list.size()]);
	}

	public static ImageIcon[] buildImageIcons(Class<?> cls, Iterator<String> it, int width, int height) {
		List<ImageIcon> list = new ArrayList<>();
		while (it.hasNext()) {
			String path = it.next();
			ImageIcon icon = getImageIcon(cls, path);
			if (width > 0 && height > 0) {
				icon = change(icon, width, height);
			}
			list.add(icon);
		}
		return list.toArray(new ImageIcon[list.size()]);
	}

	/**
	 * 使用路径数组创建图片数组
	 * @param cls
	 * @param paths
	 * @return
	 */
	public static ImageIcon[] buildImageIcons(Class<?> cls, String... paths) {
		List<ImageIcon> list = new ArrayList<>();
		for (String path : paths) {
			list.add(getImageIcon(cls, path));
		}
		return list.toArray(new ImageIcon[list.size()]);
	}

	/**
	 * i 为放缩的倍数
	 * @param image
	 * @param i
	 * @return
	 */
	public static ImageIcon change(ImageIcon image, double i) {
		int width = (int) (image.getIconWidth() * i);
		int height = (int) (image.getIconHeight() * i);
		return change(image, width, height);
	}

	public static ImageIcon change(ImageIcon image, int width, int height) {
		Image img = image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);// 第三个值可以去查api是图片转化的方式
		image.setImage(img);
		return image;
	}

	public static Iterator<String> iterator(String mask, int begin, int end) {
		return new Iterator<String>() {
			private int index = begin;

			@Override
			public boolean hasNext() {
				return index <= end;
			}

			@Override
			public String next() {
				return String.format(mask, index++);
			}
		};
	}

	public static void call(Runnable task) {
		SwingUtilities.invokeLater(task);
	}
}
