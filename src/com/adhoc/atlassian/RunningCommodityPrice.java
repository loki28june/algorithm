package com.adhoc.atlassian;

public interface RunningCommodityPrice {

    void upsertCommodityPrice(int timestamp, int commodityPrice);

    int getMaxCommodityPrice();
}
