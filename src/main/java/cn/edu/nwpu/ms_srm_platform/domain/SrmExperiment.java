package cn.edu.nwpu.ms_srm_platform.domain;

import javax.persistence.*;

/**
 * @ClassName SrmExperiment
 * @Author: wkx
 * @Date: 2019/4/12 20:08
 * @Version: v1.0
 * @Description: 实验数据表对应实体类
 */
@Entity
@Table(name = "tb_experiment")
public class SrmExperiment {
    @Id//主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)//自增策略
    @Column(name = "pk_id")
    private int pkId;
    @Column(name = "exp_time")
    private String expTime;
    @Column(name = "exp_pressure")
    private String expPressure;
    @Column(name = "exp_force")
    private String expForce;
    @Column(name = "srm_name")
    private String srmName;
    @Column(name = "gmt_create")
    private String gmtCreate;

    public int getPkId() {
        return pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }

    public String getExpPressure() {
        return expPressure;
    }

    public void setExpPressure(String expPressure) {
        this.expPressure = expPressure;
    }

    public String getExpForce() {
        return expForce;
    }

    public void setExpForce(String expForce) {
        this.expForce = expForce;
    }

    public String getSrmName() {
        return srmName;
    }

    public void setSrmName(String srmName) {
        this.srmName = srmName;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
