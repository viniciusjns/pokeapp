package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.core.mapper.Mapper
import com.vinicius.pokeapp.database.entity.*
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.response.PokemonResponse
import javax.inject.Inject

class PokemonResponseToPokemonEntityMapper @Inject constructor(

) : Mapper<PokemonResponse, PokemonEntity> {
    override fun mapFrom(from: PokemonResponse): PokemonEntity {
        return PokemonEntity(
            id = from.id,
            name = from.name,
            types = from.types,
            imageUrl = from.imageUrl,
            description = from.description,
            species = from.species,
            height = from.height,
            weight = from.weight,
            training = Training(
                evYield = from.training?.evYield,
                catchRate = DefaultData(
                    value = from.training?.catchRate?.value,
                    text = from.training?.catchRate?.text
                ),
                baseFriendship = DefaultData(
                    value = from.training?.baseFriendship?.value,
                    text = from.training?.baseFriendship?.text
                ),
                baseExp = from.training?.baseExp,
                growthRate = from.training?.growthRate,
            ),
            breedings = Breedings(
                eggGroups = from.breedings?.eggGroups,
                gender = Gender(
                    male = from.breedings?.gender?.male,
                    female = from.breedings?.gender?.female
                ),
                eggCycles = DefaultData(
                    value = from.breedings?.eggCycles?.value,
                    text = from.breedings?.eggCycles?.text,
                )
            ),
            baseStats = BaseStats(
                hp = from.baseStats?.hp,
                attack = from.baseStats?.attack,
                defense = from.baseStats?.defense,
                specialAttack = from.baseStats?.specialAttack,
                specialDefense = from.baseStats?.specialDefense,
                speed = from.baseStats?.speed,
            ),
            typeDefenses = TypeDefenses(
                normal = from.typeDefenses?.normal,
                fire = from.typeDefenses?.fire,
                water = from.typeDefenses?.water,
                electric = from.typeDefenses?.electric,
                grass = from.typeDefenses?.grass,
                ice = from.typeDefenses?.ice,
                fighting = from.typeDefenses?.fighting,
                poison = from.typeDefenses?.poison,
                ground = from.typeDefenses?.ground,
                flying = from.typeDefenses?.flying,
                psychic = from.typeDefenses?.psychic,
                bug = from.typeDefenses?.bug,
                rock = from.typeDefenses?.rock,
                ghost = from.typeDefenses?.ghost,
                dragon = from.typeDefenses?.dragon,
                dark = from.typeDefenses?.dark,
                steel = from.typeDefenses?.steel,
                fairy = from.typeDefenses?.fairy,
            )
        )
    }
}