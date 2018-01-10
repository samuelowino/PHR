package phr.muzima.org.phr.phrServices;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import phr.muzima.org.phr.model.MuzimaForm;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HP on 1/10/2018.
 */

public interface FormDownloadService {
    @GET("module/muzimacore")
    Call<List<MuzimaForm>> loadForms(@Query("q") String status);

}
