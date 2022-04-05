package t1;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JbOrder extends JFrame{
	private JTextField txtName;
	private int price =  0;
	private String price1 = "";
	private final ButtonGroup bills = new ButtonGroup();
	private final ButtonGroup take = new ButtonGroup();
	
	Vector vData = new Vector();
	JbDAO dao = new JbDAO();
	JbVO vo = new JbVO();
	
	
	public JbOrder() {
		super("상품 주문");
		setSize(1073,667);
		setLocationRelativeTo(null);
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(12, 10, 477, 608);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblPrice = new JLabel("0");
		lblPrice.setBackground(Color.WHITE);
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblPrice.setBounds(12, 453, 453, 99);
		panel1.add(lblPrice);
		
		JLabel lblTitle = new JLabel("주문 상품");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		lblTitle.setBounds(0, 0, 477, 66);
		panel1.add(lblTitle);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(0, 110, 298, 349);
		panel1.add(textArea);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textArea2.setEditable(false);
		textArea2.setBackground(SystemColor.menu);
		textArea2.setBounds(310, 110, 155, 349);
		panel1.add(textArea2);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(501, 0, 544, 345);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JButton btnMenu1 = new JButton("아메리카노");
		btnMenu1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu1.setBounds(12, 10, 121, 80);
		panel2.add(btnMenu1);
		
		JButton btnMenu2 = new JButton("에스프레소");
		btnMenu2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu2.setBounds(145, 10, 121, 80);
		panel2.add(btnMenu2);
		
		JButton btnMenu3 = new JButton("카푸치노");
		btnMenu3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu3.setBounds(278, 10, 121, 80);
		panel2.add(btnMenu3);
		
		JButton btnMenu4 = new JButton("콜드브루");
		btnMenu4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu4.setBounds(411, 10, 121, 80);
		panel2.add(btnMenu4);
		
		JButton btnMenu5 = new JButton("카라멜마끼야또");
		btnMenu5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu5.setBounds(12, 120, 121, 80);
		panel2.add(btnMenu5);
		
		JButton btnMenu6 = new JButton("더치커피");
		btnMenu6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu6.setBounds(145, 120, 121, 80);
		panel2.add(btnMenu6);
		
		JButton btnMenu7 = new JButton("레몬에이드");
		btnMenu7.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu7.setBounds(278, 120, 121, 80);
		panel2.add(btnMenu7);
		
		JButton btnMenu8 = new JButton("아이스티");
		btnMenu8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu8.setBounds(411, 120, 121, 80);
		panel2.add(btnMenu8);
		
		JButton btnMenu9 = new JButton("샷추가");
		btnMenu9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu9.setBounds(12, 228, 121, 80);
		panel2.add(btnMenu9);
		
		JButton btnMenu10 = new JButton("ICE로 변경");
		btnMenu10.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMenu10.setBounds(145, 228, 121, 80);
		panel2.add(btnMenu10);
		
		JLabel lblNewLabel_2 = new JLabel("2000\\");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(12, 95, 121, 15);
		panel2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("2000\\");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(145, 95, 121, 15);
		panel2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("3500\\");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(278, 95, 121, 15);
		panel2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("3500\\");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(411, 95, 121, 15);
		panel2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("4000\\");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_4.setBounds(12, 203, 121, 15);
		panel2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("4000\\");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_5.setBounds(145, 203, 121, 15);
		panel2.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("2000\\");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_6.setBounds(278, 203, 121, 15);
		panel2.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("2000\\");
		lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_7.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_7.setBounds(411, 203, 121, 15);
		panel2.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_8 = new JLabel("1000\\");
		lblNewLabel_2_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_8.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_8.setBounds(12, 316, 121, 15);
		panel2.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_9 = new JLabel("500\\");
		lblNewLabel_2_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_9.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_9.setBounds(145, 318, 121, 15);
		panel2.add(lblNewLabel_2_9);
		
		JPanel panel4 = new JPanel();
		panel4.setBounds(501, 503, 544, 125);
		getContentPane().add(panel4);
		panel4.setLayout(null);
		
		JButton btnOrder = new JButton("결제 하기");
		btnOrder.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		btnOrder.setBounds(12, 10, 152, 105);
		panel4.add(btnOrder);
		
		JButton btnClear = new JButton("취소 하기");
		btnClear.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		btnClear.setBounds(195, 10, 152, 105);
		panel4.add(btnClear);
		
		JButton btnClose = new JButton("뒤로 가기");
		btnClose.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		btnClose.setBounds(380, 10, 152, 105);
		panel4.add(btnClose);
		
		JPanel pane3 = new JPanel();
		pane3.setBounds(501, 343, 544, 161);
		getContentPane().add(pane3);
		pane3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원 이름 검색");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(0, 10, 125, 31);
		pane3.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("결제 방식");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(0, 106, 125, 31);
		pane3.add(lblNewLabel_1_1);
		
		txtName = new JTextField();
		txtName.setBounds(137, 10, 174, 31);
		pane3.add(txtName);
		txtName.setColumns(10);
		
		JButton btnSearch = new JButton("조회");
		btnSearch.setBounds(323, 10, 97, 31);
		pane3.add(btnSearch);
		
		JRadioButton rdbtnCash = new JRadioButton("현금결제");
		bills.add(rdbtnCash);
		rdbtnCash.setBounds(133, 99, 81, 23);
		pane3.add(rdbtnCash);
		
		JRadioButton rdbtnCard = new JRadioButton("카드결제");
		bills.add(rdbtnCard);
		rdbtnCard.setBounds(133, 124, 81, 23);
		pane3.add(rdbtnCard);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("TAKE");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(222, 106, 109, 31);
		pane3.add(lblNewLabel_1_1_1);
		
		JRadioButton rdbtnHome = new JRadioButton("매장주문");
		take.add(rdbtnHome);
		rdbtnHome.setBounds(339, 80, 81, 23);
		pane3.add(rdbtnHome);
		
		JRadioButton rdbtnTake = new JRadioButton("포장주문");
		take.add(rdbtnTake);
		rdbtnTake.setBounds(339, 106, 81, 23);
		pane3.add(rdbtnTake);
		
		JRadioButton rdbtnRide = new JRadioButton("배달주문");
		take.add(rdbtnRide);
		rdbtnRide.setBounds(339, 132, 81, 23);
		pane3.add(rdbtnRide);
		
		JButton btnMemberP = new JButton("회원 등록");
		btnMemberP.setBounds(432, 10, 97, 31);
		pane3.add(btnMemberP);
		
		JRadioButton rdbtnClear = new JRadioButton("");
		bills.add(rdbtnClear);
		rdbtnClear.setBounds(33, 63, -11, 23);
		pane3.add(rdbtnClear);
		
		JRadioButton rdbtnClear1 = new JRadioButton("");
		take.add(rdbtnClear1);
		rdbtnClear1.setBounds(378, 47, -11, 23);
		pane3.add(rdbtnClear1);
		
		
		setVisible(true);
		//회원관리
		btnMemberP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JbCreate();
			}
		});
		// 회원조회
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtName.getText();
				
				
				if(txt.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요");
					txtName.requestFocus();
					return;
				}
				else {
					vData = dao.getSearchM("name", txt);
					if(vData.size() == 0) {
						JOptionPane.showMessageDialog(null, "회원이 아닙니다.");
						txtName.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "회원 "+txt+" 검색완료");
						
					}					
				}
			}
		});
		// 아메리카노버튼
		btnMenu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 2000;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);			
				textArea.setText(textArea.getText() + "아메리카노 +\n");
				textArea2.setText(textArea2.getText() + "2000 원\n");
			}
		});
		// 에스프레소
		btnMenu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 2000;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "에스프레소 +\n");
				textArea2.setText(textArea2.getText() + "2000 원\n");
			}
		});
		btnMenu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 3500;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "카푸치노 +\n");
				textArea2.setText(textArea2.getText() + "3500 원\n");
			}
		});
		btnMenu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 3500;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "콜드브루 +\n");
				textArea2.setText(textArea2.getText() + "3500 원\n");
			}
		});
		btnMenu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 4000;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "카라멜마끼야또 +\n");
				textArea2.setText(textArea2.getText() + "4000 원\n");
			}
		});
		btnMenu6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 4000;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "더치커피 +\n");
				textArea2.setText(textArea2.getText() + "4000 원\n");
			}
		});
		btnMenu7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 2000;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "레몬에이드 +\n");
				textArea2.setText(textArea2.getText() + "2000 원\n");
			}
		});
		btnMenu8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 2000;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "아이스티 +\n");
				textArea2.setText(textArea2.getText() + "2000 원\n");
			}
		});
		btnMenu9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 1000;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "--샷추가-- +\n");
				textArea2.setText(textArea2.getText() + "1000 원\n");
			}
		});
		btnMenu10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price += 500;
				price1 = String.valueOf(price);
				lblPrice.setText(price1);
				textArea.setText(textArea.getText() + "--ICE로변경-- +\n");
				textArea2.setText(textArea2.getText() + "500 원\n");
			}
		});
		// 주문하기버튼
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String menu = textArea.getText();
				int menupri = price;
				String menubill = null;
				String menutake = null;
				boolean sw = true;
				
				while(sw) {
					if(rdbtnCash.isSelected() == false && rdbtnCard.isSelected() == false) {
						JOptionPane.showMessageDialog(null, "결제방식을 선택해주세요.");
						break;
					}
					else if(rdbtnHome.isSelected() == false && rdbtnTake.isSelected() == false && rdbtnRide.isSelected() == false) {
						JOptionPane.showMessageDialog(null, "주문방식을 선택해주세요");
						break;
					}
					else {
						if(rdbtnCash.isSelected()) {
							menubill = "현금결제";
						}
						else if(rdbtnCard.isSelected()) {
							menubill = "카드결제";
						}
						
						
						if(rdbtnHome.isSelected()) { 
							menutake = "매장주문";
						}
						else if(rdbtnTake.isSelected()) {
							menutake = "포장주문";
						}
						else if(rdbtnRide.isSelected()) { 
							menutake = "배달주문";
						}
						rdbtnClear.setSelected(true);
						rdbtnClear1.setSelected(true);
						textArea.setText("");
						textArea2.setText("");
						txtName.setText("");
						lblPrice.setText("0");
						price = 0;
						
						
						vo.setName(name);
						vo.setMenu(menu);
						vo.setMenupri(menupri);
						vo.setMenubill(menubill);
						vo.setMenutake(menutake);
						
						dao.JbOrder(vo);
						JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
						sw = false;
					}
				}
			}
		});
		// 취소하기 버튼
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnClear.setSelected(true);
				rdbtnClear1.setSelected(true);
				textArea.setText("");
				textArea2.setText("");
				txtName.setText("");
				lblPrice.setText("0");
				price = 0;
			}
		});
		// 뒤로가기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
		public static void main(String[] args) {
		new JbOrder();
	}
}
