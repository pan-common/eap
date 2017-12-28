
package com.taiji.eap.common.document.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseTree;
public class Document extends BaseTree {
    private Long documentId;//主键
    private String documentTitle;//文档标题
    private Long parentId;//上级ID
    private String documentType;//文档类型
    private String documentMdContent;//文档MD内容
    private String documentHtnlContent;//文档html内容
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date updateTime;//修改时间
    private Long creater;//创建人
    private String valid;//是否有效
    public Document(Long documentId,String documentTitle) {
        this.documentId = documentId;
        this.documentTitle = documentTitle;
    }

    public Document() {

    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }


    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }


    public String getDocumentMdContent() {
        return documentMdContent;
    }

    public void setDocumentMdContent(String documentMdContent) {
        this.documentMdContent = documentMdContent;
    }


    public String getDocumentHtnlContent() {
        return documentHtnlContent;
    }

    public void setDocumentHtnlContent(String documentHtnlContent) {
        this.documentHtnlContent = documentHtnlContent;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }


    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }


}
