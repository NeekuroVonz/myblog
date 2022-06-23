package blog.dao;

import java.util.ArrayList;
import java.util.List;

import blog.entity.BlogCategory;
import blog.entity.BlogPost;

/**
 * 
 * data store in memory
 * 
 * DAO has method Create : new data store data object Read(Retrieve) : get data,
 * view, search select by key Update : change data value data object has id
 * Delete : remove data id
 * 
 * @version 0.0.1-Trainning
 * @author william mario stanford jang
 *
 */
public class BlogMemoryDao {
	protected List<BlogPost> postRepo;
	private List<BlogCategory> categoryRepo;

	public BlogMemoryDao() {
		super();
		postRepo = new ArrayList<BlogPost>();
		categoryRepo = new ArrayList<BlogCategory>();
	}

////////	for POST	///////////////////////////////////
	public void save(BlogPost arg) {
		// auto-increment : id have to be unique
		if (arg.getId() != null) {
			for (BlogPost post : postRepo) {
				if (post.getId().intValue() == arg.getId().intValue()) {
					post.CopyData(arg);
				}
			}
		} else {
			arg.setId(postRepo.size() + 1);
			postRepo.add(arg);
		}
	}

	public BlogPost findLastPost() {
		// TODO: 1. List can have same data, 2. need to override equal()
		return (postRepo.size() == 0) ? null : postRepo.get(postRepo.size() - 1);
	}

	public List<BlogPost> findListPostByString(String key) {

		List<BlogPost> list = new ArrayList<BlogPost>();
		for (BlogPost post : postRepo) {
			if (post.getTitle().contains(key) || post.getArticle().contains(key)) {
				list.add(post);
			}
		}
		return list;// to service
	}

	public List<BlogPost> findPostAll() {
		return postRepo;
	}

	public BlogPost findPostById(Integer id) {
		for (BlogPost post : postRepo) {
			if (post.getId().intValue() == id.intValue()) {
				return post;
			}
		}
		return null;
	}

	public void deletePost(Integer id) {
		BlogPost del = null;
		for (BlogPost post : postRepo) {
			if (post.getId().intValue() == id.intValue()) {
				del = post;
				break;
			}
		}
		postRepo.remove(del);

	}

////////for Category	///////////////////////////////////
	public void save(BlogCategory arg) {
// auto-increment : id have to be unique
		if (arg.getId() != null) {
			for (BlogCategory category : categoryRepo) {
				if (category.getId().intValue() == arg.getId().intValue()) {
					category.CopyData(arg);
				}
			}
		} else {
			arg.setId(categoryRepo.size() + 1);
			categoryRepo.add(arg);
		}
	}

	public BlogCategory findLastCategory() {
// TODO: 1. List can have same data, 2. need to override equal()
		return (categoryRepo.size() == 0) ? null : categoryRepo.get(categoryRepo.size() - 1);
	}

	public List<BlogCategory> findListCategoryByString(String key) {

		List<BlogCategory> list = new ArrayList<BlogCategory>();
		for (BlogCategory category : categoryRepo) {
			if (category.getName().contains(key) ) {
				list.add(category);
			}
		}
		return list;// to service
	}

	public List<BlogCategory> findCategoryAll() {
		return categoryRepo;
	}

	public BlogCategory findCategoryById(Integer id) {
		for (BlogCategory category : categoryRepo) {
			if (category.getId().intValue() == id.intValue()) {
				return category;
			}
		}
		return null;
	}

	public void deleteCategory(Integer id) {
		BlogCategory del = null;
		for (BlogCategory category : categoryRepo) {
			if (category.getId().intValue() == id.intValue()) {
				del = category;
				break;
			}
		}
		categoryRepo.remove(del);

	}
}
