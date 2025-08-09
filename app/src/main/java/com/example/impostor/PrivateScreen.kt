import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PrivateScreen(
    currIndex: Int, players: List<String>, currImpostorIndex: Int,
    currSecret: String, nextPlayer: () -> Unit) {
    val playerName = players.getOrElse(currIndex, { "" })
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Row {
                Text(
                    text = "$playerName ist an der Reihe",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Row {
                if (currIndex == currImpostorIndex) {
                    Text(
                        text = "Impostor",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                    )
                } else {
                    Text(
                        text =currSecret,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                    )
                }
            }
            Button(
                onClick = {
                    nextPlayer()
                },
                shape = RoundedCornerShape(7.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Text("Hab mir alles voll gut gemerkt...")
            }
        }
    }
}