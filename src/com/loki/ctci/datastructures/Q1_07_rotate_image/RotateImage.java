package com.loki.ctci.datastructures.Q1_07_rotate_image;

public class RotateImage {
    public static void rotateImage(int[][] image){
        if(image.length == 0 || image.length != image[0].length) return;
        int N = image.length;
        //step 1 transpose matrix
        for(int i =0; i<N; i++){
            for(int j=i; j<N;j++){
                int temp = image[i][j];
                image[i][j] = image[j][i];
                image[j][i] = temp;
            }
        }

        //step 2 flip the row elements horizontally
        for(int i =0; i<N; i++){
            for(int j=0; j<N-2;j++){
                int temp = image[i][j];
                image[i][j] = image[i][N-1-j];
                image[i][N-1-j] = temp;
            }
        }
    }

    private static void printArray(int[][] image){
        int N = image.length;
        for(int i =0; i<N; i++){
            for(int j=0; j<N;j++){
              System.out.print(image[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] n = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printArray(n);
        rotateImage(n);
        System.out.println();
        printArray(n);
    }
}
