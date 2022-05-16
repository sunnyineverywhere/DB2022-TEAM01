
import GUI.DB2022TEAM01_ProductRegister;

import java.sql.*;
import java.util.Scanner;

public class HelloWorld {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/DB2022Team01";
    static final String USER = "DB2022Team01";
    static final String PASS = "DB2022Team01";

    public static void main(String[] args) throws SQLException {

        /*
        //jiwon
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){

        }

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
        
        //kyoomin
        Scanner scan = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rSet = statement.executeQuery("select * from `DB2022_idol`");

            String group, mem;
            group = scan.next();
            mem = scan.next();

            while(resultSet.next()){
                if(group == rSet.getString("`group`") && member == rSet.getString("`member`"))
                	System.out.println("Already Registered");
                else{
                	PreparedStatement pStmt = connection.prepareStatement("insert into `DB2022_idol` values (?, ?, ?)");
                	pStmt.setString(1, group);
                	pStmt.setString(2, mem);
                	pStmt.setString(3, null);
                	pStmt.executeUpdate();
                }   
            }
            rSet.close();
            stmt.close();
            pStmt.close();
            connection.close();
          	
        }catch (ClassNotFoundException e) {
			// TODO: handle exception
		}catch (SQLException e) {
			// TODO: handle exception
		}


         */
        
        
        // 선의 gui 확인용
        new DB2022TEAM01_ProductRegister();

    }

}
