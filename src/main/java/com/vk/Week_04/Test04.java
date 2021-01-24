package com.vk.Week_04;

import b.a.O;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本周作业
 * 简单：
 * 柠檬水找零（亚马逊在半年内面试中考过）
 * 买卖股票的最佳时机 II （亚马逊、字节跳动、微软在半年内面试中考过）
 * 分发饼干（亚马逊在半年内面试中考过）
 * 模拟行走机器人
 * 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
 * 说明：同学们可以将自己的思路、代码写在第 4 周的学习总结中
 * 中等：
 * 单词接龙（亚马逊在半年内面试常考）
 * 岛屿数量（近半年内，亚马逊在面试中考查此题达到 350 次）
 * 扫雷游戏（亚马逊、Facebook 在半年内面试中考过）
 * 跳跃游戏 （亚马逊、华为、Facebook 在半年内面试中考过）
 * 搜索旋转排序数组（Facebook、字节跳动、亚马逊在半年内面试常考）
 * 搜索二维矩阵（亚马逊、微软、Facebook 在半年内面试中考过）
 * 寻找旋转排序数组中的最小值（亚马逊、微软、字节跳动在半年内面试中考过）
 * 困难
 * 单词接龙 II （微软、亚马逊、Facebook 在半年内面试中考过）
 * 跳跃游戏 II （亚马逊、华为、字节跳动在半年内面试中考过）
 */
public class Test04 {

    public static void main(String[] args) {
        Test04 test=new Test04();

        System.out.println("第一题：柠檬水找零");
        System.out.println("输入：5，5，5，10，20");
        boolean reO=test.lemonadeChange(new int[]{5,5,5,10,20});
        System.out.println(reO);
        System.out.println("-----------------");

        System.out.println("第二题：买卖股票的最佳时机");
        System.out.println("输入：7,1,5,3,6,4");
        int reTw=test.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(reTw);
        System.out.println("-----------------");

        System.out.println("第三题：分发饼干");
        System.out.println("输入：g = [1,2,3], s = [1,1]");
        int reThr=test.findContentChildren(new int[]{1,2,3},new int[]{1,1});
        System.out.println(reThr);
        System.out.println("-----------------");

        System.out.println("第四题：模拟行走机器人");
        System.out.println("输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]");
        int reFor=test.robotSim(new int[]{4,-1,4,-2,4},new int[][]{{2,4}});
        System.out.println(reFor);
        System.out.println("-----------------");

    }

    /**
     * 题目：柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     *
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        int se=0;
        for(int b : bills){
            if(b==5){
                five++;
            }else if(b==10) {
                if(five ==0){
                    return false;
                }
                ten++;
                five--;
            }else {
                if(ten>=1 && five>=1){
                    se++;
                    ten--;
                    five--;
                }else if(five>=3){
                    se++;
                    five=five-3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 题目：买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int re=0;
        for(int i=1; i<prices.length; i++){
            re=re+Math.max(0,prices[i]-prices[i-1]);
        }
        return  re;

    }

    /**
     * 题目：分发饼干
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index=0;
        int sum=0;
        for (int child : g){
            for (int i=index;i<s.length;i++) {
                if(s[i] >=child){
                    sum++;
                    index=i+1;
                    break;
                }
            }
        }
        return sum;
    }

    /**
     * 题目：模拟行走机器人
     * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
     *
     * -2 ：向左转 90 度
     * -1 ：向右转 90 度
     * 1 <= x <= 9 ：向前移动 x 个单位长度
     * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
     *
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
     *
     * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int flag=0;
        int x=0;
        int y=0;
        for(int c :commands) {
            if(c==-2){
                if(flag==0){
                    flag=3;
                }else {
                    flag=flag-1;
                }
            }else if (c==-1){
                if(flag==3){
                    flag=1;
                }else {
                    flag=flag+1;
                }

            }else {
                if(obstacles!=null&&obstacles.length>0){
                    for(int[] obj:obstacles){
                        if(flag==0){
                            if(x==obj[0]&&y+c>=obj[1]){
                                y=obj[1]-1;
                            }else {
                                y=y+c;
                            }
                        }else if(flag==1){
                            if(y==obj[1]&&x+c>=obj[0]){
                                x=obj[0]-1;
                            }else {
                                x=x+c;
                            }
                        }else if (flag==2){
                            if(x==obj[0]&&y-c<=obj[1]){
                                y=obj[1]+1;
                            }else {
                                y=y-c;
                            }

                        }else if (flag==3){
                            if(y==obj[1]&&x-c<=obj[0]){
                                x=obj[0]+1;
                            }else {
                                x=x-c;
                            }
                        }
                    }
                }else {
                    if(flag==0){
                            y=y+c;
                    }else if(flag==1){

                            x=x+c;
                    }else if (flag==2){

                            y=y-c;

                    }else if (flag==3){

                            x=x-c;
                    }
                }
            }

        }
        return x*x+y*y;

    }

}
