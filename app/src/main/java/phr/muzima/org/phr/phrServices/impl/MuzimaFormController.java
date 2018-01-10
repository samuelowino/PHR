package phr.muzima.org.phr.phrServices.impl;

import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import phr.muzima.org.phr.model.MuzimaForm;
import phr.muzima.org.phr.phrServices.FormDownloadService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 1/10/2018.
 */

public class MuzimaFormController implements Callback<List<MuzimaForm>> {

    private final String BASE_URL = "https://demo1.muzima.org/w2/rest/";

    public void startDownload(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FormDownloadService formDownloadService = retrofit.create(FormDownloadService.class);

        Call<List<MuzimaForm>> call = formDownloadService.loadForms("status:open");
        call.enqueue(this);
    }
    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<List<MuzimaForm>> call, Response<List<MuzimaForm>> response) {
        if(response.isSuccessful()){
            final List<MuzimaForm> downloadedMuzimaFormsList = response.body();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                downloadedMuzimaFormsList.forEach(muzimaForm -> {
                    System.out.println(muzimaForm.getFormDefinition().toString());
                });
            }else {
                for (MuzimaForm muzimaForm : downloadedMuzimaFormsList) {
                    System.out.println(muzimaForm.getFormDefinition().toString());
                }
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<List<MuzimaForm>> call, Throwable t) {
        t.printStackTrace();
    }
}
