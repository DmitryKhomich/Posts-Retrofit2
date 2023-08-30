package demo.model;
import demo.entity.Post;
import demo.network.ApiClient;
import demo.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;
import java.util.List;
import java.util.Optional;

public class PostModel {

    public Optional<Response<List<Post>>> fetchPosts(){
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<List<Post>> call = service.getPosts();
        Optional<Response<List<Post>>> optional;

        try{
            optional = Optional.of(call.execute());
        }catch (Exception exception){
            optional = Optional.empty();
        }
        return optional;
    }

    public Optional<Response<Post>> fetchPostById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<Post> call = service.getPost(id);
        Optional<Response<Post>> optional;

        try{
            optional = Optional.of(call.execute());
        }catch (Exception exception){
            optional = Optional.empty();
        }
        return optional;
    }
}
