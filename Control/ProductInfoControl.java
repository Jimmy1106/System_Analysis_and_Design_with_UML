package Control;

import java.util.Vector;

import Boundary.ProductCatalogPage;
import Entity.Product;

public class ProductInfoControl {
    private Vector<Object> catalog_content;
    private Vector<Object> product_content;

    public void getProductCatalog(String catalog_sNum){

        Product product = new Product();
        ProductCatalogPage pc_page = new ProductCatalogPage();

        catalog_content = product.getCatalog(catalog_sNum);
        pc_page.displayProductList(catalog_content);

    }
    public void getProductInfo(String product_sNum){}

}
