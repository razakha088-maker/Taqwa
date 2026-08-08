package com.taqwa.guard.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF07120A)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF16331C),
                                Color(0xFF0B1C10),
                                Color(0xFF07120A)
                            )
                        )
                    )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "☪",
                        fontSize = 54.sp,
                        color = Color(0xFF6CFF72)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "TAQWA",
                        color = Color.White,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Card{Column(
    modifier = Modifier.padding(18.dp)
) {

    val quotes = listOf(var currentQuote by remember {
    mutableStateOf(0)
}

LaunchedEffect(Unit) {
    while (true) {
        delay(6000)
        currentQuote = (currentQuote + 1) % quotes.size
    }
}
        "রাসূলুল্লাহ ﷺ বলেছেন:\n\"দুই চোখের জিনা হলো (হারাম জিনিসের দিকে) তাকানো।\"\n— সহিহ বুখারি ৬২৪৩",

        "\"মুমিন পুরুষদের বলুন, তারা যেন তাদের দৃষ্টিকে সংযত রাখে এবং তাদের লজ্জাস্থানের হেফাজত করে।\"\n— সূরা নূর ২৪:৩০",

        "রাসূলুল্লাহ ﷺ বলেছেন:\n\"হে আলী! এক দৃষ্টির পর আরেক দৃষ্টি দিও না। প্রথমটি ক্ষমাযোগ্য, দ্বিতীয়টি নয়।\"\n— সুনানে আবু দাউদ ২১৪৯",

        "আমি আকস্মিক দৃষ্টি সম্পর্কে জিজ্ঞাসা করলে রাসূল ﷺ বললেন:\n\"তোমার দৃষ্টি ফিরিয়ে নাও।\"\n— সহিহ মুসলিম ২১৫৯",

        "\"মুমিন নারীদেরকে বলুন, তারা যেন তাদের দৃষ্টিকে সংযত রাখে এবং তাদের লজ্জাস্থানের হেফাজত করে।\"\n— সূরা নূর ২৪:৩১"
    )

    Text(
        text = text = quotes[currentQuote]
        fontSize = 16.sp,
        color = Color.White,
        lineHeight = 24.sp
    )
}
                        
                    ) {

                        Column(
                            modifier = Modifier.padding(18.dp)
                        ) {

                            Text(
                                text = "Quote Slider Coming...",
                                style = MaterialTheme.typography.titleMedium
                            )

                        }

                    }

                }

            }

        }

    }

}


    import androidx.compose.runtime.*
import kotlinx.coroutines.delay

    


    Spacer(modifier = Modifier.height(16.dp))
Text(
    text = "${currentQuote + 1} / ${quotes.size}",
    color = Color(0xFF6CFF72),
    fontSize = 14.sp
)
