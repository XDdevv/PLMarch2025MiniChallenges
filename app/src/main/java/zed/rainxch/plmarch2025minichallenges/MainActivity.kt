package zed.rainxch.plmarch2025minichallenges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import zed.rainxch.plmarch2025minichallenges.challenges.first.DawnDuskTheme
import zed.rainxch.plmarch2025minichallenges.challenges.second.MarsWeatherCard
import zed.rainxch.plmarch2025minichallenges.challenges.third.SupercraftFlipCards
import zed.rainxch.plmarch2025minichallenges.ui.theme.PLMarch2025MiniChallengesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PLMarch2025MiniChallengesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SupercraftFlipCards(
                        innerPadding
                    )
                }
            }
        }
    }
}