package zw.co.presentation.mapper

interface Mapper<S, T> {
    fun mapToUi(type: S): T

    fun mapToDomain(type: T): S
}