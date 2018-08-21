package wqz.model.sbmm.busproject.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_license")
public class TbLicense {
    @Id
    private Integer id;

    private String province;

    private String city;

    @Column(name = "cluster_name")
    private String clusterName;

    @Column(name = "cluster_num")
    private Integer clusterNum;

    @Column(name = "create_time")
    private Date createTime;

    private Integer indate;

    @Column(name = "expire_time")
    private Date expireTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return cluster_name
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * @param clusterName
     */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * @return cluster_num
     */
    public Integer getClusterNum() {
        return clusterNum;
    }

    /**
     * @param clusterNum
     */
    public void setClusterNum(Integer clusterNum) {
        this.clusterNum = clusterNum;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return indate
     */
    public Integer getIndate() {
        return indate;
    }

    /**
     * @param indate
     */
    public void setIndate(Integer indate) {
        this.indate = indate;
    }

    /**
     * @return expire_time
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}