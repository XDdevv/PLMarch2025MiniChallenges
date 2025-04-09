package zed.rainxch.plmarch2025minichallenges.presentation.challenges.third

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import zed.rainxch.plmarch2025minichallenges.R
import zed.rainxch.plmarch2025minichallenges.domain.model.Astro
import zed.rainxch.plmarch2025minichallenges.domain.model.AstroDTO
import zed.rainxch.plmarch2025minichallenges.presentation.challenges.third.utils.Resource
import zed.rainxch.plmarch2025minichallenges.presentation.challenges.third.vm.FlipCardsViewModel

val fontFamily = FontFamily(Font(R.font.chivo_mono_medium))

@Composable
fun SupercraftFlipCards(
    modifier: Modifier = Modifier,
    viewModel: FlipCardsViewModel = hiltViewModel(),
) {
    val cardState = viewModel.state.collectAsState().value
    when (cardState) {
        is Resource.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error : ${cardState.message} ((",
                    color = Color.White
                )
            }
        }

        is Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Hello world, its loading )",
                    color = Color.White
                )
            }
        }

        is Resource.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                cardState.data ?: return@LazyColumn
                items(cardState.data) { card ->
                    val rotation = remember { Animatable(0f) }
                    val coroutineScope = rememberCoroutineScope()

                    val frontRotation = rotation.value
                    val backRotation = rotation.value - 180f
                    val isFrontVisible = rotation.value < 90f || rotation.value > 270f

                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .clickable {
                                coroutineScope.launch {
                                    val targetValue = if (rotation.value < 180f) 180f else 360f
                                    rotation.animateTo(
                                        targetValue = targetValue,
                                        animationSpec = tween(600)
                                    )

                                    if (rotation.value >= 360f) {
                                        rotation.snapTo(0f)
                                    }
                                }
                            }
                            .padding(bottom = 50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        InactiveCard(
                            card,
                            modifier = Modifier
                                .graphicsLayer {
                                    rotationY = frontRotation
                                    cameraDistance = 12 * density
                                    alpha = if (isFrontVisible) 1f else 0f
                                }
                        )

                        ActiveCard(
                            card,
                            modifier = Modifier
                                .graphicsLayer {
                                    rotationY = backRotation
                                    cameraDistance = 12 * density
                                    alpha = if (isFrontVisible) 0f else 1f
                                }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun InactiveCard(
    astro: Astro,
    modifier: Modifier = Modifier
) {
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
            contentDescription = "Rocket",
            modifier = Modifier
                .height(345.dp)
                .align(Alignment.BottomEnd)
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
                text = astro.groupName,
                fontFamily = fontFamily,
                fontSize = 28.sp,
                color = Color.White
            )
            Text(
                text = "${astro.memberCount} crew members",
                fontFamily = fontFamily,
                fontSize = 16.sp,
                color = Color(0xffB1AEFC)
            )
        }
    }
}

@Composable
fun ActiveCard(
    asto: Astro,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(310.dp)
            .clip(CutCornerShape(topStart = 20.dp, bottomEnd = 20.dp))
            .background(
                Color(0xffCAD5FC)
            )
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_border),
            contentDescription = "Border",
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer {
                    rotationY = 180f
                }
        )

        Image(
            painter = painterResource(R.drawable.ic_rocket),
            contentDescription = "Rocket",
            modifier = Modifier
                .height(320.dp)
                .align(Alignment.BottomStart)
                .graphicsLayer {
                    rotationY = 180f
                },
        )

        Image(
            painter = painterResource(R.drawable.ic_union),
            contentDescription = "Union",
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopEnd),
            colorFilter = ColorFilter.tint(
                Color(0xffB9BDF6)
            )
        )
        val members = StringBuilder()
        asto.members.forEachIndexed { index, value ->
            members.append("${index + 1}. ${value.name}\n")
        }
        Text(
            text = members.toString(),
            fontFamily = fontFamily,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}