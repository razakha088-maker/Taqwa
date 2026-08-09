package com.taqwa.guard.ui.theme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun HomeScreen() {

    var protectionOn by remember {
        mutableStateOf(true)
    }

    var explicitOn by remember {
        mutableStateOf(true)
    }

    var womenOn by remember {
        mutableStateOf(true)
    }

    var sensitivity by remember {
        mutableIntStateOf(2)
    }

    var selectedAction by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF06140F),
                        Color(0xFF09251A),
                        Color(0xFF020B08)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // ==============================
            // APP HEADER
            // ==============================

            Text(
                text = "☾",
                color = Color(0xFFE5C96A),
                fontSize = 30.sp,
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
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

            // ==============================
            // QURAN & HADITH
            // ==============================

            QuranHadithCard()

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // ==============================
            // PROTECTION STATUS
            // ==============================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF091B15)
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {

                        Text(
                            text = "Protection",
                            color = Color.White,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = if (protectionOn) {
                                "Protection is active"
                            } else {
                                "Protection is OFF"
                            },
                            color = if (protectionOn) {
                                Color(0xFF8FE36F)
                            } else {
                                Color(0xFFFF8A80)
                            },
                            fontSize = 13.sp
                        )
                    }

                    Switch(
                        checked = protectionOn,
                        onCheckedChange = {
                            protectionOn = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color(0xFF318451),
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Color(0xFF4A5550)
                        )
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // ==============================
            // DETECTION MODE
            // ==============================

            Text(
                text = "DETECTION MODE",
                color = Color(0xFFE5C96A),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            DetectionSwitchCard(
                title = "Explicit Content",
                description = "Detect explicit images",
                checked = explicitOn,
                onCheckedChange = {
                    explicitOn = it
                }
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            DetectionSwitchCard(
                title = "Women Detection",
                description = "Detect women in images",
                checked = womenOn,
                onCheckedChange = {
                    womenOn = it
                }
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // ==============================
            // SENSITIVITY
            // ==============================

            Text(
                text = "SENSITIVITY",
                color = Color(0xFFE5C96A),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                SensitivityButton(
                    title = "Low",
                    selected = sensitivity == 1,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        sensitivity = 1
                    }
                )

                SensitivityButton(
                    title = "Medium",
                    selected = sensitivity == 2,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        sensitivity = 2
                    }
                )

                SensitivityButton(
                    title = "High",
                    selected = sensitivity == 3,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        sensitivity = 3
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // ==============================
            // QUICK ACTIONS
            // ==============================

            Text(
                text = "QUICK ACTIONS",
                color = Color(0xFFE5C96A),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                ActionButton(
                    title = "Quick\nToggle",
                    active = selectedAction == "Quick Toggle",
                    modifier = Modifier.weight(1f),
                    onClick = {
                        protectionOn = !protectionOn
                        selectedAction = "Quick Toggle"
                    }
                )

                ActionButton(
                    title = "Allowed\nApps",
                    active = selectedAction == "Allowed Apps",
                    modifier = Modifier.weight(1f),
                    onClick = {
                        selectedAction = "Allowed Apps"
                    }
                )

                ActionButton(
                    title = "Statistics",
                    active = selectedAction == "Statistics",
                    modifier = Modifier.weight(1f),
                    onClick = {
                        selectedAction = "Statistics"
                    }
                )
            }

            if (selectedAction.isNotEmpty()) {

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = when (selectedAction) {
                        "Quick Toggle" ->
                            "Protection switched " +
                                if (protectionOn) "ON" else "OFF"

                        "Allowed Apps" ->
                            "Allowed Apps selected"

                        "Statistics" ->
                            "Statistics selected"

                        else ->
                            ""
                    },
                    color = Color(0xFF9BEA7C),
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
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

                Text(
                    text = messages[currentPage],
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 27.sp,
                    textAlign = TextAlign.Center
                )

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
// DETECTION SWITCH CARD
// ======================================================

@Composable
fun DetectionSwitchCard(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0B2118)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 13.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = description,
                    color = Color(0xFF9FB5AC),
                    fontSize = 11.sp
                )
            }

            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF318451),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color(0xFF4A5550)
                )
            )
        }
    }
}


// ======================================================
// SENSITIVITY BUTTON
// ======================================================

@Composable
fun SensitivityButton(
    title: String,
    selected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(48.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (selected) {
                    Color(0xFF1B5A3B)
                } else {
                    Color(0xFF0B2118)
                }
        )
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 13.sp,
                fontWeight =
                    if (selected) {
                        FontWeight.Bold
                    } else {
                        FontWeight.Normal
                    }
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
    active: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(85.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (active) {
                    Color(0xFF1B5A3B)
                } else {
                    Color(0xFF0B2118)
                }
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
