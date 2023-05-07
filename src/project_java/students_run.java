package project_java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class students_run {
	private ArrayList<students> dsst;

	public students_run() {
		dsst = new ArrayList();
	}

	public void ghiFile(ArrayList<students> dsst) {
		try {
			FileOutputStream fileOut = new FileOutputStream("dssv.dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(dsst);
			objectOut.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<students> docFile(ArrayList<students> dsst) {
		try {
			FileInputStream fileIn = new FileInputStream("dssv.dat");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Object objdssv = objectIn.readObject();
			objectIn.close();
			dsst.addAll((ArrayList<students>) objdssv);
//			for (int i = 0; i < dsst.size(); i++) {
//				System.out.println(dsst.get(i).getId() + "  " + dsst.get(i).getTen() + dsst.get(i).getDiachi());
//			}
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dsst;
	}

//add
	public void them(students st) {

		int id = 1;
		if (dsst != null && dsst.size() > 0) {
			id = dsst.size() + 1;
		}
		st.setId(id);
		dsst.add(st);
		ghiFile(dsst);
	}

	public boolean xoa(students st) {
		boolean isFound = false;
		int size = dsst.size();
		for (int i = 0; i < size; i++) {
			if (dsst.get(i).getId() == st.getId()) {
				st = dsst.get(i);
				isFound = true;
				break;
			}
		}
		if (isFound) {
			dsst.remove(st);
			ghiFile(dsst);
			return true;
		}
		return false;
	}

	public void sua(students st) {
		for (int i = 0; i < dsst.size(); i++) {
			if (dsst.get(i).getId() == st.getId()) {
				dsst.get(i).setTen(st.getTen());
				dsst.get(i).setTuoi(st.getTuoi());
				dsst.get(i).setDiachi(st.getDiachi());
				dsst.get(i).setDiem(st.getDiem());
				ghiFile(dsst);
				break;
			}
		}
	}

//	Sap  xep theo ten
	public void sxten() {
		Collections.sort(dsst, new Comparator<students>() {
			public int compare(students student1, students student2) {
				return student1.getTen().compareTo(student2.getTen());
			}
		});

	}

//	sap xep theo diem
	public void sxdiem() {
		Collections.sort(dsst, new Comparator<students>() {
			public int compare(students student1, students student2) {
				if (student1.getDiem() > student2.getDiem()) {
					return 1;
				}
				return -1;
			}
		});
	}

//	 Tim kiem theo then
	public ArrayList<students> timkiem(ArrayList<students> dsst, String a) {
		ArrayList<students> dstk = new ArrayList<>();
		for (int i = 0; i < dsst.size(); i++) {
			if (dsst.get(i).getTen().toLowerCase().contains(a.toLowerCase())) {
				dstk.add(dsst.get(i));
			}
		}
		return dstk;
	}

	public ArrayList<students> getDsst() {
		return dsst;
	}

	public void setDsst(ArrayList<students> dsst) {
		this.dsst = dsst;
	}

}
