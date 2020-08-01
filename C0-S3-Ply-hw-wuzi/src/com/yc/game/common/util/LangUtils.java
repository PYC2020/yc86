package com.yc.game.common.util;

public class LangUtils {

	/**
	 * 遍历两数之间 ( 不含这两数 ) 的数字, 例如:3~7, 遍历:4,5,6
	 * @param begin
	 * @param end
	 * @param entry
	 */
	public static void eachIn(int begin, int end, Entry<Integer> entry) {
		int sub = Math.abs(begin - end);
		if (sub < 2) {
			return;
		}
		int offset = begin > end ? -1 : 1;
		for (int i = 1; i < sub; i++) {
			int index = begin + i * offset;
			if (entry.handle(index, index) == false) {
				return;
			}
		}
	}

	/**
	 * 遍历两数之间 ( 含这两数 ) 的数字, 例如:3~7, 遍历:3,4,5,6,7
	 * @param begin
	 * @param end
	 * @param entry
	 */
	public static void each(int begin, int end, Entry<Integer> entry) {
		int sub = Math.abs(begin - end);
		int offset = begin > end ? -1 : 1;
		for (int i = 0; i <= sub; i++) {
			int index = begin + i * offset;
			if (entry.handle(index, index) == false) {
				return;
			}
		}
	}

	public static interface Entry<T> {
		boolean handle(T cell, int index);
	}

}
