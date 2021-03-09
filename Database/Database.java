package Database;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;
import java.io.FileNotFoundException;

public class Database {

    private String dbPath = "D:/2021/JAVA/OOP/Ordering_System/Database/";
    private String members_path = dbPath + "members.txt";
    private String catalogs_path = dbPath + "catalogs.txt";

    private File members, catalogs;
    private Scanner db_members_reader, db_catalogs_reader;

    public Database(){
        try {
            members = new File(members_path);
            db_members_reader = new Scanner(members);

            catalogs = new File(catalogs_path);
            db_catalogs_reader = new Scanner(catalogs);

        } catch (FileNotFoundException e) {
            System.out.println("\nAn error occurred when constructing Database object.");
            e.printStackTrace();
        }
    }

    public String getMemberPwd(String uid){
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

    public Vector<Object> getCatalog(String catalog_sNum){
        String s_catalogInfo;
        String [] catalogInfo;

        while(db_catalogs_reader.hasNextLine()){
            s_catalogInfo = db_catalogs_reader.nextLine();

            // Parse member info by ','.
            // <catalog_sNum>,<catalog name>,<product><product>...
            catalogInfo = s_catalogInfo.split(",");
            if (catalog_sNum.equals(catalogInfo[0])){
                Vector<Object> catalog_content = new Vector<>();
                for (int i=1; i<catalogInfo.length; i++){
                    catalog_content.addElement(catalogInfo[i]);
                }
                return catalog_content;
            }
        }
        return null;
    }
}
