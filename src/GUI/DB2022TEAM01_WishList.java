package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DB2022TEAM01_WishList extends JFrame {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/DB2022Team01";
    static final String USER = "DB2022Team01";
    static final String PASS = "DB2022Team01";

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

    public DB2022TEAM01_WishList() {
        JFrame frame = new JFrame("상품 상세");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("상품 상세");
        JButton bt1 = new JButton("찜");
        JButton bt2 = new JButton("매수");

        Font font = new Font("맑은 고딕", Font.BOLD, 20);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);

        String col[] = { "상품명", "아이돌 그룹", "멤버명", "카테고리", "매도자 ID", "가격", "매수" };

        DefaultTableModel model = new DefaultTableModel(col, 0);


        Connection conn = getConnection();
    }
}
