package com.yzctest.face.controller;


import com.yzctest.face.result.ReturnWeb;
import com.yzctest.face.service.FaceIdeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

@Controller
public class BaseController {

    @Autowired
    FaceIdeService faceIdeService;

    @RequestMapping("/camera")
    public String show()
    {
        return "base";
    }

    @PostMapping("/doing/match")
    @ResponseBody
    public ReturnWeb match(String imgData)
    {

        String result = faceIdeService.resultMatch(imgData);
        if(imgData!=null)return new ReturnWeb(true,result);
        else return new ReturnWeb(false,"获取失败");


    }
    @PostMapping("/doing/detect")
    @ResponseBody
    public ReturnWeb detect(String imgData)
    {

        String detect = faceIdeService.resultDetect(imgData);
        if(imgData!=null)return new ReturnWeb(true,detect);
        else return new ReturnWeb(false,"获取失败");

    }

    @PostMapping("/doing/add")
    @ResponseBody
    public ReturnWeb add(String imgData)
    {

        boolean add = faceIdeService.resultAdd(imgData);
        if(add)return new ReturnWeb(true,"添加成功");
        else return new ReturnWeb(false,"添加失败");

    }

    @PostMapping("/doing/search")
    @ResponseBody
    public ReturnWeb search(String imgData)
    {

        boolean add = faceIdeService.isIdentify(imgData);
        if(add)return new ReturnWeb(true,"识别成功");
        else return new ReturnWeb(false,"识别失败");

    }

    @GetMapping("/success")
    public String returnSuccess()
    {
        return "success.html";
    }
}
