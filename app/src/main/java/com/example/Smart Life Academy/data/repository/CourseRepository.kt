package com.example.smartlifeacademy.data.repository

import com.example.smartlifeacademy.data.model.Course
import com.example.smartlifeacademy.data.model.Lesson
import com.example.smartlifeacademy.data.remote.SupabaseClient

class CourseRepository {
    private val client = SupabaseClient.client

    // Sample / initial course data
    private val sampleCourses = listOf(
        Course(
            id = "c1",
            title = "Android App Development with Jetpack Compose",
            description = "Master modern Android UI development using Kotlin and Jetpack Compose from scratch.",
            instructor = "Dr. Alan Turing",
            progress = 0.65f
        ),
        Course(
            id = "c2",
            title = "Data Science & Machine Learning",
            description = "Learn Python, pandas, scikit-learn, and neural networks for real-world AI applications.",
            instructor = "Prof. Ada Lovelace",
            progress = 0.30f
        ),
        Course(
            id = "c3",
            title = "Full-Stack Web Development",
            description = "Build responsive web applications with modern frontend frameworks and cloud backends.",
            instructor = "Sarah Connor",
            progress = 0.85f
        ),
        Course(
            id = "c4",
            title = "UI/UX Design Systems",
            description = "Design intuitive digital products with Figma, component libraries, and user research.",
            instructor = "Grace Hopper",
            progress = 0.10f
        )
    )

    private val sampleLessons = mapOf(
        "c1" to listOf(
            Lesson("l1", "c1", "Introduction to Jetpack Compose", content = "Learn the basics of declarative UI programming in Kotlin.", isCompleted = true),
            Lesson("l2", "c1", "Layouts and Modifiers", content = "Master Column, Row, Box, and Modifier chains.", isCompleted = true),
            Lesson("l3", "c1", "State Management & ViewModel", content = "Understand remember, StateFlow, and ViewModel lifecycle.", isCompleted = true),
            Lesson("l4", "c1", "Navigation & Deep Linking", content = "Implement NavHost, NavController, and argument passing.", isCompleted = false),
            Lesson("l5", "c1", "Connecting to Supabase Backend", content = "Integrate authentication, database, and storage APIs.", isCompleted = false)
        ),
        "c2" to listOf(
            Lesson("l6", "c2", "Python Basics for Data Science", content = "Overview of data types, loops, and NumPy arrays.", isCompleted = true),
            Lesson("l7", "c2", "Data Cleaning with Pandas", content = "Handling missing values, filtering, and aggregation.", isCompleted = false),
            Lesson("l8", "c2", "Linear Regression & Classification", content = "Build supervised learning models with Scikit-learn.", isCompleted = false)
        ),
        "c3" to listOf(
            Lesson("l9", "c3", "HTML5 & Modern CSS", content = "Semantic HTML, Flexbox, and CSS Grid layouts.", isCompleted = true),
            Lesson("l10", "c3", "JavaScript ES6+ Fundamentals", content = "Async/await, promises, and functional array methods.", isCompleted = true),
            Lesson("l11", "c3", "REST APIs & Database Integration", content = "Designing RESTful endpoints and connecting SQL databases.", isCompleted = true)
        ),
        "c4" to listOf(
            Lesson("l12", "c4", "Design Thinking & Wireframing", content = "Low-fidelity wireframes and user flow diagrams.", isCompleted = true),
            Lesson("l13", "c4", "Building Figma Component Libraries", content = "Design tokens, auto-layout, and interactive prototypes.", isCompleted = false)
        )
    )

    suspend fun getEnrolledCourses(): Result<List<Course>> {
        return Result.success(sampleCourses)
    }

    suspend fun getCourseById(courseId: String): Course? {
        return sampleCourses.find { it.id == courseId }
    }

    suspend fun getLessonsForCourse(courseId: String): List<Lesson> {
        return sampleLessons[courseId] ?: emptyList()
    }

    suspend fun getLessonById(lessonId: String): Lesson? {
        return sampleLessons.values.flatten().find { it.id == lessonId }
    }
}
