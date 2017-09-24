package com.taiji.eap.common.base.propertyeditors;

import org.springframework.beans.propertyeditors.PropertiesEditor;

class IntegerEditor extends PropertiesEditor{

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.equals("")) {
            text = "0";
        }
        setValue(Integer.parseInt(text));
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
