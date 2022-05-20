import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//매수 버튼 클릭 시 나오는 팝업
public class PopUp2 extends JFrame{
	
	public PopUp2() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JFrame frame = new JFrame("매수 완료");
	JPanel panel = new JPanel();
	JLabel label = new JLabel("상품 구입이 완료되었습니다", JLabel.CENTER);
	
	label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(label.getFont().deriveFont(15.0f));

    panel.setLayout(new BorderLayout(10, 10));
	panel.add(label);
	frame.add(panel);
	
	frame.setSize(300, 150);
	frame.setVisible(true);
	
	}
}
