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

    public void orderProduct(String productNumber, int productQuantity){
        
        Chart chart = new Chart();

        if (productQuantity>0){
            chart.addToChart(productNumber, productQuantity);
        }

        chartContent.addElement(chart);

        getChartContentFromDB();

    }

    public void clearChart(){
        Chart chart = new Chart();
        chart.clear();
    }

    public boolean checkIfChartEmpty(){
        // 當購物車不是空的, 客戶可以結帳商品
        Chart chart = (Chart)chartContent.elementAt(0);
        return chart.isEmpty();
    }

    private void getChartContentFromDB(){
        // 檢視購物車使用案例流程
        // 1.系統查詢購物車資料
        // 2.系統計算小計和總金額
        // 3.系統顯示購物車內容

        Chart chart = (Chart)chartContent.elementAt(0);

        // 再多一個ItemOfChartContent
        // 或是把所有products包裝成一個collection再丟進chartContent感覺會更好
        Vector<Product> products = new Vector<>();

        for (ChartItem item:chart.getChartItems()){
            Product product = new Product();
            product.getProductInfoFromDatabase(item.getProductNumber());
            products.addElement(product);
        }
        chartContent.addElement(products);
        chartContent.addElement(chart.calculatePriceOfChart());

        ChartPage chartPage = new ChartPage(chartContent);
        chartPage.start();
        // chartPage.displayChart();
        // chartPage.displayChartInfo();
        chartPage.displayChartGoods();
        chartPage.displayOptionMenu();

        // 替代流程: 繼續購物, 返回(1)商品目錄 (2)商品目錄清單
        // 繼續主流程: 結帳

    }

    public void modifyOrderQuantity(String productNumber, int productQuantity){
        // 修改訂購數量使用案例流程
        // 1.include::檢視購物車
        // 2.客戶修改某商品的數量
        // 3.系統更新購物車的商品數量
        // 4.系統重新計算購物車的小計和總金額
        // 5.系統顯示購物車內容
    }

    public void removeOrderedProduct(String productNumber){
        // 刪除訂購商品使用案例流程
        // 1.include::檢視購物車
        // 2.客戶點選欲刪除的商品, 按刪除鈕
        // 3.系統將選取項目從購物車中刪除
        // 4.系統重新計算購物車的小計和總金額
        // 5.系統顯示購物車內容
    }
}
