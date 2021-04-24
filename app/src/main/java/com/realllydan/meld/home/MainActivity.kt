package com.realllydan.meld.home

import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.realllydan.meld.MeldTheme
import com.realllydan.meld.composables.MeldCard
import com.realllydan.meld.data.Hash
import com.realllydan.meld.data.PassPhrase

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeldTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = MaterialTheme.colors.primary)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    var passphrase: String by remember {
                        mutableStateOf(
                            PassPhrase().getPassphrase(this@MainActivity).toString()
                        )
                    }

                    MeldCard (
                        text = passphrase,
                        color = Color(0xFF5F6466),
                    ) {
                        copyTextToClipboard(passphrase)
                    }

                    Spacer(modifier = Modifier.padding(top = 16.dp))

                    MeldCard (
                        text = Hash().getHashFromText(passphrase),
                    ) {
                        copyTextToClipboard(passphrase)
                    }

                    Spacer(modifier = Modifier.padding(top = 16.dp))

                    FloatingActionButton(
                        onClick = {
                            passphrase =
                                PassPhrase().getPassphrase(this@MainActivity).toString()
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .size(58.dp)
                    ) {
                        Icon(
                            Icons.Filled.Cached,
                            "Generate New Passphrase",
                            tint = Color.White,
                            modifier = Modifier.size(38.dp)
                        )
                    }
                }
            }
        }
    }

    private fun copyTextToClipboard(text: String) {
        val clipboard =
            getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clip = ClipData.newPlainText("Passphrase", text)
        clipboard.setPrimaryClip(clip)
    }
}