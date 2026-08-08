package com.taqwa.guard.ui.theme

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF06140F),
                        Color(0xFF09251A),
                        Color(0xFF03100C)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // --------------------------------
            // TAQWA HEADER
            // --------------------------------

            Text(
                text = "☾",
                color = Color(0xFFE5C96A),
                fontSize = 28.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "TAQWA",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 5.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Guard your gaze. Protect your soul.",
                color = Color(0xFFB8C8C0),
                fontSize = 13.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // --------------------------------
            // QURAN & HADITH SLIDER
            // --------------------------------

            QuranHadithCard()


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // --------------------------------
            // PROTECTION STATUS
            // --------------------------------

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF091B15)
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {

                    Text(
                        text = "Protection Status",
                        color = Color(0xFFB8C8C0),
                        fontSize = 14.sp
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "PROTECTED",
                        color = Color(0xFF8FE36F),
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "✓  Taqwa Guard is protecting your device",
                        color = Color(0xFFDCE8E2),
                        fontSize = 13.sp
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // --------------------------------
            // STATISTICS
            // --------------------------------

            Text(
                text = "Statistics",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                StatisticCard(
                    title = "Images",
                    value = "0",
                    modifier = Modifier.weight(1f)
                )

                StatisticCard(
                    title = "Videos",
                    value = "0",
                    modifier = Modifier.weight(1f)
                )

                StatisticCard(
                    title = "Blocked",
                    value = "0",
                    modifier = Modifier.weight(1f)
                )

                StatisticCard(
                    title = "Time",
                    value = "0m",
                    modifier = Modifier.weight(1f)
                )
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // --------------------------------
            // QUICK ACTIONS
            // --------------------------------

            Text(
                text = "Quick Actions",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                ActionCard(
                    title = "Quick\nToggle",
                    modifier = Modifier.weight(1f)
                )

                ActionCard(
                    title = "Sensitivity",
                    modifier = Modifier.weight(1f)
                )

                ActionCard(
                    title = "Allowed\nApps",
                    modifier = Modifier.weight(1f)
                )

                ActionCard(
                    title = "Statistics",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


// ======================================================
// QURAN & HADITH CARD
// ======================================================

@Composable
fun QuranHadithCard() {

    val messages = listOf(

        "সূরা নূর : ৩০\n\nমুমিন পুরুষদের বলুন, তারা যেন তাদের দৃষ্টি সংযত রাখে এবং তাদের লজ্জাস্থানের হেফাজত করে।",

        "সূরা নূর : ৩১\n\nমুমিন নারীদের বলুন, তারা যেন তাদের দৃষ্টি সংযত রাখে এবং তাদের লজ্জাস্থানের হেফাজত করে।",

        "আবু হুরায়রা (রাঃ) থেকে বর্ণিত\n\nরাসূলুল্লাহ ﷺ বলেছেন: যে ব্যক্তি আল্লাহ ও পরকালের প্রতি ঈমান রাখে, সে যেন উত্তম কথা বলে অথবা নীরব থাকে।",

        "রাসূলুল্লাহ ﷺ বলেছেন\n\nলজ্জা ঈমানের একটি শাখা।",

        "আল্লাহ বলেন\n\nনিশ্চয়ই আল্লাহ মুত্তাকীদের সঙ্গে আছেন।"
    )

    var currentPage by remember {
        mutableIntStateOf(0)
    }

    var dragAmount by remember {
        mutableFloatStateOf(0f)
    }


    // Automatic slide
    LaunchedEffect(Unit) {

        while (true) {

            delay(6000)

            currentPage =
                (currentPage + 1) % messages.size
        }
    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {

                detectHorizontalDragGestures(

                    onHorizontalDrag = { _, amount ->

                        dragAmount += amount
                    },

                    onDragEnd = {

                        if (dragAmount < -80f) {

                            currentPage =
                                (currentPage + 1) % messages.size

                        } else if (dragAmount > 80f) {

                            currentPage =
                                if (currentPage == 0) {
                                    messages.lastIndex
                                } else {
                                    currentPage - 1
                                }
                        }

                        dragAmount = 0f
                    }
                )
            },

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF102D20),
                            Color(0xFF071A13),
                            Color(0xFF020B08)
                        )
                    )
                )
                .padding(20.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "❝",
                    color = Color(0xFF9BEA7C),
                    fontSize = 34.sp
                )

                Text(
                    text = "QURAN & HADITH",
                    color = Color(0xFFE5C96A),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )


                // Text transition
                Crossfade(
                    targetState = currentPage,
                    label = "QuranHadithTransition"
                ) { page ->

                    Text(
                        text = messages[page],
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        fontSize = 16.sp,
                        lineHeight = 27.sp,
                        textAlign = TextAlign.Center
                    )
                }


                Spacer(
                    modifier = Modifier.height(14.dp)
                )


                Text(
                    text = "←  Swipe  →",
                    color = Color(0xFF9FB5AC),
                    fontSize = 12.sp
                )


                Spacer(
                    modifier = Modifier.height(10.dp)
                )


                // Page indicators
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {

                    messages.indices.forEach { index ->

                        Box(
                            modifier = Modifier
                                .padding(horizontal = 3.dp)
                                .size(
                                    if (index == currentPage) {
                                        9.dp
                                    } else {
                                        6.dp
                                    }
                                )
                                .background(
                                    color =
                                        if (index == currentPage) {
                                            Color(0xFF9BEA7C)
                                        } else {
                                            Color(0xFF526B61)
                                        },

                                    shape = RoundedCornerShape(50.dp)
                                )
                        )
                    }
                }
            }
        }
    }
}


// ======================================================
// STATISTIC CARD
// ======================================================

@Composable
fun StatisticCard(
    title: String,
    value: String,
    modifier: Modifier
) {

    Card(
        modifier = modifier.height(105.dp),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF091B15)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = value,
                color = Color(0xFF8FE36F),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = title,
                color = Color(0xFFC5D2CC),
                fontSize = 11.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


// ======================================================
// ACTION CARD
// ======================================================

@Composable
fun ActionCard(
    title: String,
    modifier: Modifier
) {

    Card(
        modifier = modifier.height(90.dp),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0B2118)
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
