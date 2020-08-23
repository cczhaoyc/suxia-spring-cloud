package com.suxia.ysyc.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * <p>
 * 根据雪花算法生成的id逆序推导创建时间
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 10:07
 */
public class SnowflakeUtil {

    /**
     * 起始时间戳 2020-08-01 00:00:00
     */
    public static long EPOCH = 1596211200000L;
    /**
     * timestamp bit长度
     */
    public static int TIMESTAMP_BIT = 41;
    /**
     * 标识位 bit长度
     */
    public static int FLAG_BIT = 1;
    /**
     * 数据中心bit长度
     */
    public static int DATA_CENTER_BIT = 5;
    /**
     * 机器bit长度
     */
    public static int WORKER_BIT = 5;
    /**
     * 每ms序号bit长度
     */
    public static int SEQ_BIT = 12;

    /**
     * <p>
     * 以二进制位带-分隔符形式返回id
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/9 11:07
     */
    public static String toBinaryString(long snowId, String delimiter) {
        char[] bId = Long.toBinaryString(snowId).toCharArray();
        StringBuilder sb = new StringBuilder();
        // 标志位
        sb.append("0").append(delimiter);

        // 时间戳
        int timestamp = bId.length - (WORKER_BIT + DATA_CENTER_BIT + SEQ_BIT);
        int zero = TIMESTAMP_BIT - timestamp;
        // 时间戳前面补全0
        for (int i = 0; i < zero; i++) {
            sb.append(0);
        }
        for (int i = 0; i < timestamp; i++) {
            sb.append(bId[i]);
        }
        sb.append(delimiter);

        // 数据中心bit长度 + 机器bit长度
        int workLength = WORKER_BIT + DATA_CENTER_BIT;
        for (int i = timestamp; i < timestamp + workLength; i++) {
            sb.append(bId[i]);
        }
        sb.append(delimiter);
        // 每ms序号bit长度
        for (int i = timestamp + workLength; i < bId.length; i++) {
            sb.append(bId[i]);
        }
        return sb.toString();
    }

    /**
     * <p>
     * 根据雪花id获取生成时间
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/9 10:51
     */
    public static long getGenerationTime(long snowId) {
        return getStartTime(snowId) + EPOCH;
    }

    /**
     * <p>
     * 从雪花id中计算以规定起始时间开始的时间值
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/9 10:53
     */
    public static long getStartTime(long snowId) {
        String startTime = Long.toBinaryString(snowId);
        int endIndex = startTime.length() - (WORKER_BIT + DATA_CENTER_BIT + SEQ_BIT);
        String substring = startTime.substring(0, endIndex);
        return Long.parseUnsignedLong(substring, 2);
    }

    /**
     * <p>
     * 从雪花id中计算出datacenterId+workerId
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/9 12:20
     */
    public static String getWorkerId(long snowId) {
        String bin = toBinaryString(snowId, "");
        // 数据中心id
        int datacenterIdBeginIndex = FLAG_BIT + TIMESTAMP_BIT;
        int datacenterIdEndIndex = FLAG_BIT + TIMESTAMP_BIT + DATA_CENTER_BIT;
        long datacenterId = Long.parseUnsignedLong(bin.substring(datacenterIdBeginIndex, datacenterIdEndIndex), 2);
        // 工作id
        int workerIdBeginIndex = FLAG_BIT + TIMESTAMP_BIT + DATA_CENTER_BIT;
        int workerIdEndIndex = FLAG_BIT + TIMESTAMP_BIT + DATA_CENTER_BIT + WORKER_BIT;
        long workerId = Long.parseUnsignedLong(bin.substring(workerIdBeginIndex, workerIdEndIndex), 2);
        return datacenterId + ":" + workerId;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.format(new Date(SnowflakeUtil.getGenerationTime(3068113142943744L)), DatePattern.CHINESE_DATE_TIME_PATTERN));
    }

}
