package Entity;


import Database.Database;
import java.util.Vector;


public class Product {
    private String productNumber;
    private String name;
    private double price;
    private String description;

    private String catalogNumber;

    // public void getCatalogFromDatabase(String catalogNumber){}

    public void getProductInfoFromDatabase(String productNumber){

        String [] tmp_ProductInfo;

        Database database = new Database();
        tmp_ProductInfo = database.getProductInfoString(productNumber).split(",");

        // Set value
        this.productNumber = tmp_ProductInfo[0];
        this.name = tmp_ProductInfo[1];
        // this.price = Double.valueOf(tmp_ProductInfo[2]);
        this.price = Double.parseDouble(tmp_ProductInfo[2]);
        this.description = tmp_ProductInfo[3];
        this.catalogNumber = tmp_ProductInfo[4];
    }

    public Vector<Object> getCatalog(String catalogNumber){
        
        String [] tmp_catalogContent;

        Database database  = new Database();
        // tmp_catalogContent = database.getCatalog(catalogNumber).split(",");
        tmp_catalogContent = database.getCatalogInfoString(catalogNumber).split(",");

        // Transform datatype.
        Vector<Object> catalogContent = new Vector<>();
        for (Object e: tmp_catalogContent){
            catalogContent.addElement(e);
        }
        return catalogContent;
    }

    public Vector<Object> getProductInfoAndReturn(String productNumber){

        String [] tmp_ProductInfo;

        Database database = new Database();
        tmp_ProductInfo = database.getProductInfoString(productNumber).split(",");

        // Set value
        productNumber = tmp_ProductInfo[0];
        name = tmp_ProductInfo[1];
        // price = Double.valueOf(tmp_ProductInfo[2]);
        price = Double.parseDouble(tmp_ProductInfo[2]);
        description = tmp_ProductInfo[3];
        catalogNumber = tmp_ProductInfo[4];


        // Transform datatype.
        Vector<Object> productInfo = new Vector<>();
        for (Object e: tmp_ProductInfo){
            productInfo.addElement(e);
        }
        return productInfo;
    }

    public String getProductNumber() {
        return productNumber;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getCatalogNumber() {
        return catalogNumber;
    }
}
