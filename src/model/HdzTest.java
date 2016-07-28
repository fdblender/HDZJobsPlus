package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HDZ_TESTS database table.
 * 
 */
@Entity
@Table(name="HDZ_TESTS")
@NamedQuery(name="HdzTest.findAll", query="SELECT h FROM HdzTest h")
public class HdzTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_TESTS_TESTSID_GENERATOR", sequenceName="HDZ_TESTS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_TESTS_TESTSID_GENERATOR")
	private long testsid;

	private String codinglanguage;

	private String testresponse;

	//bi-directional many-to-one association to HdzApplication
	@ManyToOne
	@JoinColumn(name="APPLICATIONID")
	private HdzApplication hdzApplication;

	//bi-directional many-to-one association to HdzJobquestion
	@ManyToOne
	@JoinColumn(name="JOBQUESTIONSID")
	private HdzJobquestion hdzJobquestion;

	public HdzTest() {
	}

	public long getTestsid() {
		return this.testsid;
	}

	public void setTestsid(long testsid) {
		this.testsid = testsid;
	}

	public String getCodinglanguage() {
		return this.codinglanguage;
	}

	public void setCodinglanguage(String codinglanguage) {
		this.codinglanguage = codinglanguage;
	}

	public String getTestresponse() {
		return this.testresponse;
	}

	public void setTestresponse(String testresponse) {
		this.testresponse = testresponse;
	}

	public HdzApplication getHdzApplication() {
		return this.hdzApplication;
	}

	public void setHdzApplication(HdzApplication hdzApplication) {
		this.hdzApplication = hdzApplication;
	}

	public HdzJobquestion getHdzJobquestion() {
		return this.hdzJobquestion;
	}

	public void setHdzJobquestion(HdzJobquestion hdzJobquestion) {
		this.hdzJobquestion = hdzJobquestion;
	}

}