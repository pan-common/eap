package com.taiji.eap.common.generator.bean;

import com.taiji.eap.common.base.BaseTree;

public class FileTreeView extends BaseTree {

    private String packageName;

    private String fileName;

    public FileTreeView(String packageName, String fileName) {
        this.packageName = packageName;
        this.fileName = fileName;
    }

    public FileTreeView() {
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileTreeView{" +
                "packageName='" + packageName + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
