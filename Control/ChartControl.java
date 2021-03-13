package Control;

import java.util.Vector;

import Boundary.ChartPage;
import Entity.Chart;
import Entity.ChartItem;
import Entity.Product;

public class ChartControl {
    private Vector<Object> chartContent;

    public ChartControl(){
        chartContent = new Vector<>();
    }

    public void getChartContent(){}

    public void orderProduct(String productNumber, int productQuantity){
        
        Chart chart = new Chart();
        chart.addToChart(productNumber, productQuantity);

        Vector<ChartItem> chartItems = chart.getChartItems();
        chartContent.addElement(chartItems); 

        // // Get product number from chartItems.
        // productNumber = chartItems.lastElement().getProductNumber();
        // productQuantity = chartItems.lastElement().getProductQuantity();
        // double subtotal = chartItems.lastElement().getSubtotal(); ////////////////////
        // double totalPrice = 0.0;       ////////////////////


        // 再多一個ItemOfChartContent
        // 或是把所有products包裝成一個collections再丟進chartContent感覺會更好
        Vector<Product> products = new Vector<>();

        for (ChartItem item:chartItems){
            Product product = new Product();
            product.getProductInfoFromDatabase(item.getProductNumber());
            products.addElement(product);
        }
        chartContent.addElement(products);

        // ChartPage chartPage = new ChartPage(
        //     (String)productNumber,
        //     (String)product.getName(),
        //     (double)product.getPrice(), 
        //     (int)productQuantity,
        //     (double)subtotal,
        //     (double)totalPrice
        // );
        ChartPage chartPage = new ChartPage(chartContent);
        chartPage.start();
        // chartPage.displayChart();
        // chartPage.displayChartInfo();
        chartPage.displayChartGoods();
    }

    public void modifyOrderQuantity(String productNumber, int productQuantity){
        // System.out.println("\nKeep writing your code haha ~");
    }
    public void removeOrderedProduct(String productNumber){}
    public boolean checkIfChartEmpty(){ return false; }
}
