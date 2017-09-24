package com.taiji.eap.common.base.propertyeditors;

import org.springframework.beans.propertyeditors.PropertiesEditor;

class LongEditor extends PropertiesEditor{

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.equals("")) {
            text = "0";
        }
        setValue(Long.parseLong(text));
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
