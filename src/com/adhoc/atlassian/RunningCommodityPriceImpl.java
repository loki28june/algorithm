package com.adhoc.atlassian;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RunningCommodityPriceImpl implements RunningCommodityPrice {

    private Map<Integer, Integer> timestampToCommodityPrice = new HashMap<>();
    public PriorityQueue<Integer> maximumCommodityPriceHeap = new PriorityQueue<>(Collections.reverseOrder());


    @Override
    public void upsertCommodityPrice(int timestamp, int commodityPrice) {
        if (timestampToCommodityPrice.containsKey(timestamp)) {
            int existingPrice = timestampToCommodityPrice.get(timestamp);
            maximumCommodityPriceHeap.remove(existingPrice);
        }
        timestampToCommodityPrice.put(timestamp, commodityPrice);
        if (!maximumCommodityPriceHeap.isEmpty() && maximumCommodityPriceHeap.peek() == commodityPrice) {
            return;
        }
        maximumCommodityPriceHeap.offer(commodityPrice);
    }

    @Override
    public int getMaxCommodityPrice() {
        if (maximumCommodityPriceHeap.isEmpty()) return 0;
        return maximumCommodityPriceHeap.peek();
    }

    public static void main(String[] args) {
        RunningCommodityPriceImpl r = new RunningCommodityPriceImpl();
        r.upsertCommodityPrice(4, 28);
        r.upsertCommodityPrice(3, 27);
        r.upsertCommodityPrice(4, 26);
        System.out.println(r.getMaxCommodityPrice());
        System.out.println(r.maximumCommodityPriceHeap.size());
    }
}
