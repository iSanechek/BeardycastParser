package com.isanechek.beardycastjsonparser.models;

import java.util.List;

/**
 * Created by isanechek on 23.10.16.
 */
public class PostModel {

    /**
     * title - Название страницы.
     */
    public String title;
    /**
     * url - url страницы без http(https) и www.
     */
    public String url;
    /**
     * xid - Идентификатор страницы к которому привязаны комментарии
     * (если параметр пустой, то все комментарии привязаны к url).
     */
    private String xid;
    /**
     * stream_id - id страницы в системе HC (если не указан генерируется автоматически).
     * Строка 24 символа.
     */
    private String stream_id;

    public List<CommentModel> list;

    public PostModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getStream_id() {
        return stream_id;
    }

    public void setStream_id(String stream_id) {
        this.stream_id = stream_id;
    }

    public List<CommentModel> getList() {
        return list;
    }

    public void setList(List<CommentModel> list) {
        this.list = list;
    }
}
