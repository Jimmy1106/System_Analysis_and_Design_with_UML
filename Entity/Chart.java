package Entity;

import java.util.Vector;

import Database.Database;


public class Chart {

    private Vector<ChartItem> chartItems = new Vector<>();

    public Chart(){
        initChart();
    }

    public void initChart(){

        Database database = new Database();
        String chartItemsString = database.getChartItemsString();

        if (chartItemsString.isEmpty()) return;

        String [] parsedCharItems = chartItemsString.split("\n");
        
        for (String item: parsedCharItems){
            String [] chartItem = item.split(",");
            String productNumber = chartItem[0];
            int productQuantity = Integer.parseInt(chartItem[1]);
            chartItems.addElement(new ChartItem(productNumber, productQuantity));
        }
        
    }

    public void addToChart(String productNumber, int productQuantity){
        ChartItem chartItem = new ChartItem();
        chartItem.setProductNumber(productNumber);
        chartItem.setProductQuantity(productQuantity);

        chartItems.addElement(chartItem);

        updateDB();
    }

    public void clear(){
        clearDB();
    }

    private void updateDB(){
        Database database = new Database('w');
        database.clearChartItems();;
        database.updateChartItems(chartItems);
        
    }

    private void clearDB(){
        Database database = new Database('w');
        database.clearChartItems();
    }

    // public void getChartItems(){}
    public Vector<ChartItem> getChartItems() {
        return chartItems;
    }
    
    public double calculatePriceOfChart(){

        double totalAmount = 0.0;

        for (int i=0; i<chartItems.size(); i++){
            ChartItem chartItem = chartItems.elementAt(i);
            totalAmount += chartItem.calculateSubtotal();
        }

        return totalAmount; 
    }

    public boolean isEmpty(){
        return chartItems.isEmpty();
    }
}