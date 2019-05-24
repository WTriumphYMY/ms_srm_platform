package cn.edu.nwpu.ms_srm_platform.domain;

import javax.persistence.*;

/**
 * @ClassName User
 * @Author: wkx
 * @Date: 2019/5/20 19:37
 * @Version: v1.0
 * @Description:
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id//主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)//自增策略
    @Column(name = "pk_id")
    private int pkId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "platform_access")
    private byte platformAccess;
    @Column(name = "manage_access")
    private byte manageAccess;
    @Column(name = "balszero_access")
    private byte balsAccess;

    public int getPkId() {
        return pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public byte getPlatformAccess() {
        return platformAccess;
    }

    public void setPlatformAccess(byte platformAccess) {
        this.platformAccess = platformAccess;
    }

    public byte getManageAccess() {
        return manageAccess;
    }

    public void setManageAccess(byte manageAccess) {
        this.manageAccess = manageAccess;
    }

    public byte getBalsAccess() {
        return balsAccess;
    }

    public void setBalsAccess(byte balsAccess) {
        this.balsAccess = balsAccess;
    }

    @Override
    public String toString() {
        return "User{" +
                "pkId=" + pkId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", platformAccess=" + platformAccess +
                ", manageAccess=" + manageAccess +
                ", balsAccess=" + balsAccess +
                '}';
    }
}
