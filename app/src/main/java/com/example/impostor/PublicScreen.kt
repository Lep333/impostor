import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.impostor.GameViewModel

@Composable
fun PublicScreen(
    viewModel: GameViewModel,
    privateInformation: (String) -> Unit,
    roundFinished: () -> Unit
) {
    val currIndex = viewModel.currIndex
    val players = viewModel.players
    if (currIndex < players.size) {
        val playerName = players[currIndex]
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column {
                Text(
                    text = "$playerName ist an der Reihe",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.secondary),
                    )
                }
                Button(
                    onClick = {
                        privateInformation(playerName)
                    },
                    shape = RoundedCornerShape(7.dp),
                    modifier = Modifier.padding(8.dp),
                ) {
                    Text(
                        text = "Geheime Informationen ansehen",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    } else {
        roundFinished()
    }
}