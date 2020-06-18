package tw.com.phctw.bean;
public class Student {
	String sno;
	String sName;
	int    age;
	int    sex;
	String pId;
	
	public Student() {
	}
	
	public Student(String sno, String sName, int age, int sex, String pId) {
		this.sno = sno;
		this.sName = sName;
		this.age = age;
		this.sex = sex;
		this.pId = pId;
	}
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}
	
	@Override
	public String toString() {
		return "Student [SNO: " + sno 
				+ ", SNAME: "  + sName 
				+ ", AGE: "   + age
				+ ", SEX: "   + sex 
				+ ", PID: "   + pId + "]";
	}
	
	
}
