package demo.utils;
import demo.controller.AppController;
import demo.model.AppModel;
import demo.view.AppView;

public class AppStarter {

    public static void runThisApp()  {
        AppView appView = new AppView();
        AppModel appModel = new AppModel();
        AppController appController = new AppController(appModel,appView);
        appController.runApp();
    }
}
