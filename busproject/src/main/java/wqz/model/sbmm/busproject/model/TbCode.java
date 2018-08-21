package wqz.model.sbmm.busproject.model;

import javax.persistence.*;

@Table(name = "tb_code")
public class TbCode {
    @Id
    private String uuid;

    @Column(name = "c_key")
    private String cKey;

    private String value;

    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return c_key
     */
    public String getcKey() {
        return cKey;
    }

    /**
     * @param cKey
     */
    public void setcKey(String cKey) {
        this.cKey = cKey;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
}