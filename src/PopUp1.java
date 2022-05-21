import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//찜 버튼 클릭 시 나오는 팝업
public class PopUp1 extends JFrame{
	
	public PopUp1() {	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JFrame frame = new JFrame("찜 완료");
	JPanel panel = new JPanel();
	JLabel label = new JLabel("위시리스트에 상품이 추가되었습니다", JLabel.CENTER);
	
	label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(label.getFont().deriveFont(15.0f));

    panel.setLayout(new BorderLayout(10, 10));
	panel.add(label);
	frame.add(panel);
	
	frame.setSize(300, 150);
	frame.setVisible(true);
	
	}
}
