
package com.taiji.eap.common.shiro.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class SysPurviewResource extends BaseModel{
    private Long id;//主键
    private Long puriewId;//权限ID
    private Long resourceId;//资源ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getPuriewId() {
        return puriewId;
    }

    public void setPuriewId(Long puriewId) {
        this.puriewId = puriewId;
    }


    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }


}
