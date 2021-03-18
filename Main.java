import Boundary.LoginPage;
import Boundary.ProductCatalogPage;

public class Main {
    public static void main(String[] args) {
        // This is a driver function to run Use-cases of the System.


        System.out.println();

        // Login
        // User ID: uid, Password: pwd 
        LoginPage loginPage = new LoginPage();
        loginPage.start();
        loginPage.login();

        // Product-ordering
        ProductCatalogPage productCatalogPage = new ProductCatalogPage();
        productCatalogPage.start();
        productCatalogPage.displayCatalogList();
        productCatalogPage.selectCatalog();
        
    }
}
