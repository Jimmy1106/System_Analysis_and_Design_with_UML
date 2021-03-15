package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import Entity.ChartItem;
import Entity.Product;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Database {

    private String dbPath = "D:/2021/JAVA/OOP/Ordering_System/Database/";
    private String members_path = dbPath + "members.txt";
    private String catalogs_path = dbPath + "catalogs.txt";
    private String products_path = dbPath + "products.txt";
    private String chartItems_path = dbPath + "chartItems.txt";

    private File members, catalogs, products, chartItems;
    private Scanner db_members_reader, db_catalogs_reader, db_products_reader, db_chartItems_reader;

    public Database(){
        initReader();
    }

    public Database(char act){
        if (act == 'w'){}
        else initReader();
    }

    private void initReader(){
        try {
            members = new File(members_path);
            db_members_reader = new Scanner(members);

            catalogs = new File(catalogs_path);
            db_catalogs_reader = new Scanner(catalogs);

            products = new File(products_path);
            db_products_reader = new Scanner(products);

            chartItems = new File(chartItems_path);
            db_chartItems_reader = new Scanner(chartItems);

        } catch (FileNotFoundException e) {
            System.out.println("\nAn error occurred when constructing Database object.");
            e.printStackTrace();
        }
    }

    public String getMemberPwd(String uid){ ///////////////
        String s_memberInfo;
        String [] memberInfo;

        while(db_members_reader.hasNextLine()){
            s_memberInfo = db_members_reader.nextLine();

            // Parse member info by ','.
            // <uid>,<pwd>,<name>
            memberInfo = s_memberInfo.split(",");
            if (uid.equals(memberInfo[0])){
                return memberInfo[1];
            }

        }

        return null;
    }

    public String getCatalog(String catalogNumber){
        String s_catalogInfo;
        String [] catalogInfo;
        String catalogContent = "";

        while(db_catalogs_reader.hasNextLine()){
            s_catalogInfo = db_catalogs_reader.nextLine();

            // Parse member info by ','.
            // <catalogNumber>,<catalog name>,<product><product>...
            catalogInfo = s_catalogInfo.split(",");   /////////////////////
            if (catalogNumber.equals(catalogInfo[0])){
                catalogContent += catalogInfo[1];
                for (int i=2; i<catalogInfo.length; i++){
                    catalogContent += (","+catalogInfo[i]);
                }
                break;
            }
        }
        return catalogContent;
    }

    public String getCatalogInfoString(String catalogNumber){
        String catalogInfoString = "";
        String [] catalogInfo;

        while(db_catalogs_reader.hasNextLine()){
            catalogInfoString = db_catalogs_reader.nextLine();

            // Parse member info by ','.
            // <catalogNumber>,<catalog name>,<product><product>...
            catalogInfo= catalogInfoString.split(",");
            if (catalogNumber.equals(catalogInfo[0])){    
                break;
            }
        }
        return catalogInfoString;
    }

    public String getProductInfoString(String productNumber){
        String productInfoString = "";
        String [] productInfo;

        while(db_products_reader.hasNextLine()){
            productInfoString = db_products_reader.nextLine();

            // Parse member info by ','.
            // <Product number>,<Product name>,<Price><Description><Catalog number>
            productInfo = productInfoString.split(",");
            if (productNumber.equals(productInfo[0])){    
                break;
            }
        }
        return productInfoString;
    }

    public String getChartItemsString(){
        String chartItemsString = "";

        String columnNames = db_chartItems_reader.nextLine();

        while(db_chartItems_reader.hasNextLine()){
            chartItemsString += (db_chartItems_reader.nextLine() + "\n");
        }
        return chartItemsString;
    }

    public void updateChartItems(Vector<ChartItem> chartItems){    
        try(
            FileWriter fw = new FileWriter(chartItems_path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)
        )
        {
            for (ChartItem item: chartItems){
                String line = item.getProductNumber() + "," + item.getProductQuantity();
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearChartItems(){
        try(
            FileWriter fw = new FileWriter(chartItems_path, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)
        )
        {
            out.println("Product number,Quantity");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
