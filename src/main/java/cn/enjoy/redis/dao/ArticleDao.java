package cn.enjoy.redis.dao;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
	List<Map> queryArticleVoteByPostTime(String articleId);
   
}