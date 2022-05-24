package DAO;

import DTO.DB2022TEAM01_ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DB2022TEAM01_ProductDAO {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/DB2022Team01";
    static final String USER = "DB2022Team01";
    static final String PASS = "DB2022Team01";

    public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){

        }
        return conn;
    }

    public boolean insertProduct(DB2022TEAM01_ProductDTO dto){
        boolean ok = false;

        Connection con = null; // 연결
        PreparedStatement ps = null; // 명령어

        try{
            con = getConnection();
            String sql = "insert into product(" +
                    "name, price, seller, category, date" +
                    ")" +
                    "values(?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);

            ps.setString(2, dto.getName());
            ps.setString(3, dto.getPrice());
            ps.setString(4, dto.getSeller());
            ps.setString(5, dto.getCategory());
            ps.setString(7, dto.getDate());
            int r= ps.executeUpdate();

            if(r > 0){
                System.out.println("가입 성공");
                ok = true;
            }else{
                System.out.println("가입 실패");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return ok;
    }
    
    //검색하는 함수, 필슈항목이 있어야 함.
    public int search(String idol_group, String idol_mem, String keyword, String category) {
    	String SQL = "";
    	return 0;
    }

}
