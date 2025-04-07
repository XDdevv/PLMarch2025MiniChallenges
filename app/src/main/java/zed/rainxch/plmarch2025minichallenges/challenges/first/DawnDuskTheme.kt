package zed.rainxch.plmarch2025minichallenges.challenges.first

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmarch2025minichallenges.R

@Composable
fun DawnDuskTheme(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Image(
            painter = painterResource(if (isDarkTheme) R.drawable.ic_moon else R.drawable.ic_sun),
            contentDescription = "Moon",
            modifier = Modifier
                .size(80.dp)
                .align(if (isDarkTheme) Alignment.End else Alignment.Start),
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "How was your day?",
            fontSize = 38.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        var selectedStar by rememberSaveable { mutableIntStateOf(0) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(CircleShape)
                .background(
                    if (isDarkTheme) Color(0xff2C144D)
                    else Color(0xFFFFFFFF)
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            for (i in 0 until 5) {
                Image(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
                    modifier = Modifier
                        .size(64.dp)
                        .clickable {
                            selectedStar = i + 1
                        },
                    colorFilter = ColorFilter.tint(
                        if (isDarkTheme) {
                            if (i < selectedStar) Color(0xffFF9334)
                            else Color(0xff482D6D)
                        } else {
                            if (i < selectedStar) Color(0xffFF9334)
                            else Color(0xffD7E4F7)
                        }
                    )
                )
            }
        }

    }
}