package DAO;

import java.sql.*;

public class DB2022TEAM01_SearchDAO {

    DB2022TEAM01_LogInDAO logInFunc = new DB2022TEAM01_LogInDAO();

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/DB2022Team01";
    static final String USER = "DB2022Team01";
    static final String PASS = "DB2022Team01";

    private PreparedStatement ps = null; // 명령어
    private ResultSet rs = null;
    private PreparedStatement ps2 = null;


    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean Search(String gp, String member, String keyword, String category){
        Connection conn = getConnection();

        String SQL = "select * from DB2022_product where idol_id = ? and category = ? and name like ?; ";

        try{
            ps = conn.prepareStatement(SQL);
            DB2022TEAM01_ProductDAO dao = new DB2022TEAM01_ProductDAO();
            Long idolId = dao.FindIdol(gp, member);
            ps.setLong(1, idolId);
            ps.setString(2, category);

            String searchInput = "%" + keyword + "%";
            ps.setString(3, searchInput);

            rs = ps.executeQuery();

            if(rs.next()){
                String tmp = rs.getString("name");
                System.out.println(tmp);
            }
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
