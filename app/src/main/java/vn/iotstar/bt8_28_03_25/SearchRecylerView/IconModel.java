package vn.iotstar.bt8_28_03_25.SearchRecylerView;

import java.io.Serializable;

public class IconModel implements Serializable {
    private Integer imgId;
    private String decs;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public IconModel(Integer imgId, String decs) {
        this.imgId = imgId;
        this.decs = decs;
    }
}
