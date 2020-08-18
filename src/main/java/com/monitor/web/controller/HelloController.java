package com.monitor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/toVideo")
    public ModelAndView toIndex2(){
        return new ModelAndView("/pages/video.html");
    }

    @RequestMapping("/flv")
    public ModelAndView toFlv(){
        return new ModelAndView("/pages/flv.html");
    }

    @RequestMapping("/flv2")
    public ModelAndView toFlv2(){
        return new ModelAndView("/pages/flv2.html");
    }

    //java操作CMD
    @ResponseBody
    @RequestMapping("/javaOprateCMD")
    public void javaOprateCMD(){
        String command = "ipconfig";
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }


    //VideoJS播放
    @RequestMapping("/viewByVideoJS")
    public String viewByVideoJS(){
        return "/pages/video.html";
    }


    //保存到本地E盘 flv格式
    @ResponseBody
    @RequestMapping("/save")
    public void save(){
        String command = "ffmpeg -i rtmp://localhost/live/ -c copy E:\\20200731savejava.flv";
        try {
            Process process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}