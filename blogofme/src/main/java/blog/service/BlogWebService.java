package blog.service;

import blog.dao.BlogFileDao;
import blog.dao.BlogMemoryDao;
import blog.dao.BlogUserDao;
import blog.entity.BlogUser;

public class BlogWebService extends BlogService{
	private BlogUserDao userdao;
	
	public BlogWebService(BlogMemoryDao blogMemoryDao) {
		super(blogMemoryDao);
		// TODO Auto-generated constructor stub
	}
	public BlogWebService() {
		super(new BlogFileDao());
		// TODO Auto-generated constructor stub
		userdao = new BlogUserDao();
	}
	
	public void addUser(BlogUser user) {
		// TODO : validation
		if( user != null ) {
			if( !user.getEmail().isEmpty() )
				userdao.insert(user);
		}
	}
	public BlogUser insert(BlogUser user) {
		BlogUser ayyo = userdao.insert(user);
		return user;
	}
}
