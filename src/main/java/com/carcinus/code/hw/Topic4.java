package com.carcinus.code.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 寻找链表的中间节点
 关键点1: 输入是无序的，需要构建链表
      2: 中间节点就是长度 N/2
  
 */
public class Topic4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {

        }
    }

    static class Node{
        public String address;
        public String data;
        public Node next;
    }

}
