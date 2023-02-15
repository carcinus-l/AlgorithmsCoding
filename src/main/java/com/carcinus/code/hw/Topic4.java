package com.carcinus.code.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 寻找链表的中间节点
 * 关键点1: 输入是无序的，需要构建链表
 * 2: 中间节点就是长度 N/2
 */
public class Topic4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] rootAndN = line.split(" ");
            String headAddress = rootAndN[0];
            int n = Integer.parseInt(rootAndN[1]);
            ArrayList<Node> nodes = new ArrayList<>();
            Node head = null;
            for (int i = 0; i < n; i++) {
                String[] infos = br.readLine().split(" ");
                Node node = new Node(infos[0], infos[1], infos[2]);
                if (infos[0].equals(headAddress)) {
                    //头结点
                    head = node;
                }
                nodes.add(node);
            }
            //计算中间结点是位置
            if (n % 2 == 1) {
                n = n / 2;
            } else {
                n = n / 2 + 1;
            }
            findMidNode(n, head, nodes);
            findMidNode2(n, head, nodes);
        }
    }

    //链表版
    public static void findMidNode(int n, Node head, List<Node> nodes) {
        Node current = head;
        //构建链表  -1表示尾结点
        while (!current.nextAddress.equals("-1")) {
            for (Node node : nodes) {
                if (current.nextAddress.equals(node.address)) {
                    current.next = node;
                    //挪动指针
                    current = current.next;
                }
            }
        }
        //输出
        current = head;

        String res = "";
        String mid = "";

        while (current != null) {
            res = res + "->" + current.data;
            if (--n == 0) {
                mid = current.data;
            }
            current = current.next;

        }

        //去掉第一个箭头
        System.out.println(res.substring(2));
        System.out.println(mid);
    }

    //数组版
    public static void findMidNode2(int n, Node head, List<Node> nodes) {
        String currentAddress = head.address;
        String[] res = new String[nodes.size()];
        int index = 0;
        //构建链表  -1表示尾结点
        while (!currentAddress.equals("-1")) {
            for (Node node : nodes) {
                if (currentAddress.equals(node.address)) {
                    res[index++] = node.data;
                    //挪动指针
                    currentAddress = node.nextAddress;
                }
            }
        }
        System.out.println(String.join("->", res));
        //下标从0开始,所有-1
        System.out.println(res[n - 1]);
    }

    static class Node {
        public String address;
        public String data;
        public String nextAddress;
        public Node next;

        public Node(String address, String data, String nextAddress) {
            this.address = address;
            this.data = data;
            this.nextAddress = nextAddress;
        }

        public boolean hasNext() {
            return next != null;
        }

    }

}
