package model;

import java.io.Serializable;
import javax.persistence.*;
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

	@Column(name="\"POSITION\"")
	private String position;

	//bi-directional many-to-one association to HdzApplication
	@OneToMany(mappedBy="hdzJob")
	private List<HdzApplication> hdzApplications;

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

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
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

}