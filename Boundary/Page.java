package Boundary;

public class Page {
    protected void start(){
        System.out.println();
        System.out.println("【Page title】");
        drawDivider("*");
    }
    protected void drawDivider(String s){
        for (int i=0; i<80; i++){
            System.out.print(s);
        }
        System.out.println();
    }
}
