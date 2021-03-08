package Control;

import java.util.Vector;

import Boundary.ProductCatalogPage;
import Entity.Product;

public class ProductInfoControl {
    private Vector<String> catalog_content;
    private Vector<String> product_content;

    public void getProductCatalog(String catalog_sNum){
        Product product = new Product();
        catalog_content = product.getCatalog(catalog_sNum);

        ProductCatalogPage pc_page = new ProductCatalogPage();
        pc_page.displayProductList(catalog_content);

    }
    public void getProductInfo(String product_sNum){}

}
