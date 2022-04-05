package t1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;

public class JbMember extends JFrame{
	private JTable table;
	private JTextField txtSearch;
	
	@SuppressWarnings("rawtypes")
	Vector vData = new Vector();
	JbDAO dao = new JbDAO();
	JbVO vo = new JbVO();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JbMember() {
		super("회원 관리");
		setSize(806,669);
		setLocationRelativeTo(null);
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(12, 136, 594, 486);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 594, 486);
		panel2.add(scrollPane);
		
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(12, 10, 594, 125);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JComboBox combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"번호", "이름", "생년월일", "성별", "전화번호"}));
		combo.setBounds(45, 83, 77, 32);
		panel1.add(combo);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(134, 84, 208, 32);
		panel1.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(354, 83, 99, 33);
		panel1.add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("회원 관리");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 570, 63);
		panel1.add(lblNewLabel);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(465, 83, 99, 33);
		panel1.add(btnDelete);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(604, 10, 176, 612);
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
		JButton btnCreate = new JButton("회원 등록");
		btnCreate.setFont(new Font("굴림", Font.PLAIN, 15));
		btnCreate.setBounds(12, 10, 152, 60);
		panel3.add(btnCreate);
		
		JButton btnNewButton_1 = new JButton("뒤로 가기");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 15));
		btnNewButton_1.setBounds(12, 542, 152, 60);
		panel3.add(btnNewButton_1);
		
		JButton btnAll = new JButton("전체 보기");
		btnAll.setFont(new Font("굴림", Font.PLAIN, 15));
		btnAll.setBounds(12, 80, 152, 60);
		panel3.add(btnAll);
		
		JButton btnAllclear = new JButton("전체 삭제");
		btnAllclear.setFont(new Font("굴림", Font.PLAIN, 15));
		btnAllclear.setBounds(12, 150, 152, 60);
		panel3.add(btnAllclear);
		
		Vector title = new Vector();
		title.add("번호");
		title.add("이름");
		title.add("생년월일");
		title.add("성별");
		title.add("전화번호");
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(vData, title);
		table = new JTable(defaultTableModel);
		scrollPane.setViewportView(table);
		
		vData = dao.getListM();
		defaultTableModel.setDataVector(vData, title);
		
		setVisible(true);
		//전체보기
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getListM();
				defaultTableModel.setDataVector(vData, title);
			}
		});
		//검색버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comboM = combo.getSelectedItem().toString();
				String txt = txtSearch.getText();
				txtSearch.setText("");
				
				if(txt.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요");
					txtSearch.requestFocus();
					return;
				}

				
				if(comboM.equals("이름")) {
					vData = dao.getSearchM("name", txt);
				}
				else if(comboM.equals("번호")) {
					if(!Pattern.matches("^[0-9]*$", txt)) {
						JOptionPane.showMessageDialog(null, "번호는 숫자로 입력하세요");
						txtSearch.requestFocus();
						return;
					}
					else {
						vData = dao.getSearchM("idx", txt);
					}
				}
				else if(comboM.equals("생년월일")) {
					vData = dao.getSearchM("birth", txt);
				}
				else if(comboM.equals("성별")){
					vData = dao.getSearchM("gender", txt);
				}
				else {
					vData = dao.getSearchM("phone", txt);
				}

				if(vData.size() == 0) {
					JOptionPane.showMessageDialog(null, "검색된 자료가 없습니다.");
				}
				else {
					defaultTableModel.setDataVector(vData, title);
				}
			}
		});
		// 삭제버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String comboM = combo.getSelectedItem().toString();
				String txt = txtSearch.getText();
								
				if(txt.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "입력한 값이 없습니다 \n 다시입력하세요");
					return;
				}
				else if(!comboM.equals("번호")) {
					JOptionPane.showMessageDialog(null, "삭제는 번호만 입력할수있습니다. 번호조회후 다시입력해주세요.");
					return;
				}
				else if(!Pattern.matches("^[0-9]*$", txt)) {
					JOptionPane.showMessageDialog(null, "번호는 숫자로 입력하세요");
					txtSearch.requestFocus();
					return;
				}
				else {
					vData = dao.getSearchM("idx" , txt);
				}
				if(vData.size() == 0) {
					JOptionPane.showMessageDialog(null, "검색된 자료가 없습니다.");
				}
				else {
					vo.setIdx(Integer.parseInt(txt));
					
					dao.getDelete(vo);
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
					defaultTableModel.setDataVector(vData, title);
				}
			}
		});
		// 회원생성
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JbCreate();
			}
		});
		// 전체삭제
		btnAllclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bool = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까 ?","",JOptionPane.YES_NO_OPTION);				
				if(bool == 0) {
					dao.getClearM();
					JOptionPane.showMessageDialog(null, "전체 삭제하였습니다.");
					vData = dao.getListM();
					defaultTableModel.setDataVector(vData, title);
				}
				else if(bool == 1) {
					JOptionPane.showMessageDialog(null, "취소하였습니다.");
				}
			}
		});
		// 뒤로가기
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new JbMember();
	}
}
