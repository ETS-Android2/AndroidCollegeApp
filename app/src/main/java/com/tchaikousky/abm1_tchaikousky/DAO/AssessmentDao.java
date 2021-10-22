package com.tchaikousky.abm1_tchaikousky.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.tchaikousky.abm1_tchaikousky.Entities.Assessment;

import java.util.List;

@Dao
public interface AssessmentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Assessment assessment);

    @Update
    void update(Assessment assessment);

    @Delete
    void delete(Assessment assessment);

    @Query("SELECT * FROM ASSESSMENT_TABLE WHERE courseID = :courseID ORDER BY assessmentID ASC")
    List<Assessment> getAllAssessments(int courseID);

    @Query("SELECT * FROM ASSESSMENT_TABLE WHERE assessmentID = :id ")
            List<Assessment> getSingleAssessment(int id);
}
