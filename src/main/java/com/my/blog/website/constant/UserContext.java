package com.my.blog.website.constant;

import com.my.blog.website.model.Vo.UserVo;

public class UserContext {
    private static final ThreadLocal<UserVo> userThreadLocal = new ThreadLocal<>();
    public static UserVo get() {
        return userThreadLocal.get();
    }
    public static void set(UserVo user) {
        userThreadLocal.set(user);
    }
}  