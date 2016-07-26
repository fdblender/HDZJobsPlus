package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HDZ_JOBHISTORY database table.
 * 
 */
@Entity
@Table(name="HDZ_JOBHISTORY")
@NamedQuery(name="HdzJobhistory.findAll", query="SELECT h FROM HdzJobhistory h")
public class HdzJobhistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_JOBHISTORY_JOBHISTORYID_GENERATOR", sequenceName="HDZ_JOBHISTORY_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_JOBHISTORY_JOBHISTORYID_GENERATOR")
	private long jobhistoryid;

	private String companyname;

	private String description;

	private String enddate;

	private String jobhistoryflag;

	@Column(name="\"POSITION\"")
	private String position;

	private String startdate;

	//bi-directional many-to-one association to HdzApplicant
	@ManyToOne
	@JoinColumn(name="APPLICANTID")
	private HdzApplicant hdzApplicant;

	public HdzJobhistory() {
	}

	public long getJobhistoryid() {
		return this.jobhistoryid;
	}

	public void setJobhistoryid(long jobhistoryid) {
		this.jobhistoryid = jobhistoryid;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getJobhistoryflag() {
		return this.jobhistoryflag;
	}

	public void setJobhistoryflag(String jobhistoryflag) {
		this.jobhistoryflag = jobhistoryflag;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStartdate() {
		return this.startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public HdzApplicant getHdzApplicant() {
		return this.hdzApplicant;
	}

	public void setHdzApplicant(HdzApplicant hdzApplicant) {
		this.hdzApplicant = hdzApplicant;
	}

}