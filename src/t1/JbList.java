package t1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JbList extends JFrame{
	JbDAO dao = new JbDAO();
	Vector vData = new Vector();
	
	private JTable table;
	private JTextField txtSearch;
	public JbList() {
		super("결제 내역");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(12, 90, 640, 461);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(652, 10, 120, 541);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JButton btnNewButton = new JButton("닫기");
		btnNewButton.setBounds(12, 483, 97, 48);
		panel2.add(btnNewButton);
		
		JButton btnNewButton_1_1_2 = new JButton("전체삭제");
		btnNewButton_1_1_2.setBounds(12, 20, 97, 48);
		panel2.add(btnNewButton_1_1_2);
		
		Vector title = new Vector();
		title.add("번호");
		title.add("이름");
		title.add("메뉴");
		title.add("가격");
		title.add("결제방식");
		title.add("주문방식");
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(vData, title);
		table = new JTable(defaultTableModel);
		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 616, 521);
		panel1.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(12, 10, 640, 82);
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(112, 21, 286, 37);
		panel3.add(txtSearch);
		txtSearch.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"주문번호", "이름"}));
		comboBox.setBounds(12, 21, 88, 37);
		panel3.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("찾기");
		btnNewButton_1.setBounds(410, 21, 97, 37);
		panel3.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("전체보기");
		btnNewButton_1_1.setBounds(520, 21, 97, 37);
		panel3.add(btnNewButton_1_1);
		
		vData = dao.getList();
		defaultTableModel.setDataVector(vData, title);
		setVisible(true);
		
		// 전체조회
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				vData = dao.getList();
				defaultTableModel.setDataVector(vData, title);
			}
		});
		// 찾기 버튼
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				String combo = comboBox.getSelectedItem().toString();
				String txt = txtSearch.getText();
				
				if(txt.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "다시입력해주세요");
					txtSearch.requestFocus();
					return;
				}
				if(combo.equals("이름")) {
					vData = dao.getSearch("name", txt);
				}
				else if(combo.equals("주문번호")) {
					vData = dao.getSearch("idx", txt);
				}
				if(vData.size() == 0) {
					JOptionPane.showMessageDialog(null, "검색된 자료가 없습니다.");
				}
				else {
					defaultTableModel.setDataVector(vData, title);
				}
			}
		});

		
		
		// 전체삭제
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				int bool = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까 ?","",JOptionPane.YES_NO_OPTION);				
				if(bool == 0) {
					dao.getClear();
					JOptionPane.showMessageDialog(null, "전체 삭제하였습니다.");
					vData = dao.getList();
					defaultTableModel.setDataVector(vData, title);
				}
				else if(bool == 1) {
					JOptionPane.showMessageDialog(null, "취소하였습니다.");
				}
				
				
			}
		});
		// 뒤로가기		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
	}
	
	
	
	public static void main(String[] args) {
		new JbList();
	}
}
