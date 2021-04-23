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
import com.realllydan.meld.composables.PassphraseCard
import com.realllydan.meld.data.Hash
import com.realllydan.meld.data.PassPhrase

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeldTheme {
                BottomSheetScaffold(
                    sheetContent = {
                        Box(
                            Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Previous",
                                color = MaterialTheme.colors.onSurface,
                                fontSize = 40.sp,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    top = 24.dp,
                                    end = 16.dp,
                                    bottom = 16.dp
                                )
                            )
                        }
                    }, sheetPeekHeight = 40.dp
                ) {
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

                        PassphraseCard (
                            text = passphrase,
                            onClick = {
                                copyTextToClipboard(passphrase)
                            }
                        )

                        Spacer(modifier = Modifier.padding(top = 16.dp))

                        PassphraseCard (
                            text = Hash().getHashFromText(passphrase),
                            onClick = {
                                copyTextToClipboard(passphrase)
                            }
                        )

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
    }

    private fun copyTextToClipboard(text: String) {
        val clipboard =
            getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clip = ClipData.newPlainText("Passphrase", text)
        clipboard.setPrimaryClip(clip)
    }
}