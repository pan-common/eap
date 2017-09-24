package com.taiji.eap.common.http.methods;


import com.taiji.eap.common.http.entity.Header;
import com.taiji.eap.common.http.entity.Request;
import com.taiji.eap.common.http.entity.RequestBody;
import com.taiji.eap.common.utils.UUIDUtils;

/**
 * 作者：panho on 2017-3-16 00:23
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class RequestHelper<T> {

    public RequestHelper(){
    }

    public Request<T> getRequest(T t) {
        Header header = new Header("android", UUIDUtils.getGUID(), "---");
        RequestBody<T> requestBody = new RequestBody<T>(t);
        Request<T> mRequest = new Request<T>(header,requestBody);
        return mRequest;
    }

}
