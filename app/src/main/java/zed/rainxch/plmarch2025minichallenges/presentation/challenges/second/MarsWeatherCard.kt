package zed.rainxch.plmarch2025minichallenges.presentation.challenges.second

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.plmarch2025minichallenges.R

val myFontFamily = FontFamily(Font(R.font.chivo_mono_medium))

@Composable
fun MarsWeatherCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(0xff120327),
                        Color(0xff210A41)
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(R.drawable.mars),
            contentDescription = "Mars",
            modifier = Modifier
                .height(400.dp)
                .wrapContentWidth()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .width(350.dp)
                .clip(CutCornerShape(topEnd = 20.dp))
                .background(Color.White)
                .padding(12.dp)
                .align(Alignment.Center)
        ) {
            IconText(Icons.Filled.LocationOn, "Olympus Mons", Color(0xFFC5B1DC), Color(0xFFAC92D1))
            Spacer(modifier = Modifier.height(100.dp))
            IconText(
                painterResource(R.drawable.ic_wind),
                "Dust Storm",
                textColor = Color(0xffCD533C)
            )
            Spacer(modifier = Modifier.height(10.dp))
            val temperatureString = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 64.sp, fontWeight = FontWeight.SemiBold)) {
                    append("-63")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        baselineShift = BaselineShift(2f)
                    )
                ) {
                    append("°C")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = temperatureString,
                    color = Color(0xff14171E),
                    fontFamily = myFontFamily
                )

                Column(
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text(
                        text = "H:-52°C",
                        color = Color(0xff474F63),
                        fontSize = 16.sp,
                        fontFamily = myFontFamily
                    )
                    Text(
                        text = "L:-73°C",
                        color = Color(0xff474F63),
                        fontSize = 16.sp,
                        fontFamily = myFontFamily
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                val items = listOf(
                    Content("Wind speed", "27km/h NW"),
                    Content("Pressure", "600 Pa"),
                    Content("UV Radiation", "0.5 mSv/day"),
                    Content("Martian date", "914 Sol")
                )
                items(4) { index ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .background(Color(0XFFF9E8E5))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = items[index].title,
                            color = Color(0xffCD533C),
                            fontSize = 14.sp,
                            fontFamily = myFontFamily
                        )
                        Text(
                            text = items[index].description,
                            color = Color(0xff14171E),
                            fontSize = 16.sp,
                            fontFamily = myFontFamily
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun IconText(
    icon: ImageVector,
    text: String,
    iconColor: Color,
    textColor: Color,
) {
    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Location",
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = textColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = myFontFamily
        )
    }
}

@Composable
fun IconText(
    icon: Painter,
    text: String,
    textColor: Color,
) {
    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = "Location",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = textColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = myFontFamily
        )
    }
}