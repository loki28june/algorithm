package com.loki.neetcode150;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int minimum=-1,max=Integer.MIN_VALUE;
        for(int pile : piles){
            max = Math.max(max,pile);
        }
        int low=0,high=max-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int time = getAllBananasEatTime(mid,piles);
            if(time <=h){
                minimum = mid+1;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return minimum;
    }

    public static int getAllBananasEatTime(int mid,int[] piles){
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / mid);
        }
        return hours;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }
}
