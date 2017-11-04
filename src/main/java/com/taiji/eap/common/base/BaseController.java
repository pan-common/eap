package com.taiji.eap.common.base;

import com.sun.beans.editors.IntegerEditor;
import com.sun.beans.editors.LongEditor;
import com.taiji.eap.common.base.propertyeditors.DoubleEditor;
import com.taiji.eap.common.base.propertyeditors.FloatEditor;
import com.taiji.eap.common.base.propertyeditors.StringArrayEditor;
import com.taiji.eap.common.base.propertyeditors.StringEscapeEditor;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.http.methods.HttpResponseHelper;
import com.taiji.eap.common.shiro.bean.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class BaseController extends BaseShiro{

	protected static Logger logger = LoggerFactory.getLogger(BaseController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));   
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(float.class, new FloatEditor());
		
		/**
		 * 防止XSS攻击
		 */
		binder.registerCustomEditor(String.class, new StringEscapeEditor());
	}

	/**
	 * 跳转页面方法
	 * @param url 跳转URL
	 * @param map 参数
	 * @return
	 */
	protected ModelAndView toView(String url,Map<String,String> map){
		ModelAndView view = new ModelAndView(url);
		view.addObject("param",map);
		return view;
	}
	

	/**
	 * 返回失败信息
	 * @param <T>
	 * @param errorMsg
	 * @return
	 */
	public <T> Response<T> renderError(String errorMsg){
		HttpResponseHelper<T> helper = new HttpResponseHelper<T>();
		return helper.responsefailed(errorMsg);
	}
	/**
	 * 返回成功信息
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> Response<T> renderSuccess(T t){
		HttpResponseHelper<T> helper = new HttpResponseHelper<T>();
		return helper.responseSuccess(t);
	}

}
