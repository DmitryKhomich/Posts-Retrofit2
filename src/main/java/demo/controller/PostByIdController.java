package demo.controller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import demo.entity.Post;
import demo.model.PostModel;
import demo.utils.AppStarter;
import demo.utils.Constants;
import demo.view.PostByIdView;
import retrofit2.Response;
import java.util.Optional;

public class PostByIdController {
    PostModel model;
    PostByIdView view;

    public PostByIdController(PostModel model, PostByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getPostById()  {
        view.getOutput(readPostById(Integer.parseInt(view.getIdPost())));
        AppStarter.runThisApp();
    }

    public String readPostById(int id)  {
        Optional<Response<Post>> optional = model.fetchPostById(id);
        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Gson gson = new Gson();
            Post user = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<Post>() {}.getType());
            return "Post: user id " + user.getUserId() + ", id " + user.getId() +
                    " ---> Title: " + user.getTitle() + ", Body: " + user.getBody();
        }
    }
}
