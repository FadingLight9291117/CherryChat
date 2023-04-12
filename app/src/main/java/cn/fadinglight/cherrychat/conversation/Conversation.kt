package cn.fadinglight.cherrychat.conversation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cn.fadinglight.cherrychat.ui.theme.CherryChatTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationContent(
    uiState: ConversationUiState?, modifier: Modifier = Modifier
) {
    Scaffold() {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Messages(
                messages = emptyList(), Modifier.weight(1f)
            )
            UserInput(onMessageSent = {})
        }
    }
}

@Composable
fun Messages(
    messages: List<Message>, modifier: Modifier
) {
    Box(modifier = modifier) {}
}

@Composable
fun Message(
    onAuthorClick: (String) -> Unit,
    msg: Message,
    isUserMe: Boolean,
    isFirstMessageByAuthor: Boolean,
    isLastMessageByAuthor: Boolean,
) {
    val borderColor = if (isUserMe) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.tertiary

    val spaceBetweenAuthors = if (isLastMessageByAuthor) Modifier.padding(top = 8.dp)
    else Modifier

    Row(modifier = spaceBetweenAuthors) {
        if (isFirstMessageByAuthor) {
            // Avatar
            Image(
                modifier = Modifier
                    .clickable { onAuthorClick(msg.author) }
                    .padding(horizontal = 16.dp)
                    .size(42.dp)
                    .border(1.5.dp, borderColor, CircleShape)
                    .clip(CircleShape)
                    .align(Alignment.Top),
                painter = painterResource(id = msg.authorImage),
                contentDescription = null
            )
        } else {
            // Space under avatar
            Spacer(modifier = Modifier.width(74.dp))
        }
    }
}

@Preview
@Composable
fun ConversationPreview() {
    CherryChatTheme {
        ConversationContent(uiState = null)
    }
}

