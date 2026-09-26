package com.example.smartlifeacademy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Assignment
import androidx.compose.material.icons.outlined.UploadFile
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartlifeacademy.ui.theme.SmartLifeAcademyTheme

private val NavyDeep = Color(0xFF0A0E1A)
private val CardBg = Color(0xCC0F1630)
private val AccentLight = Color(0xFF6495ED)
private val TextPrimary = Color(0xFFE8ECF4)

private data class AssignmentItem(
    val id: String,
    val title: String,
    val courseName: String,
    val dueDate: String,
    val isSubmitted: Boolean
)

private val sampleAssignments = listOf(
    AssignmentItem("a1", "Build Compose UI Wireframe", "Android App Development", "Oct 28, 2025", false),
    AssignmentItem("a2", "Data Cleaning Project", "Data Science & Machine Learning", "Nov 02, 2025", true),
    AssignmentItem("a3", "REST API Backend Submission", "Full-Stack Web Development", "Nov 10, 2025", false)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssignmentScreen(
    onBackClick: () -> Unit
) {
    var assignments by remember { mutableStateOf(sampleAssignments) }
    var uploadStatusMessage by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Assignments & Homework", fontSize = 18.sp) },
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
                if (uploadStatusMessage.isNotBlank()) {
                    item {
                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            color = AccentLight.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = uploadStatusMessage,
                                modifier = Modifier.padding(12.dp),
                                color = AccentLight,
                                fontSize = 13.sp
                            )
                        }
                    }
                }

                items(assignments) { assignment ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = CardBg),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = assignment.title,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimary
                                )
                                Icon(Icons.Outlined.Assignment, contentDescription = null, tint = AccentLight)
                            }

                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = assignment.courseName, fontSize = 13.sp, color = AccentLight)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Due Date: ${assignment.dueDate}", fontSize = 12.sp, color = Color.LightGray)

                            Spacer(modifier = Modifier.height(14.dp))

                            if (assignment.isSubmitted) {
                                Text("Status: Submitted ✅", color = Color(0xFF1D9E75), fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                            } else {
                                OutlinedButton(
                                    onClick = {
                                        assignments = assignments.map {
                                            if (it.id == assignment.id) it.copy(isSubmitted = true) else it
                                        }
                                        uploadStatusMessage = "File uploaded for '${assignment.title}' successfully!"
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Icon(Icons.Outlined.UploadFile, contentDescription = null)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Upload & Submit File")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AssignmentScreenPreview() {
    SmartLifeAcademyTheme {
        AssignmentScreen(onBackClick = {})
    }
}
