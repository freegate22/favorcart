package main.java.com.cart.common;

/**
 * Created by hshs on 2016. 1. 2..
 */
public class Cart {

    enum Type {
        FOLDER("folder"),
        BOOKMARK("bookmark");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }


    private String type;
    private String action;
    private String folderId;
    private String destFolderId;
    private String name;
    private String url;
    private String bookmarkId;
    private long regDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getDestFolderId() {
        return destFolderId;
    }

    public void setDestFolderId(String destFolderId) {
        this.destFolderId = destFolderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(String bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public long getRegDate() {
        return regDate;
    }

    public void setRegDate(long regDate) {
        this.regDate = regDate;
    }
}
