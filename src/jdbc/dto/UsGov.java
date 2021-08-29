package jdbc.dto;

public class UsGov {
	
	private String name;
	private String first_name;
	private String last_name;
	private String state_code;
	private String phone;
	
	public UsGov(String name, String first_name, String last_name, String state_code, String phone) {
		this.name =name;
		this.first_name =first_name;
		this.last_name = last_name;
		this.state_code = state_code;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "UsGov [name: " + name + ", phone: "+ phone + ", state_code: "+state_code + "]";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}