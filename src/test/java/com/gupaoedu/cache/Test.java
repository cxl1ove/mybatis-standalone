package com.gupaoedu.cache;


import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("输入边长");
        int n = reader.nextInt();
        System.out.print("地雷数量");
        int m = reader.nextInt();
        reader.close();
        if (n < 5 || n > 20 || m < 0 || m > n * n / 2) {
            System.out.println("数据不符合要求");
            System.exit(0);
        }
        char[][] mineField = new char[n][n];
        int[] mines = new int[m];
        mines[0] = (int)(Math.random() * n * n);
        int i;
        for (i = 1; i < m; i++) {
            int temp = (int)(Math.random() * n * n);
            boolean isExist = false;
            for (int j = 0; j < i; j++) {
                if (temp == mines[j]) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                i--;
            } else {
                mines[i] = temp;
            }
        }
        for (i = 0; i < m; i++) {
            int row = mines[i] / n;
            int col = mines[i] % n;
            mineField[row][col] = '*';
        }
        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mineField[i][j] != '*') {
                    int count = 0;
                    for (int tempI = i - 1; tempI <= i + 1; tempI++) {
                        for (int tempJ = j - 1; tempJ <= j + 1; tempJ++) {
                            if (tempI >= 0 && tempI < n && tempJ >= 0 && tempJ < n &&
                                    mineField[tempI][tempJ] == '*')
                                count++;
                        }
                    }
                    mineField[i][j] = (char)(48 + count);
                }
            }
        }
        System.out.println("生成雷场如下");
        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(String.valueOf(mineField[i][j]) + " ");
            System.out.println();
        }
    }
}