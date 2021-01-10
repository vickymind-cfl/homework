package com.vk.Week_02;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;
    Node left;
    Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
    Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }



}
