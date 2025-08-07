package com.example.impostor

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.impostor.ui.theme.ImpostorTheme
import kotlinx.coroutines.delay
import kotlin.getValue

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.impostor.ui.theme.Pink40
import com.example.impostor.ui.theme.Purple40
import ir.ehsannarmani.compose_charts.RowChart
import ir.ehsannarmani.compose_charts.models.BarProperties
import ir.ehsannarmani.compose_charts.models.Bars
import ir.ehsannarmani.compose_charts.models.DividerProperties
import ir.ehsannarmani.compose_charts.models.GridProperties
import ir.ehsannarmani.compose_charts.models.LabelHelperProperties
import ir.ehsannarmani.compose_charts.models.LabelProperties
import ir.ehsannarmani.compose_charts.models.LineProperties

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
                        text ="$currSecret",
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

@Composable
fun BlankScreen(viewModel: GameViewModel, transitionFunction: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Bitte Handy weitergeben")
    }
    LaunchedEffect(Unit) {
        delay(500)
        transitionFunction()
    }
}

@Composable
fun RoundFinished(viewModel: GameViewModel, votingScreen: () -> Unit) {
    val players = viewModel.players
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(
                text = "Reihenfolge",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
            Column {
                players.forEach { name ->
                    Row {
                        Text(
                            text = name,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
            }
            Button(
                onClick = { votingScreen() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(7.dp),
            ) {
                Text("Zur Abstimmung")
            }
        }
    }
}

@Composable
fun VotingScreen(
    viewModel: GameViewModel,
    endScreenTransition: () -> Unit
) {
    val players = viewModel.players
    val currIndex = viewModel.currIndex
    if (viewModel.currIndex < players.size) {
        val currPlayer = players[currIndex]
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.Center) {
            Column {
                Text(
                    text = "$currPlayer stimmt ab",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
                players.forEach { name ->
                    if (currPlayer != name) {
                        Row {
                            Button(
                                onClick = {
                                    viewModel.vote(name)
                                    viewModel.incrementCurrIndex()
                                },
                                shape = RoundedCornerShape(7.dp),
                            ) {
                                Text(
                                    text = name,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                            }
                        }
                    }
                }
            }
        }
    } else {
        endScreenTransition()
    }
}

@Composable
fun WaveTransitionScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Text in der Mitte
        Text(
            text = "Pass the device to the next player",
            modifier = Modifier.align(Alignment.Center)
        )

        // Animierte Wellen am unteren Rand
        Waves(modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Waves(modifier: Modifier = Modifier) {
    // Animationswert von 0f bis 1f, wiederholt unendlich
    val infiniteTransition = rememberInfiniteTransition()
    val waveOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = modifier) {
        drawWave(waveOffset, Color(0xFF2196F3), amplitude = 30f, wavelength = 300f, phaseShift = 0f)
        drawWave(waveOffset, Color(0xFF64B5F6), amplitude = 20f, wavelength = 200f, phaseShift = 100f)
        drawWave(waveOffset, Color(0xFFBBDEFB), amplitude = 15f, wavelength = 150f, phaseShift = 200f)
    }
}

fun DrawScope.drawWave(
    waveOffset: Float,
    color: Color,
    amplitude: Float,
    wavelength: Float,
    phaseShift: Float
) {
    val height = size.height
    val width = size.width

    val path = Path()

    // Start unten links
    path.moveTo(0f, height)

    // Wellenkurve zeichnen
    val step = 1f
    var x = 0f
    while (x <= width) {
        val y = height / 2f + amplitude * kotlin.math.sin(
            2 * Math.PI * (x / wavelength + waveOffset + phaseShift / wavelength)
        ).toFloat()
        path.lineTo(x, y)
        x += step
    }

    // Pfad unten rechts schließen
    path.lineTo(width, height)
    path.close()

    drawPath(path = path, color = color)
}