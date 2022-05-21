package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DB2022TEAM01_WishList extends JFrame {
    public DB2022TEAM01_WishList(){

        String colunmName[] = {"상품명", "아이돌 그룹", "아이돌 이름", "카테고리", "가격", "찜"};
        DefaultTableModel model = new DefaultTableModel(colunmName, 0);

        String temp[][] = {};

        setTitle("위시리스트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        JTable resTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(resTable);

        c.add(resTable);

        c.setSize(1000, 700);
        c.setVisible(true);
    }
}
