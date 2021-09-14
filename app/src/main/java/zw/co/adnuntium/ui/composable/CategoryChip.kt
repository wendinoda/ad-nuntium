package zw.co.adnuntium.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryChip(
    label: String,
    isClickable: Boolean = false,
    onClick: () -> Unit = { }
) {
    Box(modifier = Modifier.padding(8.dp)) {
        Surface(
            modifier = Modifier.clickable(
                enabled = isClickable,
                onClick = { onClick() }
            ),
            elevation = 1.dp,
            shape = MaterialTheme.shapes.small,
            color = Color.LightGray
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    label,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.button.copy(color = Color.DarkGray)
                )
            }
        }
    }
}