package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：DK
 * 日期：20-2-17 上午10:20
 * 描述：
 */
public class Forecast {
    public String date;
    @SerializedName("tmp")
    public Temperature temperature;
    @SerializedName("cond")
    public More more;
    public class Temperature {
        public String max;
        public String min;
    }
    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}
