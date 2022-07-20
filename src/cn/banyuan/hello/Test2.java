package cn.banyuan.hello;

public class Test2 {


    public static void main(String[] args) {
        //要求：打印五行五列的*
        //思路：先打印一行的 然后将一行执行多次


        for(int j=1;j<=5;j++){   //外层循环执行一次，内层循环执行一遍
            for(int i=1;i<=5;i++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
