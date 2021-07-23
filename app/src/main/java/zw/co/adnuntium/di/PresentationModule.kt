package zw.co.adnuntium.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zw.co.domain.model.SourcesSuccess
import zw.co.presentation.mapper.Mapper
import zw.co.presentation.mapper.SourceMapper
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

    /*@Binds
    @IntoMap
    @ViewModelKey(SourceViewModel::class)
    abstract fun bindSourceViewModel(viewModel: SourceViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
*/
}