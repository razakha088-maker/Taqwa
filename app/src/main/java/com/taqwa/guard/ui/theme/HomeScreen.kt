package com.taqwa.guard.ui.theme
import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


// ======================================================
// HOME SCREEN
// ======================================================

@Composable
fun HomeScreen() {

    val context = LocalContext.current

    var showSettings by remember {
        mutableStateOf(false)
    }

    var dialogTitle by remember {
        mutableStateOf("")
    }

    var dialogMessage by remember {
        mutableStateOf("")
    }

    var showActionDialog by remember {
        mutableStateOf(false)
    }

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
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(16.dp)
        ) {

            // --------------------------------
            // TAQWA HEADER
            // --------------------------------

            Text(
                text = "☾",
                color = Color(0xFFE5C96A),
                fontSize = 28.sp,
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
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
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
            )

            Text(
                text = "Guard your gaze. Protect your soul.",
                color = Color(0xFFB8C8C0),
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // --------------------------------
            // QURAN & HADITH
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
                modifier = Modifier.height(20.dp)
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
                    modifier = Modifier.weight(1f),
                    onClick = {
                        Toast.makeText(
                            context,
                            "Taqwa Guard toggle",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )

                ActionCard(
                    title = "Sensitivity",
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dialogTitle = "Sensitivity"
                        dialogMessage =
                            "Sensitivity settings will be available here."
                        showActionDialog = true
                    }
                )

                ActionCard(
                    title = "Allowed\nApps",
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dialogTitle = "Allowed Apps"
                        dialogMessage =
                            "Allowed apps settings will be available here."
                        showActionDialog = true
                    }
                )

                ActionCard(
                    title = "Settings",
                    modifier = Modifier.weight(1f),
                    onClick = {
                        showSettings = true
                    }
                )
            }


            Spacer(
                modifier = Modifier.height(24.dp)
            )


            // --------------------------------
            // BOTTOM INFORMATION
            // --------------------------------

            Text(
                text = "Taqwa Guard",
                color = Color(0xFF78968A),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }


    // ==================================================
    // SETTINGS DIALOG
    // ==================================================

    if (showSettings) {

        AlertDialog(
            onDismissRequest = {
                showSettings = false
            },

            title = {
                Text(
                    text = "Taqwa Settings",
                    fontWeight = FontWeight.Bold
                )
            },

            text = {
                Text(
                    text =
                        "Taqwa Guard settings\n\n" +
                        "• Protection status\n" +
                        "• Sensitivity\n" +
                        "• Allowed apps\n" +
                        "• Accessibility service"
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        showSettings = false
                    }
                ) {
                    Text("Close")
                }
            }
        )
    }


    // ==================================================
    // ACTION DIALOG
    // ==================================================

    if (showActionDialog) {

        AlertDialog(
            onDismissRequest = {
                showActionDialog = false
            },

            title = {
                Text(
                    text = dialogTitle,
                    fontWeight = FontWeight.Bold
                )
            },

            text = {
                Text(
                    text = dialogMessage
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        showActionDialog = false
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }
}


// ======================================================
// QURAN & HADITH CARD
// ======================================================

@Composable
fun QuranHadithCard() {

    val messages = listOf(

        "সূরা নূর : ৩০\n\n" +
                "মুমিন পুরুষদের বলুন, তারা যেন " +
                "তাদের দৃষ্টি সংযত রাখে এবং তাদের " +
                "লজ্জাস্থানের হেফাজত করে।",

        "সূরা নূর : ৩১\n\n" +
                "মুমিন নারীদের বলুন, তারা যেন " +
                "তাদের দৃষ্টি সংযত রাখে এবং তাদের " +
                "লজ্জাস্থানের হেফাজত করে।",

        "আবু হুরায়রা (রাঃ) থেকে বর্ণিত\n\n" +
                "রাসূলুল্লাহ সাল্লাল্লাহু আলাইহি ওয়াসাল্লাম ﷺ বলেছেন: " +
                "যে ব্যক্তি আল্লাহ ও পরকালের প্রতি ঈমান রাখে, " +
                "সে যেন উত্তম কথা বলে অথবা নীরব থাকে।",

        "রাসূলুল্লাহ সাল্লাল্লাহু আলাইহি ওয়াসাল্লাম ﷺ বলেছেন\n\n" +
                "লজ্জা ঈমানের একটি শাখা।",

        "আল্লাহ বলেন\n\n" +
                "নিশ্চয়ই আল্লাহ মুত্তাকীদের সঙ্গে আছেন।"
    )

    var currentPage by remember {
        mutableIntStateOf(0)
    }

    var dragAmount by remember {
        mutableFloatStateOf(0f)
    }


    // --------------------------------
    // AUTOMATIC SLIDE
    // --------------------------------

    LaunchedEffect(Unit) {

        while (true) {

            delay(6000)

            currentPage =
                (currentPage + 1) % messages.size
        }
    }


    // --------------------------------
    // CARD
    // --------------------------------

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
                    },

                    onDragCancel = {

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
                    Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF1D4934),
                            Color(0xFF0C281D),
                            Color(0xFF03100C)
                        )
                    )
                )
                .padding(22.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment =
                    Alignment.CenterHorizontally
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


                // --------------------------------
                // MESSAGE
                // --------------------------------

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


                // --------------------------------
                // PAGE INDICATORS
                // --------------------------------

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.Center,
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    messages.indices.forEach { index ->

                        Box(
                            modifier = Modifier
                                .padding(horizontal = 3.dp)
                                .size(
                                    if (
                                        index == currentPage
                                    ) {
                                        9.dp
                                    } else {
                                        6.dp
                                    }
                                )
                                .background(
                                    color =
                                        if (
                                            index ==
                                            currentPage
                                        ) {
                                            Color(0xFF9BEA7C)
                                        } else {
                                            Color(0xFF526B61)
                                        },

                                    shape =
                                        RoundedCornerShape(
                                            50.dp
                                        )
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

            horizontalAlignment =
                Alignment.CenterHorizontally,

            verticalArrangement =
                Arrangement.Center
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
    modifier: Modifier,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(90.dp)
            .pointerInput(Unit) {
                // Keeps the card responsive while
                // the HomeScreen itself is scrollable.
            },

        onClick = onClick,

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
