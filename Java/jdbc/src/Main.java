import java.sql.*;
import java.util.Scanner;

public class Main extends Queries {
    public static void main(String[] args) throws SQLException {

        Scanner sc =new Scanner(System.in);
//        Connection connection = null;
//        Statement stm = null;
        createConnection();
        while(true){
            System.out.println("enter \n1.insertRow\n2.display\n3.deleteRow\n4.search");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    insertRow();
                    break;
                case 2:
                    display();

                    break;
                case 3:
                    deleteRow();
                    break;
                case 4:
                default:
                    System.out.println("enter right option");
                    break;
                }
        }
    }


}
