package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 作者：DK
 * 日期：20-2-14 下午1:59
 * 描述：解析和处理服务器返回的数据
 */
public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvince = new JSONArray(response);
                //遍历数据
                for (int i = 0; i < allProvince.length(); i++) {
                    JSONObject provinceJSONObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceCode(provinceJSONObject.getInt("id"));
                    province.setProvinceName(provinceJSONObject.getString("name"));
                    //存入数据库
                    province.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /** 解析和处理服务器返回的市级数据*/
    public static boolean handleCityResponse(String response,int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                //遍历数据
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityJSONObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityJSONObject.getInt("id"));
                    city.setCityName(cityJSONObject.getString("name"));
                    city.setProvinceId(provinceId);
                    //存入数据库
                    city.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                //遍历数据
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyJSONObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCityId(cityId);
                    county.setCountyName(countyJSONObject.getString("name"));
                    county.setWeatherId(countyJSONObject.getString("weather_id"));
                    //存入数据库
                    county.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /** 将返回的JSON数据解析成Weather实体类*/
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            //将JSON数据转换成Weather 对象
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
