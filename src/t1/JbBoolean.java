package t1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class JbBoolean extends JFrame{
	private JTextField txtID;
	private JPasswordField txtPWD;
	
	public JbBoolean() {
		super("관리자 확인");
		setSize(459,301);
		setLocationRelativeTo(null);
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 445, 203);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("관리자 확인");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(76, 0, 301, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 80, 81, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PWD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(12, 137, 81, 35);
		panel.add(lblNewLabel_1_1);
		
		txtID = new JTextField();
		txtID.setBounds(98, 80, 230, 35);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JButton btnLog = new JButton("로그인");
		btnLog.setBounds(340, 75, 93, 97);
		panel.add(btnLog);
		
		txtPWD = new JPasswordField();
		txtPWD.setBounds(98, 137, 230, 35);
		panel.add(txtPWD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 200, 445, 64);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnClear = new JButton("입력취소");
		btnClear.setBounds(95, 10, 109, 44);
		panel_1.add(btnClear);
		
		JButton btnClose = new JButton("나가기");
		btnClose.setBounds(225, 10, 109, 44);
		panel_1.add(btnClose);
		
		setVisible(true);
		
		
		//로그인버튼클릭
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "root";
				String pwd = "1234";
				
				int choice = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까 ?","",JOptionPane.YES_NO_OPTION);
				
				if(id.equals(txtID.getText()) && pwd.equals(txtPWD.getText())) {					
					if(choice == 0) {
						int bool = 0;
						
					}else {
						int bool = 1;
						dispose();
					}
				}
				else if(!id.equals(txtID.getText())) {
					JOptionPane.showMessageDialog(null, "*존재하지않는 관리자입니다.*");
					txtID.setText("");
					txtPWD.setText("");
					txtID.requestFocus();
				}
				else if(!pwd.equals(txtPWD.getText())){
					JOptionPane.showMessageDialog(null, "*비밀번호가 다릅니다.*");				
					txtPWD.setText("");
					txtPWD.requestFocus();
				}
			}
		});
	}
	
	
	


	public static void main(String[] args) {
		
		
	}

	
}



