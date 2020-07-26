package ca.sheridancollege.beans;

public class Show {

	String groupName;
	String breedCount;
	String breed;
	String maleCount;
	String femaleCount;
	String maleSpecialCount;
	String femaleSpecialCount;
	
	public Show() {

	}

	public Show(String groupName, String breedCount, String breed, String maleCount, String femaleCount,
			String maleSpecialCount, String femaleSpecialCount) {
		super();
		this.groupName = groupName;
		this.breedCount = breedCount;
		this.breed = breed;
		this.maleCount = maleCount;
		this.femaleCount = femaleCount;
		this.maleSpecialCount = maleSpecialCount;
		this.femaleSpecialCount = femaleSpecialCount;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getBreedCount() {
		return breedCount;
	}

	public void setBreedCount(String breedCount) {
		this.breedCount = breedCount;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getMaleCount() {
		return maleCount;
	}

	public void setMaleCount(String maleCount) {
		this.maleCount = maleCount;
	}

	public String getFemaleCount() {
		return femaleCount;
	}

	public void setFemaleCount(String femaleCount) {
		this.femaleCount = femaleCount;
	}

	public String getMaleSpecialCount() {
		return maleSpecialCount;
	}

	public void setMaleSpecialCount(String maleSpecialCount) {
		this.maleSpecialCount = maleSpecialCount;
	}

	public String getFemaleSpecialCount() {
		return femaleSpecialCount;
	}

	public void setFemaleSpecialCount(String femaleSpecialCount) {
		this.femaleSpecialCount = femaleSpecialCount;
	}

	@Override
	public String toString() {
		return "Show [groupName=" + groupName + ", breedCount=" + breedCount + ", breed=" + breed + ", maleCount="
				+ maleCount + ", femaleCount=" + femaleCount + ", maleSpecialCount=" + maleSpecialCount
				+ ", femaleSpecialCount=" + femaleSpecialCount + "]";
	}

	
	
	
}
