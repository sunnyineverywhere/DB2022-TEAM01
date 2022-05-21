import java.awt.*;
import javax.swing.*;

public class DB2022TEAM01_TradeList extends JFrame{

	public DB2022TEAM01_TradeList() {
		setTitle("마이페이지 - 거래 내역");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setBackground(Color.WHITE);
		
		String header[] = {"상품명", "아이돌 그룹", "멤버명", "카테고리", "매도자", "가격"};
		//db에서 불러올 부분
		String contents[][] = {
				{"더보이즈 주연 쓰릴라이드 미공포 양도", "더보이즈", "주연", "포카", "dagef", "3500"},
				{"더보이즈 현재 인형 달곰 판매", "더보이즈", "현재", "인형", "dlksjdf", "50000"}
		};
		JTable list = new JTable(contents,header);
		JScrollPane scrollpane = new JScrollPane(list);
		cp.add(scrollpane);
		
		setSize(1000, 700);
		setVisible(true);
	}
	public static void main(String[] args) {
		DB2022TEAM01_TradeList tradeList = new DB2022TEAM01_TradeList();

	}

}
