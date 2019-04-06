package cdibeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author steven
 */
@Named(value = "viewParaBean")
@SessionScoped
public class viewParaBean implements Serializable {
    private String pageID;
    private String author;
    /**
     * Creates a new instance of viewParaBean
     */
    public viewParaBean() {
    }

    public String getPageID() {
        return pageID;
    }

    public void setPageID(String pageID) {
        this.pageID = pageID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
}
