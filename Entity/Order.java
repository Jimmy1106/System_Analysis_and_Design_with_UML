package Entity;

import java.util.Date;
import java.util.Vector;

public class Order {
    
    private String orderNumber;
    private Vector Items;
    private char payment_method;
    private Date date;
    private char state;

    public void saveOrder(){}
    public double calculatePriceOfOrder(){ return 0.0; }
    public void getItems(){}

}