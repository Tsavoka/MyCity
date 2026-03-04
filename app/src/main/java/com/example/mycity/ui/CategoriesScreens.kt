package com.example.mycity.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.MyCityTheme
import com.example.mycity.R
import com.example.mycity.data.DataSource
import com.example.mycity.model.CategoryItem


@Composable
fun MyCityListItem(
    category: CategoryItem,
    onItemClick: (CategoryItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(category) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            MyCityListImageItem(
                category = category,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(category.titleResourceId),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(
                    text = stringResource(category.subtitleResourceId),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 5
                )
            }
        }
    }
}

@Composable
private fun MyCityListImageItem(category: CategoryItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(category.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = modifier,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
private fun MyCityList(
    category: List<CategoryItem>,
    onClick: (CategoryItem) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier,
    ) {
        items(category) { category ->
            MyCityListItem(
                category = category,
                onItemClick = onClick
            )
        }
    }
}

@Composable
private fun MyCityDetail(
    selectedPlace: CategoryItem,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current
    Box(
        modifier = modifier
            .verticalScroll(state = scrollState)
            .padding(top = contentPadding.calculateTopPadding())
    ) {
        Column(
            modifier = Modifier
                .padding(
                    bottom = contentPadding.calculateTopPadding(),
                    start = contentPadding.calculateStartPadding(layoutDirection),
                    end = contentPadding.calculateEndPadding(layoutDirection)
                )
        ) {
            Box {
                Box {
                    Image(
                        painter = painterResource(selectedPlace.imageResourceId),
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.FillWidth,
                    )
                }
                Column(
                    Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, MaterialTheme.colorScheme.scrim),
                                0f,
                                400f
                            )
                        )
                ) {
                    Text(
                        text = stringResource(selectedPlace.titleResourceId),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
            Text(
                text = stringResource(selectedPlace.subtitleResourceId),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.padding_detail_content_vertical),
                    horizontal = dimensionResource(R.dimen.padding_detail_content_horizontal)
                )
            )
        }
    }
}

@SuppressLint("ContextCastToActivity")
@Composable
private fun MyCityListAndDetails(
    category: List<CategoryItem>,
    selectedPlace: CategoryItem,
    onClick: (CategoryItem) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MyCityList(
            category = category,
            onClick = onClick,
            modifier = Modifier.weight(1f),
            contentPadding = contentPadding
        )
        MyCityDetail(
            selectedPlace = selectedPlace,
            contentPadding = contentPadding,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun MyCityListItemPreview() {
    MyCityTheme {
        MyCityListItem(
            category = DataSource.getCategories()[0],
            onItemClick = {}
        )
    }
}

@Preview
@Composable
fun MyCityListPreview() {
    MyCityTheme {
        Surface {
            MyCityList(
                category = DataSource.getCoffee(),
                onClick = {}
            )
        }
    }
}

@Preview(widthDp = 1000)
@Composable
fun MyCityListAndDetailsPreview() {
    MyCityTheme {
        Surface {
            MyCityListAndDetails(
                category = DataSource.getCoffee(),
                selectedPlace = DataSource.getCoffee().getOrElse(0) {
                    DataSource.getCoffee()[0]
                },
                onClick = {}
            )
        }
    }
}