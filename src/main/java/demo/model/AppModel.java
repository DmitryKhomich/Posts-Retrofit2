package demo.model;
import demo.controller.PostByIdController;
import demo.controller.PostsController;
import demo.view.PostByIdView;
import demo.view.PostsView;


public class AppModel {
    public void readPosts()  {
        PostModel postModel = new PostModel();
        PostsView postsView = new PostsView();
        PostsController postsController = new PostsController(postModel,postsView);
        postsController.getPosts();
    }

    public void readPostById()  {
        PostModel postModel = new PostModel();
        PostByIdView postByIdView = new PostByIdView();
        PostByIdController postByIdController = new PostByIdController(postModel,postByIdView);
        postByIdController.getPostById();
    }
}
