package com.example.smartlifeacademy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CardMembership
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartlifeacademy.ui.theme.SmartLifeAcademyTheme

private val NavyDeep = Color(0xFF0A0E1A)
private val CardBg = Color(0xCC0F1630)
private val AccentBlue = Color(0xFF3A6BC8)
private val AccentLight = Color(0xFF6495ED)
private val TextPrimary = Color(0xFFE8ECF4)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Student Profile & Grades", fontSize = 18.sp) },
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
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // User Avatar
                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .background(AccentBlue.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = AccentLight
                    )
                }

                Text("Alex Mercer", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                Text("Role: Student | ID: SLA-2025-88", fontSize = 13.sp, color = AccentLight)

                Spacer(modifier = Modifier.height(4.dp))

                // Grades & Certificates Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = CardBg),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Outlined.Grade, contentDescription = null, tint = AccentLight)
                            Spacer(modifier = Modifier.width(10.dp))
                            Text("Current Grades & GPA", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("• Android Development: A (94%)", color = TextPrimary, fontSize = 14.sp)
                        Text("• Full-Stack Web: A- (91%)", color = TextPrimary, fontSize = 14.sp)
                        Text("• Data Science: B+ (88%)", color = TextPrimary, fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Overall GPA: 3.84 / 4.0", color = AccentLight, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = CardBg),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Outlined.CardMembership, contentDescription = null, tint = AccentLight)
                            Spacer(modifier = Modifier.width(10.dp))
                            Text("Earned Certificates 📜", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("1. Certificate of Completion - Mobile UI Design", color = TextPrimary, fontSize = 14.sp)
                        Text("2. Certificate of Achievement - Jetpack Compose Essentials", color = TextPrimary, fontSize = 14.sp)
                    }
                }

                Button(
                    onClick = onLogoutClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE24B4A)),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Logout from Smart Life Academy")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    SmartLifeAcademyTheme {
        ProfileScreen(
            onBackClick = {},
            onLogoutClick = {}
        )
    }
}
