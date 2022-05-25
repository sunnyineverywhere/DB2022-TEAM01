package DAO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Vector;

public class DB2022TEAM01_ProductDetailDAO {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/DB2022Team01";
    static final String USER = "DB2022Team01";
    static final String PASS = "DB2022Team01";

    private String productName;
    private Long IdolID;
    private String IdolGroup;
    private String IdolMemeber;
    private String Category;
    private String Seller;
    private long price;
    private LocalDateTime resisterAt;
    private boolean isInWishlist;
    private boolean isSold;

    public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    private PreparedStatement ps;
    private ResultSet rs;

    public Vector getAllProduct(){

        Vector record = new Vector();
        Connection conn = getConnection();
        int row = 1;
        String SQL = "select * from DB2022_product where isSold = false";
        try{
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            record.add(Integer.toString(row++));
            record.add(rs.getString("name"));
            record.add(rs.getLong("price"));
            record.add(rs.getString("seller"));
            record.add(rs.getString("category"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return record;
    }




}
