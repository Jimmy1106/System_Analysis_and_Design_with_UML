package Entity;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Database {

    private String dbPath = "D:/2021/JAVA/OOP/Ordering_System/Database/";
    private String members_path = dbPath + "members.txt";

    private File members;
    private Scanner db_members_reader;

    Database(){
        try {
            members = new File(members_path);
            db_members_reader = new Scanner(members);

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
}
