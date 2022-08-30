package com.cfs.demo.controller;

/**
 * ClassName: ParseArray
 * Description:
 * date: 2022/5/22 19:12
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class ParseArray {
	public static void main(String[] args) {
		//创建原始的二维数组11*11
		//0：无棋，1：黑棋，2：白棋
		int cherryArray[][] = new int[11][11];
		cherryArray[1][2] = 1;
		cherryArray[2][3] = 2;
		for (int[] row : cherryArray) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		//将二维数组 转 稀疏数组
		//1、先遍历二维数组 得到非零数据的个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (cherryArray[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("非空白棋子：" + sum);
		//2、创建对应的稀疏数组
		int sparseArr[][] = new int[sum + 1][3];
		//给稀疏数组赋值
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;

		//遍历二维数组，将非零的值存放到sparseArr中
		int count = 1;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (cherryArray[i][j] != 0) {
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = cherryArray[i][j];
					count++;
				}
			}
		}

		System.out.println("转换后的棋子");
		for (int[] parseArr : sparseArr) {
			for (int data : parseArr) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}
}
