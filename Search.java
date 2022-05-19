package db2022;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Search {
	public static void main(String[] args) {
		// 프레임 생성
        JFrame frm = new JFrame("Search");
 
        // 프레임 크기 설정
        frm.setSize(1000, 700);
 
        // 프레임을 화면 가운데에 배치
        frm.setLocationRelativeTo(null);
 
        // 프레임을 닫았을 때 메모리에서 제거되도록 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // 레이아웃 설정
        frm.getContentPane().setLayout(null);
        
        //폰트
        Font font = new Font("맑은 고딕", Font.PLAIN, 50);
 
        // 라벨 생성
        JLabel lb1 = new JLabel("검색");
        lb1.setFont(font);
        
        // 텍스트 필드 생성
        JTextField tf1 = new JTextField("아이돌 그룹");
        JTextField tf2 = new JTextField("멤버명");
        JTextField tf3 = new JTextField("검색 키워드");
        
        
        // 버튼 생성          
 	JButton btn1 = new JButton("Home");
 	JButton btn2 = new JButton("검색하기");
 		
	// 드롭다운 메뉴 생성
	String[] optionsToChoose = {"굿즈 카테고리", "앨범", "포토카드", "폴라로이드", "응원봉", "시즌 그리팅", "기타"};
        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);

 
        // 컨텐츠 위치와 크기 설정
        lb1.setBounds(454,189,100,61);
        
	tf1.setBounds(50,300,280,90);
	tf2.setBounds(360,300,280,90);
	tf3.setBounds(50,420,590,90);
		
	btn1.setBounds(865,30,75,75);
	btn2.setBounds(670,420,280,90);

        jComboBox.setBounds(670,300,280,90);


 
        // 붙이기!
        frm.getContentPane().add(lb1);
		
        frm.getContentPane().add(tf1);
        frm.getContentPane().add(tf2);
        frm.getContentPane().add(tf3);
		
        frm.getContentPane().add(btn1);
        frm.getContentPane().add(btn2);
		
        frm.getContentPane().add(jComboBox);


 
        // 프레임이 보이도록 설정
        frm.setVisible(true);
 

	}

}
