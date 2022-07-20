package cn.banyuan.hello;

import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String chice;
        int sum=0;
        for (int i = 1; i <=5 ; i++) {
            System.out.println("欢迎光临第"+i+"家店");
            for (int j = 1; j <=3 ; j++) {
                System.out.println("是否要离开（y/n）?");
                chice=scanner.next();
                if ("n".equals(chice)){
                    System.out.println("买了一件衣服");
                    sum+=1;

                }else {
                    System.out.println("离店结账");
                    break;
                }


            }

        }
        System.out.println("总数"+sum);

    }

}
