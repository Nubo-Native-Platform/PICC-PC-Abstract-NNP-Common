
package com.nnp.common.abs.util;

import java.util.concurrent.atomic.AtomicInteger;

import com.nnp.common.abs.constant.NNPCommonConstants;


public class UUIDGenerator {

    private static String appPrefix  = NNPCommonConstants.ID_PREFIX_APP;
    private static final AtomicInteger counter = new AtomicInteger();
    private UUIDGenerator() {}
    public static void setAppPrefix(String ap){
        appPrefix = ap;
    }
    public static String generateId(String prefix) {

        long time = System.nanoTime();
        return appPrefix  + NNPCommonConstants.ID_DELIM + prefix + NNPCommonConstants.ID_DELIM + counter.incrementAndGet() + getTimeLow(time) + getTimeHigh(time);
    }

    private static int getTimeLow(long l) {
        return (int) (0x0000000000ffffff & l);
    }

    private static long getTimeHigh(long l) {
        return ((0xffffff0000000000L & l) >> 16);
    }

}
