package zed.rainxch.plmarch2025minichallenges.challenges.third

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import zed.rainxch.plmarch2025minichallenges.R

val fontFamily = FontFamily(Font(R.font.chivo_mono_medium))

@Composable
fun SupercraftFlipCards(
    innerPaddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    val rotation = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    val frontRotation = rotation.value
    val backRotation = rotation.value - 180f
    val isFrontVisible = rotation.value < 90f || rotation.value > 270f

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xff210A41),
                        Color(0xff120327)
                    )
                )
            )
            .padding(innerPaddingValues)
            .clickable {
                coroutineScope.launch {
                    // Animate to 180 or 0/360 depending on current state
                    val targetValue = if (rotation.value < 180f) 180f else 360f
                    rotation.animateTo(
                        targetValue = targetValue,
                        animationSpec = tween(600)
                    )

                    // Reset to 0 if we reached 360
                    if (rotation.value >= 360f) {
                        rotation.snapTo(0f)
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        InactiveCard(
            modifier = Modifier
                .graphicsLayer {
                    rotationY = frontRotation
                    cameraDistance = 12 * density
                    // Hide backface when rotated
                    alpha = if (isFrontVisible) 1f else 0f
                }
        )

        ActiveCard(
            modifier = Modifier
                .graphicsLayer {
                    rotationY = backRotation
                    cameraDistance = 12 * density
                    alpha = if (isFrontVisible) 0f else 1f
                }
        )
    }
}

@Preview
@Composable
fun InactiveCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(310.dp)
            .clip(CutCornerShape(topEnd = 20.dp, bottomStart = 20.dp))
            .background(
                Color(0xff420794)
            )
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_border),
            contentDescription = "Border",
            modifier = Modifier.align(Alignment.Center)
        )

        Image(
            painter = painterResource(R.drawable.ic_rocket),
            contentDescription = "Border",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(top = 24.dp),
        )

        Image(
            painter = painterResource(R.drawable.ic_union),
            contentDescription = "Union",
            modifier = Modifier.padding(10.dp),
            colorFilter = ColorFilter.tint(
                Color(0xff551DC3)
            )
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ISS Spacecraft",
                fontFamily = fontFamily,
                fontSize = 28.sp,
                color = Color.White
            )
            Text(
                text = "12 crew members",
                fontFamily = fontFamily,
                fontSize = 16.sp,
                color = Color(0xffB1AEFC)
            )
        }
    }
}

@Preview
@Composable
fun ActiveCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(310.dp)
            .clip(CutCornerShape(topEnd = 20.dp, bottomStart = 20.dp))
            .background(
                Color(0xffCAD5FC)
            )
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_border),
            contentDescription = "Border",
            modifier = Modifier.align(Alignment.Center)
        )

        Image(
            painter = painterResource(R.drawable.ic_rocket),
            contentDescription = "Border",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(top = 24.dp),
        )

        Image(
            painter = painterResource(R.drawable.ic_union),
            contentDescription = "Union",
            modifier = Modifier.padding(10.dp),
            colorFilter = ColorFilter.tint(
                Color(0xffB9BDF6)
            )
        )

        Text(
            text = "1. Oleg Kononenko\n" +
                    "2. Nikolai Chub\n" +
                    "3. Tracy Caldwell Dyson\n" +
                    "4. Matthew Dominick\n" +
                    "5. Michael Barratt\n" +
                    "6. Jeanette Epps\n" +
                    "7. Alexander Grebenkin\n" +
                    "8. Butch Wilmore\n" +
                    "9. Sunita Williams\n" +
                    "10. Li Guangsu\n" +
                    "11. Li Cong\n" +
                    "12. Ye Guangfu",
            fontFamily = fontFamily,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}