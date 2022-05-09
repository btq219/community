package com.nowcoder.community.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;



import java.util.Map;
import java.util.UUID;


public class CommunityUtil {

    // 随机字符串，上传文件 随机名称
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    // MD5加密
    public static String md5(String key){
        if(StringUtils.isBlank(key)){
            return null;
        } else{
            return DigestUtils.md5DigestAsHex(key.getBytes());
        }
    }

    //封装json工具
    public static String getJSONString(int code, String msg, Map<String,Object> map){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        if(map != null){
            for(String key : map.keySet()){
                json.put(key,map.get(key));
            }
        }
        return json.toJSONString();
    }

    //重载json工具
    public static String getJSONString(int code, String msg){
        return getJSONString(code,msg,null);
    }

    //重载json工具
    public static String getJSONString(int code){
        return getJSONString(code,null,null);
    }


}
