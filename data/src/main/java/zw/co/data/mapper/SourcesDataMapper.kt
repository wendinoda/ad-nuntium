package zw.co.data.mapper

import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.domain.model.Source
import zw.co.domain.model.SourcesSuccess
import javax.inject.Inject

open class SourcesDataMapper
@Inject
constructor() : Mapper<SourcesSuccessDataModel, SourcesSuccess> {
    override fun mapFromEntity(type: SourcesSuccessDataModel) = SourcesSuccess(
        status = type.status,
        sources = type.sources.map {
            mapFromEntity(it)
        }
    )

    override fun mapToEntity(type: SourcesSuccess): SourcesSuccessDataModel {
        TODO("TO be implemented")
    }

    private fun mapFromEntity(type: SourceDataModel) = Source(
        id = type.id,
        name = type.name,
        description = type.description,
        category = type.category,
        country = type.country,
        language = type.language,
        url = type.url,
    )

    fun mapToEntity(type: Source) = SourceDataModel(
        id = type.id,
        name = type.name,
        description = type.description,
        category = type.category,
        country = type.country,
        language = type.language,
        url = type.url,
    )
}