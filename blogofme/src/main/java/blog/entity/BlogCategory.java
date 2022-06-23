package blog.entity;

import java.sql.Timestamp;

//카테고리 
public class BlogCategory {

 // 카테고리 아이디 
 private Integer id;

 // 카테고리 이름 
 private String name;

 // 수정된 카테고리 이름 
 private String nameClean;

 // 활성화 여부 
 private Boolean enabled;

 // 등록일 
 private Timestamp dateCreated;

 public Integer getId() {
     return id;
 }

 public void setId(Integer id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getNameClean() {
     return nameClean;
 }

 public void setNameClean(String nameClean) {
     this.nameClean = nameClean;
 }

 public Boolean getEnabled() {
     return enabled;
 }

 public void setEnabled(Boolean enabled) {
     this.enabled = enabled;
 }

 public Timestamp getDateCreated() {
     return dateCreated;
 }

 public void setDateCreated(Timestamp dateCreated) {
     this.dateCreated = dateCreated;
 }

 // BlogCategory 모델 복사
 public void CopyData(BlogCategory param)
 {
     this.id = param.getId();
     this.name = param.getName();
     this.nameClean = param.getNameClean();
     this.enabled = param.getEnabled();
     this.dateCreated = param.getDateCreated();
 }
}
