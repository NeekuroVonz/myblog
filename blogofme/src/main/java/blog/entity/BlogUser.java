package blog.entity;

//회원 
public class BlogUser {

 // 회원 아이디 
 private Integer userId;

 // 회원 이름 
 private String name;

 // 회원 이메일 
 private String email;

 public Integer getUserId() {
     return userId;
 }

 public void setUserId(Integer userId) {
     this.userId = userId;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 // BlogUser 모델 복사
 public void CopyData(BlogUser param)
 {
     this.userId = param.getUserId();
     this.name = param.getName();
     this.email = param.getEmail();
 }
}
