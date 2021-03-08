import Boundary.LoginPage;
import Boundary.ProductCatalogPage;

public class Main {
    public static void main(String[] args) {
        // This is a driver function to run Use-cases of the System.


        System.out.println();

        // Login
        // User ID: uid, Password: pwd 
        LoginPage login = new LoginPage();
        login.start();

        // Product-ordering
        ProductCatalogPage pc_page = new ProductCatalogPage();
        pc_page.start();
        
        
    }
}
