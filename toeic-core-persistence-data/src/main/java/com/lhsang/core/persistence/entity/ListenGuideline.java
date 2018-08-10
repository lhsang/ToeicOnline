package com.lhsang.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "listenguideline")
public class ListenGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuideline;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "createdate")
    private Timestamp createDate;

    @Column(name = "modifieddate")
    private Timestamp modefiedDate;



    @OneToMany(mappedBy = "listenGuideline",fetch = FetchType.LAZY)
    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getListenGuideline() {
        return listenGuideline;
    }

    public void setListenGuideline(Integer listenGuideline) {
        this.listenGuideline = listenGuideline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModefiedDate() {
        return modefiedDate;
    }

    public void setModefiedDate(Timestamp modefiedDate) {
        this.modefiedDate = modefiedDate;
    }
}
