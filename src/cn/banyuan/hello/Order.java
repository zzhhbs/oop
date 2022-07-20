package cn.banyuan.hello;

import java.util.Scanner;

public class Order {
    public static void main(String[] args) {

        /*订餐人*/
        String names[]=new String[4];
        /*订餐份数*/
    String dishMegs[] = new String[4];
        /*时间*/
        int [] times=new int[4];

        /*地址*/
        String addresses[] = new String[4];

        /*状态*/
        int [] status = new int[4];  // 0表示完成  1 已预订

        /*价格*/
        double [] priceses =new double[4];

        /*给数组赋初始值*/
        names[0]="陶涛";
        dishMegs[0]="鱼香肉丝1份";
        times[0]=12;
        addresses[0]="半圆大厅";
        status[0]=0;
        priceses[0]=13;


        names[1]="张天弘";
        dishMegs[1]="西红柿炒韭菜";
        times[1]=12;
        addresses[1]="教室";
        status[1]=1;
        priceses[1]=23;

        /*声明菜单的相关数组*/
        String dishMeg[] ={"红烧带鱼","西红柿炒番茄","剁椒鱼头"};
        double price[]={38.0,22.0,58.0};
        int zan[] =new int[4];

        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用吃货联盟订餐系统*****");

        boolean isExit=false;  //false  不退出系统  true  退出系统
        int m=-1;

        do{
            System.out.println("1.我要订餐");
            System.out.println("2.查看餐袋");
            System.out.println("3.签收订单");
            System.out.println("4.删除订单");
            System.out.println("5.我要点赞");
            System.out.println("6.退出系统");
            System.out.println("*****************");
            System.out.print("请选择：");
            int choose=sc.nextInt();


            boolean isAdd=false;  //false 餐袋满了  true  没有满
            boolean idFind=false; //false 找不到签收的序号  true 找到了签收的序号
            boolean isDel=false;//false 找不到删除的序号  true 找到了删除的序号


            switch (choose){
                case 1:
                    System.out.println("1.我要订餐");
                    for(int i=0;i<names.length;i++){
                        //当names[i] ==null的时候表示有空座位 才可以点餐
                        if(names[i]==null){
                           isAdd=true;
                            System.out.print("请输入订餐人姓名：");
                            String name=sc.next();
                            //遍历餐单
                            System.out.println("序号\t菜品\t单价(元)\t点赞数");
                            for(int j=0;j<dishMeg.length;j++){
                                System.out.println((j+1)+"\t"+dishMeg[j]+"\t"+price[j]+"\t"+zan[j]);
                            }
                            System.out.print("选择菜品编号：");
                            int num=sc.nextInt();
                            String dish=dishMeg[num-1];



                            System.out.print("份数：");
                            int  fen=sc.nextInt();

                            /*计算餐费*/
                           double pri= price[num-1]*fen;
                            double p=pri>50?0 :5;


                            System.out.print("送餐时间（10~20点）");
                            int time=sc.nextInt();
                            while(time<10 || time>20){
                                System.out.print("sorry,不在送餐时间内，重新输入：");
                                time=sc.nextInt();
                            }
                            System.out.print("地址：");
                            String address=sc.next();
                            System.out.println("订餐成功*****");

                            System.out.println("您订的是："+dish+fen+"份");
                            System.out.println("送餐时间是："+time);
                            System.out.println("餐费是："+pri+"送餐费是："+p+"总计："+(pri+p));


                            names[i]=name;
                            dishMegs[i]=dish;
                            times[i]=time;
                            status[i]=1;
                            addresses[i]=address;
                            priceses[i]=(pri+p);
                            break;
                        }
                    }

                    if(!isAdd){
                        System.out.println("不好意思，餐袋已满");
                    }



                    break;
                case 2:
                    System.out.println("2.查看餐袋");
                    //1.遍历一下原来数组
                    System.out.println("序号\t订餐人\t餐品信息\t送餐日期\t地址\t总金额\t状态");
                    for(int i=0;i<names.length;i++){
                            if(names[i]!=null){
                                //2.根据要求打印内容
                                String time=times[i]+"时";
                                String pri=priceses[i]+"元";
                                String statu=  status[i]==0?"已完成":"已预订";
                                System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+pri+"\t"+statu);

                            }

                    }


                    break;
                case 3:
                    System.out.println("3.签收订单");
                    System.out.print("请输入需要签收的订单序号：");
                    int num=sc.nextInt();

                    //遍历循环 原有数组
                    for(int  i=0;i<names.length;i++){
                        //有值得情况下  状态是预订状态下才可签收\
                        if(names[i]!=null && status[i]==1 && num==i+1){
                            idFind=true;
                            //签收进来之后  修改状态 完成状态
                            status[i]=0;
                            System.out.println("签收完成");

                        }else if(names[i]!=null && status[i]==0 && num==i+1){
                            idFind=true;
                            System.out.println("已经签收不可重复签收");
                        }



                    }

                if(! idFind){
                    System.out.println("不好意思 没找到您需要签收的订单");
                }


                    break;
                case 4:
                    System.out.println("4.删除订单");
                    System.out.print("请输入删除订单的序号：");
                    int del=sc.nextInt();
                    /*
                    * 1.先遍历数组内容，
                    * 2.在循环遍历的过程中判断  有值  状态是完成状态
                    * 3.删除某个值之后  位置就空了八  需要将后面的值想前挪动
                    *   都挪动结束之后 需要将最后一个位置置空
                    *
                    * */
                    for (int i=0;i<names.length;i++){

                        if(names[i]!=null && status[i]==0 && del==i+1){
                          isDel=true;
                            //删除  ：从输入的序号的下标开始  到最后一个
                            for(int j=del-1;j<names.length-1;j++){
                                names[j]=names[j+1];
                                dishMegs[j]=dishMegs[j+1];
                                times[j]=times[j+1];

                                addresses[j]=addresses[j+1];
                                status[j]=status[j+1];
                                priceses[j]=priceses[j+1];
                            }
                            /*都挪动完之后  倒数第二个和倒数第一个的值都是一样的 需要将最后一个置空
                            * */
                            names[names.length-1]=null;
                            dishMegs[names.length-1]=null;
                            times[names.length-1]=0;

                            addresses[names.length-1]=null;
                            status[names.length-1]=0;
                            priceses[names.length-1]=0;
                            System.out.println("删除成功~~");
                            break;
                        }else if(names[i]!=null && status[i]==1 && del==i+1){
                            isDel=true;
                            System.out.println("订单还未完成不能删除");
                            break;
                        }

                    }


                    if(!isDel){
                        System.out.println("您需要删除的订单不存在");
                    }



                    break;
                case 5:
                    System.out.println("5.我要点赞");
                    System.out.println("序号\t菜品\t单价(元)\t点赞数");
                    for(int j=0;j<dishMeg.length;j++){
                        System.out.println((j+1)+"\t"+dishMeg[j]+"\t"+price[j]+"\t"+zan[j]);
                    }
                    System.out.print("选择需要点赞的菜品编号：");
                    int number=sc.nextInt();
                    zan[number-1]++;
                    System.out.println("点赞成功");

                    break;
                case 6:
                    System.out.println("6.退出系统");
                    isExit=true;
                    break;
                    default:
                        isExit=true;
                        break;
            }

            if(!isExit){
                System.out.print("输入0返回上级菜单：");
                m=sc.nextInt();
            }else{
                break;
            }



        }while(m==0);
        System.out.println("谢谢使用");
    }


    }
