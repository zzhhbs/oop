package cn.banyuan.hello;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        /*计算三个班级每个班级4名学生的成绩平均分*/

        /*1.先思考如何计算一个班级的学生平均分*/
        int score=0;
        int sum=0;
        for(int j=1;j<=3;j++){
            System.out.println("请输入第"+j+"个班级的成绩");
             sum=0;

            for(int i=1;i<=4;i++){
                System.out.print("请输入第"+i+"个学生的成绩");
                score=sc.nextInt();
                sum+=score;
            }
            System.out.println("第"+j+"个班级的平均分是："+sum/4);
        }

    }


}
