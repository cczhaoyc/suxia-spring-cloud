package com.suxia.ysyc.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * <p>
 * 拼接字符串
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 13:45
 */
public class StringJoinerUtil {

    public static final String DEFAULT_DELIMITER = ":";

    /**
     * <p>
     * 拼装字符串
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/9 13:47
     */
    public static String build(String... key) {
        return buildFree(DEFAULT_DELIMITER, key);
    }

    /**
     * <p>
     * 拼装字符串
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/9 13:47
     */
    public static String buildFree(String delimiter, String... key) {
        if (StringUtils.isBlank(delimiter)) {
            delimiter = DEFAULT_DELIMITER;
        }
        StringJoiner completeKey = new StringJoiner(delimiter);
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                return key[0];
            } else {
                List<String> keyList = Arrays.asList(key);
                keyList.forEach(completeKey::add);
                return completeKey.toString();
            }
        }
        return null;
    }
}
