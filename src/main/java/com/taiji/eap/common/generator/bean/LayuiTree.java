package com.taiji.eap.common.generator.bean;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

public abstract class LayuiTree {

    public static final String CONNECT = "01";

    public static final String DATASOURCE = "02";

    public static final String TABLE = "03";

    public static final String FILE = "04";

    public static final String DICTIONARY = "05";

    public static final String MENU = "06";

    public static final String OTHER = "255";

    protected String name;

    protected boolean spread;

    protected String type;

    protected List<LayuiTree> children;

    public LayuiTree(String name, boolean spread, String type) {
        this.name = name;
        this.spread = spread;
        this.type = type;
    }

    public LayuiTree() {
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

    public List<LayuiTree> getChildren() {
        if(children==null){
            children = new ArrayList<LayuiTree>();
        }
        return children;
    }

    public void setChildren(List<LayuiTree> children) {
        this.children = children;
    }

    public void addChildren(LayuiTree layuiTree){
        if(children==null){
            children = new ArrayList<LayuiTree>();
        }
        children.add(layuiTree);
    }

    public void addChildrens(List<LayuiTree> layuiTrees){
        if(children==null){
            children = new ArrayList<LayuiTree>();
        }
        children.addAll(layuiTrees);
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
