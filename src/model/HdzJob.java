package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HDZ_JOBS database table.
 * 
 */
@Entity
@Table(name="HDZ_JOBS")
@NamedQuery(name="HdzJob.findAll", query="SELECT h FROM HdzJob h")
public class HdzJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_JOBS_JOBSID_GENERATOR", sequenceName="HDZ_JOBS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_JOBS_JOBSID_GENERATOR")
	private long jobsid;

	private String description;

	private BigDecimal numberopenings;

	private BigDecimal overallexperience;

	//bi-directional many-to-one association to HdzApplication
	@OneToMany(mappedBy="hdzJob")
	private List<HdzApplication> hdzApplications;

	//bi-directional many-to-one association to HdzPosition
	@ManyToOne
	@JoinColumn(name="POSITIONID")
	private HdzPosition hdzPosition;

	//bi-directional many-to-one association to HdzJobskill
	@OneToMany(mappedBy="hdzJob")
	private List<HdzJobskill> hdzJobskills;

	public HdzJob() {
	}

	public long getJobsid() {
		return this.jobsid;
	}

	public void setJobsid(long jobsid) {
		this.jobsid = jobsid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getNumberopenings() {
		return this.numberopenings;
	}

	public void setNumberopenings(BigDecimal numberopenings) {
		this.numberopenings = numberopenings;
	}

	public BigDecimal getOverallexperience() {
		return this.overallexperience;
	}

	public void setOverallexperience(BigDecimal overallexperience) {
		this.overallexperience = overallexperience;
	}

	public List<HdzApplication> getHdzApplications() {
		return this.hdzApplications;
	}

	public void setHdzApplications(List<HdzApplication> hdzApplications) {
		this.hdzApplications = hdzApplications;
	}

	public HdzApplication addHdzApplication(HdzApplication hdzApplication) {
		getHdzApplications().add(hdzApplication);
		hdzApplication.setHdzJob(this);

		return hdzApplication;
	}

	public HdzApplication removeHdzApplication(HdzApplication hdzApplication) {
		getHdzApplications().remove(hdzApplication);
		hdzApplication.setHdzJob(null);

		return hdzApplication;
	}

	public HdzPosition getHdzPosition() {
		return this.hdzPosition;
	}

	public void setHdzPosition(HdzPosition hdzPosition) {
		this.hdzPosition = hdzPosition;
	}

	public List<HdzJobskill> getHdzJobskills() {
		return this.hdzJobskills;
	}

	public void setHdzJobskills(List<HdzJobskill> hdzJobskills) {
		this.hdzJobskills = hdzJobskills;
	}

	public HdzJobskill addHdzJobskill(HdzJobskill hdzJobskill) {
		getHdzJobskills().add(hdzJobskill);
		hdzJobskill.setHdzJob(this);

		return hdzJobskill;
	}

	public HdzJobskill removeHdzJobskill(HdzJobskill hdzJobskill) {
		getHdzJobskills().remove(hdzJobskill);
		hdzJobskill.setHdzJob(null);

		return hdzJobskill;
	}

}