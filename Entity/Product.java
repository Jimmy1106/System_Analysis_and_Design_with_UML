package Entity;


import Database.Database;
import java.util.Vector;

public class Product {
    private String serial_num;
    private String name;
    private double price;
    private String description;

    private String catalog_sNum;

    public Vector<Object> getCatalog(String catalog_sNum){
        Database database  = new Database();
        return database.getCatalog(catalog_sNum);
    }
    // public void getCatalog(String catalog_sNum){}
    public void getProductInfo(String serial_num){}

    public double getPrice() {
        return price;
    }
}
