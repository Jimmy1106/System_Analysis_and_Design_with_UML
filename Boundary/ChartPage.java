package Boundary;

import java.util.Vector;
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

        Vector<ChartItem> chartItems = (Vector<ChartItem>)chartContent.elementAt(0);
        Vector<Product> products = (Vector<Product>)chartContent.elementAt(1);

        totalPrice = 0;

        for (int i=0; i<chartItems.size(); i++){

            Product product = products.elementAt(i);
            ChartItem chartItem = chartItems.elementAt(i);

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
}
