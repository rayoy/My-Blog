package com.my.blog.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.blog.website.constant.WebConst;
import com.my.blog.website.dao.AttachVoMapper;
import com.my.blog.website.dao.JordonMapMapper;
import com.my.blog.website.model.JordonMap;
import com.my.blog.website.model.JordonMapCriteria;
import com.my.blog.website.model.Vo.AttachVo;
import com.my.blog.website.model.Vo.AttachVoExample;
import com.my.blog.website.service.IAttachService;
import com.my.blog.website.service.IJordonMapService;
import com.my.blog.website.utils.DateKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wangq on 2017/3/20.
 */
@Service
public class JordonServiceImpl implements IJordonMapService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JordonServiceImpl.class);

    @Resource
    private JordonMapMapper jordonMapMapper;

    @Override
    public PageInfo<JordonMap> getJordanMap(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        JordonMapCriteria jordonMapCriteria = new JordonMapCriteria();
        jordonMapCriteria.setOrderByClause("update_time desc");
        List<JordonMap> jordonMapList = jordonMapMapper.selectByExample(jordonMapCriteria);
        return new PageInfo<>(jordonMapList);
    }

    @Override
    public JordonMap selectById(Long id) {
        if (null != id) {
            return jordonMapMapper.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    @Transactional
    public String save(String key, String value) {
        JordonMap jordonMap = new JordonMap();
        jordonMap.setK(key);
        jordonMap.setV(value);
        jordonMap.setUpdateTime(new Date());
        try{
            jordonMapMapper.insertSelective(jordonMap);
        }catch (Exception e){
            return "["+jordonMap.getK() + "]已经存在，换一个密钥吧。";
        }
        return WebConst.SUCCESS_RESULT;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (null != id) {
            jordonMapMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public JordonMap getJordonMapByKey(String key) {
        JordonMap jordonMap;
        JordonMapCriteria jordonMapCriteria = new JordonMapCriteria();
        jordonMapCriteria.createCriteria().andKEqualTo(key
        );
        List<JordonMap> list = jordonMapMapper.selectByExample(jordonMapCriteria);
        if (list != null && list.size() > 0) {
            jordonMap = list.get(0);
        } else {
            jordonMap = new JordonMap();
            jordonMap.setK(key);
            jordonMap.setV("密碼不存在！");
        }
        return jordonMap;
    }

    @Override
    public String update(JordonMap jordonMap) {
        jordonMap.setUpdateTime(new Date());
        try{
            jordonMapMapper.updateByPrimaryKey(jordonMap);
        }catch (Exception e){
            return "["+jordonMap.getK() + "]已经存在，换一个密钥吧。";
        }
        return WebConst.SUCCESS_RESULT;
    }
}
