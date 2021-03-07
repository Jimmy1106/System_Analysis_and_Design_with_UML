package Boundary;

import java.util.Scanner;
import Control.UserAuthenticationControl;

public class LoginPage {
    private String userId;
    private String password;

    public void start(){

        Scanner input = new Scanner(System.in);

        System.out.println("Plz input your user ID and password.");

        System.out.print("User ID: ");
        userId = input.nextLine();

        System.out.print("password: ");
        password = input.nextLine();
        
        System.out.println();

        login(userId, password);
    }

    public void login(String userId, String password){

        UserAuthenticationControl UA_control = new UserAuthenticationControl(
            userId, password
        );

        if(!(UA_control.authenticate())){
            loginFail();
        }

        // UA_control.authenticate();

        // if( UA_control.authenticate() ){
        //     System.out.println("Login successfully!");
        // }
        // else{
        //     System.out.println("Login fail... Plz try another account or password.");
        // }

    }

    public void loginFail(){
        System.out.println("Login fail... Plz try another account or password.");
    }


}
