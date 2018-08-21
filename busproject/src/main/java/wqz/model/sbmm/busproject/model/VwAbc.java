package wqz.model.sbmm.busproject.model;

import javax.persistence.*;

@Table(name = "vw_abc")
public class VwAbc {
    private String uuid;

    private String pk1;

    private String pk2;

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
     * @return pk1
     */
    public String getPk1() {
        return pk1;
    }

    /**
     * @param pk1
     */
    public void setPk1(String pk1) {
        this.pk1 = pk1;
    }

    /**
     * @return pk2
     */
    public String getPk2() {
        return pk2;
    }

    /**
     * @param pk2
     */
    public void setPk2(String pk2) {
        this.pk2 = pk2;
    }
}