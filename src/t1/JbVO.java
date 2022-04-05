package t1;

public class JbVO {
	private int idx;
	private String name;
	private String menu;
	private int menupri;
	private String menubill;
	private String menutake;
	private String nameS;
	private int numS;
	private String nameM;
	private String birthM;
	private String genderM;
	private String phoneM;
	
	public JbVO() {}
	
	public JbVO(int idx, String name, String menu, int menupri, String menubill, String menutake, String nameS, int numS ,String nameM ,String birthM, String GenderM, String phoneM) {
		this.idx = idx;
		this.name = name;
		this.menu = menu;
		this.menupri = menupri;
		this.menubill = menubill;
		this.menutake = menutake;
		this.nameS = nameS;
		this.numS = numS;
	}

	public String getNameM() {
		return nameM;
	}

	public void setNameM(String nameM) {
		this.nameM = nameM;
	}

	public String getBirthM() {
		return birthM;
	}

	public void setBirthM(String birthM) {
		this.birthM = birthM;
	}

	public String getGenderM() {
		return genderM;
	}

	public void setGenderM(String genderM) {
		this.genderM = genderM;
	}

	public String getPhoneM() {
		return phoneM;
	}

	public void setPhoneM(String phoneM) {
		this.phoneM = phoneM;
	}

	public String getNameS() {
		return nameS;
	}

	public void setNameS(String nameS) {
		this.nameS = nameS;
	}

	public int getNumS() {
		return numS;
	}

	public void setNumS(int numS) {
		this.numS = numS;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getMenupri() {
		return menupri;
	}

	public void setMenupri(int menupri) {
		this.menupri = menupri;
	}

	public String getMenubill() {
		return menubill;
	}

	public void setMenubill(String menubill) {
		this.menubill = menubill;
	}

	public String getMenutake() {
		return menutake;
	}

	public void setMenutake(String menutake) {
		this.menutake = menutake;
	}

}
