package com.taqwa.guard.ui.theme
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun HomeScreen() {

    val scrollState = rememberScrollState()

    val messages = listOf(
        """
        রাসূলুল্লাহ ﷺ বলেছেন:

        "দুই চোখের জিনা হলো
        (হারাম জিনিসের দিকে) তাকানো।"

        সূত্র: সহিহ বুখারি : ৬২৪৩
        """.trimIndent(),

        """
        "মুমিন পুরুষদের বলুন,
        তারা যেন তাদের দৃষ্টিকে সংযত রাখে
        এবং তাদের লজ্জাস্থানের হেফাজত করে।"

        — সূরা নূর: ৩০
        """.trimIndent(),

        """
        আলী ইবনে আবু তালিব (রা.) থেকে বর্ণিত:

        রাসূলুল্লাহ ﷺ বলেছেন,
        "হে আলী! এক দৃষ্টির পর আরেক দৃষ্টি দিও না।
        কারণ প্রথম দৃষ্টি তোমার জন্য ক্ষমাযোগ্য,
        কিন্তু দ্বিতীয়টি নয়।"

        সূত্র: সুনানে আবু দাউদ : ২১৪৯
        """.trimIndent(),

        """
        জারির ইবনে আব্দুল্লাহ (রা.) থেকে বর্ণিত:

        আমি রাসূলুল্লাহ ﷺ-কে আকস্মিক দৃষ্টি
        সম্পর্কে জিজ্ঞাসা করলে তিনি বললেন,

        "তোমার দৃষ্টি ফিরিয়ে নাও।"

        সূত্র: সহিহ মুসলিম : ২১৫৯
        """.trimIndent(),

        """
        "মুমিন নারীদেরকে বলুন
        তারা যেন তাদের দৃষ্টিকে সংযত রাখে
        এবং তাদের লজ্জাস্থানের হেফাজত করে।"

        — সূরা নূর: ৩১
        """.trimIndent()
    )

    var currentMessage by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            currentMessage =
                (currentMessage + 1) % messages.size
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF03100C),
                        Color(0xFF071A13),
                        Color(0xFF04110C)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 22.dp,
                    bottom = 24.dp
                )
        ) {

            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "☰",
                    color = Color.White,
                    fontSize = 30.sp
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "TAQWA",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 6.sp
                    )

                    Text(
                        text = "Guard your gaze. Protect your soul.",
                        color = Color(0xFFB8C9C1),
                        fontSize = 12.sp
                    )
                }

                Text(
                    text = "✓",
                    color = Color(0xFF9BEA7C),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            // Protection Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF0C241B)
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp)
                ) {

                    Text(
                        text = "●  ACTIVE",
                        color = Color(0xFF7CF58A),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "Protection is ON",
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "✓  You are safe",
                                color = Color(0xFFB9E8B9),
                                fontSize = 16.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(
                                    color = Color(0xFF1B704A),
                                    shape = RoundedCornerShape(50.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "ON",
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Detection Mode
            Text(
                text = "DETECTION MODE",
                color = Color(0xFFE5C96A),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                DetectionCard(
                    modifier = Modifier.weight(1f),
                    title = "Explicit\nContent",
                    active = true
                )

                DetectionCard(
                    modifier = Modifier.weight(1f),
                    title = "Women\nDetection",
                    active = false
                )

                DetectionCard(
                    modifier = Modifier.weight(1f),
                    title = "Both\nModes",
                    active = false
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Statistics
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                StatCard(
                    modifier = Modifier.weight(1f),
                    number = "0",
                    label = "Images\nBlurred"
                )

                StatCard(
                    modifier = Modifier.weight(1f),
                    number = "0",
                    label = "Videos\nBlurred"
                )

                StatCard(
                    modifier = Modifier.weight(1f),
                    number = "0m",
                    label = "Protected\nTime"
                )

                StatCard(
                    modifier = Modifier.weight(1f),
                    number = "0",
                    label = "Detections\nToday"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Quran / Hadith Slider
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF10261D)
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Text(
                        text = "QURAN & HADITH",
                        color = Color(0xFFE5C96A),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Crossfade(
                        targetState = currentMessage,
                        label = "message_slide"
                    ) { index ->

                        Text(
                            text = messages[index],
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.White,
                            fontSize = 16.sp,
                            lineHeight = 25.sp,
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        messages.indices.forEach { index ->

                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 3.dp)
                                    .size(
                                        if (index == currentMessage) {
                                            9.dp
                                        } else {
                                            6.dp
                                        }
                                    )
                                    .background(
                                        color =
                                            if (index == currentMessage) {
                                                Color(0xFF8BEA7A)
                                            } else {
                                                Color(0xFF557067)
                                            },
                                        shape = RoundedCornerShape(50.dp)
                                    )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Quick Actions
            Text(
                text = "QUICK ACTIONS",
                color = Color(0xFFE5C96A),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                ActionCard(
                    modifier = Modifier.weight(1f),
                    title = "⚡\nQuick Toggle"
                )

                ActionCard(
                    modifier = Modifier.weight(1f),
                    title = "☷\nSensitivity"
                )

                ActionCard(
                    modifier = Modifier.weight(1f),
                    title = "▦\nAllowed Apps"
                )

                ActionCard(
                    modifier = Modifier.weight(1f),
                    title = "▥\nStatistics"
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Bottom Navigation
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF0A1B15)
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    NavigationItem(
                        icon = "⌂",
                        label = "Home",
                        active = true
                    )

                    NavigationItem(
                        icon = "◈",
                        label = "Protection",
                        active = false
                    )

                    NavigationItem(
                        icon = "✦",
                        label = "Insights",
                        active = false
                    )

                    NavigationItem(
                        icon = "●",
                        label = "Profile",
                        active = false
                    )
                }
            }
        }
    }
}


@Composable
fun DetectionCard(
    modifier: Modifier,
    title: String,
    active: Boolean
) {

    Card(
        modifier = modifier.height(115.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (active) {
                    Color(0xFF123D2A)
                } else {
                    Color(0xFF0D1D19)
                }
        )
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = title,
                color =
                    if (active) {
                        Color(0xFFB9F6A7)
                    } else {
                        Color.White
                    },
                fontSize = 14.sp,
                fontWeight =
                    if (active) {
                        FontWeight.Bold
                    } else {
                        FontWeight.Normal
                    },
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun StatCard(
    modifier: Modifier,
    number: String,
    label: String
) {

    Card(
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0D211A)
        )
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = number,
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = label,
                color = Color(0xFF9FB5AC),
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun ActionCard(
    modifier: Modifier,
    title: String
) {

    Card(
        modifier = modifier.height(95.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF101F19)
        )
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun NavigationItem(
    icon: String,
    label: String,
    active: Boolean
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = icon,
            color =
                if (active) {
                    Color(0xFF9BEA7C)
                } else {
                    Color(0xFF87958F)
                },
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            color =
                if (active) {
                    Color(0xFF9BEA7C)
                } else {
                    Color(0xFF87958F)
                },
            fontSize = 11.sp
        )
    }
}
