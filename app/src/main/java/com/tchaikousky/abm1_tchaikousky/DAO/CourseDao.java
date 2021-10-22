package com.tchaikousky.abm1_tchaikousky.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.tchaikousky.abm1_tchaikousky.Entities.Course;

import java.util.List;

@Dao
public interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM COURSE_TABLE ORDER BY courseID ASC")
    List<Course> getAllCourses();

    @Query("SELECT * FROM COURSE_TABLE WHERE courseID = :id ")
    List<Course> getSingleCourse(int id);

    @Query("SELECT * FROM COURSE_TABLE WHERE termID = :termID ")
    List<Course> getTermCourses(int termID);
}
