package com.example.smartlifeacademy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartlifeacademy.data.model.Lesson
import com.example.smartlifeacademy.ui.theme.SmartLifeAcademyTheme
import com.example.smartlifeacademy.viewmodel.CourseViewModel

private val NavyDeep = Color(0xFF0A0E1A)
private val CardBg = Color(0xCC0F1630)
private val AccentLight = Color(0xFF6495ED)
private val TextPrimary = Color(0xFFE8ECF4)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen(
    courseId: String,
    onLessonClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    val viewModel: CourseViewModel = viewModel()
    val course by viewModel.selectedCourse.collectAsState()
    val lessons by viewModel.lessons.collectAsState()

    LaunchedEffect(courseId) {
        viewModel.loadCourseDetails(courseId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(course?.title ?: "Course Details", fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = NavyDeep,
                    titleContentColor = TextPrimary,
                    navigationIconContentColor = TextPrimary
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    Brush.verticalGradient(
                        listOf(NavyDeep, Color(0xFF0D1625))
                    )
                )
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                course?.let { currentCourse ->
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = CardBg),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(modifier = Modifier.padding(20.dp)) {
                                Text(
                                    text = currentCourse.title,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Instructor: ${currentCourse.instructor}",
                                    fontSize = 14.sp,
                                    color = AccentLight
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = currentCourse.description,
                                    fontSize = 14.sp,
                                    color = Color.LightGray
                                )
                            }
                        }
                    }
                }

                item {
                    Text(
                        text = "Course Modules & Lessons",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }

                items(lessons) { lesson ->
                    LessonCard(lesson = lesson, onClick = { onLessonClick(lesson.id) })
                }
            }
        }
    }
}

@Composable
fun LessonCard(lesson: Lesson, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = CardBg),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = if (lesson.isCompleted) Icons.Outlined.CheckCircle else Icons.Outlined.PlayCircle,
                    contentDescription = null,
                    tint = if (lesson.isCompleted) Color(0xFF1D9E75) else AccentLight
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = lesson.title,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextPrimary
                    )
                    Text(
                        text = if (lesson.isCompleted) "Completed" else "Tap to start lesson",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseDetailScreenPreview() {
    SmartLifeAcademyTheme {
        CourseDetailScreen(
            courseId = "c1",
            onLessonClick = {},
            onBackClick = {}
        )
    }
}
