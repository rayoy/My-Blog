package com.my.blog.website.controller.admin;


import com.github.pagehelper.PageInfo;
import com.my.blog.website.constant.WebConst;
import com.my.blog.website.controller.BaseController;
import com.my.blog.website.dao.JordonMapMapper;
import com.my.blog.website.dto.LogActions;
import com.my.blog.website.dto.Types;
import com.my.blog.website.exception.TipException;
import com.my.blog.website.model.Bo.RestResponseBo;
import com.my.blog.website.model.JordonMap;
import com.my.blog.website.model.Vo.ContentVo;
import com.my.blog.website.model.Vo.ContentVoExample;
import com.my.blog.website.model.Vo.MetaVo;
import com.my.blog.website.model.Vo.UserVo;
import com.my.blog.website.service.IContentService;
import com.my.blog.website.service.IJordonMapService;
import com.my.blog.website.service.ILogService;
import com.my.blog.website.service.IMetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.my.blog.website.constant.WebConst.SUCCESS_RESULT;

/**
 * Created by ray.wang on 2017/2/21.
 */
@Controller
@RequestMapping("/admin/jordan")
@Transactional(rollbackFor = TipException.class)
public class JordanController extends BaseController {

    @Resource
    private IJordonMapService jordonMapService;
    @Resource
    private JordonMapMapper jordonMapMapper;

    @GetMapping(value = "")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        PageInfo<JordonMap> jordonMapPageInfo = jordonMapService.getJordanMap(page, limit);
        request.setAttribute("jordonMaps", jordonMapPageInfo);
        return "admin/jordan_list";
    }

    @GetMapping(value = "/add")
    public String addPage() {
        return "admin/jordan_edit";
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public RestResponseBo save(JordonMap jordonMap) {
        String result = jordonMapService.save(jordonMap.getK(), jordonMap.getV());
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable Long id, HttpServletRequest request) {
        request.setAttribute("jordonMap", jordonMapMapper.selectByPrimaryKey(id));
        return "admin/jordan_edit";
    }

    @PostMapping(value = "/modify")
    @ResponseBody
    public RestResponseBo modify(JordonMap jordonMap) {
        String result = jordonMapService.update(jordonMap);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Long id) {
        jordonMapService.deleteById(id);
        return RestResponseBo.ok();
    }
}
