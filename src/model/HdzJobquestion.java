package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HDZ_JOBQUESTIONS database table.
 * 
 */
@Entity
@Table(name="HDZ_JOBQUESTIONS")
@NamedQuery(name="HdzJobquestion.findAll", query="SELECT h FROM HdzJobquestion h")
public class HdzJobquestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_JOBQUESTIONS_JOBQUESTIONSID_GENERATOR", sequenceName="HDZ_JOBQUESTIONS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_JOBQUESTIONS_JOBQUESTIONSID_GENERATOR")
	private long jobquestionsid;

	private String interviewtype;

	private String jobquestion;

	//bi-directional many-to-one association to HdzPosition
	@ManyToOne
	@JoinColumn(name="POSITIONID")
	private HdzPosition hdzPosition;

	//bi-directional many-to-one association to HdzTest
	@OneToMany(mappedBy="hdzJobquestion")
	private List<HdzTest> hdzTests;

	public HdzJobquestion() {
	}

	public long getJobquestionsid() {
		return this.jobquestionsid;
	}

	public void setJobquestionsid(long jobquestionsid) {
		this.jobquestionsid = jobquestionsid;
	}

	public String getInterviewtype() {
		return this.interviewtype;
	}

	public void setInterviewtype(String interviewtype) {
		this.interviewtype = interviewtype;
	}

	public String getJobquestion() {
		return this.jobquestion;
	}

	public void setJobquestion(String jobquestion) {
		this.jobquestion = jobquestion;
	}

	public HdzPosition getHdzPosition() {
		return this.hdzPosition;
	}

	public void setHdzPosition(HdzPosition hdzPosition) {
		this.hdzPosition = hdzPosition;
	}

	public List<HdzTest> getHdzTests() {
		return this.hdzTests;
	}

	public void setHdzTests(List<HdzTest> hdzTests) {
		this.hdzTests = hdzTests;
	}

	public HdzTest addHdzTest(HdzTest hdzTest) {
		getHdzTests().add(hdzTest);
		hdzTest.setHdzJobquestion(this);

		return hdzTest;
	}

	public HdzTest removeHdzTest(HdzTest hdzTest) {
		getHdzTests().remove(hdzTest);
		hdzTest.setHdzJobquestion(null);

		return hdzTest;
	}

}