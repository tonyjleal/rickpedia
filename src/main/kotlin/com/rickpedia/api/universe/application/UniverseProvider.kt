package com.rickpedia.api.universe.application

import com.rickpedia.api.shared.domain.exceptions.EntityNotFound
import com.rickpedia.api.universe.domain.UniverseDto
import com.rickpedia.api.universe.domain.UniverseMapper
import com.rickpedia.api.universe.domain.UniverseRepository
import org.springframework.stereotype.Service

@Service
class UniverseProvider(
        private val universeRepository: UniverseRepository,
        private val universeMapper: UniverseMapper) {

    fun findByUniverseId(universeId: Long): UniverseDto {
        val foundUniverse = universeRepository.findById(universeId)
        if (foundUniverse.isPresent) throw EntityNotFound("Universe")
        return universeMapper.entityToDto(foundUniverse.get())
    }

    fun findAll() = universeMapper.entityToDtoList(universeRepository.findAll().toList())
}