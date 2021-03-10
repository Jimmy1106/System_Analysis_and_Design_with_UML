package Boundary;

public class ProductInfoPage {
    private String productNumber;
    private String productName;
    private double price;
    private String description;


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

    public void displayProductInfo(){
        
        System.out.println();

        System.out.println(productName);
        
        drawDivider();

        System.out.println( "Product number: " + productNumber );
        System.out.println( "Price: " + price );
        System.out.println( "Description: ");
        System.out.println( "\t" + description );
            
    }

    private void drawDivider(){
        for (int i=0; i<80; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
