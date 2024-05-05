package yaroslav.snake.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import yaroslav.snake.domain.extension.launchActivity
import yaroslav.snake.domain.navigation.Screen
import yaroslav.snake.presentation.activity.GameActivity
import yaroslav.snake.presentation.component.AppButton
import yaroslav.snake.presentation.component.DisplayLarge
import yaroslav.snake.presentation.theme.border2dp
import yaroslav.snake.presentation.theme.padding16dp
import yaroslav.snake.presentation.theme.padding64dp
import yaroslav.snake.presentation.theme.width248dp


@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding16dp)
            .border(width = border2dp, color = MaterialTheme.colorScheme.onBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current
        DisplayLarge(text = "Змейка")

        AppButton(
            modifier = Modifier
                .width(width248dp)
                .padding(top = padding64dp),
            text = "Новая игра"
        ) { context.launchActivity<GameActivity>() }
        AppButton(
            modifier = Modifier.width(width248dp),
            text = "Рекорды"
        ) {
            navController.navigate(Screen.HighScores.route)
        }

    }
}