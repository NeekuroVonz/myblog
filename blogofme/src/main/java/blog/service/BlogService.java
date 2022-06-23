package blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import blog.dao.BlogMemoryDao;
import blog.entity.BlogPost;


public class BlogService {
	private BlogMemoryDao dao;

//	public BlogService() {}
// remove default constructor by JVM
	public BlogService(BlogMemoryDao blogMemoryDao) {
		super();
		// TODO : below your code
		this.dao = blogMemoryDao;
	}
	
	public Map<String, String> process(String cmd) {
		Map<String, String> model = new HashMap<String, String>();
		model.put("service", this.getClass().getName());
		if( !cmd.contains("?") ) {
			if( cmd.equals("post/") ) {
				recentPostOne(model);
			}else if( cmd.equals("post/list") ) {
				getPostAll(model);
			}else if( cmd.equals("category/list") ) {
				getCategoryAll(model);
			}else {
				model.put("404","Not Found");
			}
		}else {
			String[] req = cmd.split("\\?");
			if( req.length == 2 ) {
				// string -> map<string,string>
				String[] parameters = req[1].split("&");
				for(String elm : parameters) {
					String[] pair = elm.split("=");
					model.put(pair[0], pair[1]);
				}
				// dispatch method
				if( req[0].equals("post/add") ) {
					registPost(model);
				}
				// search is hard( key, filter, method ) 
				if( req[0].equals("post/search") ) {
					// "keyword"
					getPostByString(model);
//					getPostWithCategory(model);
				}
				if( req[0].equals("post/view") ) {
					getPostById(model);
				}
				if( req[0].equals("post/update") ) {
					updatePost(model);
				}
				if( req[0].equals("post/delete") ) {
					deletePost(model);
				}
				if( req[0].equals("category/add") ) {
					registCategory(model);
				}
				if( req[0].equals("category/search") ) {
					getCategoryByString(model);
//					getCategoryWithCategory(model);
				}
				if( req[0].equals("category/view") ) {
					getCategoryById(model);
				}
				if( req[0].equals("category/update") ) {
					updateCategory(model);
				}
				if( req[0].equals("category/delete") ) {
					deleteCategory(model);
				}
			}else {
				model.put("400","Bad Request : need paramter");
			}
		}// end else
		
		return model;
	}// end method

	private void recentPostOne(Map<String, String> model) {
		// TODO: get from DAO
		BlogPost post = dao.findLastPost();
		if( post == null) {
			model.put("data", "have no post");
		}else {
			model.put("data", post.toString());			
		}
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void deleteCategory(Map<String, String> model) {
		// TODO Auto-generated method stub		
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void updateCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getCategoryByString(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getCategoryWithCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getCategoryById(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getCategoryAll(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void registCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void deletePost(Map<String, String> model) {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(model.get("id"));
		dao.deletePost(id);
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void updatePost(Map<String, String> model) {
		// TODO Auto-generated method stub
		BlogPost post = toPost(model);
		dao.save(post);
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private BlogPost toPost(Map<String, String> model) {
		if( model.get("id")==null	||
			model.get("title")==null	||
			model.get("article")==null) {
			return null;
		}
		BlogPost post = new BlogPost();
		post.setId(Integer.valueOf(model.get("id")));
		post.setTitle(model.get("title"));
		post.setArticle(model.get("article"));
		return post;
	}

	private List<BlogPost> getPostByString(Map<String, String> model) {
		// TODO Auto-generated method stub
		String key = model.get("keyword");
		List<BlogPost> list = dao.findListPostByString(key);
		model.put("data", list.toString());
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
		return list;// to process()
	}

	private List<BlogPost> getPostWithCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		String categoryname = model.get("keyword");
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
		return null;
	}

	private void getPostById(Map<String, String> model) {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(model.get("id"));
		BlogPost post = dao.findPostById(id);
		model.put("data", post.toString());
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getPostAll(Map<String, String> model) {
		// TODO Auto-generated method stub
		List<BlogPost> list = dao.findPostAll();
		model.put("data", list.toString());
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void registPost(Map<String, String> model) {
		// TODO: 1 create BlogPost, 2 dao.save( );
		BlogPost post = new BlogPost();
		// required field
		if( model.get("title") != null && model.get("article") != null ) {
			post.setTitle(model.get("title"));
			post.setArticle(model.get("article"));
			dao.save(post);
		}
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}	

}






