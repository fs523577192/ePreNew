package fyp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Videos")
public class Video extends IdStatusTimeModel implements Comparable<Video> {
	@Transient
	private static final long serialVersionUID = 1L;
	
	/*
	private Integer presentationId;
	
	public Integer getPresentationId(){
		return presentationId;
	}
	
	public void setPresentationId(Integer presentationId){
		this.presentationId = presentationId;
	}
	*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "presentation_id", nullable = false)
	private Presentation presentation;
	
	public Presentation getPresentation(){
		return presentation;
	}
	
	public void setPresentation(Presentation presentation){
		this.presentation = presentation;
	}
	
	
	/*
	private Integer userId;
	
	public Integer getUserId(){
		return userId;
	}
	
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User owner;
	
	public User getOwner(){
		return owner;
	}
	
	public void setOwner(User owner){
		this.owner = owner;
	}
	
	@Column(length = 64, nullable = false)
	private String name;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(length = 256, nullable = false)
	private String info;
	
	public String getInfo(){
		return info;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
	
	
	public int compareTo(Video video) {
		int result = presentation.compareTo(video.presentation);
		if (0 != result) return result;
		
		result = owner.compareTo(video.owner);
		if (0 != result) return result;
		
		return -(createTime.compareTo(video.createTime));
	}
}