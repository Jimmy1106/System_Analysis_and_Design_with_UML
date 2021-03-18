package Boundary;

public class MainPage extends Page{
    public void start(){
        System.out.println("\nWelcome to main page.");
        drawDivider("*");
        System.out.println();
    }

    public void loginSuccess(){
        System.out.println("\nLogin successfully!");
    }
}
