package bean;

import java.io.Serializable;

public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String tagName;

    public Tag() {
    }

    public Tag(long id, String tagName) {
        super();
        this.id = id;
        this.tagName = tagName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return tagName;
    }

    public void setName(String tagName) {
        this.tagName = tagName;
    }
}
