package project_java;

import java.io.Serializable;

public class students implements Serializable {
	private int id;
	private String ten;
	private int tuoi;
	private String diachi;
	private float diem;

	public students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public students(int id, String ten, int tuoi, String diachi, float diem) {
		super();
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.diem = diem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

}
