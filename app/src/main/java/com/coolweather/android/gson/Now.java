package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：DK
 * 日期：20-2-17 上午10:16
 * 描述：
 */
public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
