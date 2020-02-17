package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：DK
 * 日期：20-2-17 上午10:17
 * 描述：封装天气信息
 */
public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort;
    @SerializedName("cw")
    public CarWash carWash;
    public Sport sport;

    public class Comfort {
        @SerializedName("txt")
        public String info;
    }

    public class CarWash {
        @SerializedName("txt")
        public String info;
    }

    public class Sport {
        @SerializedName("txt")
        public String info;
    }
}
