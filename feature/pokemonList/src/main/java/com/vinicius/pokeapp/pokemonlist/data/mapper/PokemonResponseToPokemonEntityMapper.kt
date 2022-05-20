package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.database.entity.*
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonResponse

fun PokemonResponse.toPokemonEntity() = PokemonEntity(
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
        catchRate = DefaultData(
            value = training?.catchRate?.value,
            text = training?.catchRate?.text
        ),
        baseFriendship = DefaultData(
            value = training?.baseFriendship?.value,
            text = training?.baseFriendship?.text
        ),
        baseExp = training?.baseExp,
        growthRate = training?.growthRate,
    ),
    breedings = Breedings(
        eggGroups = breedings?.eggGroups,
        gender = Gender(
            male = breedings?.gender?.male,
            female = breedings?.gender?.female
        ),
        eggCycles = DefaultData(
            value = breedings?.eggCycles?.value,
            text = breedings?.eggCycles?.text,
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