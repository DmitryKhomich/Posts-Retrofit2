package demo.view;

import java.util.Scanner;

public class AppView {

    Scanner scanner = new Scanner(System.in);

    public String getOptions(){
        getMenu();
        return scanner.nextLine();
    }
    private static void getMenu() {
        System.out.println(""" 
                                                   
                >>>>> MENU <<<<<<
                1 - Get all posts.
                2 - Get post by id.
                0 - Close the app.
                """);
    }

    public void getOutput(String output, String choice) {
        if (choice.equals("0")) System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}
