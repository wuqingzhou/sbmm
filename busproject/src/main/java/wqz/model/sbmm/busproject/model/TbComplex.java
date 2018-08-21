package wqz.model.sbmm.busproject.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_complex")
public class TbComplex {
    @Id
    private String pk1;

    @Id
    private String pk2;

    @Column(name = "col_a")
    private Double colA;

    @Column(name = "col_b")
    private Date colB;

    @Column(name = "col_c")
    private Date colC;

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

    /**
     * @return col_a
     */
    public Double getColA() {
        return colA;
    }

    /**
     * @param colA
     */
    public void setColA(Double colA) {
        this.colA = colA;
    }

    /**
     * @return col_b
     */
    public Date getColB() {
        return colB;
    }

    /**
     * @param colB
     */
    public void setColB(Date colB) {
        this.colB = colB;
    }

    /**
     * @return col_c
     */
    public Date getColC() {
        return colC;
    }

    /**
     * @param colC
     */
    public void setColC(Date colC) {
        this.colC = colC;
    }
}