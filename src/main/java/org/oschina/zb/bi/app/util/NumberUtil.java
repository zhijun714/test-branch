package org.oschina.zb.bi.app.util;

import java.text.NumberFormat;

/**
 * 验证工具类
 * 
 * @author ljw
 *
 */
public class NumberUtil {

	public static String getPercent(long one, long total) {

		if (one == 0 || total == 0) {
			return "0%";
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format((float) one / (float) total * 100);
		return result + "%";
	}
	
	public static Double getDoublePercent(long one, long total) {

		if (one == 0 || total == 0) {
			return 0d;
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format((float) one / (float) total * 100);
		return Double.parseDouble(result);
	}

	public static void main(String[] args) {

		System.out.println(getPercent(0L, 0L));
		System.out.println(getPercent(0L, 1L));
		System.out.println(getPercent(1L, 0L));
		System.out.println(getPercent(1L, 3L));
	}
}
