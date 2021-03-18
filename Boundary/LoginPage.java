package Boundary;

import java.util.Scanner;
import Control.UserAuthenticationControl;

public class LoginPage extends Page{
    private String userId;
    private String password;

    public void start(){
        System.out.println("\nLogin Page");
        drawDivider("*");
    }

    public void displayLoginForm(){
        Scanner input = new Scanner(System.in);

        System.out.println("\nPlz input your user ID and password.");

        System.out.print("User ID: ");
        userId = input.nextLine();

        System.out.print("password: ");
        password = input.nextLine();
        
        System.out.println();
    }

    public void login(){

        UserAuthenticationControl userAuthenticationControl = new UserAuthenticationControl(
            userId, password
        );

        if(!(userAuthenticationControl.authenticate())){
            loginFail();
        }

        // userAuthenticationControl.authenticate();

        // if( userAuthenticationControl.authenticate() ){
        //     System.out.println("Login successfully!");
        // }
        // else{
        //     System.out.println("Login fail... Plz try another account or password.");
        // }

    }

    public void loginFail(){
        System.out.println("\nLogin fail... Plz try another account or password.");
    }


}
