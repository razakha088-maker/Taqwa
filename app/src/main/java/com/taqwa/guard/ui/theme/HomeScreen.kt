package com.taqwa.guard.ui.theme

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun HomeScreen() {

    var currentQuote by remember { mutableStateOf(0) }
    var isBangla by remember { mutableStateOf(true) }

    val banglaQuotes = listOf(
        "রাসূলুল্লাহ ﷺ বলেছেন:\n\"দুই চোখের জিনা হলো (হারাম জিনিসের দিকে) তাকানো।\"\n— সহিহ বুখারি ৬২৪৩",
        "\"মুমিন পুরুষদের বলুন, তারা যেন তাদের দৃষ্টিকে সংযত রাখে এবং তাদের লজ্জাস্থানের হেফাজত করে।\"\n— সূরা নূর ২৪:৩০",
        "আলী ইবনে আবু তালিব (রা.) থেকে বর্ণিত:\nরাসূলুল্লাহ ﷺ বলেছেন:\n\"হে আলী! এক দৃষ্টির পর আরেক দৃষ্টি দিও না।\"\n— সুনানে আবু দাউদ ২১৪৯",
        "জারির ইবনে আব্দুল্লাহ (রা.) থেকে বর্ণিত:\nরাসূলুল্লাহ ﷺ বলেছেন:\n\"তোমার দৃষ্টি ফিরিয়ে নাও।\"\n— সহিহ মুসলিম ২১৫৯",
        "\"মুমিন নারীদেরকে বলুন তারা যেন তাদের দৃষ্টিকে সংযত রাখে এবং তাদের লজ্জাস্থানের হেফাজত করে।\"\n— সূরা নূর ২৪:৩১"
    )

    val englishQuotes = listOf(
        "The Messenger of Allah ﷺ said:\n\"The zina of the eyes is looking at what is unlawful.\"\n— Sahih al-Bukhari 6243",
        "\"Tell the believing men to lower their gaze and guard their private parts.\"\n— Surah An-Nur 24:30",
        "Ali ibn Abi Talib (ra) reported:\nThe Messenger of Allah ﷺ said:\n\"O Ali! Do not follow one glance with another.\"\n— Sunan Abi Dawud 2149",
        "Jarir ibn Abdullah (ra) reported:\nThe Messenger of Allah ﷺ said:\n\"Turn your gaze away.\"\n— Sahih Muslim 2159",
        "\"And tell the believing women to lower their gaze and guard their private parts.\"\n— Surah An-Nur 24:31"
    )

    val quotes = if (isBangla) banglaQuotes else englishQuotes

    LaunchedEffect(isBangla) {
        while (true) {
            delay(6000)
            currentQuote = (currentQuote + 1) % quotes.size
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF07120A)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF17351D),
                            Color(0xFF0B1C10),
                            Color(0xFF07120A)
                        )
                    )
                )
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "☪",
                fontSize = 48.sp,
                color = Color(0xFF6CFF72),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "TAQWA",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF122218)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    AnimatedContent(
                        targetState = currentQuote,
                        transitionSpec = {
                            (
                                slideInHorizontally { width -> width } +
                                    fadeIn()
                            ).togetherWith(
                                slideOutHorizontally { width -> -width } +
                                    fadeOut()
                            )
                        },
                        label = "quote_transition"
                    ) { index ->

                        Text(
                            text = quotes[index],
                            color = Color.White,
                            fontSize = 16.sp,
                            lineHeight = 25.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "${currentQuote + 1} / ${quotes.size}",
                            color = Color(0xFF6CFF72),
                            fontSize = 14.sp
                        )

                        Row {

                            Text(
                                text = "বাংলা",
                                color = if (isBangla)
                                    Color(0xFF6CFF72)
                                else
                                    Color.Gray,
                                modifier = Modifier.clickable {
                                    isBangla = true
                                    currentQuote = 0
                                }
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = "English",
                                color = if (!isBangla)
                                    Color(0xFF6CFF72)
                                else
                                    Color.Gray,
                                modifier = Modifier.clickable {
                                    isBangla = false
                                    currentQuote = 0
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Protection Status",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF122218)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "PROTECTED",
                        color = Color(0xFF6CFF72),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Taqwa Guard is protecting your device",
                        color = Color.LightGray,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Statistics",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                StatCard(
    modifier = Modifier.weight(1f),
    number = "0",
    label = "Images"
)

StatCard(
    modifier = Modifier.weight(1f),
    number = "0",
    label = "Videos"
)
               
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                StatCard(
    modifier = Modifier.weight(1f),
    number = "0",
    label = "Detections"
)

StatCard(
    modifier = Modifier.weight(1f),
    number = "0m",
    label = "Today"
)
                
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Detection Mode",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            ActionCard(
                title = "Explicit Protection",
                description = "Detect and protect against explicit content."
            )

            Spacer(modifier = Modifier.height(12.dp))

            ActionCard(
                title = "Women Detection",
                description = "Detect female subjects according to your protection settings."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Quick Actions",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                QuickCard(
                    modifier = Modifier.weight(1f),
                    title = "Quick Toggle"
                )

                QuickCard(
                    modifier = Modifier.weight(1f),
                    title = "Settings"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    number: String,
    label: String
) {
   
    
) {

    Card(
        modifier = Modifier
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF122218)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = number,
                color = Color(0xFF6CFF72),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = Color.LightGray,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun ActionCard(
    title: String,
    description: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF122218)
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = title,
                color = Color(0xFF6CFF72),
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = description,
                color = Color.LightGray,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun QuickCard(
    modifier: Modifier = Modifier,
    title: String
) {

    Card(
        modifier = modifier.height(90.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF122218)
        )
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }
}
