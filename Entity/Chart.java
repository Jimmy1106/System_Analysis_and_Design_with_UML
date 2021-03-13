package Entity;

import java.util.Vector;


public class Chart {

    private Vector<ChartItem> chartItems;

    public Chart(){
        chartItems = new Vector<>();
    }

    public void addToChart(String productNumber, int productQuantity){
        ChartItem chartItem = new ChartItem();
        chartItem.setProductNumber(productNumber);
        chartItem.setProductQuantity(productQuantity);

        chartItems.addElement(chartItem);
    }

    // public void getChartItems(){}
    public Vector<ChartItem> getChartItems() {
        return chartItems;
    }
    
    public double calculatePriceOfChart(){ return 0.0; }
}