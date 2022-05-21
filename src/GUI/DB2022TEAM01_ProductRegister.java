package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DB2022TEAM01_ProductRegister extends JFrame {
    public DB2022TEAM01_ProductRegister(){
        setTitle("상품 등록");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel title = new JLabel("상품 등록");

        Font basic = new Font("맑은 고딕", Font.BOLD, 30);

        c.setBackground(Color.white);

        JLabel productName = new JLabel("상품명 ");
        JLabel IdolGroup = new JLabel("아이돌그룹 ");
        JLabel IdolMember = new JLabel("멤버명 ");
        JLabel category = new JLabel("카테고리 ");
        JLabel price = new JLabel("가격 ");

        JTextField productNameInput = new JTextField(45);
        JTextField IdolGroupInput = new JTextField(45);
        JTextField IdolMemberInput = new JTextField(45);
        JTextField categoryInput = new JTextField(45);
        JTextField priceInput = new JTextField(45);

        productName.setBounds(200, 100, 300, 45);
        IdolGroup.setBounds(200, 180, 300, 45);
        IdolMember.setBounds(200, 260, 300, 45);
        category.setBounds(200, 340, 300, 45);
        price.setBounds(200, 420, 300, 45);

        productNameInput.setBounds(550, 100, 300, 45);
        IdolGroupInput.setBounds(550, 180, 300, 45);
        IdolMemberInput.setBounds(550, 260, 300, 45);
        categoryInput.setBounds(550, 340, 300, 45);
        priceInput.setBounds(550, 420, 300, 45);

        price.setFont(basic);
        productName.setFont(basic);
        IdolGroup.setFont(basic);
        IdolMember.setFont(basic);
        category.setFont(basic);
        productNameInput.setFont(basic);
        priceInput.setFont(basic);
        IdolGroupInput.setFont(basic);
        IdolMemberInput.setFont(basic);
        category.setFont(basic);

        JButton conform = new JButton("등록");	//등록 버튼
        
        Color buttonColor = new Color(0xFF6472);

        conform.setBackground(buttonColor);
        conform.setBounds(400, 500, 200, 100);
        conform.setFont(basic);
        c.add(conform);
        
        
        JButton home = DB2022TEAM01_Main.make_home();
        home.setBounds(800, 30, 30, 30);
        c.add(home);


        c.add(productName);
        c.add(productNameInput);
        c.add(IdolGroup);
        c.add(IdolMemberInput);
        c.add(IdolMember);
        c.add(IdolGroupInput);
        c.add(category);
        c.add(price);
        c.add(priceInput);
        c.add(categoryInput);

        conform.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = productNameInput.getText();
                String IdolGroup = IdolGroupInput.getText();
                String IdolMember = IdolMemberInput.getText();
                String category = categoryInput.getText();
                String price_str = priceInput.getText();
                int price = Integer.parseInt(price_str);
                System.out.println(productName);
            }
        });
        
        //홈버튼
        home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new DB2022TEAM01_Main();
			}
		});

        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);	//화면 중앙에 뜸
        setVisible(true);
    }
    
}
