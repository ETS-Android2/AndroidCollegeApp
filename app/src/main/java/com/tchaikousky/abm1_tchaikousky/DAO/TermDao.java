package com.tchaikousky.abm1_tchaikousky.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.tchaikousky.abm1_tchaikousky.Entities.Term;

import java.util.List;

@Dao
public interface TermDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Term term);

    @Update
    void update(Term term);

    @Delete
    void delete(Term term);

    @Query("SELECT * FROM TERM_TABLE ORDER BY termID ASC")
    List<Term> getAllTerms();

    @Query("SELECT * FROM TERM_TABLE WHERE termID = :id ")
    List<Term> getSingleTerm(int id);
}
