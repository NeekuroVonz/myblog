package blog.dao;

import java.util.List;

import blog.entity.BlogUser;

public interface BlogDao<T> {
	BlogUser insert(T arg);
	void update(T arg);
	T select(int id);
	List<T> selectAll();
	void delete(int id);
}
