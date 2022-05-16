package GUI;

import javax.swing.*;
import java.awt.*;

public class DB2022TEAM01_ProductRegister extends JFrame {
    public DB2022TEAM01_ProductRegister(){
        setTitle("상품 등록");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("상품명 "));
        c.add(new JTextField(45));
        c.add(new JLabel("아이돌그룹 "));
        c.add(new JTextField(45));
        c.add(new JLabel("멤버명 "));
        c.add(new JTextField(45));
        c.add(new JLabel("카테고리 "));
        c.add(new JTextField(45));
        c.add(new JLabel("가격 "));
        c.add(new JTextField(45));

        c.add(new JButton("등록"));

        setSize(500, 200);
        setVisible(true);
    }
}
