package phr.muzima.org.phr.model;

/**
 * Created by HP on 1/12/2018.
 */

public class LandingMenuItem {

    private String title;
    private int iconResourceId;

    public LandingMenuItem(String title, int iconResourceId) {
        this.title = title;
        this.iconResourceId = iconResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }
}
