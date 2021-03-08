package Boundary;

public class MainPage {
    public void start(){
        System.out.println("\nWelcome to main page.");
        for (int i=0; i<80; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void loginSuccess(){
        System.out.println("\nLogin successfully!");
    }
}
