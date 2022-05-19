import java.awt.*;
import javax.swing.*;

public class DB2022TEAM01_Idol extends JFrame{
	public DB2022TEAM01_Idol() {
		setTitle("아이돌 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setBackground(Color.WHITE);
		cp.setLayout(new FlowLayout());
		
		cp.add(new JLabel("아이돌 그룹"));
		cp.add(new JTextField(10));
		cp.add(new JLabel("아이돌 이름"));
		cp.add(new JTextField(10));
		cp.add(new JButton("등록하기"));
		
		setSize(1000, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		DB2022TEAM01_Idol dbIdol = new DB2022TEAM01_Idol();
	}
}
