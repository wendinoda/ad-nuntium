package zw.co.adnuntium.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import zw.co.adnuntium.R
import zw.co.presentation.model.ArticlesView

@Composable
fun Author(
    article: ArticlesView,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            article.author?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun ArticleImage(article: ArticlesView, modifier: Modifier = Modifier) {
    Image(
        painter = rememberImagePainter(
            data = article.urlToImage,
            builder = {
                crossfade(true)
            }
        ),
        contentDescription = "",
        modifier = modifier
            .size(40.dp, 40.dp)
            .clip(MaterialTheme.shapes.small)
    )
}

@Composable
fun PostTitle(article: ArticlesView) {
    article.title?.let { Text(it, style = MaterialTheme.typography.subtitle1) }
}

@Composable
fun ArticleCardSimple(
    article: ArticlesView,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit
) {
    val bookmarkAction = stringResource(if (isFavorite) R.string.unsave else R.string.save)
    Row(
        modifier = Modifier
            .clickable(onClick = { })
            .padding(16.dp)
            .semantics {
                customActions = listOf(
                    CustomAccessibilityAction(
                        label = bookmarkAction,
                        action = { onToggleFavorite(); true }
                    )
                )
            }
    ) {
        ArticleImage(article, Modifier.padding(end = 16.dp))
        Column(modifier = Modifier.weight(1f)) {
            PostTitle(article)
            Author(article)
        }
        BookmarkButton(
            isBookmarked = isFavorite,
            onClick = onToggleFavorite,
            modifier = Modifier.clearAndSetSemantics {}
        )
    }
}

@Composable
fun BookmarkButton(
    isBookmarked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val clickLabel = stringResource(
        if (isBookmarked) R.string.unsave else R.string.save
    )
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        IconToggleButton(
            checked = isBookmarked,
            onCheckedChange = { onClick() },
            modifier = modifier.semantics {
                this.onClick(label = clickLabel, action = null)
            }
        ) {
            Icon(
                imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                contentDescription = ""
            )
        }
    }
}
