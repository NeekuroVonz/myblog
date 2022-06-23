package blog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

//게시글 
public class BlogPost  implements Serializable {
	private static final long serialVersionUID = -1880873079573672341L;

	// 게시글 아이디
	private Integer id;

	// 게시글 제목
	private String title;

	// 게시글 내용
	private String article;

	// 수정된 게시글 제목
	private String titleClean;

	// 첨부 파일
	private String file;

	// 저자 아이디 저자 미상 포스트 가능
	private Integer authorId;

	// 공개 일자
	private Timestamp datePublished;

	// 광고 이미지
	private String bannerImage;

	// 특징
	private Boolean featured;

	// 활성화 여부
	private Boolean enabled;

	// 댓글 가능 여부
	private Boolean commentsEnabled;

	// 읽은 횟수
	private Integer views;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null) {
			this.title = "";
		} else {
			this.title = title;
		}
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getTitleClean() {
		return titleClean;
	}

	public void setTitleClean(String titleClean) {
		this.titleClean = titleClean;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Timestamp getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Timestamp datePublished) {
		this.datePublished = datePublished;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public Boolean getFeatured() {
		return featured;
	}

	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getCommentsEnabled() {
		return commentsEnabled;
	}

	public void setCommentsEnabled(Boolean commentsEnabled) {
		this.commentsEnabled = commentsEnabled;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	// BlogPost 모델 복사
	public void CopyData(BlogPost param) {
		this.id = param.getId();
		this.title = param.getTitle();
		this.article = param.getArticle();
		this.titleClean = param.getTitleClean();
		this.file = param.getFile();
		this.authorId = param.getAuthorId();
		this.datePublished = param.getDatePublished();
		this.bannerImage = param.getBannerImage();
		this.featured = param.getFeatured();
		this.enabled = param.getEnabled();
		this.commentsEnabled = param.getCommentsEnabled();
		this.views = param.getViews();
	}

	@Override
	public String toString() {
		return "BlogPost {id:" + id + ", title:" + title + ", article:" + article + "}";
	}

}
