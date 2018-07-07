package com.my.blog.website.service;

import com.github.pagehelper.PageInfo;
import com.my.blog.website.model.JordonMap;

/**
 * Created by ray.wang on 2017/3/13 013.
 */
public interface IJordonMapService {
    public PageInfo<JordonMap> getJordanMap(Integer page, Integer limit);

    JordonMap selectById(Long id);

    String save(String key, String value);

    void deleteById(Long id);

    JordonMap getJordonMapByKey(String key);

    String update(JordonMap jordonMap);
}
