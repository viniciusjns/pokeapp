package com.vinicius.pokeapp.pokemondetail.domain

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemondetail.data.repository.PokemonDetailRepository
import javax.inject.Inject

class PokemonDetailUseCaseImpl @Inject constructor(
    private val pokemonDetailRepository: PokemonDetailRepository,
) : PokemonDetailUseCase {

    override suspend fun getPokemonById(id: Int): Result<PokemonDomainModel, String> =
        pokemonDetailRepository.getPokemonById(id)
            .mapSuccess {
                PokemonDomainModel(
                    id = it.id,
                    name = it.name,
                    types = it.types,
                    imageUrl = it.imageUrl,
                    description = it.description,
                    species = it.species,
                    height = it.height,
                    weight = it.weight,
                    training = Training(
                        evYield = it.training?.evYield,
                        baseExp = it.training?.baseExp,
                        growthRate = it.training?.growthRate,
                        catchRate = DefaultData(
                            value = it.training?.catchRate?.value,
                            text = it.training?.catchRate?.text
                        ),
                        baseFriendship = DefaultData(
                            value = it.training?.baseFriendship?.value,
                            text = it.training?.baseFriendship?.text
                        )
                    ),
                    breedings = Breedings(
                        eggGroups = it.breedings?.eggGroups,
                        eggCycles = DefaultData(
                            value = it.breedings?.eggCycles?.value,
                            text = it.breedings?.eggCycles?.text,
                        ),
                        gender = Gender(
                            male = it.breedings?.gender?.male,
                            female = it.breedings?.gender?.female,
                        )
                    ),
                    baseStats = BaseStats(
                        hp = it.baseStats?.hp,
                        attack = it.baseStats?.attack,
                        defense = it.baseStats?.defense,
                        specialAttack = it.baseStats?.specialAttack,
                        specialDefense = it.baseStats?.specialDefense,
                        speed = it.baseStats?.speed,
                    ),
                    typeDefences = null
                )
            }
            .mapError { "" }
}