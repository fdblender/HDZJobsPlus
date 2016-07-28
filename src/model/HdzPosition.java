package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HDZ_POSITIONS database table.
 * 
 */
@Entity
@Table(name="HDZ_POSITIONS")
@NamedQuery(name="HdzPosition.findAll", query="SELECT h FROM HdzPosition h")
public class HdzPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HDZ_POSITIONS_POSITIONID_GENERATOR", sequenceName="HDZ_POSITIONS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDZ_POSITIONS_POSITIONID_GENERATOR")
	private long positionid;

	@Column(name="\"POSITION\"")
	private String position;

	private String positiontype;

	//bi-directional many-to-one association to HdzJobquestion
	@OneToMany(mappedBy="hdzPosition")
	private List<HdzJobquestion> hdzJobquestions;

	//bi-directional many-to-one association to HdzJob
	@OneToMany(mappedBy="hdzPosition")
	private List<HdzJob> hdzJobs;

	public HdzPosition() {
	}

	public long getPositionid() {
		return this.positionid;
	}

	public void setPositionid(long positionid) {
		this.positionid = positionid;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPositiontype() {
		return this.positiontype;
	}

	public void setPositiontype(String positiontype) {
		this.positiontype = positiontype;
	}

	public List<HdzJobquestion> getHdzJobquestions() {
		return this.hdzJobquestions;
	}

	public void setHdzJobquestions(List<HdzJobquestion> hdzJobquestions) {
		this.hdzJobquestions = hdzJobquestions;
	}

	public HdzJobquestion addHdzJobquestion(HdzJobquestion hdzJobquestion) {
		getHdzJobquestions().add(hdzJobquestion);
		hdzJobquestion.setHdzPosition(this);

		return hdzJobquestion;
	}

	public HdzJobquestion removeHdzJobquestion(HdzJobquestion hdzJobquestion) {
		getHdzJobquestions().remove(hdzJobquestion);
		hdzJobquestion.setHdzPosition(null);

		return hdzJobquestion;
	}

	public List<HdzJob> getHdzJobs() {
		return this.hdzJobs;
	}

	public void setHdzJobs(List<HdzJob> hdzJobs) {
		this.hdzJobs = hdzJobs;
	}

	public HdzJob addHdzJob(HdzJob hdzJob) {
		getHdzJobs().add(hdzJob);
		hdzJob.setHdzPosition(this);

		return hdzJob;
	}

	public HdzJob removeHdzJob(HdzJob hdzJob) {
		getHdzJobs().remove(hdzJob);
		hdzJob.setHdzPosition(null);

		return hdzJob;
	}

}