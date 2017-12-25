package com.taiji.eap.common.shiro.filter;

import com.taiji.eap.common.shiro.service.SysPurviewService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ShiroPermissionFactory extends ShiroFilterFactoryBean implements ShiroChainDefinitionsService{

    @Autowired
    private SysPurviewService sysPurviewService;

    private String definitions;

    private PatternMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void setFilterChainDefinitions(String definitions) {
        this.definitions = definitions;
        intiPermission();
    }

    @Override
    public void intiPermission() {
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        Map<String, String> otherChains = initOtherPermission();
        section.putAll(otherChains);
        setFilterChainDefinitionMap(section);
    }

    @Override
    public synchronized void updatePermission() throws Exception {
        AbstractShiroFilter shiroFilter = (AbstractShiroFilter) getObject();
        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
                .getFilterChainResolver();
        DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
        // 清空权限管理资源 重新设置
        manager.getFilterChains().clear();
        getFilterChainDefinitionMap().clear();
        intiPermission();
        Map<String, String> chains = getFilterChainDefinitionMap();
        for (Map.Entry<String, String> entry : chains.entrySet()) {
            String url = entry.getKey();
            String chainDefinition = entry.getValue().trim().replace(" ", "");
            manager.createChain(url, chainDefinition);
        }
    }

    @Override
    public Map<String, String> initOtherPermission() {
        Map<String, String> otherChains = new HashMap<>();
        List<Map<String, Object>> maps = null;
        try {
            maps = sysPurviewService.globalConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Map<String, Object> map : maps) {
            if (map == null) {
                break;
            }
            String[] expressions = String.valueOf(map.get("EXPRESSION")).split(",");
            if (expressions == null) {
                break;
            }
            String urls = String.valueOf(map.get("URLS"));
            if (urls == null) {
                break;
            }
            for (String expression : expressions) {
                otherChains.put(expression, urls);
            }
        }
        maps = null;
        return dealWithExpression(otherChains);
    }

    @Override
    public Map<String, String> dealWithExpression(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key1 = entry.getKey();
            String value1 = entry.getValue();
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                String key2 = entry2.getKey();
                String value2 = entry2.getValue();
                if (!key1.equals(key2) && pathMatcher.matches(key1, key2)) {
                    map.put(key2, value1 + "," + value2);
                }
            }
        }
        Map<String, String> otherChains = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            otherChains.put(entry.getKey(), String.format(PORPERMS_STRING, entry.getValue()));
        }
        map = null;
        return otherChains;
    }
}
