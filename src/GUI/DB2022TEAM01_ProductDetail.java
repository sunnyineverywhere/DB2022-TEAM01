package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

public class DB2022TEAM01_ProductDetail {
	public DB2022TEAM01_ProductDetail() {
		JFrame frame = new JFrame("상품 상세"); 
        JPanel panel = new JPanel();
        JLabel label = new JLabel("상품 상세");
        JButton bt1 = new JButton("찜");
        JButton bt2 = new JButton("매수");
        
        Font font = new Font("맑은 고딕", Font.BOLD, 20);
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);
 
        
        String col[] = { "상품명", "아이돌 그룹", "멤버명", "카테고리" , "매도자 ID", "가격", "등록 날짜", "찜", "매수" };   
 
        Object values[][] = { { "샤넬 가현 포카", "드림캐쳐", "가현", "포토카드" , "a456737", "15000", "2020/04/19", "찜", "매수" }, 
        		{ "자연광 수민 포카", "스테이씨", "수민", "포토카드" , "a456737", "15000", "2020/04/19", "찜", "매수" } , 
        		{ "세은 쥬얼 포카", "스테이씨", "세은", "포토카드" , "a456737", "15000", "2020/04/19", "찜", "매수" } , 
        		{ "이달의 소녀 응원봉", "이달의 소녀", "???", "응원봉" , "a456737", "35000", "2020/04/19", "찜", "매수" } 
                 };
 
        JTable table = new JTable(values, col); 
        table.setRowHeight(30);
        table.getColumnModel().getColumn(7).setCellRenderer(new TableCell1());
        table.getColumnModel().getColumn(7).setCellEditor(new TableCell1());;
        
        table.getColumnModel().getColumn(8).setCellRenderer(new TableCell2());
        table.getColumnModel().getColumn(8).setCellEditor(new TableCell2());;
        
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

//btn1(찜 버튼 셀에 추가)
class TableCell1 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	JButton btn1;
	
	public TableCell1() {
		btn1 = new JButton("찜");
		
		btn1.addActionListener(e -> {
			new PopUp1();
		});
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return btn1;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return btn1;
	}
	
}
//btn2(매수 버튼 셀에 추가)
class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	JButton btn2;
	
	public TableCell2() {
		btn2 = new JButton("매수");
		btn2.addActionListener(e -> {
			new PopUp2();
		});
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return btn2;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return btn2;
	}
	
}
