package com.taqwa.guard.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF061410))
            .padding(16.dp)
    ) {

        Text(
            text = "TAQWA",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Guard your gaze. Protect your soul.",
            color = Color.LightGray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF10241C)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "●  ACTIVE",
                    color = Color(0xFF6CFF72),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Protection is ON",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "You are protected",
                    color = Color.LightGray,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF10241C)
            )
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "DETECTION MODE",
                    color = Color(0xFF9BEA9E),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    ModeCard(
                        modifier = Modifier.weight(1f),
                        title = "Explicit\nContent"
                    )

                    ModeCard(
                        modifier = Modifier.weight(1f),
                        title = "Women\nDetection"
                    )

                    ModeCard(
                        modifier = Modifier.weight(1f),
                        title = "Both\nModes"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

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

            StatCard(
                modifier = Modifier.weight(1f),
                number = "0",
                label = "Detections"
            )

            StatCard(
                modifier = Modifier.weight(1f),
                number = "0m",
                label = "Protected"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Quick Actions",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            QuickCard(
                modifier = Modifier.weight(1f),
                title = "Pause"
            )

            QuickCard(
                modifier = Modifier.weight(1f),
                title = "Settings"
            )

            QuickCard(
                modifier = Modifier.weight(1f),
                title = "Allowed Apps"
            )

            QuickCard(
                modifier = Modifier.weight(1f),
                title = "Statistics"
            )
        }
    }
}

@Composable
fun ModeCard(
    modifier: Modifier = Modifier,
    title: String
) {

    Card(
        modifier = modifier.height(110.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0B1C15)
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
                text = "✓",
                color = Color(0xFF6CFF72),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = title,
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    number: String,
    label: String
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF10241C)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = number,
                color = Color(0xFF6CFF72),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = Color.LightGray,
                fontSize = 11.sp
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
            containerColor = Color(0xFF10241C)
        )
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "◆",
                color = Color(0xFF6CFF72),
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = title,
                color = Color.White,
                fontSize = 11.sp
            )
        }
    }
}
