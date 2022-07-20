package cn.banyuan.hello;

import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("输入星星的行数：");
        int n=sc.nextInt();
        for(int i=n;i>=1;i--){
            for(int j=1; j<=(2*i-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }


}
