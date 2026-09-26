package com.example.smartlifeacademy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Assignment
import androidx.compose.material.icons.outlined.Campaign
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartlifeacademy.data.model.Course
import com.example.smartlifeacademy.ui.theme.SmartLifeAcademyTheme
import com.example.smartlifeacademy.viewmodel.CourseViewModel

private val DashboardNavy = Color(0xFF0A0E1A)
private val DashboardBlue = Color(0xFF3A6BC8)
private val DashboardLight = Color(0xFF6495ED)
private val DashboardText = Color(0xFFE8ECF4)
private val CardBg = Color(0xCC0F1630)

@Composable
fun DashboardScreen(
    onCourseClick: (String) -> Unit = {},
    onAssignmentsClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    val courseViewModel: CourseViewModel = viewModel()
    val courses by courseViewModel.courses.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        DashboardNavy,
                        Color(0xFF0D1625)
                    )
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Smart Life Academy",
                            color = DashboardText,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Welcome back, Student 🎓",
                            color = DashboardLight,
                            fontSize = 14.sp
                        )
                    }
                    IconButton(onClick = onProfileClick) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile",
                            tint = DashboardLight
                        )
                    }
                }
            }

            // Overview Row
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onAssignmentsClick() },
                        colors = CardDefaults.cardColors(containerColor = DashboardBlue.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Icon(Icons.AutoMirrored.Outlined.Assignment, contentDescription = null, tint = DashboardLight)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("Pending Tasks", color = DashboardText, fontSize = 12.sp)
                            Text("3 Due Soon", fontWeight = FontWeight.Bold, color = DashboardLight, fontSize = 18.sp)
                        }
                    }

                    Card(
                        modifier = Modifier.weight(1f),
                        colors = CardDefaults.cardColors(containerColor = DashboardBlue.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Icon(Icons.Outlined.School, contentDescription = null, tint = DashboardLight)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("Enrolled Courses", color = DashboardText, fontSize = 12.sp)
                            Text("${courses.size} Active", fontWeight = FontWeight.Bold, color = DashboardLight, fontSize = 18.sp)
                        }
                    }
                }
            }

            // Enrolled Courses Section
            item {
                Text(
                    text = "Enrolled Courses",
                    color = DashboardText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            items(courses) { course ->
                CourseCard(course = course, onClick = { onCourseClick(course.id) })
            }

            // Recent Announcements Section
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Recent Announcements 📢",
                    color = DashboardText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = CardBg),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Outlined.Campaign, contentDescription = null, tint = DashboardLight)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Midterm Exam Schedule Released", fontWeight = FontWeight.SemiBold, color = DashboardText)
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            "Check your course page for specific submission dates and guidelines.",
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )
                    }
                }
            }

            // Navigation Buttons
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = onAssignmentsClick,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.AutoMirrored.Outlined.Assignment, contentDescription = null)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Assignments")
                    }

                    OutlinedButton(
                        onClick = onProfileClick,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Outlined.Person, contentDescription = null)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Profile")
                    }
                }
            }
        }
    }
}

@Composable
fun CourseCard(course: Course, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = CardBg),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = course.title,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = DashboardText
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Instructor: ${course.instructor}",
                fontSize = 13.sp,
                color = DashboardLight
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Progress: ${(course.progress * 100).toInt()}%",
                    fontSize = 12.sp,
                    color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            LinearProgressIndicator(
                progress = { course.progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = DashboardLight,
                trackColor = DashboardNavy
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    SmartLifeAcademyTheme {
        DashboardScreen()
    }
}
