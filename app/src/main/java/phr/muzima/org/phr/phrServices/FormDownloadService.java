package phr.muzima.org.phr.phrServices;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;

import java.net.URL;
import java.net.URLConnection;

/**
 * Created by HP on 1/10/2018.
 */

public class FormDownloadService extends IntentService {

    private static final int UPDATE_PROGRESS = 8344;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param downloadServiceName Used to name the worker thread, important only for debugging.
     */
    public FormDownloadService(String downloadServiceName) {
        super("FormDownloadService");
    }

    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               Context#startService(Intent)}.
     *               This may be null if the service is being restarted after
     *               its process has gone away; see
     *               {@link Service#onStartCommand}
     *               for details.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String urlToDownload = intent.getStringExtra("url");
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("reciever");
        try {
            URL url = new URL(urlToDownload);
            URLConnection connection = url.openConnection();
            connection.connect();

        } catch (Exception ex) {
        }
    }
}
