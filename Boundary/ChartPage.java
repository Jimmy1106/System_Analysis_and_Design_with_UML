package Boundary;

import java.util.Scanner;
import java.util.Vector;

import Control.ChartControl;
import Entity.Chart;
import Entity.ChartItem;
import Entity.Product;

public class ChartPage extends Page{
    private String productNumber;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private double subtotal;
    private double totalPrice;
    private Vector<Object> chartContent;
    boolean chartEmpty = true;

    public ChartPage( Vector<Object> chartContent ){
        this.chartContent = chartContent;
    }

    // public ChartPage(
    //     String productNumber, 
    //     String productName,
    //     double productPrice, 
    //     int productQuantity,
    //     double subtotal,
    //     double totalPrice
    // )
    // {
    //     this.productNumber = productNumber;
    //     this.productName = productName;
    //     this.productPrice = productPrice;
    //     this.productQuantity = productQuantity;
    //     this.subtotal = subtotal;
    //     this.totalPrice = totalPrice;
    // }
    

    public void start(){
        System.out.println();
        System.out.println("【This is your chart】");
        drawDivider("*");
    }

    // private void assignChartInfo(){
    //     chartContent
    // }

    public void displayChart(){

        System.out.println();

        System.out.print(productName);
        System.out.println("(" + productNumber + ")");
        drawDivider("-");
        System.out.println("Price: " + productPrice);
        System.out.println("Quantity: " + productQuantity);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total price: " + totalPrice);
    }

    public void displayChartGoods(){

        Vector<ChartItem> chartItems = ((Chart)chartContent.elementAt(0)).getChartItems();
        Vector<Product> products = (Vector<Product>)chartContent.elementAt(1);

        chartEmpty = chartItems.isEmpty();

        totalPrice = (double)chartContent.elementAt(2);

        for (int i=0; i<chartItems.size(); i++){

            Product product = products.elementAt(i);
            ChartItem chartItem = chartItems.elementAt(i);

            productName = product.getName();
            productNumber = product.getProductNumber();
            productPrice = product.getPrice();
            productQuantity = chartItem.getProductQuantity();
            subtotal = chartItem.getSubtotal();

            System.out.println();

            System.out.print( "# "+ productName);
            System.out.println("(" + productNumber + ")");
            drawDivider("-");
            System.out.println("Price: " + productPrice );
            System.out.println("Quantity: " + productQuantity );
            System.out.println("Subtotal: " + subtotal );
        }

        System.out.println("\nTotal price: " + totalPrice);

        // displayOptionMenu();
    }

    public void displayChartInfo(){

        Vector<ChartItem> chartItems = (Vector<ChartItem>)chartContent.elementAt(0);

        totalPrice = 0;

        for (int i=1, j=0; i<chartContent.size(); i++){
            Product product = (Product)chartContent.elementAt(i);
            ChartItem chartItem = chartItems.elementAt(j);

            productName = product.getName();
            productNumber = product.getProductNumber();
            productPrice = product.getPrice();
            productQuantity = chartItem.getProductQuantity();
            subtotal = chartItem.getSubtotal();
            totalPrice += subtotal;

            System.out.println();

            System.out.print(productName);
            System.out.println("(" + productNumber + ")");
            drawDivider("-");
            System.out.println("Price: " + productPrice );
            System.out.println("Quantity: " + productQuantity );
            System.out.println("Subtotal: " + subtotal );
            
        }
        System.out.println("\nTotal price: " + totalPrice);
    }

    public void displayOptionMenu(){
        System.out.println("\n[Option menu]\n");

        System.out.println("1. Order other products.");
        System.out.println("2. Clear Chart.");
        System.out.println("3. Checkout.");

        System.out.print("\nYour choice: ");

        Scanner input = new Scanner(System.in);
        int selectedItem = Integer.parseInt(input.nextLine());

        switch (selectedItem) {

            case 1:
                // Back to catalog selecting process.
                ProductCatalogPage productCatalogPage = new ProductCatalogPage();
                productCatalogPage.start();
                break;

            case 2:
                // Clear all products of in chart.
                ChartControl chartControl = new ChartControl();
                chartControl.clearChart();
                System.out.println("\nChart has been empty now.");
                break;
                
            case 3:
                // Continue to checkout process.
                if (!chartEmpty)
                    System.out.println("\nKeep writing your code haha ~");
                else
                    System.out.println("\nYour chart is empty!!!");
                break;

            default:
                // Print Only 1, 2, and 3 you can select.
                System.out.println("\nKeep writing your code haha ~");
                break;    
        }
    }
}
