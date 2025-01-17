package com.loki.techinterviews;

public class FreshworksFirstRound {

        public static void main(String[] args) {
            String input = "NLNNLLL";
            int depth = 0;
            System.out.println(depthOfTree(input, 0));
        }

        private static int depthOfTree(String str,int root){
            if(root > str.length()-1 || str.charAt(root) == 'L' ){
                return 0; // base case
            }
            int leftDepth = depthOfTree(str,root+1);
            int rightDepth = depthOfTree(str,root+2);
            return 1 + Math.max(leftDepth,rightDepth);
        }
    }
