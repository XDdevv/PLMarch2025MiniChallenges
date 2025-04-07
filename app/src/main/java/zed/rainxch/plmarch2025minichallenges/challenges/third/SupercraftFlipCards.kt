package zed.rainxch.plmarch2025minichallenges.challenges.third

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zed.rainxch.plmarch2025minichallenges.R

@Composable
fun SupercraftFlipCards(
    innerPaddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
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
            .padding(innerPaddingValues),
        contentAlignment = Alignment.Center
    ) {
        var isActive by remember { mutableStateOf(false) }
        val rotateDegree by animateFloatAsState(
            targetValue = 180f,

        )
        Box(
            modifier = Modifier
                .width(310.dp)
                .clip(CutCornerShape(topEnd = 20.dp, bottomStart = 20.dp))
                .background(
                    if (isActive) Color(0xff420794)
                    else Color(0xffCAD5FC)
                )
                .rotate(rotateDegree)
                .padding(10.dp)
                .clickable {
                }
        ) {
            Image(
                painter = painterResource(R.drawable.ic_border),
                contentDescription = "Border",
                modifier = Modifier.align(Alignment.Center)
            )

            Image(
                painter = painterResource(R.drawable.ic_union),
                contentDescription = "Union",
                modifier = Modifier.padding(10.dp),
                colorFilter = ColorFilter.tint(
                    if (isActive) Color(0xffB9BDF6)
                    else Color(0xff551DC3)
                )
            )
        }
    }
}

@Preview
@Composable
fun SupercraftFlipCardsPreview() {
    SupercraftFlipCards(PaddingValues(20.dp))
}
