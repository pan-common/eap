package com.taiji.eap.common.base.packbean;

import com.taiji.eap.common.form.elementExtend.bean.ElementExtend;

import java.util.List;

/**
 *
 * @param <T>
 */
public class PackList{

    private List<ElementExtend> datas;

    public PackList(List<ElementExtend> datas) {
        this.datas = datas;
    }

    public PackList() {
    }

    public List<ElementExtend> getDatas() {
        return datas;
    }

    public void setDatas(List<ElementExtend> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "PackList{" +
                "datas=" + datas +
                '}';
    }
}
