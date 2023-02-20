package com.carcinus.code.leetcode.p_1972;

import java.util.PriorityQueue;

/**
 * 1792. 最大平均通过率
 *
 * @link <a href="https://leetcode.cn/problems/maximum-average-pass-ratio/">...</a>
 */
public class MaximumAveragePassRatio {
//
//    public double maxAverageRatio(int[][] classes, int extraStudents) {
//        double[][] avgScores = new double[classes.length][3];
//        for (int i = 0; i < classes.length; i++) {
//            int p = classes[i][0];
//            int n = classes[i][1];
//            double tmp = (n - p) / (Math.pow(n, 2) + n);
//            avgScores[i][0] = p * 1.0;
//            avgScores[i][1] = n * 1.0;
//            avgScores[i][2] = tmp;
//        }
//
//        while (extraStudents > 0) {
//            int index = 0;
//            double max = 0D;
//            for (int i = 0; i < avgScores.length; i++) {
//                if (avgScores[i][2] > max) {
//                    max = avgScores[i][2];
//                    index = i;
//                }
//            }
//            double p = avgScores[index][0] + 1;
//            double n = avgScores[index][1] + 1;
//            double tmp = (n - p) / (Math.pow(n, 2) + n);
//            avgScores[index][0] = p;
//            avgScores[index][1] = n;
//            avgScores[index][2] = tmp;
//            extraStudents--;
//        }
//        int n = avgScores.length;
//        double total = 0D;
//        for (int i = 0; i < avgScores.length; i++) {
//            total += avgScores[i][0] / avgScores[i][1];
//        }
//        return total / n;
//
//
//    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < classes.length; i++) {
            nodes.add(new Node(classes[i][0], classes[i][1]));
        }
        while (extraStudents > 0) {
            Node maxNode = nodes.poll();
            maxNode.insertStudent();
            nodes.add(maxNode);

            extraStudents--;
        }
        int n = classes.length;
        double total = 0D;

        while (nodes.size()!= 0) {
            Node node = nodes.poll();
            total += node.getAvg();
        }
        return total / n;
    }

    static class Node implements Comparable<Node> {
        public double p;
        public double n;
        public double x;

        public Node(int p, int n) {
            this.p = p * 1.0;
            this.n = n * 1.0;
            this.x = cal();
        }

        private double cal() {
            return (n - p) / (Math.pow(n, 2) + n);
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.x < 0 ? 1 : -1;
        }


        public void insertStudent() {
            this.p++;
            this.n++;
            this.x = cal();
        }
        public double getAvg() {
            return 1.0 * p / n ;
        }
    }


    public static void main(String[] args) {
        int[][] ints = new int[3][2];
        ints[0][0] = 1;
        ints[0][1] = 2;
        ints[1][0] = 3;
        ints[1][1] = 5;
        ints[2][0] = 2;
        ints[2][1] = 2;
        System.out.println(new MaximumAveragePassRatio().maxAverageRatio(ints, 2));
    }
}
