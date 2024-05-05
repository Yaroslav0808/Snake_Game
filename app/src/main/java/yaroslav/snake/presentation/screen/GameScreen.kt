package yaroslav.snake.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource

import yaroslav.snake.domain.game.GameEngine
import yaroslav.snake.domain.game.SnakeDirection
import yaroslav.snake.presentation.activity.GameActivity
import yaroslav.snake.presentation.component.AppBar
import yaroslav.snake.presentation.component.Board
import yaroslav.snake.presentation.component.Controller

@Composable
fun GameScreen(gameEngine: GameEngine, score: Int) {
    val state = gameEngine.state.collectAsState(initial = null)
    val activity = LocalContext.current as GameActivity
    AppBar(
        title = "Рекорд $score",
        onBackClicked = { activity.finish() }) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.value?.let { Board(it) }
            Controller {
                when (it) {
                    SnakeDirection.Up -> gameEngine.move = Pair(0, -1)
                    SnakeDirection.Left -> gameEngine.move = Pair(-1, 0)
                    SnakeDirection.Right -> gameEngine.move = Pair(1, 0)
                    SnakeDirection.Down -> gameEngine.move = Pair(0, 1)
                }
            }
        }
    }
}