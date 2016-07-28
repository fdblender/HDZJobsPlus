package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HDZ_JOBSKILLS database table.
 * 
 */
@Entity
@Table(name="HDZ_JOBSKILLS")
@NamedQuery(name="HdzJobskill.findAll", query="SELECT h FROM HdzJobskill h")
public class HdzJobskill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_JOBSKILLS_JOBSKILLSID_GENERATOR", sequenceName="HDZ_JOBSKILLS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_JOBSKILLS_JOBSKILLSID_GENERATOR")
	private long jobskillsid;

	private BigDecimal jobexperience;

	private String jobskills;

	//bi-directional many-to-one association to HdzJob
	@ManyToOne
	@JoinColumn(name="JOBSID")
	private HdzJob hdzJob;

	public HdzJobskill() {
	}

	public long getJobskillsid() {
		return this.jobskillsid;
	}

	public void setJobskillsid(long jobskillsid) {
		this.jobskillsid = jobskillsid;
	}

	public BigDecimal getJobexperience() {
		return this.jobexperience;
	}

	public void setJobexperience(BigDecimal jobexperience) {
		this.jobexperience = jobexperience;
	}

	public String getJobskills() {
		return this.jobskills;
	}

	public void setJobskills(String jobskills) {
		this.jobskills = jobskills;
	}

	public HdzJob getHdzJob() {
		return this.hdzJob;
	}

	public void setHdzJob(HdzJob hdzJob) {
		this.hdzJob = hdzJob;
	}

}