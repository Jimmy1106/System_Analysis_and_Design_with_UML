package Boundary;

import java.util.Scanner;

import Control.ChartControl;

public class ProductInfoPage extends Page{
    private String productNumber;
    private String productName;
    private double price;
    private String description;
    private int productQuantity;
    private boolean confirm = false;


    public ProductInfoPage( 
        String productNumber, 
        String productName,
        double price, 
        String description
    )
    {
        this.productNumber = productNumber;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }
    public void start(){
        System.out.println("\nProduct Information");
        drawDivider("*");
    }

    public void displayProductInfo(){
        
        System.out.println();

        System.out.println(productName);
        
        drawDivider("-");

        System.out.println( "Product number: " + productNumber );
        System.out.println( "Price: " + price );
        System.out.println( "Description: ");
        System.out.println( "\t" + description );

        selectQuantityAndOrder();
            
    }

    public void selectQuantityAndOrder(){
        for ( int i=0; i<3 && !confirm; i++ ){
            selectQuantity();
            confirmOrder();
        }
    }

    public void selectQuantity(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nSelect order-quantity: ");
        try {
            productQuantity = Integer.valueOf(input.nextLine());
        } catch (Exception e) {
            productQuantity = 0;
        }
        
    }

    public void confirmOrder(){

        Scanner input = new Scanner(System.in);

        System.out.print("\nConfirm to order?(Y or N) ");
        String confirmMsg = input.nextLine();

        if(confirmMsg.equals("Y") || confirmMsg.equals("y")){
            confirm = true;
            ChartControl chartControl = new ChartControl();
            chartControl.orderProduct(productNumber, productQuantity);
        }
    }
}
