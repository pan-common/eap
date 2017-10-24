package com.taiji.eap.common.http.entity;

import java.util.List;

public class EasyuiFilter {
    private List<FilterRule> filterRules;

    public EasyuiFilter(List<FilterRule> filterRules) {
        this.filterRules = filterRules;
    }

    public EasyuiFilter() {
    }

    public List<FilterRule> getFilterRules() {
        return filterRules;
    }

    public void setFilterRules(List<FilterRule> filterRules) {
        this.filterRules = filterRules;
    }

    @Override
    public String toString() {
        return "EasyuiFilter{" +
                "filterRules=" + filterRules +
                '}';
    }
}
