/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlproject;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Mohamed Elgindy
 */
public class SqlProject {

    /**
     * @param args the command line arguments
     */
    public static void start() throws SQLException{
        Student st = new Student();
        //System.out.println("Enter your Operation");

        
        //st.Insert();
        //st.showAll();
        //st.search();
        //st.Update();
        //st.delete();
        Scanner sc = new Scanner(System.in);
        int ch=0;
        do{
            System.out.println("\n\nWhat do you need to do?\n"
                    + "1- Inser new Student\n"
                    + "2- edit Student Data\n"
                    + "3- search Student\n"
                    + "4- Delete Student data\n"
                    + "5- Show All Student\n"
                    + "6- Exit\n");
            System.out.print("Enter Operation Here:");
            ch = sc.nextInt();
            switch(ch){
               // case 1: st.Insert(); break;
                //case 2: st.Update(); break;
                //case 3: st.search(); break;
                case 4: st.delete();break;
                case 5: st.showAll();break;
                case 6: st.Exit();break;
                default: System.out.println("invalid choice");
            }
        }while(ch!=6);
    }
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //start();
         //insert x =  new insert();
        //x.setVisible(true);
        //Search c = new Search();
        //c.setVisible(true);
//        ShowAll sh = new ShowAll();
//        sh.setVisible(true);
          Start s = new Start();
          s.setSize(1190, 650);
          s.setVisible(true);
    }
}
