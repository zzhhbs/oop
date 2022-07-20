package cn.banyuan.hello;

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        int reult=0;
        for (int i = 1; i <=3 ; i++) {
            reult =0;
            System.out.println("请输入第"+i+"个班级的成绩");
            for (int j = 1; j <=4 ; j++) {
                System.out.println("第"+j+"个学生的成绩");
                int score = sc.nextInt();
                reult+=score;
                if (score>85){
                    count++;
                    continue;
                }
            }
            System.out.println("这个班级的平均分是"+(reult/4));
        }
        System.out.println("分数高于85的个数："+count);
    }
}
