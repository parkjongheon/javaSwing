package t1;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.net.URL;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JbMain extends JFrame{
	public JbMain() {
		super("pos");
		setSize(600,627);
		setLocationRelativeTo(null);
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(0, 0, 421, 588);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblImage = new JLabel("New label");
		URL imgUrl = this.getClass().getClassLoader().getResource("2.jpg");
		lblImage.setIcon(new ImageIcon(imgUrl));
		lblImage.setBounds(12, 10, 397, 371);
		panel1.add(lblImage);
		
		JLabel lblLbl = new JLabel("MISO COFFEE pos v1.0");
		lblLbl.setHorizontalAlignment(SwingConstants.CENTER);
		lblLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		lblLbl.setBounds(12, 482, 397, 66);
		panel1.add(lblLbl);
		
		JLabel lblNewLabel = new JLabel("사진출처 : https://blog.naver.com/just_0ne/222497061664");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 8));
		lblNewLabel.setBounds(12, 563, 384, 15);
		panel1.add(lblNewLabel);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(422, 0, 162, 588);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JButton btnOrder = new JButton("주문 받기");
		btnOrder.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnOrder.setBackground(Color.LIGHT_GRAY);
		btnOrder.setBounds(12, 10, 138, 56);
		panel2.add(btnOrder);
		
		JButton btnBill = new JButton("결제 내역");
		btnBill.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnBill.setBackground(Color.LIGHT_GRAY);
		btnBill.setBounds(12, 76, 138, 56);
		panel2.add(btnBill);
		
		JButton btnMember = new JButton("회원 관리");
		btnMember.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnMember.setBackground(Color.LIGHT_GRAY);
		btnMember.setBounds(12, 142, 138, 56);
		panel2.add(btnMember);
		
		JButton btnClose = new JButton("종료");
		btnClose.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnClose.setBackground(Color.LIGHT_GRAY);
		btnClose.setBounds(12, 522, 138, 56);
		panel2.add(btnClose);
		
		
		
		
		
		setVisible(true);
		//주문하기
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JbOrder();
			}
		});
		//결제내역
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JbList();
			}
		});
		//회원관리 
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JbMember();
			}
		});		
		//종료버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	
	
	public static void main(String[] args) {
		new JbMain();
	}
}
