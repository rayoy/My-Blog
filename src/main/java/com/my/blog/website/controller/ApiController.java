package com.my.blog.website.controller;

import com.my.blog.website.model.JordonMap;
import com.my.blog.website.service.IJordonMapService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: ray.wang bookast@qq.com
 * Date: 2018/7/7 下午4:58
 */
@Controller
@RequestMapping("/api")
public class ApiController extends BaseController {
    @Resource
    private IJordonMapService jordonMapService;

    @GetMapping(value = "/keypair")
    @ResponseBody
    public JordonMap query(@RequestParam(name = "key") String key) {
        return jordonMapService.getJordonMapByKey(key);
    }
}
