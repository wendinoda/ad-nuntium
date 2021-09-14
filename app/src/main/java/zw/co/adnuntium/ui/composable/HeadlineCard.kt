package zw.co.adnuntium.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import zw.co.adnuntium.utils.DateFormatter
import zw.co.presentation.model.ArticlesView

@Composable
fun HeadlineNewsCard(
    article: ArticlesView,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(modifier = modifier) {
            Image(
                painter = rememberImagePainter(
                    data = article.urlToImage,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = imageModifier
            )
            Column(modifier = Modifier.padding(16.dp)) {
                article.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h6,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                article.author?.let {
                    Text(
                        text = it,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body2
                    )
                }
                article.publishedAt?.let {
                    Text(
                        text = DateFormatter.toString(it),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}