package demo.network;
import demo.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int id);

}
