package zed.rainxch.plmarch2025minichallenges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import zed.rainxch.plmarch2025minichallenges.presentation.challenges.third.SupercraftFlipCards
import zed.rainxch.plmarch2025minichallenges.presentation.challenges.third.vm.FlipCardsViewModel
import zed.rainxch.plmarch2025minichallenges.presentation.core.ui.theme.PLMarch2025MiniChallengesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PLMarch2025MiniChallengesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color(0xff210A41),
                                        Color(0xff120327)
                                    )
                                )
                            )
                            .padding(innerPadding)
                    ) {
                        SupercraftFlipCards()
                    }
                }
            }
        }
    }
}