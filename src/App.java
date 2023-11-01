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
            System.out.println("데이터 입력은 1번");
            System.out.println("데이터 조회는 2번");
            System.out.println("데이터 삭제는 3번");
            System.out.println("번호를 입력하시오");
            int num =s.nextInt();
            if(num==1){
            String insertQuery = "INSERT INTO Book (bookid,bookname,publisher,price) VALUES (1,'민재축구교과서','민재아카데미',000)";
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