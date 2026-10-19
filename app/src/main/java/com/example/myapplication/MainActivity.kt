
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val OrangeDark = Color(0xFFB84B12)
private val Orange = Color(0xFFF58235)
private val OrangeLight = Color(0xFFFFE7D5)
private val Cream = Color(0xFFFFF8F1)
private val White = Color(0xFFFFFFFF)
private val Dark = Color(0xFF30251F)
private val Muted = Color(0xFF786A61)
private val Border = Color(0xFFF0DFD1)
private val Green = Color(0xFF38836A)
private val Purple = Color(0xFF7561B5)
private val Blue = Color(0xFF467CB8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Cream
                ) {
                    AcademicDashboard()
                }
            }
        }
    }
}

data class Course(
    val code: String,
    val name: String,
    val lecturer: String,
    val schedule: String,
    val description: String,
    val meeting: String,
    val accent: Color,
    val progress: Float
)

@Composable
fun AcademicDashboard() {
    val courses = listOf(
        Course(
            "IF501",
            "Pemrograman Mobile",
            "Dosen Pengampu",
            "Senin • 08.00–09.40",
            "Pengembangan aplikasi Android dengan Kotlin dan Jetpack Compose.",
            "08",
            Orange,
            0.75f
        ),
        Course(
            "IF502",
            "Basis Data",
            "Dosen Pengampu",
            "Senin • 10.00–11.40",
            "Perancangan basis data, relasi tabel, SQL, dan pengelolaan informasi.",
            "07",
            Blue,
            0.65f
        ),
        Course(
            "IF503",
            "Rekayasa Perangkat Lunak",
            "Dosen Pengampu",
            "Selasa • 08.00–09.40",
            "Analisis kebutuhan, desain sistem, pengujian, dan pengembangan perangkat lunak.",
            "06",
            Green,
            0.55f
        ),
        Course(
            "IF504",
            "Interaksi Manusia dan Komputer",
            "Dosen Pengampu",
            "Rabu • 10.00–11.40",
            "Prinsip interaksi pengguna, aksesibilitas, dan evaluasi antarmuka.",
            "05",
            Purple,
            0.45f
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderSection()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 1000.dp)
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 20.dp, vertical = 22.dp)
        ) {
            // SAPAAN
            Text(
                text = "Halo, Mahasiswa! 👋",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Dark
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = "Semangat belajar dan raih prestasi hari ini.",
                fontSize = 14.sp,
                color = Muted,
                lineHeight = 21.sp
            )

            Spacer(Modifier.height(24.dp))

            // IPK CARD
            IpkCard()

            Spacer(Modifier.height(27.dp))

            SectionHeading(
                title = "Ringkasan Akademik",
                subtitle = "Pantau progres perkuliahanmu"
            )

            Spacer(Modifier.height(14.dp))

            SummaryGrid()

            Spacer(Modifier.height(28.dp))

            SectionHeading(
                title = "Mata Kuliah",
                subtitle = "Daftar mata kuliah semester ini"
            )

            Spacer(Modifier.height(14.dp))

            CourseGrid(courses)

            Spacer(Modifier.height(24.dp))

            // TOMBOL
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = OrangeDark
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 3.dp
                )
            ) {
                Text(
                    text = "Lihat Jadwal Lengkap   →",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = White
                )
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = "KAMPUSKU",
                modifier = Modifier.fillMaxWidth(),
                color = Muted,
                fontSize = 12.sp
            )

            Text(
                text = "Dashboard Akademik • 2026/2027",
                modifier = Modifier.fillMaxWidth(),
                color = Muted,
                fontSize = 11.sp
            )

            Spacer(Modifier.height(10.dp))
        }
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(OrangeDark)
            .padding(horizontal = 24.dp, vertical = 26.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White.copy(alpha = 0.17f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "K",
                    color = White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(Modifier.width(12.dp))

            Column {
                Text(
                    text = "KAMPUSKU",
                    color = White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.2.sp
                )

                Text(
                    text = "STUDENT ACADEMIC PORTAL",
                    color = White.copy(alpha = 0.85f),
                    fontSize = 9.sp,
                    letterSpacing = 1.sp
                )
            }
        }

        Spacer(Modifier.height(25.dp))

        Text(
            text = "Dashboard Akademik",
            color = White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 35.sp
        )

        Spacer(Modifier.height(7.dp))

        Text(
            text = "Satu tempat untuk memantau perjalanan akademikmu.",
            color = White.copy(alpha = 0.93f),
            fontSize = 14.sp,
            lineHeight = 21.sp
        )

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(Color.White.copy(alpha = 0.15f))
                .padding(horizontal = 14.dp, vertical = 9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .background(Color(0xFFFFD6A5), CircleShape)
            )

            Spacer(Modifier.width(8.dp))

            Text(
                text = "Semester 5  •  2026/2027",
                color = White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun IpkCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        border = BorderStroke(1.dp, Border)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "INDEKS PRESTASI KUMULATIF",
                    color = Muted,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp,
                    lineHeight = 15.sp
                )

                Spacer(Modifier.height(9.dp))

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "3.85",
                        color = OrangeDark,
                        fontSize = 38.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 43.sp
                    )

                    Spacer(Modifier.width(7.dp))

                    Text(
                        text = "/ 4.00",
                        color = Muted,
                        fontSize = 14.sp
                    )
                }

                Spacer(Modifier.height(7.dp))

                Text(
                    text = "Pertahankan prestasimu!",
                    color = Green,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .size(74.dp)
                    .clip(CircleShape)
                    .background(OrangeLight),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "★",
                    color = OrangeDark,
                    fontSize = 38.sp
                )
            }
        }
    }
}

@Composable
fun SectionHeading(
    title: String,
    subtitle: String
) {
    Column {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Dark,
            lineHeight = 27.sp
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = subtitle,
            fontSize = 13.sp,
            color = Muted,
            lineHeight = 19.sp
        )
    }
}

@Composable
fun SummaryGrid() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {
        val wide = maxWidth >= 500.dp

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val items = listOf(
                Triple("Total SKS", "92", "SKS ditempuh"),
                Triple("Mata Kuliah", "4", "Mata kuliah"),
                Triple("Kehadiran", "96%", "Persentase hadir"),
                Triple("Semester", "5", "Tahun 2026/2027")
            )

            items.chunked(if (wide) 2 else 1).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    rowItems.forEachIndexed { index, item ->
                        val originalIndex =
                            items.indexOf(item)

                        SummaryCard(
                            title = item.first,
                            value = item.second,
                            detail = item.third,
                            accent = listOf(
                                Orange,
                                Blue,
                                Green,
                                Purple
                            )[originalIndex],
                            modifier = Modifier.weight(1f)
                        )
                    }

                    if (wide && rowItems.size == 1) {
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun SummaryCard(
    title: String,
    value: String,
    detail: String,
    accent: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        border = BorderStroke(1.dp, Border)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(34.dp)
                    .height(5.dp)
                    .clip(CircleShape)
                    .background(accent)
            )

            Spacer(Modifier.height(13.dp))

            Text(
                text = title,
                color = Muted,
                fontSize = 12.sp,
                lineHeight = 17.sp
            )

            Spacer(Modifier.height(5.dp))

            Text(
                text = value,
                color = Dark,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 31.sp
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = detail,
                color = Muted,
                fontSize = 11.sp,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
fun CourseGrid(courses: List<Course>) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {
        val wide = maxWidth >= 500.dp

        Column(
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            courses.chunked(if (wide) 2 else 1).forEach { rowCourses ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    rowCourses.forEach { course ->
                        CourseCard(
                            course = course,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    if (wide && rowCourses.size == 1) {
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun CourseCard(
    course: Course,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        border = BorderStroke(1.dp, Border),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(course.accent.copy(alpha = 0.13f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = course.code.takeLast(2),
                        color = course.accent,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(Modifier.width(11.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = course.code,
                        color = course.accent,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = course.meeting.let { "Pertemuan $it" },
                        color = Muted,
                        fontSize = 10.sp
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = course.name,
                color = Dark,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 23.sp
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = course.description,
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 20.sp
            )

            Spacer(Modifier.height(17.dp))

            HorizontalDivider(color = Border)

            Spacer(Modifier.height(12.dp))

            Text(
                text = "JADWAL PERKULIAHAN",
                color = course.accent,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.4.sp
            )

            Spacer(Modifier.height(5.dp))

            Text(
                text = course.schedule,
                color = Dark,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 19.sp
            )

            Spacer(Modifier.height(5.dp))

            Text(
                text = course.lecturer,
                color = Muted,
                fontSize = 12.sp
            )

            Spacer(Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Progres belajar",
                    color = Muted,
                    fontSize = 11.sp
                )

                Spacer(Modifier.weight(1f))

                Text(
                    text = "${(course.progress * 100).toInt()}%",
                    color = course.accent,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(7.dp))

            LinearProgressIndicator(
                progress = { course.progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(CircleShape),
                color = course.accent,
                trackColor = course.accent.copy(alpha = 0.13f)
            )
        }
    }
}
