package zw.co.presentation.mapper

import zw.co.domain.model.Source
import zw.co.domain.model.SourcesSuccess
import zw.co.presentation.model.SourceView
import zw.co.presentation.model.SourcesSuccessView
import javax.inject.Inject

class SourceMapper @Inject constructor(): Mapper<SourcesSuccess, SourcesSuccessView> {
    override fun mapToUi(type: SourcesSuccess) = SourcesSuccessView(
        status = type.status,
        sources = type.sources.map { mapToUi(it) }
    )

    private fun mapToUi(type: Source) = SourceView(
        id = type.id,
        name = type.name,
        description = type.description,
        url = type.url,
        category = type.category,
        language = type.language,
        country = type.country,
    )

    override fun mapToDomain(type: SourcesSuccessView): SourcesSuccess {
        TODO("Not yet implemented")
    }
}