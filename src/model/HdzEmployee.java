package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HDZ_EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="HDZ_EMPLOYEE")
@NamedQuery(name="HdzEmployee.findAll", query="SELECT h FROM HdzEmployee h")
public class HdzEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_EMPLOYEE_EMPLOYEEID_GENERATOR", sequenceName="HDZ_EMPLOYEE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_EMPLOYEE_EMPLOYEEID_GENERATOR")
	private long employeeid;

	private String email;

	private String empname;

	private String hashedpwd;

	@Column(name="\"POSITION\"")
	private String position;

	private String salt;

	public HdzEmployee() {
	}

	public long getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpname() {
		return this.empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getHashedpwd() {
		return this.hashedpwd;
	}

	public void setHashedpwd(String hashedpwd) {
		this.hashedpwd = hashedpwd;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}