package blog.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import blog.entity.BlogPost;

public class BlogFileDao extends BlogMemoryDao {
	private File datafile;
	{
		String filename = "blog-data.dat";
		datafile = new File(filename);
		if( !datafile.exists() ) {
			try {
				datafile.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		try {
			loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadData() throws IOException {
//		"BlogPost {
//		id:" + id + ", title:" + title + ", article:" + article + 
//		"}";
		BufferedReader br = new BufferedReader(
								new FileReader(datafile) );
		String line;
		while( (line = br.readLine()) != null ) {
			BlogPost post = new BlogPost();
			{// convert to BlogPost
				if( line.contains("BlogPost")) {
					int si = line.indexOf("{");
					int ei = line.indexOf("}");
					String sub = line.substring(si, ei);
					String[] fields = sub.split(",");
					for (int i = 0; i < fields.length; i++) {
						String[] field = fields[i].trim().split(":");
						if( i==0 ) {// id
							post.setId(Integer.valueOf(field[1].trim()));
						}
						if( i==1 ) {// title
							post.setTitle((field[1].trim()));							
						}
						if( i==2 ) {// article
							post.setArticle((field[1].trim()));
						}
					}
					postRepo.add(post);
				}
			}
		}
	}
	

}
