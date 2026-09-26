package com.example.smartlifeacademy.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlifeacademy.data.model.Course
import com.example.smartlifeacademy.data.model.Lesson
import com.example.smartlifeacademy.data.repository.CourseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CourseViewModel : ViewModel() {
    private val repository = CourseRepository()

    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses: StateFlow<List<Course>> = _courses.asStateFlow()

    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse.asStateFlow()

    private val _lessons = MutableStateFlow<List<Lesson>>(emptyList())
    val lessons: StateFlow<List<Lesson>> = _lessons.asStateFlow()

    private val _selectedLesson = MutableStateFlow<Lesson?>(null)
    val selectedLesson: StateFlow<Lesson?> = _selectedLesson.asStateFlow()

    var message = mutableStateOf("")

    init {
        loadEnrolledCourses()
    }

    fun loadEnrolledCourses() {
        viewModelScope.launch {
            val result = repository.getEnrolledCourses()
            if (result.isSuccess) {
                _courses.value = result.getOrDefault(emptyList())
            }
        }
    }

    fun loadCourseDetails(courseId: String) {
        viewModelScope.launch {
            _selectedCourse.value = repository.getCourseById(courseId)
            _lessons.value = repository.getLessonsForCourse(courseId)
        }
    }

    fun loadLessonDetails(lessonId: String) {
        viewModelScope.launch {
            _selectedLesson.value = repository.getLessonById(lessonId)
        }
    }
}
