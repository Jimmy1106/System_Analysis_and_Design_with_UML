package Boundary;

import java.util.Scanner;
import java.util.Vector;

import Control.ProductInfoControl;

public class ProductCatalogPage extends Page{

    public void start(){
        System.out.println("\nProduct Catalog");
        drawDivider("-");
        displayCatalogList();
    }

    public void selectCatalog(String catalogNumber){

        ProductInfoControl pi_control = new ProductInfoControl();
        pi_control.getProductCatalog(catalogNumber);    
    }

    public void selectProduct(String productNumber){
        ProductInfoControl pc_control = new ProductInfoControl();
        pc_control.getProductInfoFromModel(productNumber);
    }

    private void displayCatalogList(){
        // Display UI to let user select product catalog.
        // List --> 001)Sport 002)Music 00s3)Software
        
        Scanner input = new Scanner(System.in);
        String catalogNumber;

        System.out.println("001) Sprot");
        System.out.println("002) Music");
        System.out.println("003) Software");
        System.out.println();

        System.out.println("Select a product catalog by typing the serial number.");
        System.out.print("Your choice: ");
        catalogNumber = input.nextLine();
            
        System.out.println();

        selectCatalog(catalogNumber);
    }

    public void displayProductList(Vector<Object> productCatalog){

        String catalogNumber = (String)productCatalog.elementAt(0);
        
        if (productCatalog!=null){
            System.out.println("\nProducts of "+ productCatalog.elementAt(1) +": "); ////////////
            drawDivider("-");
            // for (int i=2; i<productCatalog.size(); i++){
            //     System.out.println( (i-1) + ": " + ((String)productCatalog.elementAt(i)) );
            // }

            // int i=1,num=0;
            // while(i<productCatalog.size()-1){
            //     num = i;
            //     i++;
            //     System.out.println( num + ": " + ((String)productCatalog.elementAt(i)) );
            // }

            for ( int i=2,num=1; i<productCatalog.size(); i++ ){
                System.out.println( num + ": " + ((String)productCatalog.elementAt(i)) );
                num=i;
            }
        }
        
        Scanner input = new Scanner(System.in);
        String productNumber;

        System.out.println("\nSelect a product to see the detail.");
        System.out.print("Your choice: ");
        
        // productNumber = catalogNumber + String.format("%02d", Integer.valueOf(input.nextLine()));
        productNumber = catalogNumber + addLeadingZero(input.nextLine());
            
        System.out.println();

        selectProduct(productNumber);
    }

    private String addLeadingZero(String inputString){
        return ("00"+ inputString).substring(inputString.length());
    }
}
