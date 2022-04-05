package t1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JbCreate extends JFrame{
	private JTextField txtName;
	private JTextField txtCall;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtBirth;
	
	JbDAO dao =  new JbDAO();
	JbVO vo = new JbVO();
	
	public JbCreate() {
		super("상품 주문");
		setSize(644,601);
		setLocationRelativeTo(null);
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 563);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원 가입\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel.setBounds(12, 43, 408, 92);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(41, 204, 91, 38);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("전화번호");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(41, 417, 91, 38);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("성별");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(41, 350, 91, 38);
		panel.add(lblNewLabel_1_2);
		
		txtName = new JTextField();
		txtName.setBounds(144, 204, 213, 38);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtCall = new JTextField();
		txtCall.setColumns(10);
		txtCall.setBounds(144, 421, 213, 38);
		panel.add(txtCall);
		
		JRadioButton rdbtnMale = new JRadioButton("남자");
		buttonGroup.add(rdbtnMale);
		
		rdbtnMale.setFont(new Font("굴림", Font.PLAIN, 14));
		rdbtnMale.setBounds(166, 359, 55, 27);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("굴림", Font.PLAIN, 14));
		rdbtnFemale.setBounds(258, 359, 55, 27);
		panel.add(rdbtnFemale);
		
		JButton btnClear = new JButton("입력 취소");
		btnClear.setBounds(96, 492, 125, 45);
		panel.add(btnClear);
		
		JButton btnOk = new JButton("입력 완료");
		btnOk.setBounds(233, 492, 125, 45);
		panel.add(btnOk);
		
		JLabel lblNewLabel_1_3 = new JLabel("생년월일");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(41, 279, 91, 38);
		panel.add(lblNewLabel_1_3);
		
		txtBirth = new JTextField();
		txtBirth.setColumns(10);
		txtBirth.setBounds(144, 279, 213, 38);
		panel.add(txtBirth);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(444, 0, 179, 563);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("뒤로가기");
		btnNewButton_2.setBounds(12, 469, 155, 68);
		panel_1.add(btnNewButton_2);
		
		JButton btnMember = new JButton("회원 관리");
		btnMember.setBounds(12, 46, 155, 68);
		panel_1.add(btnMember);
		
		JRadioButton rdbtnClear = new JRadioButton("");
		rdbtnClear.setSelected(true);
		rdbtnClear.setEnabled(false);
		rdbtnClear.setBounds(27, 17, -1, 23);
		panel_1.add(rdbtnClear);
		buttonGroup.add(rdbtnClear);
		
		setVisible(true);
		//입력완료 DB연동
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String birth = txtBirth.getText();
				String gender = null;
				String phone = txtCall.getText();
				boolean sw = true;
				while(sw) {
					if(name.equals("")) {
						JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
						txtName.requestFocus();
						break;
					}
									
					if(rdbtnClear.isSelected() == true) {
						JOptionPane.showMessageDialog(null, "성별을 선택해주세요.");
						break;
					}
					else if(rdbtnMale.isSelected() == true) {
						gender = "남자";
					}
					else if(rdbtnFemale.isSelected() == true) {
						gender = "여자";
					}
					
					vo.setNameM(name);
					vo.setBirthM(birth);
					vo.setGenderM(gender);
					vo.setPhoneM(phone);
					
					dao.getCreate(vo);
					JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
					sw = false;
					
					txtName.setText("");
					txtBirth.setText("");
					rdbtnClear.setSelected(true);
					txtCall.setText("");
				}	
			}
		});
		//입력취소
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtBirth.setText("");
				rdbtnClear.setSelected(true);
				txtCall.setText("");
				
				
			}
		});
		//회원관리
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JbMember();
				dispose();
			}
		});
		//뒤로가기
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new JbCreate();
	}
}
