package bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String title;
	private String brief;
	private String info;
	private String imgPath;
	private List<Tag> tags;
	public News() {
	}

	public News(long id, String title, String brief, String info, String imgPath, List<Tag> tags){
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.info = info;
		this.imgPath = imgPath;
		this.tags = tags;
	}

	public void setTags(List<Tag> tags) {this.tags = tags;}

	public List<Tag> getTags() {return tags;}

	public long getId() { return id; }

	public void setId(int id) {this.id = id; }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brief, imgPath, info, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(brief, other.brief) && Objects.equals(imgPath, other.imgPath)
				&& Objects.equals(info, other.info) && Objects.equals(title, other.title) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", brief=" + brief + ", info=" + info + ", imgPath=" + imgPath + "]";
	}



}
