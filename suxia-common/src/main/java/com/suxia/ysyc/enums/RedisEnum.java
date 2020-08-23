package com.suxia.ysyc.enums;

/**
 * <p>
 * Redis相关常量
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 16:00
 */
public interface RedisEnum {

    enum RedisKey {

        /**
         * 用户模块Redis缓存前缀
         */
        USER("user:");

        private String prefix;

        RedisKey(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }
}
