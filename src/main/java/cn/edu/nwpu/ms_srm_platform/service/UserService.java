package cn.edu.nwpu.ms_srm_platform.service;


import cn.edu.nwpu.ms_srm_platform.domain.User;

/**
 * @ClassName UserService
 * @Author: wkx
 * @Date: 2019/5/20 20:10
 * @Version: v1.0
 * @Description: 用户服务接口
 */
public interface UserService {
    /**
     * 用户登陆功能
     * @param user
     * @return
     */
    boolean login(User user);

    /**
     * 用户注册功能
     * @param user
     * @return
     */
    boolean regist(User user);
}
