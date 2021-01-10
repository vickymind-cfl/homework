package com.vk.Week_02;

import java.util.*;

/**
 * 第二周作业
 */
public class Test02 {

    public static void main(String[] args) {

        Test02 test02=new Test02();
       /**
         * 有效字母异位词
         */
        boolean reT1=test02.isAnagram("abcdfh","hfcdba");
        System.out.println("1、'abcdfh'和'hfcdba'是异位词："+reT1);
        System.out.println("");
        /**
         * 两个数之和
         */
        int [] reT2=test02.getSum(new int[]{2,7,11,15}, 9);
        System.out.print("2、和为9的数：");
        for (int t2:reT2){
            System.out.print(t2+",");
        }
        System.out.println("");

        /**
         * N 叉树的前序遍历
         */

        Integer arr[]={1,null,3,2,4,null,5,6};
        Node n5=new Node(5);
        Node n6=new Node(6);
        List<Node> n3List=new ArrayList();
        n3List.add(n5);
        n3List.add(n6);
        Node n3=new Node(3,n3List);
        Node n2=new Node(2);
        Node n4=new Node(4);
        List<Node> n1List=new ArrayList<>();
        n1List.add(n3);
        n1List.add(n2);
        n1List.add(n4);
        Node node=new Node(1,n1List);
        List<Integer> reT3=test02.preorder(node);
        System.out.print("3、n叉树的前序遍历：");
        for (Integer t3:reT3) {
            System.out.print(t3+",");
        }
        System.out.println("");

        /**
//         * 字母易位分组
         */
        String[] arrStr={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> reT4=test02.groupAnagrams(arrStr);
        System.out.println("4、字母易位分组：");
        for(List<String> tP:reT4){
            System.out.println();
            for (String str:tP){
                System.out.print(str+",");
            }
        }
        System.out.println("");


        Node node5=new Node(1,null,new Node(2,new Node(3),null));
        /**
         * 二叉树的中序遍历
         */
        List<Integer> reT5=test02.inorderTraversal(node5);
        System.out.println("5、二叉树的中序遍历：");
        for (Integer re:reT5) {
            System.out.print(re+",");

        }
        System.out.println("");


        List<Integer> reT6=test02.preorderTraversal(node5);
        System.out.println("6、二叉树的前序遍历：");
        for (Integer re:reT6) {
            System.out.print(re+",");

        }
        System.out.println("");

        List<List<Integer>> reT7=test02.levelOrder(node);
        System.out.println("7、n叉树的层序遍历：");
        for (List<Integer> re:reT7) {
            System.out.println("");
            for(Integer r:re){
                System.out.print(r+",");
            }


        }
        System.out.println("");




    }
    /**
     * 简单：
     * 写一个关于 HashMap 的小总结。
     * 说明：对于不熟悉 Java 语言的同学，此项作业可选做。
     * /

     /**
     * 有效的字母异位词（亚马逊、Facebook、谷歌在半年内面试中考过）
     * 思路：先对两个数进行排序后对比是否是相同的数
     */
     public boolean isAnagram(String strA,String strB) {
         if (strA==null||"".equals(strA)) {
             return false;
         }
         if (strB==null||"".equals(strB)) {
             return false;
         }
         if (strA.length()!=strB.length()) {
             return false;
         }
         char[] aChar=strA.toCharArray();
         char[] bChar=strB.toCharArray();

         Arrays.sort(aChar);
         Arrays.sort(bChar);

         return Arrays.equals(aChar,bChar);

     }
     /**
     * 两数之和（近半年内，亚马逊考查此题达到 216 次、字节跳动 147 次、谷歌 104 次，Facebook、苹果、微软、腾讯也在近半年内面试常考）
      */
      public int[] getSum(int[] nums,int target) {
          int[] reNUms=null;
          for (int i:nums){
              for(int j:nums){
                  if(i+j==target){
                       reNUms=new int[]{i,j};
                  }
              }
          }

          return  reNUms;
      }
      /**
     * N 叉树的前序遍历（亚马逊在半年内面试中考过）
       * 题目：
       * 给定一个 N 叉树，返回其节点值的前序遍历。
       */
      public List<Integer> preorder(Node root) {

          LinkedList<Node> newRoot= new LinkedList();
          LinkedList<Integer> reOut=new LinkedList();

          newRoot.add(root);

          while (newRoot!=null && newRoot.size()>0){
              Node node=newRoot.pollLast();
              reOut.add(node.val);
              if(node.children!=null&&node.children.size()>0){
                  Collections.reverse(node.children);
                  for (Node item:node.children) {
                      newRoot.add(item);
                  }
              }


          }
          return reOut;
      }




      /**
       *
     * HeapSort ：自学 https://www.geeksforgeeks.org/heap-sort/
     * 中等：
     * 字母异位词分组（亚马逊在半年内面试中常考）
       * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
       */
      public List<List<String>> groupAnagrams(String[] strs) {


          Map<String,List<String>> map=new HashMap();
          for(String str:strs){
              char[] aChar=str.toCharArray();
              Arrays.sort(aChar);
              String newStr=new String(aChar);
              List<String> mList= map.get(newStr);
              if(mList!=null&&mList.size()>0){
                  mList.add(str);
              }else{
                  List<String> list=new ArrayList();
                  list.add(str);
                  map.put(newStr,list);
              }
          }
          Collection<List<String>> valueCollection = map.values();

          return new ArrayList<List<String>> (valueCollection);
      }

      /**
     * 二叉树的中序遍历（亚马逊、字节跳动、微软在半年内面试中考过）
       * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
       */
      public List<Integer> inorderTraversal(Node root) {

          List<Integer> res = new ArrayList<Integer>();
          Deque<Node> stack = new LinkedList<Node>();
          while (root != null || !stack.isEmpty()) {
              while (root != null) {
                  stack.push(root);
                  root = root.left;
              }
              root = stack.pop();
              res.add(root.val);
              root = root.right;
          }
          return res;

      }
      /**
     * 二叉树的前序遍历（字节跳动、谷歌、腾讯在半年内面试中考过）
       */
      public List<Integer> preorderTraversal(Node root) {
          List<Integer> res = new ArrayList<Integer>();
          Deque<Node> stack = new LinkedList<Node>();
          while (root != null || !stack.isEmpty()) {
              while (root != null) {
                  res.add(root.val);
                  stack.push(root);
                  root = root.left;
              }
              root = stack.pop();
              root = root.right;
          }
          return res;
      }
      /**
     * N 叉树的层序遍历（亚马逊在半年内面试中考过）
       * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
       */
      public List<List<Integer>> levelOrder(Node root) {
          List<List<Integer>> res=new ArrayList<List<Integer>>();
          Deque<Node> stack = new LinkedList<Node>();
          List<Integer> rList=new ArrayList<>();
          rList.add(root.val);
          res.add(rList);
          while (root != null || !stack.isEmpty()) {
              if(root.children!=null) {
                  List<Integer> list = new ArrayList<Integer>();
                  for (Node v : root.children) {
                      list.add(v.val);
                      stack.push(v);
                  }
                  res.add(list);
              }
              if(!stack.isEmpty()) {
                  root = stack.pop();
              }else {
                  root=null;
              }
          }
          return res;

      }

      /**
     * 丑数（字节跳动在半年内面试中考过）
     * 前 K 个高频元素（亚马逊在半年内面试中常考）
     */
}
