
package com.taiji.eap.common.redis.bean;

import com.taiji.eap.common.dictionary.annotation.Dictionary;
import com.taiji.eap.common.base.BaseTree;
public class RedisKey extends BaseTree {
    private Long keyId;//
    private String keyValue;//key值
    private String keyName;//键名称
    private Long parentId;//上级ID
    @Dictionary(dataSource = "dictionary",params = "83")
    private String keyType;//键类型
    private String keyNote;//键注释
    private String dataSize;//对应数据大小
    public RedisKey(Long keyId,String keyName) {
        this.keyId = keyId;
        this.keyName = keyName;
    }

    public RedisKey() {

    }

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }


    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }


    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }


    public String getKeyNote() {
        return keyNote;
    }

    public void setKeyNote(String keyNote) {
        this.keyNote = keyNote;
    }


    public String getDataSize() {
        return dataSize;
    }

    public void setDataSize(String dataSize) {
        this.dataSize = dataSize;
    }


}
