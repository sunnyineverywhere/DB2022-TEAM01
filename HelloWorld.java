package db2022;

import java.awt.event.*;
import javax.swing.*;

public class HelloWorld {
	public static void main(String[] args) {	
		
		  // 프레임 생성
        JFrame frm = new JFrame("Home");
 
        // 프레임 크기 설정
        frm.setSize(1000, 700);
 
        // 프레임을 화면 가운데에 배치
        frm.setLocationRelativeTo(null);
 
        // 프레임을 닫았을 때 메모리에서 제거되도록 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // 레이아웃 설정
        frm.getContentPane().setLayout(null);
 
        // 버튼 생성
		    JButton btn1 = new JButton("상품등록");
		    JButton btn2 = new JButton("상품상세");
		    JButton btn3 = new JButton("검색");
	 	    JButton btn4 = new JButton("마이페이지-위시리스트");
		    JButton btn5 = new JButton("마이페이지-거래내역");
 
        // 버튼 위치와 크기 설정
		    btn1.setBounds(125,150,300,100);
		    btn2.setBounds(575,150,300,100);
	 	    btn3.setBounds(350,300,300,100);
	    	btn4.setBounds(125,450,300,100);
    		btn5.setBounds(575,450,300,100);
		

 
        // 프레임에다가 버튼 추가
        frm.getContentPane().add(btn1);
        frm.getContentPane().add(btn2);
        frm.getContentPane().add(btn3);
        frm.getContentPane().add(btn4);
        frm.getContentPane().add(btn5);
        
 
        // 프레임이 보이도록 설정
        frm.setVisible(true);
 
    }
}
