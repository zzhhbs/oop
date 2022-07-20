package cn.banyuan.hello;

public class Test7 {
    public static void main(String[] args) {

        int arr[]={77,66,9,100,1};
        System.out.println("冒泡排序之前的样子：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


        //外层循环 控制的识 轮数
        for(int i=0;i<arr.length-1;i++){
            //内层循环控制的是每轮的次数
            System.out.println(i);
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }

        }
        System.out.println("冒泡排序之后的样子*******：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }










    }



}
