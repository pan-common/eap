package com.taiji.eap.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTree implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final String CONNECT = "01";

    public static final String DATASOURCE = "02";

    public static final String TABLE = "03";

    public static final String FILE = "04";

    public static final String DICTIONARY = "05";

    public static final String MENU = "06";

    public static final String OTHER = "255";

    protected String name;

    protected String text;

    protected boolean spread;

    protected String type;

    protected List<BaseTree> children;

    protected String iconCls = "icon-add";

    public BaseTree(String name, boolean spread, String type) {
        this.name = name;
        this.spread = spread;
        this.type = type;
    }

    public BaseTree() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<BaseTree> getChildren() {
        if(children==null){
            children = new ArrayList<BaseTree>();
        }
        return children;
    }

    public void setChildren(List<BaseTree> children) {
        this.children = children;
    }

    public void addChildren(BaseTree baseTree){
        if(children==null){
            children = new ArrayList<BaseTree>();
        }
        children.add(baseTree);
    }

    public void addChildrens(List<BaseTree> baseTrees){
        if(children==null){
            children = new ArrayList<BaseTree>();
        }
        children.addAll(baseTrees);
    }

    @Override
    public String toString() {
        return "LayuiTree{" +
                "name='" + name + '\'' +
                ", spread=" + spread +
                ", type='" + type + '\'' +
                ", children=" + children +
                '}';
    }
}
