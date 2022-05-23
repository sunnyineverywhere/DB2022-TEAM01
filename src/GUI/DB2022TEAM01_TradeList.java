package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DB2022TEAM01_TradeList extends JFrame {

    public DB2022TEAM01_TradeList(){
        setTitle("마이페이지 - 거래 내역");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setBackground(Color.white);

        JLabel title = new JLabel("마이페이지 - 거래 내역", SwingConstants.CENTER);
        title.setBounds(320, 110, 360, 50);
        Font font1 = new Font("맑은 고딕", Font.BOLD, 20);
        title.setFont(font1);
        c.add(title);

        String header[] = {"상품명", "아이돌 그룹", "멤버명", "카테고리", "매도자", "가격"};
        Object contents[] = new Object[0][6];

        /*
        DefaultTableModel model = new DefaultTableModel(contents, header);
        JTable table = new JTable(model);
        table.setRowHeight(30);


         */
        setSize(1000, 700);
        setVisible(true);


    }

}
