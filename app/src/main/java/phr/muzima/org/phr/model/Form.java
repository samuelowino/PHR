package phr.muzima.org.phr.model;

/**
 * Created by HP on 1/9/2018.
 */

/**
 * Model class for openmrs and muzima forms that are downloaded from
 * openmrs to client mobile device.
 */
public class Form {

    private String title;

    public Form(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
