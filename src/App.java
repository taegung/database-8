import java.sql.*;
import java.util.*;

public class App {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/madang",
                    "taegung", "1234");
            Statement stmt = con.createStatement();
            
            Scanner s = new Scanner(System.in);
            System.out.println("������ �Է��� 1��");
            System.out.println("������ ��ȸ�� 2��");
            System.out.println("������ ������ 3��");
            System.out.println("��ȣ�� �Է��Ͻÿ�");
            int num =s.nextInt();
            if(num==1){
            String insertQuery = "INSERT INTO Book (bookid,bookname,publisher,price) VALUES (1,'�����౸������','�����ī����',000)";
            stmt.execute(insertQuery);
            }

            if(num==3){
            int rowsAffected = stmt.executeUpdate("DELETE FROM Book WHERE bookid = 1");
            if (rowsAffected > 0) {
                System.out.println("Delete query executed successfully.");
            } else {
               System.out.println("No rows were deleted");  
            }
            }
            if(num==2){
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Book");
            while (rs1.next())
                System.out.println(rs1.getInt(1) + " " + rs1.getString(2) +
                        " " + rs1.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
      
    }
}