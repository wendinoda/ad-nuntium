package zw.co.adnuntium.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zw.co.domain.model.Headlines
import zw.co.domain.model.News
import zw.co.domain.model.SourcesSuccess
import zw.co.presentation.mapper.HeadlinesMapper
import zw.co.presentation.mapper.Mapper
import zw.co.presentation.mapper.NewsMapper
import zw.co.presentation.mapper.SourceMapper
import zw.co.presentation.model.HeadlinesView
import zw.co.presentation.model.NewsView
import zw.co.presentation.model.SourcesSuccessView


/*@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)*/

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {
    @Provides
    fun providesSourceMapper(): Mapper<SourcesSuccess, SourcesSuccessView> =
        SourceMapper()

    @Provides
    fun providesHeadlinesMapper(): Mapper<Headlines, HeadlinesView> =
        HeadlinesMapper()

    @Provides
    fun providesNewsMapper(
        headlinesMapper: HeadlinesMapper
    ): Mapper<News, NewsView> = NewsMapper(headlinesMapper)

    /*@Binds
    @IntoMap
    @ViewModelKey(SourceViewModel::class)
    abstract fun bindSourceViewModel(viewModel: SourceViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
*/
}