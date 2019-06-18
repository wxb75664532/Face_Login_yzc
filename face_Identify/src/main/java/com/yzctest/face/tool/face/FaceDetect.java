package com.yzctest.face.tool.face;

import com.yzctest.face.tool.Auth;
import com.yzctest.face.tool.GsonUtils;
import com.yzctest.face.tool.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class FaceDetect {

    public static String detect(String image)
    {

        //百度人脸识别API
        String url="https://aip.baidubce.com/rest/2.0/face/v3/detect";

        try{
            Map<String,String> options=new HashMap<String,String>();
            options.put("image",image);
            options.put("max_face_num","2");
            options.put("image_type", "BASE64");
            String param = GsonUtils.toJson(options);

            Auth auth = new Auth();
            String accessToken = auth.getAuth();


            //以百度云文档调用方式1 以URL方式请求，必须获取access_Token,param,字符串的参数
            String results = HttpUtil.post(url, accessToken, "application/json", param);


            String result=results.split(",")[5];
            String people="0";
            if(result!=null)
            {
                people=result.split(":")[2];
            }
            return people;

        }catch (Exception e)
        {
            e.printStackTrace();

        }
        return "0";
    }
}
