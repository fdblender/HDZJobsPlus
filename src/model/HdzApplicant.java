package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HDZ_APPLICANT database table.
 * 
 */
@Entity
@Table(name="HDZ_APPLICANT")
@NamedQuery(name="HdzApplicant.findAll", query="SELECT h FROM HdzApplicant h")
public class HdzApplicant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_APPLICANT_APPLICANTID_GENERATOR", sequenceName="HDZ_APPLICANT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_APPLICANT_APPLICANTID_GENERATOR")
	private long applicantid;

	private String alcoholtestflag;

	private String bday;

	private String citizen;

	private String citizenflag;

	private String codingflag;

	private String dottestflag;

	private String drugtestflag;

	private String email;

	private String employeeflag;

	private String firstname;

	private String gravatarurl;

	private String hashedpwd;

	private String invitedflag;

	private String lastname;

	private String resumeobjective;

	private String resumesummary;

	private String salt;

	private String stdpanelflag;

	private String veteran;

	private String veteranflag;

	private String visa;

	private String visaflag;

	//bi-directional many-to-one association to HdzApplicantskill
	@OneToMany(mappedBy="hdzApplicant")
	private List<HdzApplicantskill> hdzApplicantskills;

	//bi-directional many-to-one association to HdzApplication
	@OneToMany(mappedBy="hdzApplicant")
	private List<HdzApplication> hdzApplications;

	//bi-directional many-to-one association to HdzEducation
	@OneToMany(mappedBy="hdzApplicant")
	private List<HdzEducation> hdzEducations;

	//bi-directional many-to-one association to HdzJobhistory
	@OneToMany(mappedBy="hdzApplicant")
	private List<HdzJobhistory> hdzJobhistories;

	//bi-directional many-to-one association to HdzReftable
	@OneToMany(mappedBy="hdzApplicant")
	private List<HdzReftable> hdzReftables;

	public HdzApplicant() {
	}

	public long getApplicantid() {
		return this.applicantid;
	}

	public void setApplicantid(long applicantid) {
		this.applicantid = applicantid;
	}

	public String getAlcoholtestflag() {
		return this.alcoholtestflag;
	}

	public void setAlcoholtestflag(String alcoholtestflag) {
		this.alcoholtestflag = alcoholtestflag;
	}

	public String getBday() {
		return this.bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getCitizen() {
		return this.citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public String getCitizenflag() {
		return this.citizenflag;
	}

	public void setCitizenflag(String citizenflag) {
		this.citizenflag = citizenflag;
	}

	public String getCodingflag() {
		return this.codingflag;
	}

	public void setCodingflag(String codingflag) {
		this.codingflag = codingflag;
	}

	public String getDottestflag() {
		return this.dottestflag;
	}

	public void setDottestflag(String dottestflag) {
		this.dottestflag = dottestflag;
	}

	public String getDrugtestflag() {
		return this.drugtestflag;
	}

	public void setDrugtestflag(String drugtestflag) {
		this.drugtestflag = drugtestflag;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeflag() {
		return this.employeeflag;
	}

	public void setEmployeeflag(String employeeflag) {
		this.employeeflag = employeeflag;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGravatarurl() {
		return this.gravatarurl;
	}

	public void setGravatarurl(String gravatarurl) {
		this.gravatarurl = gravatarurl;
	}

	public String getHashedpwd() {
		return this.hashedpwd;
	}

	public void setHashedpwd(String hashedpwd) {
		this.hashedpwd = hashedpwd;
	}

	public String getInvitedflag() {
		return this.invitedflag;
	}

	public void setInvitedflag(String invitedflag) {
		this.invitedflag = invitedflag;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getResumeobjective() {
		return this.resumeobjective;
	}

	public void setResumeobjective(String resumeobjective) {
		this.resumeobjective = resumeobjective;
	}

	public String getResumesummary() {
		return this.resumesummary;
	}

	public void setResumesummary(String resumesummary) {
		this.resumesummary = resumesummary;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getStdpanelflag() {
		return this.stdpanelflag;
	}

	public void setStdpanelflag(String stdpanelflag) {
		this.stdpanelflag = stdpanelflag;
	}

	public String getVeteran() {
		return this.veteran;
	}

	public void setVeteran(String veteran) {
		this.veteran = veteran;
	}

	public String getVeteranflag() {
		return this.veteranflag;
	}

	public void setVeteranflag(String veteranflag) {
		this.veteranflag = veteranflag;
	}

	public String getVisa() {
		return this.visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public String getVisaflag() {
		return this.visaflag;
	}

	public void setVisaflag(String visaflag) {
		this.visaflag = visaflag;
	}

	public List<HdzApplicantskill> getHdzApplicantskills() {
		return this.hdzApplicantskills;
	}

	public void setHdzApplicantskills(List<HdzApplicantskill> hdzApplicantskills) {
		this.hdzApplicantskills = hdzApplicantskills;
	}

	public HdzApplicantskill addHdzApplicantskill(HdzApplicantskill hdzApplicantskill) {
		getHdzApplicantskills().add(hdzApplicantskill);
		hdzApplicantskill.setHdzApplicant(this);

		return hdzApplicantskill;
	}

	public HdzApplicantskill removeHdzApplicantskill(HdzApplicantskill hdzApplicantskill) {
		getHdzApplicantskills().remove(hdzApplicantskill);
		hdzApplicantskill.setHdzApplicant(null);

		return hdzApplicantskill;
	}

	public List<HdzApplication> getHdzApplications() {
		return this.hdzApplications;
	}

	public void setHdzApplications(List<HdzApplication> hdzApplications) {
		this.hdzApplications = hdzApplications;
	}

	public HdzApplication addHdzApplication(HdzApplication hdzApplication) {
		getHdzApplications().add(hdzApplication);
		hdzApplication.setHdzApplicant(this);

		return hdzApplication;
	}

	public HdzApplication removeHdzApplication(HdzApplication hdzApplication) {
		getHdzApplications().remove(hdzApplication);
		hdzApplication.setHdzApplicant(null);

		return hdzApplication;
	}

	public List<HdzEducation> getHdzEducations() {
		return this.hdzEducations;
	}

	public void setHdzEducations(List<HdzEducation> hdzEducations) {
		this.hdzEducations = hdzEducations;
	}

	public HdzEducation addHdzEducation(HdzEducation hdzEducation) {
		getHdzEducations().add(hdzEducation);
		hdzEducation.setHdzApplicant(this);

		return hdzEducation;
	}

	public HdzEducation removeHdzEducation(HdzEducation hdzEducation) {
		getHdzEducations().remove(hdzEducation);
		hdzEducation.setHdzApplicant(null);

		return hdzEducation;
	}

	public List<HdzJobhistory> getHdzJobhistories() {
		return this.hdzJobhistories;
	}

	public void setHdzJobhistories(List<HdzJobhistory> hdzJobhistories) {
		this.hdzJobhistories = hdzJobhistories;
	}

	public HdzJobhistory addHdzJobhistory(HdzJobhistory hdzJobhistory) {
		getHdzJobhistories().add(hdzJobhistory);
		hdzJobhistory.setHdzApplicant(this);

		return hdzJobhistory;
	}

	public HdzJobhistory removeHdzJobhistory(HdzJobhistory hdzJobhistory) {
		getHdzJobhistories().remove(hdzJobhistory);
		hdzJobhistory.setHdzApplicant(null);

		return hdzJobhistory;
	}

	public List<HdzReftable> getHdzReftables() {
		return this.hdzReftables;
	}

	public void setHdzReftables(List<HdzReftable> hdzReftables) {
		this.hdzReftables = hdzReftables;
	}

	public HdzReftable addHdzReftable(HdzReftable hdzReftable) {
		getHdzReftables().add(hdzReftable);
		hdzReftable.setHdzApplicant(this);

		return hdzReftable;
	}

	public HdzReftable removeHdzReftable(HdzReftable hdzReftable) {
		getHdzReftables().remove(hdzReftable);
		hdzReftable.setHdzApplicant(null);

		return hdzReftable;
	}

}