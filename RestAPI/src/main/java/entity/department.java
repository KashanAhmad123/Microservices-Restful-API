package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class department {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long departmentId;
	
	private String departmentName;
	private String departmentAdd;
	private String deparmentCode;
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentID(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentAdd() {
		return departmentAdd;
	}
	public void setDepartmentAdd(String departmentAdd) {
		this.departmentAdd = departmentAdd;
	}
	public String getDeparmentCode() {
		return deparmentCode;
	}
	public void setDeparmentCode(String deparmentCode) {
		this.deparmentCode = deparmentCode;
	}
	public department(long departmentID, String departmentName, String departmentAdd, String deparmentCode) {
		super();
		this.departmentId = departmentID;
		this.departmentName = departmentName;
		this.departmentAdd = departmentAdd;
		this.deparmentCode = deparmentCode;
	}
	public department() {
		super();
	}
	@Override
	public String toString() {
		return "department [departmentID=" + departmentId + ", departmentName=" + departmentName + ", departmentAdd="
				+ departmentAdd + ", deparmentCode=" + deparmentCode + "]";
	}
	
	

}
