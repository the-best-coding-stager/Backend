package com.springmvc.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Word;
import com.springmvc.exception.WordIdException;

@Repository
public class WordRepositoryImpl implements WordRepository{
	private JdbcTemplate template; 
	 
	 @Autowired  
	 public void setJdbctemplate(DataSource dataSource) {
	    this.template = new JdbcTemplate(dataSource);
	 }
	 
	 private List<Word> listOfWords = new ArrayList<Word>();
	 
	 public WordRepositoryImpl() {
		 Word word1 = new Word("1", "킹받다");
		 word1.setTitle("킹받네 정말!");
		 word1.setDescription("화가 날 때 쓰는 표현.");
		 
		 listOfWords.add(word1);
	 }

	@Override
	public List<Word> getAllWordList() {
		String SQL = "SELECT * FROM word";  
        List<Word> listOfWords = template.query(SQL, new WordRowMapper());  
        return listOfWords;
	}

	@Override
	public List<Word> getWordListByCategory(String category) {
		List<Word> wordsByCategory = new ArrayList<Word>(); 
	    String SQL = "SELECT * FROM word where w_category LIKE '%" + category + "%'";  
	    wordsByCategory = template.query(SQL, new WordRowMapper());  
	    return wordsByCategory;  
	}

	@Override
	public Set<Word> getWordListByFilter(Map<String, List<String>> filter) {
		Set<Word> wordsByPublisher = new HashSet<Word>();
        Set<Word> wordsByCategory = new HashSet<Word>();

        Set<String> wordsByFilter = filter.keySet();

        if (wordsByFilter.contains("publisher")) {  
            for (int j = 0; j < filter.get("publisher").size(); j++) { 
                String publisherName = filter.get("publisher").get(j); 
            	 String SQL = "SELECT * FROM word where w_publisher LIKE '%" + publisherName + "%'";  
                 wordsByPublisher.addAll(template.query(SQL, new WordRowMapper())); 
            }
        }  

        if (wordsByFilter.contains("category")) {  
            for (int i = 0; i < filter.get("category").size(); i++) { 
                String category = filter.get("category").get(i); 
            	String SQL = "SELECT * FROM word where w_category LIKE '%" + category + "%'";  
                wordsByCategory.addAll(template.query(SQL, new WordRowMapper())); 
            }
        }  

        wordsByCategory.retainAll(wordsByPublisher);  
        return wordsByCategory;
	}

	@Override
	public Word getWordById(String wordId) {
		Word wordInfo = null;

	    String SQL = "SELECT count(*) FROM word where w_wordId=?";  
	    int rowCount = template.queryForObject(SQL, Integer.class, wordId);  
	    if (rowCount != 0) {
	        SQL = "SELECT * FROM word where w_wordId=?";  
	        wordInfo = template.queryForObject(SQL, new Object[] { wordId }, new WordRowMapper());  
	    }
	    if(wordInfo == null)  
	    	throw new WordIdException(wordId);
	    return wordInfo;
	}

	@Override
	public void setNewWord(Word word) {
        String SQL = "INSERT INTO word (w_wordId, w_name, w_title, w_description, w_writer, w_releaseDate) " + "VALUES (?, ?, ?, ?, ?, ?)";
        template.update(SQL, word.getWordId(), word.getName(), word.getTitle(), word.getDescription(), word.getWriter(), word.getReleaseDate());
        return;
	}

	@Override
	public void setUpdateWord(Word word) {
		String SQL = "UPDATE Word SET w_name = ?, w_title = ?, w_description = ?, w_writer = ?, w_releaseDate = ? where w_wordId = ? ";
        template.update(SQL, word.getName(), word.getTitle(), word.getDescription(), word.getWriter(), word.getReleaseDate(), word.getWordId());
	}

	@Override
	public void setDeleteWord(String wordId) {
		String SQL = "DELETE from Word where w_wordId = ? ";
        this.template.update(SQL, wordId);
		
	}
}
