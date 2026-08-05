package io.github.amanbutnot.krossplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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
                ClipboardPlayground()
            }
        }
    }
}

@Composable
fun ClipboardPlayground() {
    val context = LocalContext.current
    val klip = remember { Klipboard(context) }

    var textResult by remember { mutableStateOf("Nothing read yet") }
    var htmlResult by remember { mutableStateOf("Nothing read yet") }
    var urlResult by remember { mutableStateOf("Nothing read yet") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // TEXT
        Text("TEXT")

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                klip.saveData(
                    KlipData.TEXT("Hello from Kross!")
                )
            }
        ) {
            Text("Copy Text")
        }

        Button(
            onClick = {
                textResult = when (val data = klip.getData(KlipType.TEXT)) {
                    is KlipData.TEXT -> {
                        data.value
                    }

                    else -> {
                        "No text found"
                    }
                }
            }
        ) {
            Text("Get Text")
        }

        Text("Result: $textResult")

        Spacer(Modifier.height(24.dp))
        HorizontalDivider()
        Spacer(Modifier.height(24.dp))


        // HTML
        Text("HTML")

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                klip.saveData(
                    KlipData.HTML(
                        "<h1>Hello Kross</h1><p>This is <b>HTML</b></p>"
                    )
                )
            }
        ) {
            Text("Copy HTML")
        }

        Button(
            onClick = {
                htmlResult = when (val data = klip.getData(KlipType.HTML)) {
                    is KlipData.HTML -> {
                        data.value
                    }

                    is KlipData.TEXT -> {
                        data.value
                    }

                    else -> {
                        "No HTML found"
                    }
                }
            }
        ) {
            Text("Get HTML")
        }

        Text("Result: $htmlResult")

        Spacer(Modifier.height(24.dp))
        HorizontalDivider()
        Spacer(Modifier.height(24.dp))


        // URL
        Text("URL")

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                klip.saveData(
                    KlipData.URL("https://www.google.com")
                )
            }
        ) {
            Text("Copy URL")
        }

        Button(
            onClick = {
                urlResult = when (val data = klip.getData(KlipType.URL)) {
                    is KlipData.URL -> {
                        data.value
                    }

                    is KlipData.TEXT -> {
                        data.value
                    }

                    else -> {
                        "No URL found"
                    }
                }
            }
        ) {
            Text("Get URL")
        }

        Text("Result: $urlResult")
    }
}