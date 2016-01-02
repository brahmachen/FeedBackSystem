package com.sdau.markchen.feedbacksystem.entity;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by mark chen on 2015/12/30.
 */
public class Problem {
    private int id;
    private String zjh = "";//日期+3位流水号
    private String bt = "";//标题
    private String nr = "";//内容
    private Date sbsj;//上报时间
    private String x = "0";
    private String y = "0";
    private String tp = "/";//图片路径
    private int lx = 0;

    public Problem() {
    }

    public int getLx() {
        return lx;
    }

    public void setLx(int lx) {
        this.lx = lx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZjh() {
        return zjh;
    }

    public void setZjh(String zjh) {
        this.zjh = zjh;
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public Date getSbsj() {
        return sbsj;
    }

    public void setSbsj(Date sbsj) {
        this.sbsj = sbsj;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", zjh='" + zjh + '\'' +
                ", bt='" + bt + '\'' +
                ", nr='" + nr + '\'' +
                ", sbsj=" + sbsj +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", tp='" + tp + '\'' +
                ", lx=" + lx +
                '}';
    }

    public HashMap getHashMap() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("id", id + "");
        hashMap.put("zjh", zjh);
        hashMap.put("bt", this.bt);
        hashMap.put("nr", nr);
        hashMap.put("sbsj", sbsj + "");
        hashMap.put("x", x);
        hashMap.put("y", y);
        hashMap.put("tp", tp);
        hashMap.put("lx", lx + "");
        return hashMap;
    }
}
