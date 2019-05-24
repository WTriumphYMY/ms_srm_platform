package cn.edu.nwpu.ms_srm_platform.repository;


import cn.edu.nwpu.ms_srm_platform.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName UserRepository
 * @Author: wkx
 * @Date: 2019/5/20 19:58
 * @Version: v1.0
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
