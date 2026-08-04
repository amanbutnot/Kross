package io.github.amanbutnot.krossplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import io.github.amanbutnot.kross_clipboard.enums.KlipData
import io.github.amanbutnot.kross_clipboard.enums.KlipType
import io.github.amanbutnot.kross_clipboard.expect.Klipboard
import io.github.amanbutnot.krossplayground.ui.theme.KrossTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KrossTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current
        val klip = Klipboard(context)
        var textData by remember { mutableStateOf("This is the string data") }
        Text(textData)
        Button(onClick = {
            klip.saveData(KlipData.URL("https://www.google.com"))
        }) {
            Text("Save String data")
        }
        Button(onClick = {
            val a = klip.getData(KlipType.TEXT)
            when (a) {
                is KlipData.HTML -> {}
                is KlipData.TEXT -> {
                    textData = a.value
                }

                is KlipData.URL -> {
                    textData = a.value
                }

                null -> {}
            }
        }) {
            Text("Get String data")
        }
    }
}