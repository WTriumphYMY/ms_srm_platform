package cn.edu.nwpu.ms_srm_platform.service.impl;

import cn.edu.nwpu.ms_srm_platform.domain.User;
import cn.edu.nwpu.ms_srm_platform.repository.UserRepository;
import cn.edu.nwpu.ms_srm_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserServiceImpl
 * @Author: wkx
 * @Date: 2019/5/20 20:11
 * @Version: v1.0
 * @Description: 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean login(User user) {
        User checkUser = userRepository.findByUserName(user.getUserName());
        if (checkUser != null && user.getUserPassword().equals(checkUser.getUserPassword())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean regist(User user) {
        if (userRepository.findByUserName(user.getUserName()) != null){
            return false;
        }else {
            userRepository.save(user);
            return true;
        }
    }
}
