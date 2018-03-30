package com.taiji.eap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * @author 潘宏智
 * @date
 */
@Controller
@RequestMapping("portal")
public class PortalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortalController.class);

    @GetMapping(value = "index")
    public String index(Locale locale, Model model){
        return "portal/index";
    }

}
