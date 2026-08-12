package com.taqwa.guard.ui.theme
import android.content.Context
import android.content.Intent
import android.provider.Settings
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
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
import androidx.compose.foundation.verticalScroll



// ======================================================
// MAIN HOME SCREEN
// ======================================================

@Composable
fun HomeScreen() {

    val context = LocalContext.current

    var protectionEnabled by remember {
        mutableStateOf(true)
    }

    var showSensitivityDialog by remember {
        mutableStateOf(false)
    }

    var showAllowedAppsDialog by remember {
        mutableStateOf(false)
    }

    var showSettingsDialog by remember {
        mutableStateOf(false)
    }

    var sensitivity by remember {
        mutableFloatStateOf(0.5f)
    }

    val sensitivityName = when {
        sensitivity < 0.34f -> "Low"
        sensitivity < 0.67f -> "Medium"
        else -> "High"
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

            // ==================================================
            // HEADER
            // ==================================================

            Text(
                text = "☾",
                color = Color(0xFFE5C96A),
                fontSize = 30.sp,
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
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // ==================================================
            // QURAN & HADITH
            // ==================================================

            QuranHadithCard()


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // ==================================================
            // PROTECTION STATUS
            // ==================================================

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
                        text = if (protectionEnabled) {
                            "PROTECTED"
                        } else {
                            "PAUSED"
                        },

                        color = if (protectionEnabled) {
                            Color(0xFF8FE36F)
                        } else {
                            Color(0xFFE5C96A)
                        },

                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = if (protectionEnabled) {
                            "✓  Taqwa Guard is protecting your device"
                        } else {
                            "Protection is currently paused"
                        },

                        color = Color(0xFFDCE8E2),
                        fontSize = 13.sp
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // ==================================================
            // STATISTICS
            // ==================================================

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

                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)
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


            // ==================================================
            // QUICK ACTIONS
            // ==================================================

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

                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                ActionButton(
                    title = if (protectionEnabled) {
                        "Protection\nON"
                    } else {
                        "Protection\nOFF"
                    },

                    modifier = Modifier.weight(1f)
                ) {

                    protectionEnabled =
                        !protectionEnabled
                }


                ActionButton(
                    title = "Sensitivity",

                    modifier = Modifier.weight(1f)
                ) {

                    showSensitivityDialog = true
                }


                ActionButton(
                    title = "Allowed\nApps",

                    modifier = Modifier.weight(1f)
                ) {

                    showAllowedAppsDialog = true
                }


                ActionButton(
                    title = "Settings",

                    modifier = Modifier.weight(1f)
                ) {

                    showSettingsDialog = true
                }
            }


            Spacer(
                modifier = Modifier.height(24.dp)
            )


            // ==================================================
            // CURRENT SETTINGS
            // ==================================================

            Card(
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(18.dp),

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
                        text = "Current Settings",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Protection: ${
                            if (protectionEnabled)
                                "ON"
                            else
                                "OFF"
                        }",

                        color = Color(0xFFC5D2CC),
                        fontSize = 13.sp
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Sensitivity: $sensitivityName",

                        color = Color(0xFFC5D2CC),
                        fontSize = 13.sp
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Button(
                        onClick = {

                            try {

                                context.startActivity(
                                    Intent(
                                        Settings.ACTION_ACCESSIBILITY_SETTINGS
                                    )
                                )

                            } catch (_: Exception) {
                            }
                        },

                        modifier = Modifier.fillMaxWidth(),

                        colors = ButtonDefaults.buttonColors(
                            containerColor =
                                Color(0xFF1D4934)
                        ),

                        shape = RoundedCornerShape(14.dp)
                    ) {

                        Text(
                            text = "Open Accessibility Settings",
                            color = Color.White
                        )
                    }
                }
            }


            Spacer(
                modifier = Modifier.height(30.dp)
            )


            Text(
                text = "Taqwa Guard",
                color = Color(0xFF526B61),
                fontSize = 12.sp,
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }


    // ======================================================
    // SENSITIVITY DIALOG
    // ======================================================

    if (showSensitivityDialog) {

        AlertDialog(
            onDismissRequest = {
                showSensitivityDialog = false
            },

            title = {

                Text(
                    text = "Sensitivity"
                )
            },

            text = {

                Column {

                    Text(
                        text = sensitivityName,

                        color = Color(0xFF1D4934),

                        fontSize = 20.sp,

                        fontWeight =
                            FontWeight.Bold,

                        modifier = Modifier.align(
                            Alignment.CenterHorizontally
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )

                    Slider(
                        value = sensitivity,

                        onValueChange = {
                            sensitivity = it
                        },

                        valueRange = 0f..1f
                    )

                    Row(
                        modifier =
                            Modifier.fillMaxWidth(),

                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Text("Low")

                        Text("Medium")

                        Text("High")
                    }
                }
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        showSensitivityDialog = false
                    }
                ) {

                    Text(
                        text = "DONE",
                        color = Color(0xFF1D4934)
                    )
                }
            }
        )
    }


    // ======================================================
    // ALLOWED APPS DIALOG
    // ======================================================

    if (showAllowedAppsDialog) {

        AllowedAppsDialog(
            onClose = {
                showAllowedAppsDialog = false
            }
        )
    }


    // ======================================================
    // SETTINGS DIALOG
    // ======================================================

    if (showSettingsDialog) {

        AlertDialog(
            onDismissRequest = {
                showSettingsDialog = false
            },

            title = {

                Text(
                    text = "Taqwa Settings"
                )
            },

            text = {

                Column {

                    Text(
                        text = "Protection status\n\n" +
                                "• Protection: ${
                                    if (protectionEnabled)
                                        "ON"
                                    else
                                        "OFF"
                                }\n\n" +

                                "• Sensitivity: $sensitivityName\n\n" +

                                "• Allowed apps: Configure from Allowed Apps\n\n" +

                                "• Accessibility service: " +
                                "Open Android Accessibility Settings"
                    )
                }
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        showSettingsDialog = false
                    }
                ) {

                    Text(
                        text = "CLOSE",
                        color = Color(0xFF1D4934)
                    )
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
                "মুমিন পুরুষদের বলুন, তারা যেন তাদের দৃষ্টি সংযত রাখে এবং তাদের লজ্জাস্থানের হেফাজত করে।",

        "সূরা নূর : ৩১\n\n" +
                "মুমিন নারীদের বলুন, তারা যেন তাদের দৃষ্টি সংযত রাখে এবং তাদের লজ্জাস্থানের হেফাজত করে।",

        "আবু হুরায়রা (রাঃ) থেকে বর্ণিত\n\n" +
                "রাসূলুল্লাহ ﷺ বলেছেন: যে ব্যক্তি আল্লাহ ও পরকালের প্রতি ঈমান রাখে, সে যেন উত্তম কথা বলে অথবা নীরব থাকে।",

        "রাসূলুল্লাহ ﷺ বলেছেন\n\n" +
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


    // ==================================================
    // AUTOMATIC SLIDE
    // ==================================================

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
                                (currentPage + 1) %
                                        messages.size

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


                Crossfade(
                    targetState = currentPage,
                    label = "QuranHadithTransition"
                ) { page ->

                    Text(
                        text = messages[page],

                        modifier =
                            Modifier.fillMaxWidth(),

                        color = Color.White,

                        fontSize = 16.sp,

                        lineHeight = 27.sp,

                        textAlign =
                            TextAlign.Center
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


                Row(
                    horizontalArrangement =
                        Arrangement.Center
                ) {

                    messages.indices.forEach { index ->

                        Box(
                            modifier = Modifier
                                .padding(
                                    horizontal = 3.dp
                                )
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
// ACTION BUTTON
// ======================================================

@Composable
fun ActionButton(
    title: String,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,

        modifier = modifier.height(90.dp),

        shape = RoundedCornerShape(16.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0B2118)
        ),

        contentPadding = androidx.compose.foundation.layout
            .PaddingValues(6.dp)
    ) {

        Text(
            text = title,

            color = Color.White,

            fontSize = 12.sp,

            textAlign = TextAlign.Center
        )
    }
}


// ======================================================
// ALLOWED APPS
// ======================================================

@Composable
fun AllowedAppsDialog(
    onClose: () -> Unit
) {

    val apps = listOf(
        "Chrome",
        "YouTube",
        "Facebook",
        "Instagram",
        "Messenger",
        "WhatsApp",
        "Telegram"
    )

    var selectedApps by remember {
        mutableStateOf(
            setOf<String>()
        )
    }


    AlertDialog(
        onDismissRequest = onClose,

        title = {

            Text(
                text = "Allowed Apps"
            )
        },

        text = {

            Column {

                Text(
                    text = "Select the apps where Taqwa Guard should work."
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                apps.forEach { app ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp),

                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        androidx.compose.material3.Checkbox(
                            checked =
                                selectedApps.contains(app),

                            onCheckedChange = { checked ->

                                selectedApps =
                                    if (checked) {

                                        selectedApps + app

                                    } else {

                                        selectedApps - app
                                    }
                            }
                        )

                        Text(
                            text = app,
                            color = Color.Black
                        )
                    }
                }
            }
        },

        confirmButton = {

            TextButton(
                onClick = onClose
            ) {

                Text(
                    text = "DONE",
                    color = Color(0xFF1D4934)
                )
            }
        }
    )
}
