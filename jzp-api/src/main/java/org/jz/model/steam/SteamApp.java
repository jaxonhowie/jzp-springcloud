package org.jz.model.steam;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author Hongyi Zheng
 * @date 2018/2/24
 */
@Table(name = "ext_steam_app")
public class SteamApp implements Serializable {

    private Integer oid;

    private String appId;

    private Date oitime;

    private Date outime;

    private String isDel;

    private String name;

    @Override
    public String toString() {
        return "SteamApp{" +
                "oid=" + oid +
                ", appId='" + appId + '\'' +
                ", oitime=" + oitime +
                ", outime=" + outime +
                ", isDel='" + isDel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteamApp steamApp = (SteamApp) o;
        return Objects.equals(oid, steamApp.oid) &&
                Objects.equals(appId, steamApp.appId) &&
                Objects.equals(oitime, steamApp.oitime) &&
                Objects.equals(outime, steamApp.outime) &&
                Objects.equals(isDel, steamApp.isDel) &&
                Objects.equals(name, steamApp.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oid, appId, oitime, outime, isDel, name);
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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
        this.isDel = isDel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
