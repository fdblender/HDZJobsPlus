package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HDZ_EDUCATION database table.
 * 
 */
@Entity
@Table(name="HDZ_EDUCATION")
@NamedQuery(name="HdzEducation.findAll", query="SELECT h FROM HdzEducation h")
public class HdzEducation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_EDUCATION_EDUCATIONID_GENERATOR", sequenceName="HDZ_EDUCATION_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_EDUCATION_EDUCATIONID_GENERATOR")
	private long educationid;

	private String datecompleted;

	private String degreecompleted;

	private String educationflag;

	private String schoolname;

	//bi-directional many-to-one association to HdzApplicant
	@ManyToOne
	@JoinColumn(name="APPLICANTID")
	private HdzApplicant hdzApplicant;

	public HdzEducation() {
	}

	public long getEducationid() {
		return this.educationid;
	}

	public void setEducationid(long educationid) {
		this.educationid = educationid;
	}

	public String getDatecompleted() {
		return this.datecompleted;
	}

	public void setDatecompleted(String datecompleted) {
		this.datecompleted = datecompleted;
	}

	public String getDegreecompleted() {
		return this.degreecompleted;
	}

	public void setDegreecompleted(String degreecompleted) {
		this.degreecompleted = degreecompleted;
	}

	public String getEducationflag() {
		return this.educationflag;
	}

	public void setEducationflag(String educationflag) {
		this.educationflag = educationflag;
	}

	public String getSchoolname() {
		return this.schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public HdzApplicant getHdzApplicant() {
		return this.hdzApplicant;
	}

	public void setHdzApplicant(HdzApplicant hdzApplicant) {
		this.hdzApplicant = hdzApplicant;
	}

}