import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DB2022TEAM01_Idol extends JFrame{
	public DB2022TEAM01_Idol() {
		setTitle("아이돌 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setBackground(Color.WHITE);
		cp.setLayout(null);
		
		//제목
		JLabel title = new JLabel("아이돌 등록", SwingConstants.CENTER);
		title.setBounds(320, 110, 360, 50);
		Font font1 = new Font("맑은 고딕", Font.BOLD, 35);
		title.setFont(font1);		
		cp.add(title);
		
		//그룹, 멤버명
		JLabel group = new JLabel("아이돌 그룹");
		JTextField groupText = new JTextField(20);
		group.setBounds(270, 200, 100, 40);
		groupText.setBounds(350, 200, 300, 40);
		
		JLabel member = new JLabel("아이돌 멤버");
		JTextField memText = new JTextField(20);	
		member.setBounds(270, 260, 100, 40);
		memText.setBounds(350, 260, 300, 40);
		
		cp.add(group);
		cp.add(groupText);
		cp.add(member);
		cp.add(memText);
		
		//버튼
		JButton idol = new JButton("등록하기");
		idol.setBounds(400, 340, 200, 50);
		Color color=new Color(0xFF6472);
		idol.setBackground(color);
		idol.setForeground(Color.white);
		cp.add(idol);
		
		idol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String group_value = groupText.getText();
				String mem_value = memText.getText();
				DBProject_idolSQL idolRegister = new DBProject_idolSQL();
				
				if(idolRegister.idolReg(group_value, mem_value) == 1)
					JOptionPane.showMessageDialog(DB2022TEAM01_Idol.this, "이미 등록된 아이돌입니다.", "아이돌 등록 오류", JOptionPane.PLAIN_MESSAGE);
				else if(idolRegister.idolReg(group_value, mem_value) == 0)
					JOptionPane.showMessageDialog(DB2022TEAM01_Idol.this, "등록이 완료되었습니다.", "아이돌 등록 완료", JOptionPane.PLAIN_MESSAGE);
				else if(idolRegister.idolReg(group_value, mem_value) == -1)
					JOptionPane.showMessageDialog(DB2022TEAM01_Idol.this, "아이돌 그룹과 멤버명을 입력해주세요", "아이돌 등록", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		
		setSize(1000, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		DB2022TEAM01_Idol dbIdol = new DB2022TEAM01_Idol();
	
	}
}
