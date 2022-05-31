package GUI;

import DAO.DB2022TEAM01_LogInDAO;
import DAO.DB2022TEAM01_ProductDAO;
import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import javax.xml.transform.Result;

public class DB2022TEAM01_ProductDetail {

	DB2022TEAM01_LogInDAO logInFunc = new DB2022TEAM01_LogInDAO();

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



	public DB2022TEAM01_ProductDetail() {
		JFrame frame = new JFrame("상품 상세");
		Container contentPane = frame.getContentPane();
		
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);
        JLabel label = new JLabel("상품 상세");        
        
        Font font = new Font("맑은 고딕", Font.BOLD, 20);             
        
        //페이지 제목
        label.setBounds(453, 23, 94, 25);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);
        contentPane.add(label);
 
        
        String col[] = { "상품 ID", "상품명", "아이돌 그룹", "멤버명", "카테고리" , "판매자", "가격", "등록 날짜" };   

		DefaultTableModel model = new DefaultTableModel(col, 0);

		Connection conn = getConnection();

		String SQL = "select * from DB2022_idol, DB2022_product where isSold = false and DB2022_idol.idol_id = DB2022_product.idol_id;";
		try{
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			int row = 1;
			while(rs.next()){
				Vector record = new Vector();
				row++;
				//상품 id
				record.add(rs.getInt("id"));
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
        
        table.setPreferredScrollableViewportSize(new Dimension (900, 650));
        table.setBackground(Color.pink); 
        
        JButton home = DB2022TEAM01_Main.make_home();
        home.setBounds(950, 5, 30, 30);
        contentPane.add(home);

        //찜, 매수하기
        JLabel idInput_label = new JLabel("상품 ID:");
        JTextField idInput = new JTextField(10);
        JButton bt1 = new JButton("찜");
        JButton bt2 = new JButton("구매");
        
        Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
        Font font3 = new Font("맑은 고딕", Font.BOLD, 11);
        Color btn_color=new Color(0xFF6472);
		
        idInput_label.setFont(font2);
        bt1.setFont(font3);
        bt1.setBackground(btn_color);
		bt1.setForeground(Color.white);
        bt2.setFont(font3);
        bt2.setBackground(btn_color);
		bt2.setForeground(Color.white);
        
        idInput_label.setBounds(298, 600, 58, 20);
        idInput.setBounds(369, 600, 178, 26);
        bt1.setBounds(567, 600, 45, 26);
        bt2.setBounds(621, 600, 60, 26);
        
        //찜 버튼 눌렀을 때
        bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DB2022TEAM01_ProductDAO dao = new DB2022TEAM01_ProductDAO();
				Long productId = Long.parseLong(idInput.getText());
				dao.addWishlist(productId);
				new PopUp1();
				//여기에 위시리스트에 추가하는 코드
			}
		});
        
        //매수 버튼 눌렀을 때
        bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DB2022TEAM01_ProductDAO dao = new DB2022TEAM01_ProductDAO();
				Long productId = Long.parseLong(idInput.getText());
				dao.buyProduct(productId);
				new PopUp2();
				//여기에 구매 처리하는 코드
			}
		});
        
        contentPane.add(idInput_label);
        contentPane.add(idInput);
        contentPane.add(bt1);
        contentPane.add(bt2);
        
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
        pane.setBounds(0, 60, 988, 510);
        contentPane.add(pane);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);	//화면 중앙에 뜸
        frame.setVisible(true); 
	}
	
}

class PopUp1 extends JFrame{
	public PopUp1() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame frame = new JFrame("찜 완료");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("위시리스트에 상품이 추가되었습니다", JLabel.CENTER);
		
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setFont(label.getFont().deriveFont(15.0f));

	    panel.setLayout(new BorderLayout(10, 10));
		panel.add(label);
		frame.add(panel);
		
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);	//화면 중앙에 뜸
		frame.setVisible(true);
		
	}
}

class PopUp2 extends JFrame{
	public PopUp2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame frame = new JFrame("매수 완료");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("상품 구입이 완료되었습니다", JLabel.CENTER);
		
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setFont(label.getFont().deriveFont(15.0f));

	    panel.setLayout(new BorderLayout(10, 10));
		panel.add(label);
		frame.add(panel);
		
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);	//화면 중앙에 뜸
		frame.setVisible(true);
		
	}
}

