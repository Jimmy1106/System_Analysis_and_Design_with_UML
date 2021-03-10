package Control;

import java.util.Vector;

import Boundary.ProductCatalogPage;
import Boundary.ProductInfoPage;
import Entity.Product;

public class ProductInfoControl {
    private Vector<Object> productCatalog = null;
    private Vector<Object> productInfo = null;

    public void getProductCatalog(String catalogNumber){

        Product product = new Product();
        ProductCatalogPage pc_page = new ProductCatalogPage();

        productCatalog = product.getCatalog(catalogNumber);
        pc_page.displayProductList(productCatalog); /////////////

    }
    public void getProductInfoFromModel(String productNumber){

        Product product = new Product();
        // productInfo = product.getProductInfoAndReturn(productNumber);
        product.getProductInfoFromDatabase(productNumber);

        // productInfo.addElement(product.getProductNumber());
        // productInfo.addElement(product.getName());
        // productInfo.addElement(product.getPrice());
        // productInfo.addElement(product.getDescription());
        // productInfo.addElement(product.getCatalogNumber());

        ProductInfoPage pi_page = new ProductInfoPage(
            product.getProductNumber(),
            product.getName(),
            product.getPrice(),
            product.getDescription()
        );

        pi_page.displayProductInfo();     
    }

    public Vector<Object> getProductInfo() {
        return productInfo;
    }

}
