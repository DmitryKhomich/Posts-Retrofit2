package demo.network;
import demo.utils.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public ApiService getApiService(){
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build())
                .build();
        return retrofit.create(ApiService.class);
    }
}
