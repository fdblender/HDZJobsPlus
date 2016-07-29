package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HDZ_APPLICANTSKILLS database table.
 * 
 */
@Entity
@Table(name="HDZ_APPLICANTSKILLS")
@NamedQuery(name="HdzApplicantskill.findAll", query="SELECT h FROM HdzApplicantskill h")
public class HdzApplicantskill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_APPLICANTSKILLS_APPLICANTSKILLSID_GENERATOR", sequenceName="HDZ_APPLICANTSKILLS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_APPLICANTSKILLS_APPLICANTSKILLSID_GENERATOR")
	private long applicantskillsid;

	private BigDecimal experience;

	private String skills;

	//bi-directional many-to-one association to HdzApplicant
	@ManyToOne
	@JoinColumn(name="APPLICANTID")
	private HdzApplicant hdzApplicant;

	public HdzApplicantskill() {
	}

	public long getApplicantskillsid() {
		return this.applicantskillsid;
	}

	public void setApplicantskillsid(long applicantskillsid) {
		this.applicantskillsid = applicantskillsid;
	}

	public BigDecimal getExperience() {
		return this.experience;
	}

	public void setExperience(BigDecimal experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public HdzApplicant getHdzApplicant() {
		return this.hdzApplicant;
	}

	public void setHdzApplicant(HdzApplicant hdzApplicant) {
		this.hdzApplicant = hdzApplicant;
	}

}