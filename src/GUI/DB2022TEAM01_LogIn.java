package GUI;

import java.awt.*;
import javax.swing.*;

public class DB2022TEAM01_LogIn extends JFrame{
	public DB2022TEAM01_LogIn() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);
		
		//페이지 타이틀 <아이돌 벼룩시장>
		JLabel title = new JLabel("아이돌 벼룩시장", SwingConstants.CENTER);	
		title.setBounds(320, 110, 360, 50);
		Font font1 = new Font("맑은 고딕", Font.BOLD, 35);
		title.setFont(font1);		
		contentPane.add(title);
		
		//id, pw 입력창
		JLabel id = new JLabel("ID");
		JLabel pw = new JLabel("PW");
		JTextField id_field = new JTextField(20);
		JPasswordField pw_field = new JPasswordField(20);
		id.setBounds(320, 200, 40, 40);
		pw.setBounds(320, 260, 40, 40);
		id_field.setBounds(380, 200, 300, 40);
		pw_field.setBounds(380, 260, 300, 40);
		
		
		Font font2 = new Font("Arial", Font.BOLD, 23);
		id.setFont(font2);
		pw.setFont(font2);
		
		contentPane.add(id);		
		contentPane.add(id_field);
		contentPane.add(pw);
		contentPane.add(pw_field);
		
		
		//로그인, 회원가입 버튼
		JButton login = new JButton("LogIn");				
		JButton signup = new JButton("SignUp");		
		
		//버튼 색깔, 폰트
		Color btn_color=new Color(0xFF6472);
		login.setBackground(btn_color);
		login.setForeground(Color.white);
		login.setFont(font2);
		signup.setBackground(btn_color);		
		signup.setForeground(Color.white);
		signup.setFont(font2);
		
		login.setBounds(320, 340, 170, 50);
		signup.setBounds(510, 340, 170, 50);
		
		contentPane.add(login);
		contentPane.add(signup);
		
		setSize(1000, 700);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		DB2022TEAM01_LogIn logIn = new DB2022TEAM01_LogIn();
		logIn.setResizable(false);
	}
	
	
}
