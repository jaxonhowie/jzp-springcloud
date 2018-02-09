package org.jz.model.steam;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Hongyi Zheng
 * @date 2018/2/9
 */
@Table(name = "ext_steam_api")
public class SteamApi implements Serializable{

    private Integer oid;

    private String name;

    private Date oitime;

    private Date outime;

    private String isDel;

    private String methods;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getOitime() {
        return oitime;
    }

    public void setOitime(Date oitime) {
        this.oitime = oitime;
    }

    public Date getOutime() {
        return outime;
    }

    public void setOutime(Date outime) {
        this.outime = outime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods == null ? null : methods.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteamApi steamApi = (SteamApi) o;
        return Objects.equals(oid, steamApi.oid) &&
                Objects.equals(name, steamApi.name) &&
                Objects.equals(oitime, steamApi.oitime) &&
                Objects.equals(outime, steamApi.outime) &&
                Objects.equals(isDel, steamApi.isDel) &&
                Objects.equals(methods, steamApi.methods);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oid, name, oitime, outime, isDel, methods);
    }

    @Override
    public String toString() {
        return "SteamApi{" +
                "oid=" + oid +
                ", name='" + name + '\'' +
                ", oitime=" + oitime +
                ", outime=" + outime +
                ", isDel='" + isDel + '\'' +
                ", methods='" + methods + '\'' +
                '}';
    }
}