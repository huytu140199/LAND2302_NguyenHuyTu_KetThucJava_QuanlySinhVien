package project_java;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class View_home extends JFrame {

	private JPanel contentPane;
	private JTextField txthome_diachi;
	private JTextField txthome_tuoi;
	private JTextField txthome_ten;
	private JTextField idtxt;
	private JTextField txthome_diem;
	private students_run strun = new students_run();
	private JTable studentTable;
	private JScrollPane jScrollPaneStudentTable;
	View_login vlg = new View_login();

	private String[] columnNames = new String[] { "ID", "Ten", "Tuoi", "Diachi", "Diem" };
	private Object data = new Object[][] {};
	private JTextField txtTim;

	/**
	 * Create the frame.
	 */
	public View_home() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(200, 200, 1131, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(23, 74, 73, 14);
		contentPane.add(lblNewLabel);

		JLabel lblTn = new JLabel("Tên :");
		lblTn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTn.setBounds(23, 116, 73, 14);
		contentPane.add(lblTn);

		JLabel lblTui = new JLabel("Tuổi :");
		lblTui.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTui.setBounds(23, 158, 73, 14);
		contentPane.add(lblTui);

		JLabel lblaCh = new JLabel("Địa chỉ :");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblaCh.setBounds(23, 197, 86, 14);
		contentPane.add(lblaCh);

		txthome_diachi = new JTextField();
		txthome_diachi.setForeground(new Color(0, 0, 0));
		txthome_diachi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txthome_diachi.setBounds(109, 197, 328, 104);
		contentPane.add(txthome_diachi);
		txthome_diachi.setColumns(10);

		txthome_tuoi = new JTextField();
		txthome_tuoi.setBounds(109, 158, 328, 20);
		contentPane.add(txthome_tuoi);
		txthome_tuoi.setColumns(10);

		txthome_ten = new JTextField();
		txthome_ten.setColumns(10);
		txthome_ten.setBounds(109, 116, 328, 20);
		contentPane.add(txthome_ten);

		idtxt = new JTextField();
		idtxt.setEnabled(false);
		idtxt.setColumns(10);
		idtxt.setBounds(106, 74, 328, 20);
		contentPane.add(idtxt);

		JLabel lblim = new JLabel("Điểm :");
		lblim.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblim.setBounds(10, 328, 86, 14);
		contentPane.add(lblim);

		txthome_diem = new JTextField();
		txthome_diem.setBounds(109, 328, 86, 20);
		contentPane.add(txthome_diem);
		txthome_diem.setColumns(10);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				students st = new students();
				if (validateform(btnThem) == true) {

					gettudents1(st);
					if (st != null) {
						strun.them(st);
//						strun.docFile(strun.getDsst());
						JOptionPane.showMessageDialog(btnThem, "Thêm thành công");
						idtxt.setText("");
						txthome_diachi.setText("");
						txthome_diem.setText("");
						txthome_ten.setText("");
						txthome_tuoi.setText("");
					}

					showListStudents(strun.getDsst());
				}

			}

		});
		btnThem.setBounds(10, 444, 89, 23);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				students s = new students();
				if (validateform(btnSua) == true) {
					if (s != null) {
						gettudents(s);
						strun.sua(s);
						JOptionPane.showMessageDialog(btnSua, "Cập nhật thành công");

					}

//					strun.docFile(strun.getDsst());
					showListStudents(strun.getDsst());
				}
			}
		});
		btnSua.setBounds(127, 444, 89, 23);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				students st = new students();
				gettudents(st);
				if (strun.xoa(st)) {
					JOptionPane.showMessageDialog(btnXoa, "xoa thanh cong");
				}
				showListStudents(strun.getDsst());
			}
		});
		btnXoa.setBounds(242, 444, 89, 23);
		contentPane.add(btnXoa);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtxt.setText("");
				txthome_diachi.setText("");
				txthome_diem.setText("");
				txthome_ten.setText("");
				txthome_tuoi.setText("");
			}
		});
		btnClear.setBounds(348, 444, 89, 23);
		contentPane.add(btnClear);

		jScrollPaneStudentTable = new JScrollPane();
		jScrollPaneStudentTable.setEnabled(false);
		jScrollPaneStudentTable.setLocation(447, 71);
		jScrollPaneStudentTable.setSize(660, 358);
		studentTable = new JTable();
		studentTable.setCellSelectionEnabled(true);
		studentTable.setColumnSelectionAllowed(true);
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = studentTable.getSelectedRow();
				idtxt.setText(studentTable.getModel().getValueAt(row, 0).toString());
				txthome_ten.setText(studentTable.getModel().getValueAt(row, 1).toString());
				txthome_tuoi.setText(studentTable.getModel().getValueAt(row, 2).toString());
				txthome_diachi.setText(studentTable.getModel().getValueAt(row, 3).toString());
				txthome_diem.setText(studentTable.getModel().getValueAt(row, 4).toString());
			}
		});
		studentTable.setToolTipText("");
		studentTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Tên", "Tuổi", "Địa chỉ", "Điểm" }));
		jScrollPaneStudentTable.setViewportView(studentTable);
		jScrollPaneStudentTable.setPreferredSize(new Dimension(461, 300));
		contentPane.add(jScrollPaneStudentTable);
		int size = strun.docFile(strun.getDsst()).size();
		if(size<=0) {
			studentTable.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Không có dữ liệu" }));
			
		}
		else {
			Object[][] students = new Object[size][5];
			for (int i = 0; i < size; i++) {
				students[i][0] = strun.docFile(strun.getDsst()).get(i).getId();
				students[i][1] = strun.docFile(strun.getDsst()).get(i).getTen();
				students[i][2] = strun.docFile(strun.getDsst()).get(i).getTuoi();
				students[i][3] = strun.docFile(strun.getDsst()).get(i).getDiachi();
				students[i][4] = strun.docFile(strun.getDsst()).get(i).getDiem();
			}
			studentTable.setModel(new DefaultTableModel(students, columnNames));
		}
		JButton btnsx_ten = new JButton("Săp xếp theo tên");
		btnsx_ten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strun.sxten();
				showListStudents(strun.getDsst());
			}
		});
		btnsx_ten.setBounds(633, 444, 144, 23);
		contentPane.add(btnsx_ten);

		JButton btnsx_ten_1 = new JButton("Sắp xếp theo điểm");
		btnsx_ten_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strun.sxdiem();
				showListStudents(strun.getDsst());
			}
		});
		btnsx_ten_1.setBounds(820, 444, 152, 23);
		contentPane.add(btnsx_ten_1);

		txtTim = new JTextField();
		txtTim.setBounds(450, 29, 413, 20);
		contentPane.add(txtTim);
		txtTim.setColumns(10);

		JButton btnTim = new JButton("Tim kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = txtTim.getText();
				if (a == null || "".equals(a.trim())) {
					JOptionPane.showMessageDialog(btnTim, "Xin mời nhập tên cần tìm");
				} else {
					if (strun.timkiem(strun.getDsst(), a).size() > 0) {
						showListStudents(strun.timkiem(strun.getDsst(), a));
					} else {
						JOptionPane.showMessageDialog(btnTim, "Không tìm thấy");
						showListStudents(strun.getDsst());
					}
				}

			}
		});
		btnTim.setBounds(873, 28, 89, 23);
		contentPane.add(btnTim);

		JButton btnallsv = new JButton("Tất cả sinh viên");
		btnallsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showListStudents(strun.docFile(strun.getDsst()));
			}
		});
		btnallsv.setBounds(972, 28, 135, 23);
		contentPane.add(btnallsv);

	}

	public students gettudents(students st) {
		st.setId(Integer.parseInt(idtxt.getText().trim()));
		st.setTen(txthome_ten.getText().trim());
		st.setTuoi(Integer.parseInt(txthome_tuoi.getText().trim()));
		st.setDiachi(txthome_diachi.getText().trim());
		st.setDiem(Float.parseFloat(txthome_diem.getText().trim()));
		return st;

	}

	public students gettudents1(students st) {
//			st.setId(Integer.parseInt(idtxt.getText().trim()));
		st.setTen(txthome_ten.getText().trim());
		st.setTuoi(Integer.parseInt(txthome_tuoi.getText().trim()));
		st.setDiachi(txthome_diachi.getText().trim());
		st.setDiem(Float.parseFloat(txthome_diem.getText().trim()));
		return st;
	}

	public void showListStudents(ArrayList<students> list) {
		int size = list.size();

		Object[][] students = new Object[size][5];
		for (int i = 0; i < size; i++) {
			students[i][0] = list.get(i).getId();
			students[i][1] = list.get(i).getTen();
			students[i][2] = list.get(i).getTuoi();
			students[i][3] = list.get(i).getDiachi();
			students[i][4] = list.get(i).getDiem();
		}
		studentTable.setModel(new DefaultTableModel(students, columnNames));
	}

	public void fillStudentFromSelectedRow() {

		int row = studentTable.getSelectedRow();
		if (row >= 0) {
			idtxt.setText(studentTable.getModel().getValueAt(row, 0).toString());
			txthome_ten.setText(studentTable.getModel().getValueAt(row, 1).toString());
			txthome_tuoi.setText(studentTable.getModel().getValueAt(row, 2).toString());
			txthome_diachi.setText(studentTable.getModel().getValueAt(row, 3).toString());
			txthome_diem.setText(studentTable.getModel().getValueAt(row, 4).toString());

		}
	}

	public boolean validateform(JButton btn) {
		String ten = txthome_ten.getText();
		String tuoi = txthome_tuoi.getText();
		String diachi = txthome_diachi.getText();
		String diem = txthome_diem.getText();
		if (ten == null || "".equals(ten.trim())) {
			txthome_ten.requestFocus();
			JOptionPane.showMessageDialog(btn, "Tên không được trống");
			return false;
		} else {

			if ("".equals(tuoi.trim())) {
				JOptionPane.showMessageDialog(btn, "tuoi khong duoc trong");
				txthome_tuoi.requestFocus();
				return false;
			} else {
				int t = Integer.parseInt(tuoi.trim());
				if (t < 0 || t > 100) {
					JOptionPane.showMessageDialog(btn, "Tuoi khhông hợp lệ");
					return false;
				} else {
					if (diachi == null || "".equals(diachi.trim())) {
						txthome_diachi.requestFocus();
						JOptionPane.showMessageDialog(btn, "Địa chỉ không được trống");
						return false;
					} else {
						if (diem == null || "".equals(diem.trim())) {
							JOptionPane.showMessageDialog(btn, "Điểm không được trống");
							txthome_diem.requestFocus();
							return false;
						} else {
							Float d = Float.parseFloat(diem.trim());
							if (d < 0 || d > 10) {
								txthome_diem.requestFocus();
								JOptionPane.showMessageDialog(btn, "Điểm không hợp lệ");
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
