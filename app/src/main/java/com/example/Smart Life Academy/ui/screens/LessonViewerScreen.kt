package com.example.smartlifeacademy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.smartlifeacademy.ui.theme.SmartLifeAcademyTheme
import com.example.smartlifeacademy.viewmodel.CourseViewModel

private val NavyDeep = Color(0xFF0A0E1A)
private val CardBg = Color(0xCC0F1630)
private val AccentLight = Color(0xFF6495ED)
private val TextPrimary = Color(0xFFE8ECF4)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonViewerScreen(
    lessonId: String,
    onBackClick: () -> Unit
) {
    val viewModel: CourseViewModel = viewModel()
    val lesson by viewModel.selectedLesson.collectAsState()

    LaunchedEffect(lessonId) {
        viewModel.loadLessonDetails(lessonId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(lesson?.title ?: "Lesson Reader", fontSize = 18.sp) },
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Video Player Placeholder
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    colors = CardDefaults.cardColors(containerColor = CardBg),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Outlined.PlayCircle,
                                contentDescription = "Play Video",
                                modifier = Modifier.size(56.dp),
                                tint = AccentLight
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("Video Lecture Player", color = TextPrimary, fontSize = 14.sp)
                        }
                    }
                }

                lesson?.let { currentLesson ->
                    Text(
                        text = currentLesson.title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = CardBg),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text(
                                text = "Lesson Content & Notes",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AccentLight
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = currentLesson.content.ifBlank {
                                    "In this lesson, you will learn key concepts, best practices, and practical implementation details. Review the video lecture above and complete the exercises."
                                },
                                fontSize = 14.sp,
                                color = TextPrimary,
                                lineHeight = 22.sp
                            )
                        }
                    }

                    Button(
                        onClick = onBackClick,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Outlined.CheckCircle, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Mark as Completed & Return")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LessonViewerScreenPreview() {
    SmartLifeAcademyTheme {
        LessonViewerScreen(
            lessonId = "l1",
            onBackClick = {}
        )
    }
}
