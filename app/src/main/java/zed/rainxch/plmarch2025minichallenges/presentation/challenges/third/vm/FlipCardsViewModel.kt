package zed.rainxch.plmarch2025minichallenges.presentation.challenges.third.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import zed.rainxch.plmarch2025minichallenges.data.service.ApiService
import zed.rainxch.plmarch2025minichallenges.domain.model.Astro
import zed.rainxch.plmarch2025minichallenges.presentation.challenges.third.utils.Resource
import javax.inject.Inject

@HiltViewModel
class FlipCardsViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _state: MutableStateFlow<Resource<List<Astro>>> =
        MutableStateFlow(Resource.Loading())
    val state = _state.asStateFlow()

    init {
        getAstro()
    }

    fun getAstro() {
        viewModelScope.launch {
            try {
                val flowAstro = flow { emit(apiService.getAstro()) }
                flowAstro
                    .catch { error ->
                        _state.value = Resource.Error(error.message ?: "Unknown error")
                    }
                    .collect { astroDTO ->
                        val astros = astroDTO.people
                            .groupBy { it.craft }
                            .map { (groupName, members) ->
                                Astro(
                                    groupName = groupName,
                                    members = members,
                                    memberCount = members.size
                                )
                            }
                        _state.value = Resource.Success(astros)
                    }
            } catch (e: Exception) {
                _state.value = Resource.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}