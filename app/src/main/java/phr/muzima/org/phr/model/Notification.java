package phr.muzima.org.phr.model;

/**
 * Created by HP on 1/9/2018.
 */

public class Notification {

    private String title;
    private String notificationBody;

    public Notification(String title, String notificationBody) {
        this.title = title;
        this.notificationBody = notificationBody;
    }

    public String getNotificationBody() {
        return notificationBody;
    }

    public void setNotificationBody(String notificationBody) {
        this.notificationBody = notificationBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
