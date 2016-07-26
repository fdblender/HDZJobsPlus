package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HDZ_APPLICATION database table.
 * 
 */
@Entity
@Table(name="HDZ_APPLICATION")
@NamedQuery(name="HdzApplication.findAll", query="SELECT h FROM HdzApplication h")
public class HdzApplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_APPLICATION_APPLICATIONID_GENERATOR", sequenceName="HDZ_APPLICATION_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_APPLICATION_APPLICATIONID_GENERATOR")
	private long applicationid;

	private String appstatus;

	private String codingtest;

	//bi-directional many-to-one association to HdzApplicant
	@ManyToOne
	@JoinColumn(name="APPLICANTID")
	private HdzApplicant hdzApplicant;

	//bi-directional many-to-one association to HdzJob
	@ManyToOne
	@JoinColumn(name="JOBSID")
	private HdzJob hdzJob;

	public HdzApplication() {
	}

	public long getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(long applicationid) {
		this.applicationid = applicationid;
	}

	public String getAppstatus() {
		return this.appstatus;
	}

	public void setAppstatus(String appstatus) {
		this.appstatus = appstatus;
	}

	public String getCodingtest() {
		return this.codingtest;
	}

	public void setCodingtest(String codingtest) {
		this.codingtest = codingtest;
	}

	public HdzApplicant getHdzApplicant() {
		return this.hdzApplicant;
	}

	public void setHdzApplicant(HdzApplicant hdzApplicant) {
		this.hdzApplicant = hdzApplicant;
	}

	public HdzJob getHdzJob() {
		return this.hdzJob;
	}

	public void setHdzJob(HdzJob hdzJob) {
		this.hdzJob = hdzJob;
	}

}