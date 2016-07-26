package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HDZ_REFTABLE database table.
 * 
 */
@Entity
@Table(name="HDZ_REFTABLE")
@NamedQuery(name="HdzReftable.findAll", query="SELECT h FROM HdzReftable h")
public class HdzReftable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_REFTABLE_REFID_GENERATOR", sequenceName="HDZ_REFTABLE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_REFTABLE_REFID_GENERATOR")
	private long refid;

	private String refemail;

	private String refflag;

	private String refname;

	private String refphone;

	private String refposition;

	//bi-directional many-to-one association to HdzApplicant
	@ManyToOne
	@JoinColumn(name="APPLICANTID")
	private HdzApplicant hdzApplicant;

	public HdzReftable() {
	}

	public long getRefid() {
		return this.refid;
	}

	public void setRefid(long refid) {
		this.refid = refid;
	}

	public String getRefemail() {
		return this.refemail;
	}

	public void setRefemail(String refemail) {
		this.refemail = refemail;
	}

	public String getRefflag() {
		return this.refflag;
	}

	public void setRefflag(String refflag) {
		this.refflag = refflag;
	}

	public String getRefname() {
		return this.refname;
	}

	public void setRefname(String refname) {
		this.refname = refname;
	}

	public String getRefphone() {
		return this.refphone;
	}

	public void setRefphone(String refphone) {
		this.refphone = refphone;
	}

	public String getRefposition() {
		return this.refposition;
	}

	public void setRefposition(String refposition) {
		this.refposition = refposition;
	}

	public HdzApplicant getHdzApplicant() {
		return this.hdzApplicant;
	}

	public void setHdzApplicant(HdzApplicant hdzApplicant) {
		this.hdzApplicant = hdzApplicant;
	}

}