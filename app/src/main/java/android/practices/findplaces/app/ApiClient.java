package android.practices.findplaces.app;

import android.practices.findplaces.constants.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Amit on 30-Nov-18.
 */
public class ApiClient {

    private static final String BASE_URL = AppConstants.GOOGLE_PLACES_URL;
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
