package phr.muzima.org.phr.Tasks;

import android.app.DownloadManager;
import android.os.AsyncTask;

import java.net.URL;

/**
 * Created by HP on 1/10/2018.
 */

public class MuzimaFormsDownloadTask extends AsyncTask<URL,Integer,Long> {
    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param urls The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalFileSize = 0;
        for (int i = 0; i < count; i++) {
            totalFileSize += DownloadManager.Request.NETWORK_WIFI;
        }
        return null;
    }
}
