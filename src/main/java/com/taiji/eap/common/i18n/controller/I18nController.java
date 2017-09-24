package com.taiji.eap.common.i18n.controller;

import com.taiji.eap.common.base.BaseController;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class I18nController extends BaseController{

	@RequestMapping(value="/setLanguage",method=RequestMethod.GET)
	public String setLanguage(HttpServletRequest request,
			HttpServletResponse response,
			String lang) {
		if("zh_CN".equals(lang)){  
			Locale locale = new Locale("zh", "CN"); 
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale); 
		}else if("en_US".equals(lang))  {
			Locale locale = new Locale("en", "US"); 
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale); 
		}else 
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
		return "system/home/home";
	}

}
