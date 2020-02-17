package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：DK
 * 日期：20-2-17 上午10:11
 * 描述：
 */
public class Basic {
    //@SerializedName注解的方式来让JSON字段和Java字段之间建立映射关系
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
