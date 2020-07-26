package ca.sheridancollege.beans;

public class Dog {
	private String number;
	private String dogname;
	private String ownername;
	private String breed;
	private String group;
	private String gender;
	private String dogclass;
	
	public Dog() {

	}

	public Dog(String number, String dogname, String ownername, String breed, String group, String gender,
			String dogclass) {
		super();
		this.number = number;
		this.dogname = dogname;
		this.ownername = ownername;
		this.breed = breed;
		this.group = group;
		this.gender = gender;
		this.dogclass = dogclass;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDogname() {
		return dogname;
	}

	public void setDogname(String dogname) {
		this.dogname = dogname;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDogclass() {
		return dogclass;
	}

	public void setDogclass(String dogclass) {
		this.dogclass = dogclass;
	}

	@Override
	public String toString() {
		return "Doggy [number=" + number + ", dogname=" + dogname + ", ownername=" + ownername + ", breed=" + breed
				+ ", group=" + group + ", gender=" + gender + ", dogclass=" + dogclass + "]";
	}
	
}
	
