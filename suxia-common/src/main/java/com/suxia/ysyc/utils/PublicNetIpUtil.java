package com.suxia.ysyc.utils;

import com.alibaba.fastjson.JSON;
import com.suxia.ysyc.domain.PublicNetIp;
import com.suxia.ysyc.exception.BusinessException;
import com.suxia.ysyc.exception.enums.BusinessExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * <p>
 * 获取本机外网ip工具类
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 13:35
 */
@Slf4j
public class PublicNetIpUtil {

    public static String publicNetIp() {
        String ip = "http://pv.sohu.com/cityjson?ie=utf-8";
        StringBuilder inputLine = new StringBuilder();
        String read;
        try {
            URL url = new URL(ip);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((read = in.readLine()) != null) {
                inputLine.append(read);
            }
            int start = inputLine.indexOf("{");
            int end = inputLine.indexOf("}") + 1;
            String substring = inputLine.substring(start, end);
            PublicNetIp pni = JSON.parseObject(substring, PublicNetIp.class);
            inputLine = new StringBuilder(pni.getCip());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取本机外网ip:{}失败", inputLine.toString(), e);
            throw new BusinessException(BusinessExceptionEnum.EX_80000, e);
        }
        return inputLine.toString();
    }

    public static void main(String[] args) {
        System.out.println(publicNetIp());
    }
}
