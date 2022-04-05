package t1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class JbLogin extends JFrame{
	private JTextField txtId;
	private JPasswordField txtPwd;
	public JbLogin() {
		super("Login");
		setSize(410,300);
		setLocationRelativeTo(null);
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 400, 94);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lbltop = new JLabel("관리자 로그인");
		lbltop.setFont(new Font("굴림", Font.BOLD, 24));
		lbltop.setHorizontalAlignment(SwingConstants.CENTER);
		lbltop.setBounds(12, 10, 385, 74);
		panel1.add(lbltop);	
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 92, 400, 35);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblLog = new JLabel("환영합니다 ");
		lblLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblLog.setBounds(87, 0, 214, 35);
		panel2.add(lblLog);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 125, 400, 136);
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.BOLD, 15));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(12, 10, 78, 26);
		panel3.add(lblId);
		
		JLabel lblPwd = new JLabel("PWD");
		lblPwd.setFont(new Font("굴림", Font.BOLD, 15));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setBounds(12, 46, 78, 26);
		panel3.add(lblPwd);
		
		txtId = new JTextField();
		txtId.setBounds(94, 11, 179, 26);
		panel3.add(txtId);
		txtId.setColumns(10);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setBounds(285, 10, 85, 64);
		panel3.add(btnLogin);
		
		JButton btnClear = new JButton("입력취소");
		btnClear.setBounds(188, 85, 85, 39);
		panel3.add(btnClear);
		
		JButton btnClose = new JButton("종료");
		btnClose.setBounds(285, 85, 85, 39);
		panel3.add(btnClose);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(94, 46, 179, 26);
		panel3.add(txtPwd);
		
		
		
		
		
		setVisible(true);
		//로그인버튼 클릭
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "root";
				String pwd = "1234";
				
				if(id.equals(txtId.getText()) && pwd.equals(txtPwd.getText())) {
					JOptionPane.showMessageDialog(null, "로그인되었습니다.");
					new JbMain();
					dispose();
				}
				else if(!id.equals(txtId.getText())) {
					lblLog.setText("*존재하지않는 관리자입니다.*");
					txtId.setText("");
					txtPwd.setText("");
					txtId.requestFocus();
				}
				else if(!pwd.equals(txtPwd.getText())){
					lblLog.setText("*비밀번호가 다릅니다.*");
					
					
					txtPwd.setText("");
					txtPwd.requestFocus();
				}
			}
		});
		// 입력취소
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtPwd.setText("");
			}
		});
		// 종료
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		new JbLogin();
	}
}
