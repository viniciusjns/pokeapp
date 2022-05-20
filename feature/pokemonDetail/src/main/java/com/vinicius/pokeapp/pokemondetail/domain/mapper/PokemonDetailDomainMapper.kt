package com.vinicius.pokeapp.pokemondetail.domain.mapper

import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDetailDataModel
import com.vinicius.pokeapp.pokemondetail.domain.model.*

fun PokemonDetailDataModel.toPokemonDetailDomainModel():
        PokemonDetailDomainModel = PokemonDetailDomainModel(
    id = id,
    name = name,
    types = types,
    imageUrl = imageUrl,
    description = description,
    species = species,
    height = height,
    weight = weight,
    training = Training(
        evYield = training?.evYield,
        baseExp = training?.baseExp,
        growthRate = training?.growthRate,
        catchRate = DefaultData(
            value = training?.catchRate?.value,
            text = training?.catchRate?.text
        ),
        baseFriendship = DefaultData(
            value = training?.baseFriendship?.value,
            text = training?.baseFriendship?.text
        )
    ),
    breedings = Breedings(
        eggGroups = breedings?.eggGroups,
        eggCycles = DefaultData(
            value = breedings?.eggCycles?.value,
            text = breedings?.eggCycles?.text,
        ),
        gender = Gender(
            male = breedings?.gender?.male,
            female = breedings?.gender?.female,
        )
    ),
    baseStats = BaseStats(
        hp = baseStats?.hp,
        attack = baseStats?.attack,
        defense = baseStats?.defense,
        specialAttack = baseStats?.specialAttack,
        specialDefense = baseStats?.specialDefense,
        speed = baseStats?.speed,
    ),
    typeDefenses = TypeDefenses(
        normal = typeDefenses?.normal,
        fire = typeDefenses?.fire,
        water = typeDefenses?.water,
        electric = typeDefenses?.electric,
        grass = typeDefenses?.grass,
        ice = typeDefenses?.ice,
        fighting = typeDefenses?.fighting,
        poison = typeDefenses?.poison,
        ground = typeDefenses?.ground,
        flying = typeDefenses?.flying,
        psychic = typeDefenses?.psychic,
        bug = typeDefenses?.bug,
        rock = typeDefenses?.rock,
        ghost = typeDefenses?.ghost,
        dragon = typeDefenses?.dragon,
        dark = typeDefenses?.dark,
        steel = typeDefenses?.steel,
        fairy = typeDefenses?.fairy,
    )
)