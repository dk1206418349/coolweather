package com.coolweather.android.gson;

/**
 * 作者：DK
 * 日期：20-2-17 上午10:15
 * 描述：  针对和风天气建立实体类
 */
public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
