package com.tchaikousky.abm1_tchaikousky.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tchaikousky.abm1_tchaikousky.Database.CourseRepository;
import com.tchaikousky.abm1_tchaikousky.Database.TermRepository;
import com.tchaikousky.abm1_tchaikousky.Entities.Course;
import com.tchaikousky.abm1_tchaikousky.Entities.Term;
import com.tchaikousky.abm1_tchaikousky.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseList extends AppCompatActivity {
    private int termID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Courses");
        termID = getIntent().getIntExtra("termID", 0);
        CourseRepository repository = new CourseRepository(getApplication());
        ArrayList<Course> courses = (ArrayList<Course>) repository.getTermCourses(getIntent().getIntExtra("termID", 0));
        RecyclerView recyclerView = findViewById(R.id.courseRecyclerView);
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setCourses(courses);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            case R.id.homeScreen:
                Intent home = new Intent(CourseList.this, MainActivity.class);
                startActivity(home);
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.course_menu, menu);
        menu.removeItem(R.id.share);
        return true;
    }

    public void addCourse(View view) {
        Intent intent = new Intent(CourseList.this, AddEditViewCourse.class);
        intent.putExtra("termID", termID);
        startActivity(intent);
    }
}