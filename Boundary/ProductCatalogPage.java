package Boundary;

import java.util.Scanner;
import java.util.Vector;

import Control.ProductInfoControl;

public class ProductCatalogPage {
    public void start(){
        System.out.println("Product Catalog");
        drawDivider();
        displayCatalogList();
    }

    public void selectCatalog(String catalog_sNum){

        ProductInfoControl pi_control = new ProductInfoControl();
        pi_control.getProductCatalog(catalog_sNum);    
    }

    public void selectProduct(){
        //////// 選取商品
    }

    private void displayCatalogList(){
        // Display UI to let user select product catalog.
        // List --> 001)Sport 002)Music 00s3)Software
        
        Scanner input = new Scanner(System.in);
        String sNum;

        System.out.println("001) Sprot");
        System.out.println("002) Music");
        System.out.println("002) Software");
        System.out.println();

        System.out.println("Select a product catalog by typing the serial number.");
        System.out.print("Your choice: ");
        sNum = input.nextLine();
            
        System.out.println();

        selectCatalog(sNum);
    }

    public void displayProductList(Vector<Object> productList){
        if (productList!=null){
            System.out.println("\nProducts of "+ productList.elementAt(0) +": ");
            drawDivider();
            for (int i=1; i<productList.size(); i++){
                System.out.println( i+ ": " + ((String)productList.elementAt(i)) );
            }
        }        
    }

    private void drawDivider(){
        for (int i=0; i<80; i++){
            System.out.print("-");
        }
        System.out.println();
    }

}
