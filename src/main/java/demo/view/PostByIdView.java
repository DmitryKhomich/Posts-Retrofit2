package demo.view;

import java.util.Scanner;

public class PostByIdView {

    Scanner scanner = new Scanner(System.in);

    public String getIdPost(){
        System.out.print("Enter post id: ");
        return scanner.nextLine();
    }

    public void getOutput(String out){
        System.out.println(out);
    }
}
