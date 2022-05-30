package GUI;

import DAO.DB2022TEAM01_LogInDAO;
import DAO.DB2022TEAM01_ProductDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

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

    DB2022TEAM01_LogInDAO loginfunc = new DB2022TEAM01_LogInDAO();
    DB2022TEAM01_ProductDAO dao = new DB2022TEAM01_ProductDAO();
    private PreparedStatement ps;
    private ResultSet rs;

    public DB2022TEAM01_WishList() {
        JFrame frame = new JFrame("위시리스트");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("위시리스트");
        JButton bt1 = new JButton("찜 해제");
        JButton bt2 = new JButton("매수");

        Font font = new Font("맑은 고딕", Font.BOLD, 20);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);

        String col[] = { "상품명", "아이돌 그룹", "멤버명", "카테고리", "매도자 ID", "가격", "매수" };

        DefaultTableModel model = new DefaultTableModel(col, 0);
        Long userId = loginfunc.getLogInUser();
        dao.WishList(userId);


        Connection conn = getConnection();

        String SQL = "select * from DB2022TEAM01.wishlist;";
        try{
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            int row = 1;
            while(rs.next()){
                Vector record = new Vector();
                row++;
                // 샹품명
                record.add(rs.getString("name"));

                // 아이돌 그룹
                record.add(rs.getString("gp"));

                // 아이돌 이름
                record.add(rs.getString("member"));

                // 카테고리
                record.add(rs.getString("category"));

                // 판매자
                record.add(rs.getString("seller"));

                // 가격
                record.add(rs.getLong("price"));

                // 등록 날짜
                record.add(rs.getString("date"));
                model.addRow(record);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JTable table = new JTable(model);
        table.setRowHeight(30);

        table.setPreferredScrollableViewportSize(new Dimension (950, 650));
        table.setBackground(Color.pink);

        JButton home = DB2022TEAM01_Main.make_home();
        home.setBounds(950, 5, 30, 30);
        panel.add(home);

        //홈버튼
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                frame.dispose();
                new DB2022TEAM01_Main();
            }
        });

        JScrollPane pane = new JScrollPane(table);
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(pane, BorderLayout.CENTER);
        panel.add(label, BorderLayout.NORTH);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);	//화면 중앙에 뜸
        frame.setVisible(true);


    }
}
