package com.apik.course.command;
// �ڽ�, ��Ŀ, ��ġ, details  ���� DTO
public class CourseVO {
	// Course TB
		private int cosnum; // �ڽ� id(1~999)
		private String play; // ����?(REST) �?(PLAY)
		private String cosname; // �ڽ���(�ѱ� 20����)
		private int lv; // ������&�Ƿε� Level (1~5)
		private String intro; // ������ �Ұ���( in ������)

		// COSLOC ���̺�� ����
		private int cosnumL; // �ڽ� id��(1~999)
		private int locnum; // ����id�� (1~999)

		// MAP ���̺�� ����
		private int locnumM; // ����id�� (1~999)
		private String locname; // ��Ҹ�(�ѱ� 20����)
		private double locationx; // �浵��(###.######)
		private double locationy; // ������(###.######)
		private String loctype; // ���Ÿ��("A001" "A002)
		
		// icontiype
		private String loctypeI,type;
		
		// DETAILS table
		private int locnumD;
 		private String address;
 		private String imgname;
 		private String tel;
 		private String time;
 		private String contents;

		// Course TB
		public int getCosnum() {
			return cosnum;
		}

		public void setCosnum(int cosnum) {
			this.cosnum = cosnum;
		}

		public String getPlay() {
			return play;
		}

		public void setPlay(String play) {
			this.play = play;
		}

		public String getCosname() {
			return cosname;
		}

		public void setCosname(String cosname) {
			this.cosname = cosname;
		}

		public int getLv() {
			return lv;
		}

		public void setLv(int lv) {
			this.lv = lv;
		}

		public String getIntro() {
			return intro;
		}

		public void setIntro(String intro) {
			this.intro = intro;
		}

		// COSLOC
		public int getCosnumL() {
			return cosnumL;
		}

		public void setCosnumL(int cosnumL) {
			this.cosnumL = cosnumL;
		}

		public int getLocnum() {
			return locnum;
		}

		public void setLocnum(int locnum) {
			this.locnum = locnum;
		}

		
		// MAP ���̺�
		public int getLocnumM() {
			return locnumM;
		}

		public void setLocnumM(int locnumM) {
			this.locnumM = locnumM;
		}

		public String getLocname() {
			return locname;
		}

		public void setLocname(String locname) {
			this.locname = locname;
		}

		public double getLocationx() {
			return locationx;
		}

		public void setLocationx(double locationx) {
			this.locationx = locationx;
		}

		public double getLocationy() {
			return locationy;
		}

		public void setLocationy(double locationy) {
			this.locationy = locationy;
		}

		public String getLoctype() {
			return loctype;
		}

		public void setLoctype(String loctype) {
			this.loctype = loctype;
		}

		public int getLocnumD() {
			return locnumD;
		}

		// details		
		public void setLocnumD(int locnumD) {
			this.locnumD = locnumD;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getImgname() {
			return imgname;
		}

		public void setImgname(String imgname) {
			this.imgname = imgname;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getContents() {
			return contents;
		}

		public void setContents(String contents) {
			this.contents = contents;
		}

		public String getLoctypeI() {
			return loctypeI;
		}

		public void setLoctypeI(String loctypeI) {
			this.loctypeI = loctypeI;
		}

		// icontype
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		
		
}
