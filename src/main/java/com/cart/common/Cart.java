package main.java.com.cart.common;

/**
 * Created by hshs on 2016. 1. 2..
 */
public class Cart {

    public enum Type {
        FOLDER("folder"),
        BOOKMARK("bookmark");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Type getType(String paramType){
            for(Type type : Type.values()){
                if(paramType.equalsIgnoreCase(type.getValue())) {
                    return type;
                }
            }
            return null;
        }

    }

    public enum Action {
        ADD("add"),
        EDIT("edit"),
        REMOVE("remove");

        private String value;

        private Action(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Action getType(String paramAction){
            for(Action action : Action.values()){
                if(paramAction.equalsIgnoreCase(action.getValue())) {
                    return action;
                }
            }
            return null;
        }

    }

    private String type;
    private String id;
    private String action;
    private String folderId;
    private String name;
    private String url;
    private String regDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
