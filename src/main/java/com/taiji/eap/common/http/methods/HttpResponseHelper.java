package com.taiji.eap.common.http.methods;

import com.taiji.eap.common.http.entity.Header;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.http.entity.ResponseBody;
import com.taiji.eap.common.utils.UUIDUtils;

public class HttpResponseHelper<T> {

	private Response<T> response;
	
	public HttpResponseHelper() {
		
	}
	/**
	 * 响应成功
	 * @param t 返回数据实体
	 * @return
	 */
	public Response<T> responseSuccess(T t){
		ResponseBody<T> responseBody = new ResponseBody<T>(ResponseBody.SUCCESS,"成功",t);
		Header header = new Header("CULTURE_AND_DATA_CENTER", UUIDUtils.getGUID(), "0");
		response = new Response<T>(header, responseBody);
		return response;
	}

	/**
	 * 响应成功
	 * @param t
	 * @return
     */
	public Response<T> getResponse(T t){
		ResponseBody<T> responseBody = new ResponseBody<T>(ResponseBody.SUCCESS,"成功",t);
		Header header = new Header("CULTURE_AND_DATA_CENTER", UUIDUtils.getGUID(), "0");
		response = new Response<T>(header, responseBody);
		return response;
	}

	/**
	 * 响应失败
	 * @param errorMessage 返回错误信息
	 * @return
	 */
	public Response<T> responsefailed(String errorMessage){
		Header header = new Header("CULTURE_AND_DATA_CENTER", UUIDUtils.getGUID(), "0");
		ResponseBody<T> responseBody = new ResponseBody<T>(ResponseBody.FAILED,errorMessage,null);
		response = new Response<T>(header, responseBody);
		return response;
	}
	
}
