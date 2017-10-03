package Hospital;

public class Test {
	
	private String description;
	private String testType;
	
	public Test(String desc, String type) {
		this.description = desc;
		this.testType = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}
	

}
