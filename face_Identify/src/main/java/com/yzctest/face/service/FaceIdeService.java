package com.yzctest.face.service;

import com.yzctest.face.tool.face.FaceAdd;
import com.yzctest.face.tool.face.FaceDetect;
import com.yzctest.face.tool.face.FaceMatch;
import com.yzctest.face.tool.face.FaceSearch;
import org.springframework.stereotype.Service;

@Service
public class FaceIdeService {


    ///调用人脸识别MATCH，获取两者之间的score,大于80则认为相同
    public String resultMatch(String image)
    {

        String[] imageInfo=image.split(",");
        String match = FaceMatch.match(imageInfo[imageInfo.length - 1]);
        System.out.println(match);
        return match;
    }

    ///调用人脸检测Detect方法，获取当前照片的人数
    public String resultDetect(String image)
    {
        String[] imageInfo=image.split(",");
        String detect = FaceDetect.detect(imageInfo[imageInfo.length - 1]);
        System.out.println(detect);
        return detect;
    }

    /*
        调用人脸注册Add方法，先将图片保存在数据库中，然后向百度云人脸库中添加人脸数据，
    返回是否添加成功。
    */
    public boolean resultAdd(String image)
    {
        String[] imageInfo=image.split(",");
        boolean add = FaceAdd.add(2,imageInfo[imageInfo.length - 1]);
        return add;
    }

    /*
        调用人脸搜索SearchAPI，获取当前匹配成读最高的user_id,并判断匹配值
     */
    public boolean isIdentify(String image)
    {
        String[] imageInfo=image.split(",");
        String result = FaceSearch.FaceSearch(imageInfo[imageInfo.length - 1]);

        if(result==null)return false;

        String[] results=result.split(",");
        String score=results[9].split(":")[1];
        System.out.println(score);
        if(score.compareTo("80")>0)
        {
            String user_id=results[7].split(":")[1].replaceAll("\"","");
            System.out.println(user_id);
            return true;
        }
        return false;
    }
}
