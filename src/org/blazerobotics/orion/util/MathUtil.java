package org.blazerobotics.orion.util;

public class MathUtil {
	public static double cube(double n) {
		return n*n*n;
	}
	public static double distance(double n, double k) {
		return Math.abs(k - n);
	}
	public static double average(double... n) {
		double total = 0;
		for (double i : n) {
			total += i;
		}
		return total / n.length;
	}
	public static boolean sign(double n, double k) {
		return (n < 0) == (k < 0);
	}
}
