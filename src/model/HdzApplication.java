package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


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

	private String comments;

	private BigDecimal score;

	//bi-directional many-to-one association to HdzApplicant
	@ManyToOne
	@JoinColumn(name="APPLICANTID")
	private HdzApplicant hdzApplicant;

	//bi-directional many-to-one association to HdzJob
	@ManyToOne
	@JoinColumn(name="JOBSID")
	private HdzJob hdzJob;

	//bi-directional many-to-one association to HdzTest
	@OneToMany(mappedBy="hdzApplication")
	private List<HdzTest> hdzTests;

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

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
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

	public List<HdzTest> getHdzTests() {
		return this.hdzTests;
	}

	public void setHdzTests(List<HdzTest> hdzTests) {
		this.hdzTests = hdzTests;
	}

	public HdzTest addHdzTest(HdzTest hdzTest) {
		getHdzTests().add(hdzTest);
		hdzTest.setHdzApplication(this);

		return hdzTest;
	}

	public HdzTest removeHdzTest(HdzTest hdzTest) {
		getHdzTests().remove(hdzTest);
		hdzTest.setHdzApplication(null);

		return hdzTest;
	}

}